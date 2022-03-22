package dill.lee;

import java.util.Arrays;

/**
 * 合并两个有序数组，为什么要合并两个有序的数组集合
 * https://leetcode-cn.com/problems/merge-sorted-array
 * <pre>
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * </pre>
 */
public class MergeSortArray88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;

        // Compare elements from nums1Copy and nums2
        // and add the smallest one into nums1.
        while ((p1 < m) && (p2 < n))
            nums1[p++] = (nums1Copy[p1] < nums2[p2]) ? nums1Copy[p1++] : nums2[p2++];

        // if there are still elements to add
        if (p1 < m)
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n)
            System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 定义p1 和 p2 指针
        int p1 = m - 1;
        int p2 = n - 1;

        // 定义num1 值设置指针
        int p = m + n - 1;

        // 当p1和p2都包含数据元素是进行大小的比较并赋值给num1
        while ((p1 >= 0) && (p2 >= 0)) {
            // compare two elements from nums1 and nums2 ,and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    /**
     * 1.m数组大小是m+n的大小
     * 2.数组空间从后向前填充
     *
     * @param num1 数组1
     * @param m    数组1长度
     * @param num2 数组2
     * @param n    数组2长度
     */
    public void merge3(int[] num1, int m, int[] num2, int n) {
        for (int idx = m + n - 1; idx >= 0; idx--) {
            if (m <= 0) {
                num1[idx] = num2[--n];
            } else if (n <= 0) {
                break;
            } else if (num1[m - 1] < num2[n - 1]) {
                num1[idx] = num2[--n];
            } else {
                num1[idx] = num1[--m];
            }
        }
    }


    public static void main(String[] args) {
        int[] numberArr1 = {1, 2, 3, 0, 0, 0};
        int[] numberArr2 = {2, 5, 6};

        MergeSortArray88 mergeSortArray = new MergeSortArray88();
        mergeSortArray.merge2(numberArr1, 3, numberArr2, numberArr2.length);

        for (int i : numberArr1) {
            System.out.print(i + " ");
        }
        System.err.println("");


    }
}
