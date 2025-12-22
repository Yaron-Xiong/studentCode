package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3573. 买卖股票的最佳时机 V
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 prices，其中 prices[i] 是第 i 天股票的价格（美元），以及一个整数 k。
 * <p>
 * 你最多可以进行 k 笔交易，每笔交易可以是以下任一类型：
 * <p>
 * 普通交易：在第 i 天买入，然后在之后的第 j 天卖出，其中 i < j。你的利润是 prices[j] - prices[i]。
 * <p>
 * 做空交易：在第 i 天卖出，然后在之后的第 j 天买回，其中 i < j。你的利润是 prices[i] - prices[j]。
 * <p>
 * 注意：你必须在开始下一笔交易之前完成当前交易。此外，你不能在已经进行买入或卖出操作的同一天再次进行买入或卖出操作。
 * <p>
 * 通过进行 最多 k 笔交易，返回你可以获得的最大总利润。
 * <p>
 * 示例 1:
 * <p>
 * 输入: prices = [1,7,9,8,2], k = 2
 * <p>
 * 输出: 14
 * <p>
 * 解释:
 * <p>
 * 我们可以通过 2 笔交易获得 14 美元的利润：
 * 一笔普通交易：第 0 天以 1 美元买入，第 2 天以 9 美元卖出。
 * 一笔做空交易：第 3 天以 8 美元卖出，第 4 天以 2 美元买回。
 * 示例 2:
 * <p>
 * 输入: prices = [12,16,19,19,8,1,19,13,9], k = 3
 * <p>
 * 输出: 36
 * <p>
 * 解释:
 * <p>
 * 我们可以通过 3 笔交易获得 36 美元的利润：
 * 一笔普通交易：第 0 天以 12 美元买入，第 2 天以 19 美元卖出。
 * 一笔做空交易：第 3 天以 19 美元卖出，第 4 天以 8 美元买回。
 * 一笔普通交易：第 5 天以 1 美元买入，第 6 天以 19 美元卖出。
 * <p>
 * 提示:
 * <p>
 * 2 <= prices.length <= 103
 * 1 <= prices[i] <= 109
 * 1 <= k <= prices.length / 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-v/description/?envType=daily-question&envId=2025-12-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3573_MaximumProfit {
    public static void main(String[] args) {
        L3573_MaximumProfit l3573MaximumProfit = new L3573_MaximumProfit();
        System.out.println(l3573MaximumProfit.maximumProfit(new int[]{1, 7, 9, 8, 2}, 2));
        System.out.println(l3573MaximumProfit.maximumProfit(new int[]{12, 16, 19, 19, 8, 1, 19, 13, 9}, 3));
    }

    private static final long nge = Long.MIN_VALUE / 2;

    public long maximumProfit(int[] prices, int k) {
        long[][][] memo = new long[prices.length][3][k + 1];
        for (long[][] longs : memo) {
            for (long[] aLong : longs) {
                Arrays.fill(aLong, nge);
            }
        }
        //第几个元素、持有股票状态、剩余交易次数、价格
        return dfs2(0, 0, k, prices, memo);
    }

    private long dfs2(int i, int state, int k, int[] prices, long[][][] memo) {
        if (k < 0) {
            return nge;
        }
        if (i >= prices.length) {
            return state == 0 ? 0L : nge;
        }
        if (memo[i][state][k] != nge) {
            return memo[i][state][k];
        }
        //可以选择的操作 [不做、做多-买、做多-卖、做空-买、做空-卖]
        //不做
        long v = dfs2(i + 1, state, k, prices, memo);
        if (state == 0) {
            //做多-买
            v = Math.max(v, dfs2(i + 1, 1, k - 1, prices, memo) - prices[i]);
            //做空-买
            v = Math.max(v, dfs2(i + 1, 2, k - 1, prices, memo) + prices[i]);
        } else if (state == 1) {
            //做多-卖
            v = Math.max(v, dfs2(i + 1, 0, k, prices, memo) + prices[i]);
        } else {
            //做空-卖
            v = Math.max(v, dfs2(i + 1, 0, k, prices, memo) - prices[i]);
        }
        return memo[i][state][k] = v;
    }
}
