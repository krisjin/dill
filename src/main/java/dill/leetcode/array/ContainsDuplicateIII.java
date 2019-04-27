package dill.leetcode.array;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 难度: 中等
 * 描述:
 * Given an array of integers,
 * find out whether there are two distinct indices i and j in the array such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 * (给定一个整数数组，判断其中是否存在两个不同的下标i和j满足：| nums[i] - nums[j] | <= t 并且 | i - j | <= k)
 * <p/>
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/17
 * Time: 14:32
 */
public class ContainsDuplicateIII {


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
