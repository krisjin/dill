package dill.leet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * User:krisjin
 * Date:2019-10-22
 * 有效的字母异位词
 * https://leetcode-cn.com/problems/valid-anagram
 *
 * <pre>
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 *
 * 示例 1:
 *
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 *
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 *
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 *
 * </pre>
 */
public class C0242 {


    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


    public boolean isAnagramWithMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map map = new HashMap<>();
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        for (char c1 : str1) {
            map.put(c1, c1);
        }
        for (char c2 : str2) {
            Object cc = map.get(c2);
            if (cc != null) {
                map.remove(cc);
            }
        }


        return map.size() == 0 ? true : false;
    }


    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";

//        String s1 = "rat";
//        String s2 = "car";
        C0242 c0242 = new C0242();

        System.out.println(c0242.isAnagramWithMap(s1, s2));
    }

}
