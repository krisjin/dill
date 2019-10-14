package dill.leetcode;

/**
 * @author krisjin on 2019/10/15
 *         <p>
 *         <p>
 *         链接：https://leetcode-cn.com/problems/move-zeroes
 *         给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *         示例:
 *         输入: [0,1,0,3,12]
 *         输出: [1,3,12,0,0]
 *         说明:
 *         必须在原数组上操作，不能拷贝额外的数组。
 *         尽量减少操作次数
 */
public class C0283 {


    public void moveZeros(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {

                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};

        C0283 c0283 = new C0283();
         c0283.moveZeros(nums);

        for (int i = 0; i < nums.length; ++i) {
            System.out.printf(nums[i] + " ");
        }
    }


}
