package dill.lee.string;


public class SubtractString {


    static String sub(String a, String b) {
        StringBuffer res = new StringBuffer();
        int borrow = 0;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            int x = i >= 0 ? a.charAt(i) - '0' : 0;
            int y = j >= 0 ? b.charAt(j) - '0' : 0;
            int z = (x - borrow - y + 10) % 10;
            res.append(z);
            borrow = x - borrow - y < 0 ? 1 : 0;
            i--;
            j--;
        }
//        res.
        //删除前导0。循环条件是res.size()-1是为防止"0000"的情况
        int pos;
        for (pos = 0; pos < res.length() - 1; pos++) {
//            if (res[pos] != '0') break;
        }
        return null;
    }


    /**
     * charAt(), % , /
     * 从低位到
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int num1Len = num1.length() - 1;
        int num2Len = num2.length() - 1;
        int add = 0;

        StringBuffer ans = new StringBuffer();
        while (num1Len >= 0 || num1Len >= 0 || add != 0) {
            int x = num1Len >= 0 ? num1.charAt(num1Len) - '0' : 0;
            int y = num2Len >= 0 ? num2.charAt(num2Len) - '0' : 0;
            int result = x + y + add;
            ans.append(result % 10);
            add = result / 10;
            num1Len--;
            num2Len--;
        }
        ans.reverse();
        return ans.toString();
    }

    public static void main(String[] args) {
//        String num1 = "1000000000000", num2 = "123";
//        String s = addStrings(num1, num2);
//        System.out.println(s);


    }
}
