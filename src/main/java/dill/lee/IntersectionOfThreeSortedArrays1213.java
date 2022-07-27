package dill.lee;

import java.util.LinkedList;
import java.util.List;

/**
 * 三个有序数组的交集
 * https://leetcode.cn/problems/intersection-of-three-sorted-arrays
 * <pre>
 * 给出三个均为 严格递增排列 的整数数组 arr1，arr2 和 arr3。返回一个由 仅 在这三个数组中 同时出现 的整数所构成的有序数组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * 输出: [1,5]
 * 解释: 只有 1 和 5 同时在这三个数组中出现.
 * 示例 2:
 *
 * 输入: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
 * 输出: []
 *
 * </pre>
 */
public class IntersectionOfThreeSortedArrays1213 {

    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        int[] hash = new int[2001];
        List<Integer> result = new LinkedList<>();
        for (int index = 0; index < arr1.length; index++) {
            hash[arr1[index]]++;
        }

        for (int index = 0; index < arr2.length; index++) {
            hash[arr2[index]]++;
        }

        for (int index = 0; index < arr3.length; index++) {
            if (hash[arr3[index]] == 2) {
                result.add(arr3[index]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5}, arr2 = {1, 2, 5, 7, 9}, arr3 = {1, 3, 4, 5, 8};

        List<Integer> l = arraysIntersection(arr1, arr2, arr3);

        System.err.println(l);
    }
}
