package dill.lee.math;

/**
 * User:krisjin
 * Date:2019-11-03
 * x 的平方根
 * https://leetcode-cn.com/problems/sqrtx
 * <pre>
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 *
 * </pre>
 */
public class MySqrt69 {

    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        long left = 1;
        long right = x;
        long mid = 1;

        while (left <= right) {
            mid = left + (left + right) / 2;
            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int) right;
    }

    //https://leetcode-cn.com/problems/sqrtx/solution/er-fen-cha-zhao-niu-dun-fa-python-dai-ma-by-liweiw/
    public int mySqrt1(int a) {
        long x = a;
        while (x * x > a) {
            x = (x + a / x) / 2;
        }
        return (int) x;
    }


    public static void main(String[] args) {
        MySqrt69 mySqrt69 = new MySqrt69();
        Math.sqrt(9);
        System.err.println(mySqrt69.mySqrt(9));
    }
}
