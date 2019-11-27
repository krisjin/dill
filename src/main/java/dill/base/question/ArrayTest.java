package dill.base.question;


import java.util.*;

/**
 * User:krisjin
 * Date:2019-10-14
 */
public class ArrayTest {


    public static void main(String[] args) {
        List l = new ArrayList<>();


        Random random = new Random();
//        random.setSeed(10);

        for (int i = 1; i < 10; i++) {
            System.out.println(random.nextInt(10));

        }


        Set<String> set = new HashSet<>();

        set.add("a");
        set.add("b");

        String[] aa = new String[2];
        String[] s = set.toArray(aa);

        System.err.println(s[1]);
        //0.549833997312478

        System.out.println(sigmoid(-32323232.43232));

        String TMP_PATH = System.getProperty("java.io.tmpdir", "/tmp");

        System.out.println(TMP_PATH);

    }


    public static double sigmoid(double x) {
        return (1.0 / (1.0 + Math.exp(-x)));
    }


    public static double sigmoid2(double x) {
        return 1 / (1 + Math.exp(-1 * x));
    }










//    ....{"matrixId":9,"matrixName":"gbdt.split.feature","formatClassName":"com.tencent.angel.model.output.format.RowIdColIdValueTextRowFormat","rowType":21,"row":2,"col":3,
//        "blockRow":2,"blockCol":3,"options":{"feature.index.range.end":"3","matrix.oplog.type":"T_INT_DENSE","matrix.save.path": "file:////var/folders/1_/jkx2bw_j29q32x3tg97n833c5_6bm9/T//model/gbdt","feature.index.range.start":"0"},
//        "partMetas":{"0":{"partId":0, "startRow":0,"endRow":2, "startCol":0,"endCol":3, "nnz":6,"saveRowNum":2," saveColNum":0,"saveColElemNum":0,"fileName":"0", "offset":0,"length":38,"rowMetas":{"0":{"rowId":0,"offset":0,"elementNum ":3,"saveType":0},"1":{" rowId":1,"offset":0,"elementNum":3,"saveType":0}
//        }}}}
















}
