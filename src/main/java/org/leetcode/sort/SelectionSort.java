package org.leetcode.sort;

/**
 * 选择排序
 * <pre>
 * 核心：不断地选择剩余元素中的最小者。
 *
 * 找到数组中最小元素并将其和数组第一个元素交换位置。
 * 在剩下的元素中找到最小元素并将其与数组第二个元素交换，直至整个数组排序。
 * 性质：
 *
 * 比较次数=(N-1)+(N-2)+(N-3)+...+2+1~N^2/2
 * 交换次数=N
 * 运行时间与输入无关
 * 数据移动最少
 * </pre>
 * User : krisibm@163.com
 * Date: 2015/8/21
 * Time: 10:46
 */
public class SelectionSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {12, 9, 8, 7, 7, 6, 5, 4, 3, 2, 1, 0};
        SelectionSort.sort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
