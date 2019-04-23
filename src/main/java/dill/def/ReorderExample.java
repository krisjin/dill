package dill.def;

/**
 * User:shijingui
 * Date:2019/4/10
 *  
 */
public class ReorderExample {

    static int a = 0;
    static boolean flag = false;

    public static void main(String[] args) {
        for (int i=0;i<100;i++){

            write();
            reader();

        }

    }


    private static void write() {
        a = 2;
        flag = true;
    }


    private static void reader() {
        if (flag) {
            int i = a * a;
            System.out.println(i);
        }

    }
}
