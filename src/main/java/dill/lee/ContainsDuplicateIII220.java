package dill.lee;

import dill.base.array.ContainsDuplicateIII;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 存在重复元素 III
 * https://leetcode-cn.com/problems/contains-duplicate-iii
 * <pre>
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，使得abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。
 *
 * 如果存在则返回 true，不存在返回 false。
 *
 *
 * 示例1：
 *
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 *
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 *
 * </pre>
 */
public class ContainsDuplicateIII220 {

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0 || nums == null || nums.length < 2)
            return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (set.floor(n) != null && n <= t + set.floor(n) ||
                    set.ceiling(n) != null && set.ceiling(n) <= t + n)
                return true;
            set.add(n);
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        if (t < 0)
            return false;
        TreeSet<Long> set = new TreeSet<Long>();

        for (int i = 0; i < nums.length; i++) {
            if (i - k - 1 >= 0)
                set.remove((long) nums[i - k - 1]);

            SortedSet<Long> subSet = set.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            //t为负的话 fromKey > toKey 因此开始要判断
            if (!subSet.isEmpty()) return true;

            set.add((long) nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 4, 5, 1, 7, 6};
        ContainsDuplicateIII containsDuplicateIII = new ContainsDuplicateIII();
        boolean ret = containsDuplicateIII.containsNearbyAlmostDuplicate(arr, 3, 5);
        System.out.println(ret);

    }
}
