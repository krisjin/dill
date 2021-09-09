package dill.lee;

/**
 * 二分查找
 */
public class BinarySearch704 {

    public static int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;//防止left+right溢出
            if (target < nums[mid]) hi = mid - 1;
            else if (target > nums[mid]) lo = mid + 1;
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


    //二分查找模板
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int index = binarySearch(nums, 12);
//        int index = recursionSearch(10, nums);
        System.out.println(index);
    }

}




