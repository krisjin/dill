package dill.leetcode.sort;

/**
 * <pre>
 *  核心：快排是一种采用分治思想的排序算法，大致分为三个步骤。
 *  1.定基准——首先随机选择一个元素最为基准
 *  2.划分区——所有比基准小的元素置于基准左侧，比基准大的元素置于右侧
 *  3.递归调用——递归地调用此切分过程
 * </pre>
 * https://algorithm.yuanbin.me/zh-hans/basics_sorting/quick_sort.html
 */
public class QuickSort {


    public static void main(String[] args) {
        int unsortedArray[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        quickSort(unsortedArray);
        System.out.println("After sort: ");
        for (int item : unsortedArray) {
            System.out.print(item + " ");
        }
    }

    public static void quickSort2(int[] array, int l, int u) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();

        if (l >= u) return;
        int pivot = array[l];
        int left = l + 1;
        int right = u;
        while (left <= right) {
            while (left <= right && array[left] < pivot) {
                left++;
            }
            while (left <= right && array[right] >= pivot) {
                right--;
            }
            if (left > right) break;
            // swap array[left] with array[right] while left <= right
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
        }
        /* swap the smaller with pivot */
        int temp = array[right];
        array[right] = array[l];
        array[l] = temp;

        quickSort2(array, l, right - 1);
        quickSort2(array, right + 1, u);
    }

    public static void quickSort(int[] array) {
        quickSort2(array, 0, array.length - 1);
    }
}
