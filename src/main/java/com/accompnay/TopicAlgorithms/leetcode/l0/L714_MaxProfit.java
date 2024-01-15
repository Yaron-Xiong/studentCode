package com.accompnay.TopicAlgorithms.leetcode.l0;

/**
 * 714. 买卖股票的最佳时机含手续费
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [1, 3, 2, 8, 4, 9], fee = 2
 * 输出：8
 * 解释：能够达到的最大利润:
 * 在此处买入 prices[0] = 1
 * 在此处卖出 prices[3] = 8
 * 在此处买入 prices[4] = 4
 * 在此处卖出 prices[5] = 9
 * 总利润: ((8 - 1) - 2) + ((9 - 4) - 2) = 8
 * 示例 2：
 * <p>
 * 输入：prices = [1,3,7,5,10,3], fee = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5 * 104
 * 1 <= prices[i] < 5 * 104
 * 0 <= fee < 5 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/?envType=daily-question&envId=2023-10-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L714_MaxProfit {
    public static void main(String[] args) {
        L714_MaxProfit l714MaxProfit = new L714_MaxProfit();
        System.out.println(l714MaxProfit.maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    public int maxProfit(int[] prices, int fee) {
        int dp_0 = 0;
        int dp_1 = -prices[0] - fee;
        for (int i = 1; i < prices.length; i++) {
            int curDp_0 = Math.max(dp_1 + prices[i], dp_0);
            int curDp_1 = Math.max(dp_1, dp_0 - prices[i] - fee);
            dp_0 = curDp_0;
            dp_1 = curDp_1;
        }
        return Math.max(dp_0, dp_1);
    }
}
