package com.accompnay.TopicAlgorithms.leetcode;

import com.google.common.collect.Lists;
import lombok.var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1595. 连通两组点的最小成本
 * 提示
 * 困难
 * 86
 * 相关企业
 * 给你两组点，其中第一组中有 size1 个点，第二组中有 size2 个点，且 size1 >= size2 。
 * <p>
 * 任意两点间的连接成本 cost 由大小为 size1 x size2 矩阵给出，
 * 其中 cost[i][j] 是第一组中的点 i 和第二组中的点 j 的连接成本。
 * 如果两个组中的每个点都与另一组中的一个或多个点连接，则称这两组点是连通的。
 * 换言之，第一组中的每个点必须至少与第二组中的一个点连接，且第二组中的每个点必须至少与第一组中的一个点连接。
 * <p>
 * 返回连通两组点所需的最小成本。
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [[15, 96], [36, 2]]
 * 输出：17
 * 解释：连通两组点的最佳方法是：
 * 1--A
 * 2--B
 * 总成本为 17 。
 * 示例 2：
 * <p>
 * 输入：cost = [[1, 3, 5], [4, 1, 1], [1, 5, 3]]
 * 输出：4
 * 解释：连通两组点的最佳方法是：
 * 1--A
 * 2--B
 * 2--C
 * 3--A
 * 最小成本为 4 。
 * 请注意，虽然有多个点连接到第一组中的点 2 和第二组中的点 A ，但由于题目并不限制连接点的数目，所以只需要关心最低总成本。
 * 示例 3：
 * <p>
 * 输入：cost = [[2, 5, 1], [3, 4, 7], [8, 1, 2], [6, 2, 4], [3, 8, 8]]
 * 输出：10
 * <p>
 * 提示：
 * <p>
 * size1 == cost.length
 * size2 == cost[i].length
 * 1 <= size1, size2 <= 12
 * size1 >= size2
 * 0 <= cost[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-cost-to-connect-two-groups-of-points/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1595_ConnectTwoGroups {
    public static void main(String[] args) {
        L1595_ConnectTwoGroups l1595ConnectTwoGroups = new L1595_ConnectTwoGroups();
        ArrayList<List<Integer>> list = new ArrayList<>();
        list.add(Lists.newArrayList(1, 3, 5));
        list.add(Lists.newArrayList(4, 1, 1));
        list.add(Lists.newArrayList(1, 5, 3));
        System.out.println(l1595ConnectTwoGroups.connectTwoGroups(list));
    }

    private List<List<Integer>> cost;
    private int[] minCost;
    private int[][] memo;

    public int connectTwoGroups(List<List<Integer>> cost) {
        this.cost = cost;
        int n = cost.size();
        int m = cost.get(0).size();
        minCost = new int[m];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        for (int j = 0; j < m; j++) {
            for (var c : cost) {
                minCost[j] = Math.min(minCost[j], c.get(j));
            }
        }

        memo = new int[n][1 << m];
        for (int i = 0; i < n; i++) {
            // -1 表示没有计算过
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, (1 << m) - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0) {
            int res = 0;
            for (int k = 0; k < minCost.length; k++) {
                // 第二组的点 k 未连接
                if ((j >> k & 1) == 1) {
                    // 去第一组找个成本最小的点连接
                    res += minCost[k];
                }
            }
            return res;
        }
        if (memo[i][j] != -1) {
            // 之前算过了
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        // 第一组的点 i 与第二组的点 k
        for (int k = 0; k < minCost.length; k++) {
            res = Math.min(res, dfs(i - 1, j & ~(1 << k)) + cost.get(i).get(k));
        }
        // 记忆化
        return memo[i][j] = res;
    }
}
