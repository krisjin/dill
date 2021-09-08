package dill.lee;

/**
 * 长度最小的子数组
 * https://leetcode-cn.com/problems/minimum-size-subarray-sum/
 * <pre>
 * 给定一个含有n个正整数的数组和一个正整数 target 。
 *
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 *
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组[4,3]是该条件下的长度最小的子数组。
 *
 *
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 *
 *
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * </pre>
 */
public class MinimumSizeSubArraySum209 {


    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        // window [start...end]
        int start = 0;
        int end = -1;
        int sum = 0;
        int result = nums.length + 1;
        while (start < nums.length) {
            // 还有剩余元素未考察并且窗口内元素总和小于目标值s
            if (end + 1 < nums.length && sum < target) {
                end++;
                sum += nums[end];
            } else { // 尝试缩小窗口
                sum -= nums[start];
                start++;
            }
            // 窗口内元素总和大于等于目标值s则更新结果值
            if (sum >= target) {
                result = Math.min(result, end - start + 1);
            }
        }
        return result == nums.length + 1 ? 0 : result;
    }


    public static void main(String[] args) {

    }


}
