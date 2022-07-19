package dill.base.question;


import java.util.*;

public class ArrayTest {
    public static void main(String[] args) {
        System.err.println(5 & -98223);
        Random random = new Random();

        for (int i = 1; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }
        System.out.println(sigmoid(-32323232.43232));
        String TMP_PATH = System.getProperty("java.io.tmpdir", "/tmp");
        System.out.println(TMP_PATH);
        System.out.println("------------------");
        int n = (int) Math.ceil((double) 11 / (double) 10);
    }

    public static double sigmoid(double x) {
        return (1.0 / (1.0 + Math.exp(-x)));
    }


    public static double sigmoid2(double x) {
        return 1 / (1 + Math.exp(-1 * x));
    }


}
