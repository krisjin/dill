package dill.lee.array;

/**
 * 二分查找,前提是数组是有序的
 * 二分查找也叫折半查找，该算法应用的前提是要有一个有序数列，比如数组。不是有序数列，要进行升序排序。
 * 取中间值  mid = low +（high - low）/ 2;
 */
public class BinarySearch704 {

    /**
     * @param nums   查找数组
     * @param target 目标值
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;//防止left+right溢出
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static int recursionSearch(int key, int[] nums) {
        return recursionSearch(key, nums, 0, nums.length - 1);
    }

    public static int recursionSearch(int target, int[] nums, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;//取中值
        if (target < nums[mid]) return recursionSearch(target, nums, left, mid - 1);
        else if (target > nums[mid]) return recursionSearch(target, nums, mid + 1, right);
        else return mid;
    }


    //二分查找模板
    public static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
//        int index = binarySearch(nums, 3);
        int index = recursionSearch(9, nums);
        System.out.println(index);
    }

}




