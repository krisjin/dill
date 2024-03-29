package dill.base.array;

/**
 * 数组操作类
 */
public class ArrayOps {

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
            if (numArr[i] > maxVal) {
                maxVal = numArr[i];
            }
        }
        return maxVal;
    }

    /**
     * @param numArr
     * @return
     */
    public static double avg(double numArr[]) {
        double sum = 0;
        for (int i = 0; i < numArr.length; i++) {
            sum += numArr[i];
        }
        double avg = sum / numArr.length;
        return avg;
    }

    /**
     * int数组反转, 使用numArr[N - 1 - i] 从数组尾部与数据头部进行交换
     *
     * @param numArr
     */
    public static void reverse(int numArr[]) {
        int len = numArr.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = numArr[i];
            numArr[i] = numArr[len - 1 - i];
            numArr[len - 1 - i] = temp;
        }
    }


    /**
     * 反转数组
     *
     * @param arr
     * @return
     */
    public static int[] reverseArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] numArr = {1, 2, 3, 4, 5, 6, 7};
        reverseArray(numArr);
        for (int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i] + " ");
        }
    }

}