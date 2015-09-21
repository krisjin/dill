package org.leetcode.math;

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
 * User : krisibm@163.com
 * Date: 2015/9/17
 * Time: 17:32
 */
public class ReverseInteger {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            // 每一次都在原来结果的基础上变大10倍，再加上余数
            res = res * 10 + Long.valueOf(x % 10);
            //对x不停除10
            x = x / 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
        return (int) res;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int ret = reverseInteger.reverse(123);
//        int ret2 = reverseInteger.reverse(-123);
//        System.out.println(ret);
//        System.out.println(ret2);
    }

}
