package dill.lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 合并区间
 * <pre>
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 *
 * 示例 1:
 *
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 *
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * https://leetcode-cn.com/problems/merge-intervals
 * </pre>
 *
 * @User krisjin
 * @Date 2020/9/25
 */
public class MergeInterval56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

        List<int[]> mergedList = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];//当前区间
            //当前区间的左端点与mergedList最后一个数组中的右端点进行比较
            if (mergedList.size() == 0 || mergedList.get(mergedList.size() - 1)[1] < L) {
                mergedList.add(new int[]{L, R});
            } else {
                mergedList.get(mergedList.size() - 1)[1] = Math.max(mergedList.get(mergedList.size() - 1)[1], R);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][2]);
    }

    public static void main(String[] args) {
        MergeInterval56 mergeInterval56 = new MergeInterval56();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//        int[][] intervals = {{1, 2}, {3, 4}, {0, 1}};
        int[][] res = mergeInterval56.merge(intervals);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

}
