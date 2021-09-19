package dill.base.question;


import java.util.*;

/**
 * User:krisjin
 * Date:2019-10-14
 */
public class ArrayTest {
    public static void main(String[] args) {
        List l = new ArrayList<>();
        String a = Integer.toBinaryString(1);

        System.err.println("--" + a);

        System.err.println(5 & -98223);

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


        System.out.println("------------------");
        int n = (int) Math.ceil((double) 11 / (double) 10);

        System.out.println(n);

    }


    public static double sigmoid(double x) {
        return (1.0 / (1.0 + Math.exp(-x)));
    }


    public static double sigmoid2(double x) {
        return 1 / (1 + Math.exp(-1 * x));
    }


}
