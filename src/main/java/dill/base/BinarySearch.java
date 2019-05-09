package dill.base;

/**
 *  二分搜索是一种在有序数组中寻找目标值的经典方法，也就是说使用前提是『有序数组』。非常简单的题中『有序』特征非常明显，
 * 但更多时候可能需要我们自己去构造『有序数组』。下面我们从最基本的二分搜索开始逐步深入。
 * <p>
 * <p>
 * <p>
 * <pre>
 *
 * 以lowerBound的实现为例，以上二分搜索的模板有几个非常优雅的实现：
 *
 * while 循环中 lb + 1 < ub, 而不是等号，因为取等号可能会引起死循环。初始化lb < ub 时，最后循环退出时一定有lb + 1 == ub.
 * mid = lb + (ub - lb) / 2, 可有效防止两数相加后溢出。
 * lb 和 ub 的初始化，初始化为数组的两端以外，这种初始化方式比起0 和nums.length - 1 有不少优点，详述如下。
 * 如果遇到有问插入索引的位置时，可以分三种典型情况：
 *
 * 目标值在数组范围之内，最后返回值一定是lb + 1
 * 目标值比数组最小值还小，此时lb 一直为-1, 故最后返回lb + 1 也没错，也可以将-1 理解为数组前一个更小的值
 * 目标值大于等于数组最后一个值，由于循环退出条件为lb + 1 == ub, 那么循环退出时一定有lb = A.length - 1, 应该返回lb + 1
 * 综上所述，返回lb + 1是非常优雅的实现。其实以上三种情况都可以统一为一种方式来理解，即索引-1 对应于数组前方一个非常小的数，
 * 索引ub 即对应数组后方一个非常大的数，那么要插入的数就一定在lb 和ub 之间了。
 *
 * 有时复杂的边界条件处理可以通过『补项』这种优雅的方式巧妙处理。
 *
 * 关于lb 和 ub 的初始化，由于mid = lb + (ub - lb) / 2, 且有lb + 1 < ub，故 mid 还是有可能为ub - 1或者lb + 1的，在需要访问mid + 1或者mid - 1处索引的元素时可能会越界。
 * 这时候就需要将初始化方式改为lb = 0, ub = A.length - 1 了，最后再加一个关于lb, ub 处索引元素的判断即可。如 Search for a Range 和 Find Peak Element.
 * 尤其是 Find Peak Element 中 lb 和 ub 的初始值如果初始化为-1和数组长度会带来一些麻烦。
 * </pre>
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 4, 6, 6, 6, 13, 18};
        System.out.println(lowerBound(nums, 6)); // 5
        System.out.println(upperBound(nums, 6)); // 7
        System.out.println(lowerBound(nums, 7)); // 8
        System.out.println(upperBound(nums, 7)); // 7


        System.out.println("##########递归调用##############");
        System.out.println(rank(5, nums));

        System.out.println("##########22222##############");
        System.out.println(BinarySearchUtil.rank(4, nums));


    }

    /*
     * nums[index] >= target, min(index)
     */
    public static int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] < target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb + 1;
    }

    /*
     * nums[index] <= target, max(index)
     */
    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return ub - 1;
    }


    //递归调用
    public static int rank(int key, int[] arr) {
        return rank(key, arr, 0, arr.length - 1);
    }

    public static int rank(int key, int[] arr, int lo, int hi) {
        //如果key存在于arr[]中，它的索引不会小于lo且不会大于hi
        if (lo > hi) {
            return -1;
        }

        int mid = lo + (hi - lo) / 2;
        if (key < arr[mid])
            return rank(key, arr, lo, mid - 1);
        else if (key > arr[mid])
            return rank(key, arr, mid + 1, hi);
        else return mid;

    }
}
