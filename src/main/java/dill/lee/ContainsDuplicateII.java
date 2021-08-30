package dill.lee;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/contains-duplicate-ii
 * <pre>
 * 给定一个整数数组和一个整数k，判断数组中是否存在两个不同的索引i和j，使得nums [i] = nums [j]，并且 i 和 j的差的 绝对值 至多为 k。
 *
 * 示例 1:
 *
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 * </pre>
 * User: krisjin
 * Date: 2021/8/30
 */
public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        // hashmap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果含有
            if (map.containsKey(nums[i])) {
                //判断是否小于K，如果小于等于则直接返回
                int abs = Math.abs(i - map.get(nums[i]));
                if (abs <= k) return true;//小于等于则返回
            }
            //更新索引，此时有两种情况，不存在，或者存在时，将后出现的索引保存
            map.put(nums[i], i);
        }
        return false;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 2, 3};
        boolean result = containsNearbyDuplicate(nums, 2);
        System.err.println(result);
    }

}
