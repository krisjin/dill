package dill.lee.array;

/**
 * 二分查找,前提是数组是有序的
 * 二分查找也叫折半查找，该算法应用的前提是要有一个有序数列，比如数组。不是有序数列，要进行升序排序。
 * //*
 * 二分查找，是找寻目标的一种算法，在现实生活中，.......想了想....没想起来，可能更适用于数字计算机吧，把思绪拉回来。
 * 一种逻辑思路，解决问题的算法。
 * 二分找找的前提提交就是数据是有序的，只有这样，才能确定是查找大小的方向，主要的算法就是将一串数字，平均分成两份，并取中位数，通过中位数与目标值的比较
 * 确定方向，如果目标大于中位数，向右移
 * <p>
 * 取中间值  mid = low +（high - low）/ 2;
 */
public class BinarySearch704 {

    /**
     * 高低位,使用左右指针,确定下一次查找集合的边界，同时要取中间值，将中间值与目标值进行判断，确定下一次的左右指针
     *
     * @param nums   查找数组
     * @param target 目标值
     * @return
     */
    public static int search(int[] nums, int target) {
        int left = 0; //左边界值
        int right = nums.length - 1; //右边界最大取值，避免溢出+1
        //终止条件，在遍历的过程中，当左边值小于等于右边界值，退出循环，找到指定的目标值
        while (left <= right) {
            int mid = left + (right - left) / 2;//防止left+right溢出
            if (target < nums[mid]) {
                right = mid - 1;//如果目标值小于中间值，mid中间值-1，left指针不变，将中间值赋值给right指针
            } else if (target > nums[mid]) {
                left = mid + 1;//如果目标值大于中间值，mid中间值+1,且将中间值赋值给左指针，right指针不变
            } else {
                return mid;//找到目标中间值返回
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


    /**
     * 二分查找模板
     */
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




