package dill.base.array;

import java.util.Arrays;

/**
 * @User krisjin
 * @Date 2020/9/24
 */
public class Ops {

    public static int maxVal(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) max = nums[i];
        }
        return max;
    }

    public static double avg(double nums[]) {
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        double avg = sum / nums.length;
        return avg;
    }

    public static void reverse(int nums[]) {
        int N = nums.length;
        for (int i = 0; i < N / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[N - 1 - i];
            nums[N - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int ret = maxVal(nums);
        System.out.println(ret);

        reverse(nums);
        for (int i = 0; i < nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
