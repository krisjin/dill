package dill.lee;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * <pre>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 * </pre>
 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    /**
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


    public int lengthOfLongestSubstring3(String s) {
        StringBuffer sb = new StringBuffer();

        return 0;
    }


    /**
     * 暴力破解
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        Set set = new HashSet();

        int index = 0; //String s的索引
        int maxSize = 0; //返回的值
        while (index < s.length()) {
            while (true) {
                char c = s.charAt(index);
                if (set.contains(c)) {
                    index = index - set.size() + 1;//index回退到重复元素的后一个位置（不可以用indexOf）
                    break;
                } else {
                    set.add(c);//元素与set集合里面的不重复，添加到set里
                    index++;
                }
                if (index == s.length()) {
                    break;
                }
            }
            if (maxSize < set.size()) { //找出每次遍历中set最大的元素，即最大不重复子串
                maxSize = set.size();
            }
            set.clear(); //每次有重复元素，重置set集合
        }
        return maxSize;
    }

    public static void main(String[] args) {

    }

}
