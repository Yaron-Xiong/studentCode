package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3652. 按策略买卖股票的最佳时机
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数数组 prices 和 strategy，其中：
 * <p>
 * prices[i] 表示第 i 天某股票的价格。
 * strategy[i] 表示第 i 天的交易策略，其中：
 * -1 表示买入一单位股票。
 * 0 表示持有股票。
 * 1 表示卖出一单位股票。
 * 同时给你一个 偶数 整数 k，你可以对 strategy 进行 最多一次 修改。一次修改包括：
 * <p>
 * 选择 strategy 中恰好 k 个 连续 元素。
 * 将前 k / 2 个元素设为 0（持有）。
 * 将后 k / 2 个元素设为 1（卖出）。
 * 利润 定义为所有天数中 strategy[i] * prices[i] 的 总和 。
 * <p>
 * 返回你可以获得的 最大 可能利润。
 * <p>
 * 注意： 没有预算或股票持有数量的限制，因此所有买入和卖出操作均可行，无需考虑过去的操作。
 * <p>
 * 示例 1：
 * <p>
 * 输入： prices = [4,2,8], strategy = [-1,0,1], k = 2
 * <p>
 * 输出： 10
 * <p>
 * 解释：
 * <p>
 * 修改	策略	利润计算	利润
 * 原始	[-1, 0, 1]	(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8	4
 * 修改 [0, 1]	[0, 1, 1]	(0 × 4) + (1 × 2) + (1 × 8) = 0 + 2 + 8	10
 * 修改 [1, 2]	[-1, 0, 1]	(-1 × 4) + (0 × 2) + (1 × 8) = -4 + 0 + 8	4
 * 因此，最大可能利润是 10，通过修改子数组 [0, 1] 实现。
 * <p>
 * 示例 2：
 * <p>
 * 输入： prices = [5,4,3], strategy = [1,1,0], k = 2
 * <p>
 * 输出： 9
 * <p>
 * 解释：
 * <p>
 * 修改	策略	利润计算	利润
 * 原始	[1, 1, 0]	(1 × 5) + (1 × 4) + (0 × 3) = 5 + 4 + 0	9
 * 修改 [0, 1]	[0, 1, 0]	(0 × 5) + (1 × 4) + (0 × 3) = 0 + 4 + 0	4
 * 修改 [1, 2]	[1, 0, 1]	(1 × 5) + (0 × 4) + (1 × 3) = 5 + 0 + 3	8
 * 因此，最大可能利润是 9，无需任何修改即可达成。
 * <p>
 * 提示：
 * <p>
 * 2 <= prices.length == strategy.length <= 105
 * 1 <= prices[i] <= 105
 * -1 <= strategy[i] <= 1
 * 2 <= k <= prices.length
 * k 是偶数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-using-strategy/description/?envType=daily-question&envId=2025-12-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3652_MaxProfit {
    public static void main(String[] args) {
        L3652_MaxProfit l3652MaxProfit = new L3652_MaxProfit();
        System.out.println(l3652MaxProfit.maxProfit(new int[]{4, 7, 13}, new int[]{-1, -1, 0}, 2));
        System.out.println(l3652MaxProfit.maxProfit(new int[]{4, 2, 8}, new int[]{-1, 0, 1}, 2));
        System.out.println(l3652MaxProfit.maxProfit(new int[]{5, 4, 3}, new int[]{1, 1, 0}, 2));
    }

    public long maxProfit(int[] prices, int[] strategy, int k) {
        long sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += (long) strategy[i] * prices[i];
        }
        long ans = sum;
        long originLeft = 0;
        long originRight = 0;
        long curRight = 0;
        for (int i = 0; i < k; i++) {
            if (i < k / 2) {
                originLeft += (long) strategy[i] * prices[i];
            } else {
                curRight += prices[i];
                originRight += (long) strategy[i] * prices[i];
            }
        }
        ans = Math.max(ans, sum + curRight - originRight - originLeft);
        //滑动窗口
        for (int i = k; i < strategy.length; i++) {
            int left = i - k + 1;
            int right = i;
            int mid = (left + right) / 2;
            originLeft = originLeft - ((long) prices[left - 1] * strategy[left - 1]) + ((long) prices[mid] * strategy[mid]);
            originRight = originRight - ((long) prices[mid] * strategy[mid]) + ((long) prices[right] * strategy[right]);
            curRight = curRight - ((long) prices[mid]) + ((long) prices[right]);
            ans = Math.max(ans, sum + curRight - originRight - originLeft);
        }
        return ans;
    }
}
