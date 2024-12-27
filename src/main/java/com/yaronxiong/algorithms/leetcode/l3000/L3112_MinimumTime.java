package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.*;

/**
 * 3112. 访问消失节点的最少时间
 * 算术评级: 5
 * 第 128 场双周赛
 * Q3
 * 1757
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维数组 edges 表示一个 n 个点的无向图，其中 edges[i] = [ui, vi, lengthi] 表示节点 ui 和节点 vi 之间有一条需要 lengthi 单位时间通过的无向边。
 * <p>
 * 同时给你一个数组 disappear ，其中 disappear[i] 表示节点 i 从图中消失的时间点，在那一刻及以后，你无法再访问这个节点。
 * <p>
 * 注意，图有可能一开始是不连通的，两个节点之间也可能有多条边。
 * <p>
 * 请你返回数组 answer ，answer[i] 表示从节点 0 到节点 i 需要的 最少 单位时间。如果从节点 0 出发 无法 到达节点 i ，那么 answer[i] 为 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,1,5]
 * <p>
 * 输出：[0,-1,4]
 * <p>
 * 解释：
 * <p>
 * 我们从节点 0 出发，目的是用最少的时间在其他节点消失之前到达它们。
 * <p>
 * 对于节点 0 ，我们不需要任何时间，因为它就是我们的起点。
 * 对于节点 1 ，我们需要至少 2 单位时间，通过 edges[0] 到达。但当我们到达的时候，它已经消失了，所以我们无法到达它。
 * 对于节点 2 ，我们需要至少 4 单位时间，通过 edges[2] 到达。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1,2],[1,2,1],[0,2,4]], disappear = [1,3,5]
 * <p>
 * 输出：[0,2,3]
 * <p>
 * 解释：
 * <p>
 * 我们从节点 0 出发，目的是用最少的时间在其他节点消失之前到达它们。
 * <p>
 * 对于节点 0 ，我们不需要任何时间，因为它就是我们的起点。
 * 对于节点 1 ，我们需要至少 2 单位时间，通过 edges[0] 到达。
 * 对于节点 2 ，我们需要至少 3 单位时间，通过 edges[0] 和 edges[1] 到达。
 * 示例 3：
 * <p>
 * 输入：n = 2, edges = [[0,1,1]], disappear = [1,1]
 * <p>
 * 输出：[0,-1]
 * <p>
 * 解释：
 * <p>
 * 当我们到达节点 1 的时候，它恰好消失，所以我们无法到达节点 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 5 * 104
 * 0 <= edges.length <= 105
 * edges[i] == [ui, vi, lengthi]
 * 0 <= ui, vi <= n - 1
 * 1 <= lengthi <= 105
 * disappear.length == n
 * 1 <= disappear[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-time-to-visit-disappearing-nodes/?envType=daily-question&envId=2024-07-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3112_MinimumTime {
    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        ans[0] = 0;
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int curNode = node[0];
            int cost = node[1];
            if (cost > ans[curNode]) {
                continue;
            }
            List<int[]> neighbors = graph[curNode];
            for (int[] neighbor : neighbors) {
                //判断能不能抵达邻居节点,如果不能则跳过
                int nextCost = neighbor[1] + cost;
                int neighborId = neighbor[0];
                if (nextCost < disappear[neighborId] && (ans[neighborId] < 0 || nextCost < ans[neighborId])) {
                    ans[neighborId] = nextCost;
                    queue.add(new int[]{neighborId, nextCost});
                }
            }
        }
        return ans;
    }

}
