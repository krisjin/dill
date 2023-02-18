package dill.lee.array;

/**
 * 加一
 * https://leetcode-cn.com/problems/plus-one
 * <pre>
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 *
 * 示例 1:
 *
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * 示例 2:
 *
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * </pre>
 */
public class PlusOne66 {

    /**
     * 1. 遍历整数数组，对每个数进行处理
     * 2. 先将数组中的一个整数+1
     * 3. 再将当前的整数取模(i%10),如果当前数要是进位的话，那么取余数为0，不是的话，返回原值
     * 4. 判断当前整数值是否为0，就继续循环操作，从步骤2开始，这里面有个细节就是，每次遍历中先对当前值+1
     * 5. 在最后如果没有在循环中执行return的话，那就是出现里[9,9,9] 这样的情况,所有的为都进位，那就要调整数组大小+1，并将下标是0的值设置为1
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public int[] plusOne2(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {9, 9, 9};
        PlusOne66 plusOne66 = new PlusOne66();

        nums = plusOne66.plusOne2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
