package dill.lee.array;

import java.util.Arrays;

/**
 * 合并两个有序数组，为什么要合并两个有序的数组集合
 * 去重
 * https://leetcode-cn.com/problems/merge-sorted-array
 * <pre>
 * 给定两个有序整数数组nums1 和 nums2，将 nums2 合并到nums1中，使得num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化nums1 和 nums2 的元素数量分别为m 和 n。
 * 你可以假设nums1有足够的空间（空间大小大于或等于m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出:[1,2,2,3,5,6]
 *
 * </pre>
 */
public class MergeSortArray88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //先去拷贝
        System.arraycopy(nums2, 0, nums1, m, n);
        //在排序
        Arrays.sort(nums1);
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;

        //比较元素，从nums1 拷贝到nums2, 添加最小的元素到nums1
        while ((p1 < m) && (p2 < n)) nums1[p++] = (nums1Copy[p1] < nums2[p2]) ? nums1Copy[p1++] : nums2[p2++];

        //添加剩余元素
        if (p1 < m) System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        if (p2 < n) System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
    }


    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        // 定义p1 和 p2 指针
        int p1 = m - 1;
        int p2 = n - 1;
        // 定义num1 值设置指针
        int p = m + n - 1;

        // 当p1和p2都包含数据元素是进行大小的比较并赋值给num1
        while ((p1 >= 0) && (p2 >= 0)) {
            //比较nums1和nums2，将最大的值赋值给p索引
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }

        //添加nums2中缺少的元素
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


    public static void mergeSortArray(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];

        int p1 = 0, p2 = 0, r = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            if (nums1[p1] < nums2[p2]) {
                result[r] = nums1[p1];
                p1++;
                r++;
            } else if (nums1[p1] == nums2[p2]) {
                result[r] = nums1[p1];
                p1++;
                p2++;
                r++;
            } else {
                result[r] = nums2[p2];
                r++;
                p2++;
            }
        }

        while (p1 < nums1.length && p2 < nums2.length) {

        }


        while (p1 < nums1.length) {
            result[r] = nums1[p1];
            r++;
            p1++;
        }

        while (p2 < nums2.length) {
            result[r] = nums2[p2];
            r++;
            p2++;
        }

        System.out.println(Arrays.toString(result));

    }


    public static void main(String[] args) {
        int[] numberArr1 = {1, 2, 3};
        int[] numberArr2 = {2, 5, 6};


//        merge1(numberArr1, numberArr2);


    }
}
