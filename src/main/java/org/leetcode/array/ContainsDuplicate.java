package org.leetcode.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 难度: 简单
 * 描述:
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 * (给定一个整数数组，查找数组中包含任何重复的。如果任何值在数组中至少出现两次，你的函数应该返回true。
 * 如果每个元素都是唯一的那么返回false。)
 * <p/>
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/17
 * Time: 14:32
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            } else {
                set.add(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 7, 1};
        ContainsDuplicate containsDuplicate = new ContainsDuplicate();
        boolean ret = containsDuplicate.containsDuplicate(arr);
        System.out.println(ret);
    }
}
