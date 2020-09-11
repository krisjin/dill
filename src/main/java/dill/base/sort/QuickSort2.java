package dill.base.sort;

/**
 * @User kisjin
 * @date 2020/9/12
 */
public class QuickSort2 {


    public static void quickSort(int[] array, int begin, int end) {
        if (end <= begin) return;
        int pivot = partition(array, begin, end);
        quickSort(array, begin, pivot - 1);
        quickSort(array, pivot + 1, end);
    }

    private static int partition(int[] arr, int begin, int end) {
        // pivot:标杆位置, counter:小于 pivot的元素的个数
        int pivot = end;
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[counter];
                arr[counter] = arr[i];
                arr[i] = temp;
                counter++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[counter];
        arr[counter] = temp;
        return counter;
    }

    public static void main(String[] args) {
        int data[] = new int[]{6, 5, 3, 1, 8, 7, 2, 4};
        quickSort(data, 0, data.length - 1);
        for (int item : data) {
            System.out.print(item + " ");
        }
    }

}
