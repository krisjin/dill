package dill.base.sort;

/**
 * 冒泡排序
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/8/20
 * Time: 13:09
 */
public final class BubbleSort {

    public static void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }


    public static void main(String[] args) {
        int[] nums = {6, 5, 3, 1, 8, 7, 2, 4};
        sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }


}
