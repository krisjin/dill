package dill.lee;

/**
 * 旋转数组
 *
 * @author krisjin on 2019/10/23
 * <p>
 * <pre>
 *  给定一个数组，将数组中的元素向右移动k个位置，其中k是非负数。
 *
 *  示例 1:
 *
 *  输入: [1,2,3,4,5,6,7] 和 k = 3
 *  输出: [5,6,7,1,2,3,4]
 *  解释:
 *  向右旋转 1 步: [7,1,2,3,4,5,6]
 *  向右旋转 2 步: [6,7,1,2,3,4,5]
 *  向右旋转 3 步: [5,6,7,1,2,3,4]
 *  示例 2:
 *
 *  输入: [-1,-100,3,99] 和 k = 2
 *  输出: [3,99,-1,-100]
 *  解释:
 *  向右旋转 1 步: [99,-1,-100,3]
 *  向右旋转 2 步: [3,99,-1,-100]
 *  说明:
 *
 *  尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 *  要求使用空间复杂度为 O(1) 的 原地 算法。
 *
 *  链接：https://leetcode-cn.com/problems/rotate-array
 * </pre>
 */
public class RotateArray189 {

    /**
     * 解法1
     *
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int temp, previous;
        for (int i = 0; i < k; i++) {
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }

    }

    /**
     * 这个方法基于这个事实：当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。
     * <p>
     * 在这个方法中，我们首先将所有元素反转。然后反转前 k 个元素，再反转后面 n-kn−k 个元素，就能得到想要的结果。
     * <p>
     * 假设 n=7n=7 且 k=3k=3 。
     *
     * @param nums
     * @param k
     */
    public void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 4;

        RotateArray189 rotateArray189 = new RotateArray189();
        rotateArray189.rotate2(nums, k);


    }
}
