package org.leetcode.sort;

/**
 * 冒泡排序
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/8/20
 * Time: 13:09
 */
public final class BubbleSort {

    public static void sort(int[] arrs) {
        int len = arrs.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (arrs[j - 1] > arrs[j]) {
                    int tmp = arrs[j - 1];
                    arrs[j - 1] = arrs[j];
                    arrs[j] = tmp;
                }
            }
        }
    }
}
