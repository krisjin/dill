package org.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Notes:
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p/>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * <p/>
 * You may assume that each input would have exactly one solution.
 * <p/>
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * <p/>
 * Solution: 1. Hash table. O(n)
 * <p/>
 * Note:  Hash Table solution has been updated.  In case that the two elements are the same,
 * all the indices should be stored in the map.
 * <p/>
 * <p/>
 * 这道题目的意思是给定一个数组和一个值，让求出这个数组中两个值的和等于这个给定值的坐
 * 标。输出是有要求的，1， 坐标较小的放在前面，较大的放在后面。2， 这俩坐标不能为零。
 * 时间复杂度: O(N)******- 空间复杂度: O(N)
 *
 * tag:数组、hashmap
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/16
 * Time: 21:38
 */
public class TwoSum001 {

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; ++i) {
            int temp = target - nums[i];
            if (map.get(temp) != null) {
                return new int[]{map.get(temp), i + 1};
            } else {
                map.put(nums[i], i + 1);
            }

        }
        return null;
    }


    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        TwoSum001 twoSum001 = new TwoSum001();
        int[] result = twoSum001.twoSum(nums, 9);

        System.out.println("index1=" + result[0] + ", index2=" + result[1]);
    }
}
