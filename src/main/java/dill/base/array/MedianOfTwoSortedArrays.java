package dill.base.array;

/**
 * Problem:    Median of Two Sorted Arrays
 * Difficulty: Hard
 * Source:     http://leetcode.com/onlinejudge#question_4
 * Notes:
 * There are two sorted arrays SimHash and B of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p/>
 * Solution: 1. O(m+n)
 * 2. O(log(m+n))
 * <p/>
 * 寻找两个已排序数组的中位数，要求时间复杂度为 log(m+n).
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/9/17
 * Time: 9:44
 */
public class MedianOfTwoSortedArrays {


    public double findMedianSortedArrays(int[] a, int[] b) {
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

        if ((total & 1) == 0) //偶数个
            return (prev + last) / 2.0;
        else //奇数个
            return last;
    }


    public static void main(String[] args) {
        int[] a = {1};
        int[] b = {2, 4};

        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        double median = medianOfTwoSortedArrays.findMedianSortedArrays(a, b);
        System.out.println(median);
        String one = Integer.toBinaryString(178);
        String two = Integer.toBinaryString(143);


        System.out.println(one);
        System.out.println(two);
        System.out.println(178 & 143);


    }

}
