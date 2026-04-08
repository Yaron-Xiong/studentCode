package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3418. 机器人可以获得的最大金币数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的网格。一个机器人从网格的左上角 (0, 0) 出发，目标是到达网格的右下角 (m - 1, n - 1)。在任意时刻，机器人只能向右或向下移动。
 * <p>
 * 网格中的每个单元格包含一个值 coins[i][j]：
 * <p>
 * 如果 coins[i][j] >= 0，机器人可以获得该单元格的金币。
 * 如果 coins[i][j] < 0，机器人会遇到一个强盗，强盗会抢走该单元格数值的 绝对值 的金币。
 * 机器人有一项特殊能力，可以在行程中 最多感化 2个单元格的强盗，从而防止这些单元格的金币被抢走。
 * <p>
 * 注意：机器人的总金币数可以是负数。
 * <p>
 * 返回机器人在路径上可以获得的 最大金币数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入： coins = [[0,1,-1],[1,-2,3],[2,-3,4]]
 * <p>
 * 输出： 8
 * <p>
 * 解释：
 * <p>
 * 一个获得最多金币的最优路径如下：
 * <p>
 * 从 (0, 0) 出发，初始金币为 0（总金币 = 0）。
 * 移动到 (0, 1)，获得 1 枚金币（总金币 = 0 + 1 = 1）。
 * 移动到 (1, 1)，遇到强盗抢走 2 枚金币。机器人在此处使用一次感化能力，避免被抢（总金币 = 1）。
 * 移动到 (1, 2)，获得 3 枚金币（总金币 = 1 + 3 = 4）。
 * 移动到 (2, 2)，获得 4 枚金币（总金币 = 4 + 4 = 8）。
 * 示例 2：
 * <p>
 * 输入： coins = [[10,10,10],[10,10,10]]
 * <p>
 * 输出： 40
 * <p>
 * 解释：
 * <p>
 * 一个获得最多金币的最优路径如下：
 * <p>
 * 从 (0, 0) 出发，初始金币为 10（总金币 = 10）。
 * 移动到 (0, 1)，获得 10 枚金币（总金币 = 10 + 10 = 20）。
 * 移动到 (0, 2)，再获得 10 枚金币（总金币 = 20 + 10 = 30）。
 * 移动到 (1, 2)，获得 10 枚金币（总金币 = 30 + 10 = 40）。
 * <p>
 * 提示：
 * <p>
 * m == coins.length
 * n == coins[i].length
 * 1 <= m, n <= 500
 * -1000 <= coins[i][j] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-amount-of-money-robot-can-earn/description/?envType=daily-question&envId=2026-04-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3418_MaximumAmount {
    public static void main(String[] args) {
        L3418_MaximumAmount l3418MaximumAmount = new L3418_MaximumAmount();
        System.out.println(l3418MaximumAmount.maximumAmount(new int[][]{{4, -16, 1, -11}, {6, 18, -17, 14}, {16, -10, 9, 3}, {-11, 17, 0, -11}}));
        System.out.println(l3418MaximumAmount.maximumAmount(new int[][]{{0, 1, -1}, {1, -2, 3}, {2, -3, 4}}));
        System.out.println(l3418MaximumAmount.maximumAmount(new int[][]{{-16, 8, -7, -19}, {6, 3, -10, 13}, {13, 15, 4, -3}, {-16, 4, 19, -12}}));
        System.out.println(l3418MaximumAmount.maximumAmount(new int[][]{{0, 1, -1}, {1, -2, 3}, {2, -3, 4}}));
        System.out.println(l3418MaximumAmount.maximumAmount(new int[][]{{10, 10, 10}, {10, 10, 10}}));
    }

    public int maximumAmount(int[][] coins) {
        int[][][] dp = new int[coins.length][coins[0].length][3];
        dp[0][0][0] = coins[0][0];
        dp[0][0][1] = Math.max(0, coins[0][0]);
        dp[0][0][2] = Math.max(0, coins[0][0]);

        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i][0] = dp[0][i - 1][0] + coins[0][i];
            dp[0][i][1] = Math.max(dp[0][i - 1][0] + Math.max(0, coins[0][i]), dp[0][i - 1][1] + coins[0][i]);
            dp[0][i][2] = Math.max(dp[0][i - 1][1] + Math.max(0, coins[0][i]), dp[0][i - 1][2] + coins[0][i]);
        }

        for (int i = 1; i < dp.length; i++) {
            dp[i][0][0] = dp[i - 1][0][0] + coins[i][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][0] + Math.max(0, coins[i][0]), dp[i - 1][0][1] + coins[i][0]);
            dp[i][0][2] = Math.max(dp[i - 1][0][1] + Math.max(0, coins[i][0]), dp[i - 1][0][2] + coins[i][0]);
        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < coins[i].length; j++) {
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + coins[i][j];

                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + coins[i][j];
                dp[i][j][1] = Math.max(dp[i][j][1], Math.max(dp[i - 1][j][0], dp[i][j - 1][0]) + Math.max(coins[i][j], 0));

                dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i][j - 1][2]) + coins[i][j];
                dp[i][j][2] = Math.max(dp[i][j][2], Math.max(dp[i - 1][j][1], dp[i][j - 1][1]) + Math.max(coins[i][j], 0));
            }
        }

        int[] ints = dp[dp.length - 1][dp[0].length - 1];
        int ans = Integer.MIN_VALUE;
        for (int anInt : ints) {
            ans = Math.max(ans, anInt);
        }
        return ans;
    }


    public int maximumAmount2(int[][] coins) {
        int[][][] memo = new int[coins.length][coins[0].length][3];
        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, Integer.MIN_VALUE);
            }
        }
        return dfs2(0, 0, 2, coins, memo);
    }

    private int dfs2(int x, int y, int k, int[][] coins, int[][][] memo) {
        if (x >= coins.length || y >= coins[0].length) {
            return Integer.MIN_VALUE + 5000;
        }
        if (memo[x][y][k] != Integer.MIN_VALUE) {
            return memo[x][y][k];
        }
        if (x == coins.length - 1 && y == coins[0].length - 1) {
            if (coins[x][y] < 0) {
                return k > 0 ? 0 : coins[x][y];
            }
            return coins[x][y];
        }
        int ans = dfs2(x + 1, y, k, coins, memo) + coins[x][y];
        ans = Math.max(ans, dfs2(x, y + 1, k, coins, memo) + coins[x][y]);
        if (coins[x][y] < 0 && k > 0) {
            ans = Math.max(ans, dfs2(x + 1, y, k - 1, coins, memo));
            ans = Math.max(ans, dfs2(x, y + 1, k - 1, coins, memo));
        }
        memo[x][y][k] = ans;
        return ans;
    }
}
