package dill.off;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <pre>
 * 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *  
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * 链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 *
 * sort
 * </pre>
 *
 * @User krisjin
 * @date 2020/9/10
 */
public class O40 {

    /**
     * 堆使用
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = heap.poll();
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 6, 7, 1};
        int k = 3;
        int[] ans = getLeastNumbers(arr, k);

        for (int i:ans)
            System.err.println(i);
    }

}
