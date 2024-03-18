package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1155. 掷骰子等于目标和的方法数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n ,  k 和 target ，返回可能的方式(从总共 kn 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 109 + 7 取模 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你扔一个有 6 个面的骰子。
 * 得到 3 的和只有一种方法。
 * 示例 2：
 * <p>
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你扔两个骰子，每个骰子有 6 个面。
 * 得到 7 的和有 6 种方法：1+6 2+5 3+4 4+3 5+2 6+1。
 * 示例 3：
 * <p>
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须是对 109 + 7 取模。
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 */
public class L1155_NumRollsToTarget {
    public static void main(String[] args) {
        L1155_NumRollsToTarget l1155NumRollsToTarget = new L1155_NumRollsToTarget();
        System.out.println(l1155NumRollsToTarget.numRollsToTarget(1, 6, 3));
    }

    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n + 1][Math.max(target + 1, k + 1)];
        for (int i = 1; i <= k; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                for (int curK = 1; curK <= k; curK++) {
                    if (j - curK < 0 || dp[i - 1][j - curK] <= 0) {
                        continue;
                    }
                    dp[i][j] += dp[i - 1][j - curK];
                    dp[i][j] %= 1000000007L;
                }
            }
        }
        return (int) (dp[n][target] % 1000000007L);
    }


}
