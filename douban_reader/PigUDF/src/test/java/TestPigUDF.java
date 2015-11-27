import com.myudf.Score;
import org.apache.pig.data.BinSedesTupleFactory;
import org.apache.pig.data.Tuple;
import org.junit.Test;

/**
 * Created by michael1 on 15/11/26.
 */
public class TestPigUDF {
    @Test
    public void testGetScore() throws Exception {
        Tuple input = BinSedesTupleFactory.getInstance().newTuple();
        input.append("big");
        input.append(8.7);
        input.append("good");
        input.append(3);

        Score score = new Score();
        Double result = score.exec(input);
        System.out.print(result);
    }
}
