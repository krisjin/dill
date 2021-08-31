package dill.lee;

/**
 * 缺失的第一个正数
 * https://leetcode-cn.com/problems/first-missing-positive
 * <pre>
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 *
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *
 * </pre>
 * 题解
 * 1.要求时间复杂度o(n) ,空间复杂度o(1)
 * 2.未排序的整数数组，需要采用排序解决吗？应该是不需要
 * 3.
 * User: krisjin
 * Date: 2021/8/30
 */
public class FirstMissingPositive {

    public static int firstMissingPositive_1(int[] nums) {
        if (nums.length == 0) {
            return 1;
        }
        //因为是返回第一个正整数，不包括 0，所以需要长度加1，细节1
        int[] res = new int[nums.length + 1];
        //将数组元素添加到辅助数组中
        for (int x : nums) {
            if (x > 0 && x < res.length) {
                res[x] = x;
            }
        }
        //遍历查找,发现不一样时直接返回
        for (int i = 1; i < res.length; i++) {
            if (res[i] != i) {
                return i;
            }
        }
        //缺少最后一个，例如 1，2，3此时缺少 4 ，细节2
        return res.length;
    }


    public int firstMissingPositive_2(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; ++i) {
            int num = Math.abs(nums[i]);
            if (num <= n) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        for (int i = 0; i < n; ++i) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }


    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        int n = firstMissingPositive_1(nums);
        System.err.println(n);
    }
}
