package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1334. 阈值距离内邻居最少的城市
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 个城市，按从 0 到 n-1 编号。给你一个边数组 edges，
 * 其中 edges[i] = [fromi, toi, weighti] 代表 fromi 和 toi 两个城市之间的双向加权边，距离阈值是一个整数 distanceThreshold。
 * <p>
 * 返回能通过某些路径到达其他城市数目最少、且路径距离 最大 为 distanceThreshold 的城市。如果有多个这样的城市，则返回编号最大的城市。
 * <p>
 * 注意，连接城市 i 和 j 的路径的距离等于沿该路径的所有边的权重之和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]], distanceThreshold = 4
 * 输出：3
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 4 内的邻居城市分别是：
 * 城市 0 -> [城市 1, 城市 2]
 * 城市 1 -> [城市 0, 城市 2, 城市 3]
 * 城市 2 -> [城市 0, 城市 1, 城市 3]
 * 城市 3 -> [城市 1, 城市 2]
 * 城市 0 和 3 在阈值距离 4 以内都有 2 个邻居城市，但是我们必须返回城市 3，因为它的编号最大。
 * 示例 2：
 * <p>
 * 输入：n = 5, edges = [[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]], distanceThreshold = 2
 * 输出：0
 * 解释：城市分布图如上。
 * 每个城市阈值距离 distanceThreshold = 2 内的邻居城市分别是：
 * 城市 0 -> [城市 1]
 * 城市 1 -> [城市 0, 城市 4]
 * 城市 2 -> [城市 3, 城市 4]
 * 城市 3 -> [城市 2, 城市 4]
 * 城市 4 -> [城市 1, 城市 2, 城市 3]
 * 城市 0 在阈值距离 2 以内只有 1 个邻居城市。
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 100
 * 1 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 3
 * 0 <= fromi < toi < n
 * 1 <= weighti, distanceThreshold <= 10^4
 * 所有 (fromi, toi) 都是不同的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/?envType=daily-question&envId=2023-11-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1334_FindTheCity {
    public static void main(String[] args) {
        L1334_FindTheCity l1334FindTheCity = new L1334_FindTheCity();
        System.out.println(l1334FindTheCity.findTheCity(5, new int[][]{{0, 1, 2}, {0, 4, 8}, {1, 2, 3}, {1, 4, 2}, {2, 3, 1}, {3, 4, 1}}, 2));
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //计算每个点能抵达的城市列表
        //但是距离不能超过distanceThreshold
        int[][] graph = new int[n][n];
        for (int[] ints : graph) {
            Arrays.fill(ints, Integer.MAX_VALUE >> 1);
        }
        for (int[] edge : edges) {
            graph[edge[0]][edge[1]] = edge[2];
            graph[edge[1]][edge[0]] = edge[2];
        }
        int minArrival = Integer.MAX_VALUE;
        int ans = 0;
        int[][][] memo = new int[n][n][n];
        for (int i = 0; i < n; i++) {
            int canArrival = 0;
            for (int j = n - 1; j >= 0; j--) {
                //判断 i点跟j点的链接情况
                if (i == j) {
                    continue;
                }
                if (dfs2(i, j, n - 1, memo, graph) <= distanceThreshold) {
                    canArrival++;
                }
            }
            if (canArrival <= minArrival) {
                minArrival = canArrival;
                ans = i;
            }
        }
        return ans;
    }

    private int dfs2(int i, int j, int k, int[][][] memo, int[][] graph) {
        if (k < 0) {
            return graph[i][j];
        }
        if (memo[i][j][k] != 0) {
            return memo[i][j][k];
        }
        //假设从i->j 要经过k这个节点的最小值
        //假设选择k
        int v1 = dfs2(i, k, k - 1, memo, graph) + dfs2(k, j, k - 1, memo, graph);
        //假设不选择k
        int v2 = dfs2(i, j, k - 1, memo, graph);
        return memo[i][j][k] = Math.min(v1, v2);
    }

}
