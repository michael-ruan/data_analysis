package com.myudf;

import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michael1 on 15/11/26.
 */
public class Score extends EvalFunc<Double> {

    @Override
    public Double exec(Tuple tuple) throws IOException {
        if (tuple == null || tuple.size() == 0) {
            return null;
        }

        double bookNameWeight = 2;
        double bookRatingWeight = 1;
        double readerMsgWeight = 0.5;
        double countWeight = 0;

        try {
            String bookName = "";
            if (tuple.get(0) != null) {
                bookName = (String) tuple.get(0);
            }
            double bookRating = 0;
            if (tuple.get(1) != null) {
                bookRating = (double) tuple.get(1);
            }

            String readerMsg = "";
            if (tuple.get(2) != null) {
                readerMsg = (String) tuple.get(2);
            }
            int count = (int) tuple.get(3);

            //中英文书计算
            double bookNameItem = 1;
            String regex = ".*[\\u4E00-\\u9FA5]+.*";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(bookName);


            if (matcher.matches()) {
                bookNameItem = 0;
            }

            //评论计算
            double readerMsgItem;
            if (readerMsg.length() < 10) {
                readerMsgItem = 1;
            } else if (readerMsg.length() < 20 ) {
                readerMsgItem = 2;
            } else if (readerMsg.length() < 30 ) {
                readerMsgItem = 3;
            } else {
                readerMsgItem = 4;
            }
            return bookNameItem * bookNameWeight +
                    bookRating * bookRatingWeight +
                    readerMsgItem * readerMsgWeight +
                    count * countWeight;
        } catch (Exception e) {
            e.printStackTrace();
            throw new IOException(e.getMessage());

        }
    }
}
