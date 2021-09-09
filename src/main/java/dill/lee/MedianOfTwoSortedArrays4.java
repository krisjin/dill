package dill.lee;

/**
 * 寻找两个正序数组的中位数
 * https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * <p>
 * <pre>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 * 示例 2：
 *
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 * 示例 3：
 *
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 * 示例 4：
 *
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 * 示例 5：
 *
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * </pre>
 */
public class MedianOfTwoSortedArrays4 {


    public static double findMedianSortedArrays(int[] a, int[] b) {
        int aIndex = 0;
        int bIndex = 0;

        int aLen = a.length;
        int bLen = b.length;
        int total = aLen + bLen;

        double prev = 0;
        double last = 0;

        if (total < 2) {
            if (aLen == 0 && bLen == 0) return 0;
            if (aLen == 1) {
                return a[0];
            } else {
                return b[0];
            }
        }

        while ((aIndex + bIndex) <= (total / 2)) {
            prev = last;
            //如果A中的元素已经用完，直接取B数组
            if (aIndex >= aLen) {
                last = b[bIndex];
                bIndex++;
            } else if (bIndex >= bLen) {
                last = a[aIndex];
                aIndex++;
            } else if (a[aIndex] < b[bIndex]) {
                //取A[i] 和 B[j] 中较小的
                last = a[aIndex];
                aIndex++;
            } else {
                last = b[bIndex];
                bIndex++;
            }
        }

        //偶数个
        if ((total & 1) == 0) {
            return (prev + last) / 2.0;
        } else {//奇数个
            return last;
        }

    }


    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {2, 4};

        double median = findMedianSortedArrays(a, b);
        System.out.println(median);
        String one = Integer.toBinaryString(178);
        String two = Integer.toBinaryString(143);


        System.out.println(one);
        System.out.println(two);
        System.out.println(178 & 143);

    }
}
