package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Arrays;

/**
 * 1547. 切棍子的最小成本
 * 算术评级: 8
 * 第 201 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2116
 * 相关标签
 * 相关企业
 * 提示
 * 有一根长度为 n 个单位的木棍，棍上从 0 到 n 标记了若干位置。例如，长度为 6 的棍子可以标记如下：
 * <p>
 * 给你一个整数数组 cuts ，其中 cuts[i] 表示你需要将棍子切开的位置。
 * <p>
 * 你可以按顺序完成切割，也可以根据需要更改切割的顺序。
 * <p>
 * 每次切割的成本都是当前要切割的棍子的长度，切棍子的总成本是历次切割成本的总和。
 * 对棍子进行切割将会把一根木棍分成两根较小的木棍（这两根木棍的长度和就是切割前木棍的长度）。请参阅第一个示例以获得更直观的解释。
 * <p>
 * 返回切棍子的 最小总成本 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 7, cuts = [1,3,4,5]
 * 输出：16
 * 解释：按 [1, 3, 4, 5] 的顺序切割的情况如下所示：
 * <p>
 * 第一次切割长度为 7 的棍子，成本为 7 。第二次切割长度为 6 的棍子（即第一次切割得到的第二根棍子），第三次切割为长度 4 的棍子，
 * 最后切割长度为 3 的棍子。总成本为 7 + 6 + 4 + 3 = 20 。
 * 而将切割顺序重新排列为 [3, 5, 1, 4] 后，总成本 = 16（如示例图中 7 + 4 + 3 + 2 = 16）。
 * 示例 2：
 * <p>
 * 输入：n = 9, cuts = [5,6,1,4,2]
 * 输出：22
 * 解释：如果按给定的顺序切割，则总成本为 25 。总成本 <= 25 的切割顺序很多，例如，[4, 6, 5, 2, 1] 的总成本 = 22，是所有可能方案中成本最小的。
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10^6
 * 1 <= cuts.length <= min(n - 1, 100)
 * 1 <= cuts[i] <= n - 1
 * cuts 数组中的所有整数都 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-cost-to-cut-a-stick/description/?envType=daily-question&envId=2024-11-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1547_MinCost {
    public static void main(String[] args) {
        L1547_MinCost l1547MinCost = new L1547_MinCost();
        System.out.println(l1547MinCost.minCost(9, new int[]{5, 6, 1, 4, 2}));
    }

    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int[] newCuts = new int[cuts.length + 2];
        System.arraycopy(cuts, 0, newCuts, 1, cuts.length);
        newCuts[newCuts.length - 1] = n;
        int[][] memo = new int[cuts.length + 2][cuts.length + 2];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs2(newCuts, 0, newCuts.length - 1, memo);
    }

    private int dfs2(int[] cuts, int left, int right, int[][] memo) {
        if (left + 1 >= right) {
            //这时候不用切割了
            return 0;
        }
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = left + 1; i < right; i++) {
            int v1 = dfs2(cuts, left, i, memo) + dfs2(cuts, i, right, memo);
            ans = Math.min(ans, v1);
        }
        return memo[left][right] = ans + cuts[right] - cuts[left];
    }
}
