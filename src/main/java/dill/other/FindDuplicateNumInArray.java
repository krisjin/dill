package dill.other;

/**
 * <pre>
 *
 * 描述：
 * 在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 *
 * 解题思路
 *
 * 要求是时间复杂度 O(N)，空间复杂度 O(1)。因此不能使用排序的方法，也不能使用额外的标记数组。
 *
 * 对于这种数组元素在 [0, n-1] 范围内的问题，可以将值为 i 的元素调整到第 i 个位置上进行求解。
 *
 * 以 (2, 3, 1, 0, 2, 5) 为例，遍历到位置 4 时，该位置上的数为 2，但是第 2 个位置上已经有一个 2 的值了，因此可以知道 2 重复：
 *
 *
 * </pre>
 */
public class FindDuplicateNumInArray {

    public static boolean duplicate(int[] nums, int[] duplication) {
        if (nums == null || nums.length <= 0)
            return false;

        int length = nums.length;
        for (int i = 0; i < length; i++) {
            while (nums[i] != i) { //下表索引和值不能相等
                if (nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums, i, nums[i]);
            }
        }
        return false;
    }

    /**
     * 可以将值为 i 的元素调整到第 i 个位置上进行求解
     * @param nums
     * @param i
     * @param j
     */
    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {

        int[] arrs = {2, 3, 1, 0, 2, 5};
        int[] result = new int[arrs.length];
        duplicate(arrs, result);

        for (int i : result) {
            System.out.println(i);
        }

    }


}
