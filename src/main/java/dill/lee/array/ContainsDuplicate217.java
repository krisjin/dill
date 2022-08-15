package dill.lee.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 存在重复元素
 * https://leetcode.cn/problems/contains-duplicate
 * <pre>
 * 给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：true
 * 示例 2：
 *
 * 输入：nums = [1,2,3,4]
 * 输出：false
 * 示例 3：
 *
 * 输入：nums = [1,1,1,3,3,4,3,2,4,2]
 * 输出：true
 * </pre>
 */
public class ContainsDuplicate217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            else set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 2, 6, 7, 1};
        ContainsDuplicate217 containsDuplicate217 = new ContainsDuplicate217();
        boolean ret = containsDuplicate217.containsDuplicate(arr);
        System.out.println(ret);
    }
}
