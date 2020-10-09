package dill.leet;

/**
 * User:krisjin
 * Date:2019-11-07
 * 反转字符串
 * 链接：https://leetcode-cn.com/problems/reverse-string
 * <pre>
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 *
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 *
 * </pre>
 */
public class ReverseString344 {

    public static void reverseString(char[] s) {
        swap(0, s.length - 1, s);//初始调用
    }

    public static void swap(int start, int end, char[] s) {
        if (start >= end) return;

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        swap(start + 1, end - 1, s);
    }

    public void reverseString2(char[] s) {
        int n = s.length;
        for (int left = 0, right = n - 1; left < right; left++, right--) {
            char tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
        }
    }


    public static void main(String[] args) {
        char[] c = "abcde".toCharArray();
        ReverseString344 reverseString344 = new ReverseString344();
        reverseString344.reverseString2(c);
        System.out.println(c);
    }
}
