package dill.base.array;

/**
 * @User krisjin
 * @Date 2020/9/24
 */
public class Ops {
    /**
     * 数组求最大值
     * 使用一个地址，存储最大值。迭代遍历数组，迭代中的每个元素值都与该最大值进行比较，当num[i] 大于maxVal，执行maxVal = numArr[i]
     *
     * @param numArr
     * @return
     */
    public static int maxVal(int[] numArr) {
        int maxVal = 0;
        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] > maxVal) maxVal = numArr[i];
        }
        return maxVal;
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
