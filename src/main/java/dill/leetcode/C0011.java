package dill.leetcode;

/**
 * @author krisjin on 2019/10/16
 *         <p>
 *         给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 *         找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *         说明：你不能倾斜容器，且 n 的值至少为 2。
 *         <p>
 *         图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *         示例:
 *         <p>
 *         输入: [1,8,6,2,5,4,8,3,7]
 *         输出: 49
 *         链接：https://leetcode-cn.com/problems/container-with-most-water
 */
public class C0011 {


    public int maxArea(int[] b) {

        int max = 0;
        for (int i = 0; i < b.length - 1; ++i) {
            for (int j = i + 1; j < b.length; ++j) {
                int area = (j - i) * Math.min(b[i], b[j]);
                max = Math.max(max, area);
            }
        }
        return max;
    }


    public static void main(String[] args) {
        C0011 c0011 = new C0011();
        int[] b = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = c0011.maxArea(b);
        System.err.println(maxArea);
    }
}
