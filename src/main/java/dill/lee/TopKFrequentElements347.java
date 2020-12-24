package dill.lee;

import java.util.*;

/**
 * 前 K 个高频元素
 * <pre>
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *  
 *
 * 提示：
 *
 * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 * 你可以按任意顺序返回答案。
 *
 * https://leetcode-cn.com/problems/top-k-frequent-elements
 * </pre>
 *
 * @User krisjin
 * @date 2020/9/10
 */
public class TopKFrequentElements347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);//计算频率
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            maxHeap.add(entry);
        }

        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
            Map.Entry<Integer, Integer> entry = maxHeap.poll();
            res.add(entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = new int[]{5, 5, 1, 1, 1, 2, 2, 3, 3, 3};
        TopKFrequentElements347 topKFrequentElements347 = new TopKFrequentElements347();

        List<Integer> res = topKFrequentElements347.topKFrequent(num, 2);
        for (Integer i : res)
            System.out.println(i);
    }
}
