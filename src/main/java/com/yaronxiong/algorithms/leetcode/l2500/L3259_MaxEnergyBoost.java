package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3259. 超级饮料的最大强化能量
 * 算术评级: 4
 * 第 411 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1484
 * 相关标签
 * 相关企业
 * 提示
 * 来自未来的体育科学家给你两个整数数组 energyDrinkA 和 energyDrinkB，数组长度都等于 n。这两个数组分别代表 A、B 两种不同能量饮料每小时所能提供的强化能量。
 * <p>
 * 你需要每小时饮用一种能量饮料来 最大化 你的总强化能量。
 * 然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任何强化能量）。
 * <p>
 * 返回在接下来的 n 小时内你能获得的 最大 总强化能量。
 * <p>
 * 注意 你可以选择从饮用任意一种能量饮料开始。
 * <p>
 * 示例 1：
 * <p>
 * 输入：energyDrinkA = [1,3,1], energyDrinkB = [3,1,1]
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 要想获得 5 点强化能量，需要选择只饮用能量饮料 A（或者只饮用 B）。
 * <p>
 * 示例 2：
 * <p>
 * 输入：energyDrinkA = [4,1,1], energyDrinkB = [1,1,3]
 * <p>
 * 输出：7
 * <p>
 * 解释：
 * <p>
 * 第一个小时饮用能量饮料 A。
 * 切换到能量饮料 B ，在第二个小时无法获得强化能量。
 * 第三个小时饮用能量饮料 B ，并获得强化能量。
 * <p>
 * 提示：
 * <p>
 * n == energyDrinkA.length == energyDrinkB.length
 * 3 <= n <= 105
 * 1 <= energyDrinkA[i], energyDrinkB[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-energy-boost-from-two-drinks/description/?envType=daily-question&envId=2024-11-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3259_MaxEnergyBoost {
    public static void main(String[] args) {
        L3259_MaxEnergyBoost l3259MaxEnergyBoost = new L3259_MaxEnergyBoost();
        System.out.println(l3259MaxEnergyBoost.maxEnergyBoost(new int[]{3, 3, 3}, new int[]{3, 4, 6}));
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        //在选择了1或者2时的最优解
        int n = energyDrinkB.length;
        long[][] dp = new long[2][n];
        dp[0][0] = energyDrinkA[0];
        dp[1][0] = energyDrinkB[0];
        dp[0][1] = dp[0][0] + energyDrinkA[1];
        dp[1][1] = dp[1][0] + energyDrinkB[1];
        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 2]) + energyDrinkA[i];
            dp[1][i] = Math.max(dp[1][i - 1], dp[0][i - 2]) + energyDrinkB[i];
        }
        return Math.max(dp[0][n - 1], dp[1][n - 1]);
    }

}
