package dill.lee.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * https://leetcode-cn.com/problems/two-sum
 * //
 * 整数数组，给定一个目标整数值，求数组中两个数相加等于目标的两个整数，并返回它们的数组下表。
 * 数组下标，数组是一个集合，通过下标操作数组中的元素。
 * 9=7+2,  2=9-7, 通过将加法的方式，改成减法 ，这就是一个思路转换，遍历整数数组，目标值减去遍历值target - arr[i] 得到另一个变量值。
 * 将另一个数组元素、元素下标存储起来，方便返回，这是使用map进行存储，key=element  value = index , 在每次遍历时，
 * //
 * <pre>
 * 给定一个整数数组 nums和一个目标值 target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 这道题目的意思是给定一个数组和一个值，让求出这个数组中两个值的和等于这个给定值的坐
 * 标。输出是有要求的，1， 坐标较小的放在前面，较大的放在后面。2， 这俩坐标不能为零。
 * 时间复杂度: O(N)******- 空间复杂度: O(N)
 * 思路：通过给出的已知条件：1.给定的数组中存在两个数相加等于目标值，要想求出求出数组中两个数的和等于目标值，
 * 可以在遍历数组时，先求出另一个值(目标值减当前遍历值)，并将该值存在map中。求出另一个值后，没次都要去map中查找该值，
 * 如果有那就直接返回了。没有就将当前遍历的值存如map中。key为元素值，value为元素索引
 * </pre>
 */
public class TwoSum1 {

    //使用map
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /**
     * @param nums   整数数组
     * @param target 目标值
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; ++i) {
            int temp = target - nums[i];//获取另一个值
            if (map.get(temp) != null) {
                return new int[]{map.get(temp), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 7, 2, 11, 15};
        TwoSum1 twoSum001 = new TwoSum1();
        int[] result = twoSum001.twoSum(nums, 9);

        System.out.println("index1=" + result[0] + ", index2=" + result[1]);
    }

}
