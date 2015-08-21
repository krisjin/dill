package org.leetcode.sort;

/**
 * 选择排序
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/8/21
 * Time: 10:46
 */
public class SelectionSort {

    public static void sort(int[] arrs) {
        for (int i = 0; i < arrs.length; i++) {

            int minIndex = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j] < arrs[minIndex]) {
                    minIndex = j;
                }
            }
            int tmp = arrs[minIndex];
            arrs[minIndex] = arrs[i];
            arrs[i] = tmp;
        }
    }
}
