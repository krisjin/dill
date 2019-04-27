package dill.base;

/**
 * @author krisjin on 2019/4/20
 */
public class Fact {


    private static int fact(int n) {
        if (n == 1 || n == 0) return 1;

        int i = n * fact(n - 1);

        System.out.println(n);
        return i;
    }

    private static int print(int n) {
        if (n == 0) {
            return 0;
        } else {
            System.out.println(n);

            return print(n - 1);
        }

    }

    public static void main(String[] args) {

        int i = fact(4);
//        int i2 = print(3);

        System.err.println(i);
    }
}
