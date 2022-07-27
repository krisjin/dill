package dill.lee;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两个数组的交集 II
 * https://leetcode.cn/problems/intersection-of-two-arrays-ii
 * <pre>
 *  给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 *
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 *  
 *  </pre>
 */
public class IntersectionOfTwoArraysII350 {

    public static int[] intersect(int[] nums1, int[] nums2) {
        //先计算数组小的
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        //将一个数组存入map
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        //交集对象
        int[] intersection = new int[nums1.length];
        int idx = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[idx++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return intersection;

    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 2, 1};
        int[] num2 = {2, 2};
        int[] aaa = intersect(num1, num2);
        System.out.println(Arrays.toString(aaa));
    }


}
