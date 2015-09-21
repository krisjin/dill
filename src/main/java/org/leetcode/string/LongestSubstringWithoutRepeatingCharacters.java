package org.leetcode.string;

import java.util.Arrays;

/**
 * 难度：中等
 * 描述：Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * 给定一个字符串，从中找出不含重复字符的最长子串的长度。例如，"abcabcbb"的不含重复字母的最长子串为"abc"，其长度是3。
 * "bbbbb"的最长子串是"b"，长度为1。
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/21
 * Time: 13:23
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring_1(String s) {
        boolean[] hash = new boolean[256];
        Arrays.fill(hash, false);
        int n = s.length();
        if (n <= 1) return n;
        int start = 0, end = 0, res = 0;
        while (end < n && start + res < n) {
            if (hash[s.charAt(end)] == false) {
                hash[s.charAt(end++)] = true;
            } else {
                hash[s.charAt(start++)] = false;
            }
            res = Math.max(res, end - start);
        }
        return res;
    }

    public int lengthOfLongestSubstring_2(String s) {
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int n = s.length();
        if (n <= 1) return n;
        hash[s.charAt(0)] = 0;
        int start = 0, res = 1, cur = 0;
        while (++cur < n) {
            if (hash[s.charAt(cur)] >= start) {
                start = hash[s.charAt(cur)] + 1;
            }
            res = Math.max(res, cur - start + 1);
            hash[s.charAt(cur)] = cur;
        }
        return res;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters withoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
        int s = withoutRepeatingCharacters.lengthOfLongestSubstring_2("abcabcbb");
        System.out.println(s);
    }
}
