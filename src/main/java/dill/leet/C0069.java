package dill.leet;

/**
 * User:krisjin
 * Date:2019-11-03
 * x 的平方根
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * <pre>
 * 实现 int sqrt(int x) 函数。
 *
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 *
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 *
 * 输入: 4
 * 输出: 2
 * 示例 2:
 *
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 * </pre>
 */
public class C0069 {


    public static int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0;
        int right = 0;
        int mid = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                left = i + 1;
                right = i;
                break;
            }
        }
        while ((right - left + nums.length) % nums.length > 0) {
            mid = ((right - left + nums.length) % nums.length / 2 + left) % nums.length;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (left == right && nums[left] == target) return left;
        else return -1;
    }


    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7, 0, 1, 2};
        int aa = search(a, 0);
    }
}
