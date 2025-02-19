package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2944. 购买水果需要的最少金币数
 * 算术评级: 5
 * 第 118 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1709
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 下标从 1 开始的 整数数组 prices ，其中 prices[i] 表示你购买第 i 个水果需要花费的金币数目。
 * <p>
 * 水果超市有如下促销活动：
 * <p>
 * 如果你花费 prices[i] 购买了下标为 i 的水果，那么你可以免费获得下标范围在 [i + 1, i + i] 的水果。
 * 注意 ，即使你 可以 免费获得水果 j ，你仍然可以花费 prices[j] 个金币去购买它以获得它的奖励。
 * <p>
 * 请你返回获得所有水果所需要的 最少 金币数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [3,1,2]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 用 prices[0] = 3 个金币购买第 1 个水果，你可以免费获得第 2 个水果。
 * 用 prices[1] = 1 个金币购买第 2 个水果，你可以免费获得第 3 个水果。
 * 免费获得第 3 个水果。
 * 请注意，即使您可以免费获得第 2 个水果作为购买第 1 个水果的奖励，但您购买它是为了获得其奖励，这是更优化的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：prices = [1,10,1,1]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 用 prices[0] = 1 个金币购买第 1 个水果，你可以免费获得第 2 个水果。
 * 免费获得第 2 个水果。
 * 用 prices[2] = 1 个金币购买第 3 个水果，你可以免费获得第 4 个水果。
 * 免费获得第 4 个水果。
 * 示例 3：
 * <p>
 * 输入：prices = [26,18,6,12,49,7,45,45]
 * <p>
 * 输出：39
 * <p>
 * 解释：
 * <p>
 * 用 prices[0] = 26 个金币购买第 1 个水果，你可以免费获得第 2 个水果。
 * 免费获得第 2 个水果。
 * 用 prices[2] = 6 个金币购买第 3 个水果，你可以免费获得第 4，5，6（接下来的三个）水果。
 * 免费获得第 4 个水果。
 * 免费获得第 5 个水果。
 * 用 prices[5] = 7 个金币购买第 6 个水果，你可以免费获得第 7 和 第 8 个水果。
 * 免费获得第 7 个水果。
 * 免费获得第 8 个水果。
 * 请注意，即使您可以免费获得第 6 个水果作为购买第 3 个水果的奖励，但您购买它是为了获得其奖励，这是更优化的。
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 1000
 * 1 <= prices[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-coins-for-fruits/?envType=daily-question&envId=2025-02-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2944_MinimumCoins {
    public static void main(String[] args) {
        L2944_MinimumCoins l2944MinimumCoins = new L2944_MinimumCoins();
        System.out.println(l2944MinimumCoins.minimumCoins(new int[]{1, 10, 1, 1}));
    }

    public int minimumCoins(int[] prices) {
        return dfs2(0, prices);
    }

    Map<Integer, Integer> memo = new HashMap<>();

    /**
     * 从i~ n-1 需要的钱
     */
    private int dfs2(int i, int[] prices) {
        //免费水果区间
        int left = i + 1;
        int right = 2 * i + 1;
        if (right >= prices.length - 1) {
            return prices[i];
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for (int j = left; j <= right + 1; j++) {
            //选择购买j
            ans = Math.min(ans, dfs2(j, prices) + prices[i]);
        }
        ans = ans == Integer.MAX_VALUE ? prices[i] : ans;
        memo.put(i, ans);
        return ans;
    }
}
