package dill.lee.array;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * //
 * 一个整数数组，一个目标值，返回一个结果的个数，在该数组中求解相邻元素值相加等于目标值。
 * 有点
 * //
 * <pre>
 * 给定一个整数数组和一个整数k，你需要找到该数组中和为k的连续的子数组的个数。
 *
 * 示例 1 :
 *
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
 * 说明 :
 *
 * 数组的长度为 [1, 20,000]。
 * 数组中元素的范围是 [-1000, 1000] ，且整数的范围是[-1e7, 1e7]。
 * </pre>
 */
public class SubArraySumEqualsK560 {

    public static int subArraySum(int[] nums, int k) {
        int count = 0;
        //第一层循环i
        for (int start = 0; start < nums.length; ++start) {
            int sum = 0;
            //第二层循环，从结束位置向前遍历，相当于从每次都是一个子数组，子数组在向前推移滑动，在分别却遍历求和与目标值比较
            for (int end = start; end >= 0; --end) {
                sum += nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }


    public int[] subarraySum_2(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        //一次遍历
        for (int i = 0; i < nums.length; ++i) {
            //存在时，我们用数组得值为 key，索引为 value
            if (map.containsKey(k - nums[i])) {
                return new int[]{i, map.get(k - nums[i])};
            }
            //存入值
            map.put(nums[i], i);
        }
        //返回
        return new int[]{};
    }


    public static void main(String[] args) {
        int[] i = new int[]{1, 1, 1};
        int count = subArraySum(i, 3);
        System.err.println(count);
    }

}
