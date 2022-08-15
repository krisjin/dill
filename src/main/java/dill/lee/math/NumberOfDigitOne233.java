package dill.lee.math;

/**
 * 数字1的个数
 * https://leetcode-cn.com/problems/number-of-digit-one/
 * <pre>
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 *
 * 示例 1：
 * 输入：n = 13
 * 输出：6
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：0
 * </pre>
 */
public class NumberOfDigitOne233 {

    public static int countDigitOne(int n) {
        // mulk 表示 10^k
        // 在下面的代码中，可以发现 k 并没有被直接使用到（都是使用 10^k）
        // 但为了让代码看起来更加直观，这里保留了 k
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }


    public static int countDigitOne2(int num) {
        int n = 0, ans = 0, ynum = num;
        while(num > 0){
            int k = num % 10;
            num /= 10;
            int temp = (int)Math.pow(10, n);
            if(k == 1) ans += ynum % temp + 1;
            ans += k * n * (temp / 10);
            if(k > 1) ans += temp;
            n++;
        }
        return ans;
    }

    public static void main(String[] args) {
       int n =  countDigitOne2(14);

        System.out.println(n);
    }


}
