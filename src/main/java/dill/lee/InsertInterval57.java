package dill.lee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 插入区间
 * <pre>
 * 给出一个无重叠的 ，按照区间起始端点排序的区间列表。
 *
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 *
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 *  
 *
 * 注意：输入类型已在 2019 年 4 月 15 日更改。请重置为默认代码定义以获取新的方法签名。
 *
 * 链接：https://leetcode-cn.com/problems/insert-interval
 * </pre>
 *
 * @User krisjin
 * @date 2020/9/9
 */
public class InsertInterval57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] newIntervals = new int[intervals.length + 1][2];
        newIntervals[0] = newInterval;
        for (int i = 0; i < intervals.length; i++)
            System.arraycopy(intervals[i], 0, newIntervals[i + 1], 0, intervals[i].length);
        Arrays.sort(newIntervals, (v1, v2) -> v1[0] - v2[0]);

        List<int[]> mergedList = new ArrayList<int[]>();
        for (int i = 0; i < newIntervals.length; ++i) {
            int L = newIntervals[i][0], R = newIntervals[i][1];//当前区间
            //当前区间的左端点与mergedList最后一个数组中的右端点进行比较
            if (mergedList.size() == 0 || mergedList.get(mergedList.size() - 1)[1] < L) {
                mergedList.add(new int[]{L, R});
            } else {
                mergedList.get(mergedList.size() - 1)[1] = Math.max(mergedList.get(mergedList.size() - 1)[1], R);
            }
        }
        return mergedList.toArray(new int[mergedList.size()][]);
    }

    public int[][] insert2(int[][] intervals, int[] newInterval) {
        if (newInterval == null || intervals == null) {
            return intervals;
        }
        List<int[]> results = new ArrayList<int[]>();
        int insertPos = 0;//插入位置
        for (int[] interval : intervals) {//遍历intervals
            if (interval[1] < newInterval[0]) {//如果当前区间的end小于新区间的start，说明无重叠，直接添加
                results.add(new int[]{interval[0], interval[1]});
                insertPos++;//插入位置+1
            } else if (interval[0] > newInterval[1]) {//如果当前区间的start小于新区间的end，说明无重叠，直接添加
                results.add(new int[]{interval[0], interval[1]});
            } else {//否则一定有重叠，取两个区间的最小start，和最大end, 作为新区间
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        results.add(insertPos, new int[]{newInterval[0], newInterval[1]});
        return results.toArray(new int[results.size()][2]);

    }


    public static void main(String[] args) {
        InsertInterval57 mergeInterval56 = new InsertInterval57();
        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] insertVal = {4, 8};
//        int[][] intervals = {{1, 2}, {3, 4}, {0, 1}};
        int[][] res = mergeInterval56.insert(intervals, insertVal);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }
}
