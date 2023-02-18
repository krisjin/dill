package dill.lee.array;

/**
 * 盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water
 * //
 * 每个点
 * //
 * <pre>
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * </pre>
 */
public class ContainerWithMostWater11 {

    //暴力法
    public static int maxArea1(int[] nums) {
        int maxArea = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            for (int j = i + 1; j < nums.length; ++j) {
                int area = (j - i) * Math.min(nums[i], nums[j]);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }


    /**
     * 最初我们考虑由最外围两条线段构成的区域。现在，为了使面积最大化，我们需要考虑更长的两条线段之间的区域。
     * 如果我们试图将指向较长线段的指针向内侧移动，矩形区域的面积将受限于较短的线段而不会获得任何增加。但是，
     * 在同样的条件下，移动指向较短线段的指针尽管造成了矩形宽度的减小，但却可能会有助于面积的增大。
     * 因为移动较短线段的指针会得到一条相对较长的线段，这可以克服由宽度减小而引起的面积减小。
     *
     * @param nums
     * @return
     */
    public static int maxArea2(int[] nums) {
        int maxArea = 0, l = 0, r = nums.length - 1;
        //左指针 右指针 0 5
        while (l < r) { //左边指针小于右边指针，作为遍历条件，大于等于结束循环
            //左右指针高度，取做小的高度乘以 右指针减左指针宽度，计算面积
            maxArea = Math.max(maxArea, Math.min(nums[l], nums[r]) * (r - l));
            if (nums[l] < nums[r])//移动指针，左值小于幼稚
                l++;
            else r--;
        }
        return maxArea;
    }


    public static int maxArea(int[] container) {
        int max = 0;
        for (int i = 0, j = container.length - 1; i < j; ) {
            int minHeight = container[i] < container[j] ? container[i++] : container[j--];
            max = Math.max(max, (j - i + 1) * minHeight);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] b = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(b);
        System.err.println(maxArea);
    }
}
