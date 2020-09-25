package dill.base;

/**
 * 二分查找
 *
 * @author krisjin on 2019/5/9
 */
public class BinarySearch {


    public static int rank(int key, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < arr[mid]) hi = mid - 1;
            else if (key > arr[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }


    public static int recursionSearch(int key, int[] nums) {
        return recursionSearch(key, nums, 0, nums.length - 1);
    }

    public static int recursionSearch(int key, int[] nums, int lo, int hi) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (key < nums[mid]) return recursionSearch(key, nums, lo, mid - 1);
        else if (key > nums[mid]) return recursionSearch(key, nums, mid + 1, hi);
        else return mid;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

//        int index = rank(3, nums);
        int index = recursionSearch(10, nums);

        System.out.println(index);
    }

}




