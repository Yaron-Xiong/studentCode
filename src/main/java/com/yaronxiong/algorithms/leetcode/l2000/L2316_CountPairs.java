package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2316. 统计无向图中无法互相到达点对数
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。
 * 同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
 * <p>
 * 请你返回 无法互相到达 的不同 点对数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, edges = [[0,1],[0,2],[1,2]]
 * 输出：0
 * 解释：所有点都能互相到达，意味着没有点对无法互相到达，所以我们返回 0 。
 * 示例 2：
 * <p>
 * 输入：n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
 * 输出：14
 * 解释：总共有 14 个点对互相无法到达：
 * [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]]
 * 所以我们返回 14 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * 不会有重复边。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/description/?envType=daily-question&envId=2023-10-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2316_CountPairs {
    public static void main(String[] args) {
        L2316_CountPairs l2316CountPairs = new L2316_CountPairs();
        System.out.println(l2316CountPairs.countPairs(7, new int[][]{{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}}));
    }

    public long countPairs(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, e -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visit = new boolean[n];
        long ans = 0;
        for (int i = 0, total = 0; i < n; i++) {
            if (!visit[i]) {
                int size = dfs(i, graph, visit);
                ans += (long) size * total;
                total += size;
            }
        }
        return ans;
    }

    private int dfs(int node, List<Integer>[] graph, boolean[] visit) {
        if (visit[node]) {
            return 0;
        }
        visit[node] = true;
        int size = 1;
        for (Integer neighbor : graph[node]) {
            size += dfs(neighbor, graph, visit);
        }
        return size;
    }

}
