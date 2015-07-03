package org.leetcode.land.array;

/**
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/7/3
 * Time: 9:06
 */
public class RemoveDuplicatesFromSortedArrayII {

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        if (len <= 2) {
            return len;
        }
        int retLen = 2;
        for (int i = 2; i < len; i++) {
            if (nums[i] != nums[retLen - 2]) {
                nums[retLen++] = nums[i];
            }
        }
        return retLen;
    }

    public static void main(String[] args) {

        int[] nums = {1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3};
        int len = removeDuplicates(nums);
        System.out.println(len);
    }
}
