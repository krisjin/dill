package dill.base.sort;

/**
 * <pre>
 * 核心：通过构建有序序列，对于未排序序列，在已排序序列中从后向前扫描(对于单向链表则只能从前往后遍历)，找到相应位置并插入。
 * 实现上通常使用in-place排序(需用到O(1)的额外空间)
 *
 * 从第一个元素开始，该元素可认为已排序
 * 取下一个元素，对已排序数组从后往前扫描
 * 若从排序数组中取出的元素大于新元素，则移至下一位置
 * 重复步骤3，直至找到已排序元素小于或等于新元素的位置
 * 插入新元素至该位置
 * 重复2~5
 * 性质：
 *
 * 交换操作和数组中倒置的数量相同
 * 比较次数>=倒置数量，<=倒置的数量加上数组的大小减一
 * 每次交换都改变了两个顺序颠倒的元素的位置，即减少了一对倒置，倒置数量为0时即完成排序。
 * 每次交换对应着一次比较，且1到N-1之间的每个i都可能需要一次额外的记录(a[i]未到达数组左端时)
 * 最坏情况下需要~N^2/2次比较和~N^2/2次交换，最好情况下需要N-1次比较和0次交换。
 * 平均情况下需要~N^2/4次比较和~N^2/4次交换
 * </pre>
 */
public class InsertionSort {

    public static void insertionSort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            int idx = i;
            int arrVal = arr[i];

            while (idx > 0 && arr[idx - 1] > arrVal) {
                arr[idx] = arr[idx - 1];
                idx -= 1;
            }

            arr[idx] = arrVal;
        }

        for (int item : arr) {
            System.out.print(item + " ");
        }
    }


    public static void main(String[] args) {
        int[] numberArr = {98, 87, 67, 99, 34, 32, 42, 13, 22, 55, 76, 1};

        insertionSort(numberArr);
    }


}
