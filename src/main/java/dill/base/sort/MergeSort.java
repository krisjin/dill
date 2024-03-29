package dill.base.sort;

/**
 * 归并排序，归并排序是一种典型的分治应用。
 * 核心：将两个有序对数组归并成一个更大的有序数组。通常做法为递归排序，并将两个不同的有序数组归并到第三个数组中。
 */
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        mergeSort(arr);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int[] helper = new int[array.length];
        // copy array to helper
        for (int k = low; k <= high; k++) {
            helper[k] = array[k];
        }
        // merge array[low...mid] and array[mid + 1...high]
        int i = low, j = mid + 1;

        for (int k = low; k <= high; k++) {
            // k means current location
            if (i > mid) {
                // no item in left part
                array[k] = helper[j];
                j++;
            } else if (j > high) {
                // no item in right part
                array[k] = helper[i];
                i++;
            } else if (helper[i] > helper[j]) {
                // get smaller item in the right side
                array[k] = helper[j];
                j++;
            } else {
                // get smaller item in the left side
                array[k] = helper[i];
                i++;
            }
        }
    }

    /**
     * 设定两个指针，最初位置分别为两个已经排序序列的起始位置
     *
     * @param array
     * @param low
     * @param high
     */
    public static void sort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        //中出中间索引 min= le
        //int mid = low + (high - low) / 2;
        int mid = (low + high) / 2;

        sort(array, low, mid);

        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    public static void mergeSort(int[] array) {
        sort(array, 0, array.length - 1);
    }
}
