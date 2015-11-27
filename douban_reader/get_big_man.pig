REGISTER PigUDF.jar;
A = LOAD 'reader_list_final' USING PigStorage('`') AS (col1:chararray, col2:double, col3:chararray, col4:chararray, col5:chararray);
-- A: {col1: chararray,col2: float,col3: chararray,col4: chararray,col5: chararray}

B = FILTER A BY col3 != '[已注销]';
-- B: {col1: chararray,col2: float,col3: chararray,col4: chararray,col5: chararray}

C = FOREACH B GENERATE col3, com.myudf.Score(col1, col2, col5, 0) AS score;
-- C: {col3: chararray,score: double}

D = GROUP C BY col3;
-- D: {group: chararray,C: {(col3: chararray,score: double)}}

E = FOREACH D GENERATE FLATTEN(group), SUM(C.score) AS final_score;
-- E: {group: chararray,final_score: double}

F = ORDER E BY final_score DESC;
-- F: {group: chararray,final_score: double}

STORE F INTO 'out';