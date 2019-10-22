package dill.base.sort;

/**
 * 冒泡排序
 * <p/>
 * User : krisibm@163.com
 * Date: 2015/8/20
 * Time: 13:09
 */
public final class BubbleSort {

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 1; j < len; j++) {
                if (arr[j - 1] > arr[j]) {
                    int tmp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }


    public static void main(String[] args) {

        int[] nums = {12, 343, 3, 4, 9};

        sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }


}
