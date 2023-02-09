package dill.lee.string;

/**
 * 字符串相加
 * https://leetcode.cn/problems/add-strings/solution/zi-fu-chuan-xiang-jia-by-leetcode-solution/
 * <pre>
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 *
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 * </pre>
 */
public class AddString415 {

    /**
     * charAt(), % , /
     * 从低位到
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
        String num1 = "1000000000000", num2 = "123";
        String s = addStrings(num1, num2);
        System.out.println(s);
    }
}
