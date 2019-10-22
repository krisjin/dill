package dill.base.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 难度: 简单
 * 描述:
 * Given an array of integers and an integer k,
 * find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k.
 * (给定一个整数数组与一个整数k，当且仅当存在两个不同的下标i和j满足nums[i] = nums[j]并且| i - j | <= k时返回true，否则返回false。)
 * <p/>
 * 使用{@link Map}保存数组值与数组下标，Map中的key是不允许重复的，所以在实现中数据并没有全部加载进去，而是在判断的时候去添加，当存在重复是就不在添加了。
 * 所有在这个实现过程中，可以不可率Key重复的问题
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/17
 * Time: 14:32
 */
public class ContainsDuplicateII {


    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]);
                if (i - j <= k) return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        int[] arr = {7, 3, 4, 5, 1, 7, 6};
        ContainsDuplicateII containsDuplicateII = new ContainsDuplicateII();
        boolean ret = containsDuplicateII.containsNearbyDuplicate(arr, 1);
        System.out.println(ret);

    }
}
