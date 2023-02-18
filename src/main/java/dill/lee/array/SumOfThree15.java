package dill.lee.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 * https://leetcode-cn.com/problems/3sum
 * <pre>
 *  给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 *
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 *
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * </pre>
 */
public class SumOfThree15 {


    /**
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len; i++) { //第一层循环 i
            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (i > 0 && nums[i] == nums[i - 1]) continue; // i去重,相邻数据相同跳过
            int l = i + 1; //左指针 i+1
            int r = len - 1; //右指针 len-1
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++; // 去重
                    while (l < r && nums[r] == nums[r - 1]) r--; // 去重
                    l++;
                    r--;
                } else if (sum < 0) l++;
                else if (sum > 0) r--;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] numArr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(numArr);
        System.out.println(result);
    }
}
