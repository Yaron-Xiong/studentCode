package com.accompnay.TopicAlgorithms.practiceSet.dp.stock;

/**
 * 309. 最佳买卖股票时机含冷冻期
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,2,3,0,2]
 * 输出: 3
 * 解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 * 示例 2:
 * <p>
 * 输入: prices = [1]
 * 输出: 0
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 5000
 * 0 <= prices[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitV {
	public static void main(String[] args) {
		MaxProfitV maxProfitV = new MaxProfitV();
		int i = maxProfitV.maxProfit(new int[]{1, 2, 3, 0, 2});
		System.out.println(i);
	}

	public int maxProfit(int[] prices) {
		int[][] dp = new int[prices.length][2];
		for (int i = 0; i < prices.length; i++) {
			if (i == 0) {
				dp[i][1] = -prices[i];
				dp[i][0] = 0;
				continue;
			}
			dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
			if (i - 2 < 0) {
				dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
				continue;
			}
			dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
		}
		return dp[prices.length - 1][0];
	}
}
