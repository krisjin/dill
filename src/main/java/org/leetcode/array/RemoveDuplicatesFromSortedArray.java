package org.leetcode.array;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/1
 * Time: 22:35
 */
public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] arr) {
        int j = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (i == 0 || arr[i] != arr[i - 1]) {
                arr[j++] = arr[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2};
        int ret = removeDuplicates(arr);
        System.out.println(ret);
    }
}
