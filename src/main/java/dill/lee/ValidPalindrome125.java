package dill.lee;

/**
 * 验证回文串
 * <pre>
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "SimHash man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 * </pre>
 * https://leetcode-cn.com/problems/valid-palindrome
 */
public class ValidPalindrome125 {


    /**
     * 回文串的特点，正向字符串与反向字符串相等的特点
     *
     * @param s
     * @return
     */
    public static boolean isPalindrome_1(String s) {
        StringBuffer str = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                str.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer strRev = new StringBuffer(str).reverse();
        return str.toString().equals(strRev.toString());
    }


    public static boolean isPalindrome_2(String s) {
        StringBuffer str = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                str.append(Character.toLowerCase(ch));
            }
        }
        int n = str.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }

    public static boolean isPalindrome_3(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String s = "SimHash man, a plan, a canal: Panama";

        boolean b = isPalindrome_2(s);

        System.err.println(b);
    }

}
