package dill.lee;

/**
 * 买卖股票的最佳时机
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
 * <pre>
 * 给定一个数组 prices ，它的第i 个元素prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 *
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 * </pre>
 */
public class BestTimeToBuyAndSellStock121 {

    /**
     * 使用暴力破解法，两层循环，计算最大的利润
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                //每次都计算利润，这样的算法不合乎正常的股票交易操作
                if (prices[j] - prices[i] > maxProfit) maxProfit = prices[j] - prices[i];
            }
        }
        return maxProfit;
    }

    /**
     * @param prices
     * @return
     */
    public static int maxProfit2(int prices[]) {
        //记录最低价格变量，在最低价格买入
        int minPrice = 0;
        //存储最大利润计算
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            //每次循环中都记录一个当前正在执行的最低价格,在记录最低价格的同时，计算最大的利润，如果当前利润大于已存储的最大利润，进行替换
            //搞清楚业务逻辑优化当前的算法，主要使用的循环和if判断条件
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static int test(int prices[]) {
        int maxProfit = 0;

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] stocks = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit2(stocks);
        System.out.println(maxProfit);

    }
}
