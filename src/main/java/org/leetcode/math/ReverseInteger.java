package org.leetcode.math;

/**
 * 难度：简单
 * <p/>
 * 描述：
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/17
 * Time: 17:32
 */
public class ReverseInteger {

    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + Long.valueOf(x % 10);
            x = x / 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return 0;
        return (int) res;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        int ret = reverseInteger.reverse(1230);
        int ret2 = reverseInteger.reverse(-123);
        System.out.println(ret);
        System.out.println(ret2);
    }

}
