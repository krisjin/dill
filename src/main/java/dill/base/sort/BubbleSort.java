package dill.base.sort;


/**
 * 人生态度，言如意，调整，真意
 * 比较，一次次的向上飘移
 */
public final class BubbleSort {

    /**
     * 1.嵌套循环
     * 2.嵌套循环比较大小，使用临时的进行进行交换
     *
     * @param nums
     */
    public static void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (nums[j] < nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void aa(int nums[]) {

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - 1; j++) {
                if (nums[j] < nums[j] + 1) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                }
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {55, 6, 5, 3, 1, 8, 7, 2, 4, 12};
        sort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

}
