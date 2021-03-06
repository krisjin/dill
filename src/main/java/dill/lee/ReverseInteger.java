package dill.lee;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 难度：简单
 * <p/>
 * 描述：
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p/>
 * 对反转的数值，总是对10取模，这样就每次都是获取最后一个数字，每次的结果乘以10加上余数就进行了一次反转。
 * 再对数值除以10，得到一个整数数进行下次取模加值。
 * https://leetcode-cn.com/problems/reverse-integer/
 */
public class ReverseInteger {

    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            // 每一次都在原来结果的基础上变大10倍，再加上余数 x%10，总是会获取最后一个数
            res = res * 10 + x % 10;
            //对x不停除10
            x = x / 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
        return res;
    }

    /**
     * 暴力方法
     *
     * @param x
     * @return
     */
    public static String reverse2(int x) {
        String strX = x + "";
        String result = "";
        for (int i = strX.length(); i > 0; i--) {
            result += strX.charAt(i - 1);
        }
        return result;
    }

    /**
     * 使用stack,代码很复杂
     *
     * @param x
     * @return
     */
    public static String reverse3(int x) {
        String strX = x + "";
        String negative = "";
        if (strX.indexOf("-") != -1) {
            negative = "-";
            strX = strX.substring(1);
        }
        Deque<Character> stack = new LinkedList();

        String result = negative;
        for (int i = 0; i < strX.length(); i++)
            stack.push((strX.charAt(i)));

        for (int j = 0; j < strX.length(); j++) {
            result += stack.pop();
        }
        return result;
    }


    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int ret = reverseInteger.reverse(0);
//        System.out.println(ret);
        System.out.println(reverse2(-123));

        System.out.println(reverse3(-123));
    }

}
