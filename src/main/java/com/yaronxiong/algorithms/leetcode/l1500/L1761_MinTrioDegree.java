package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1761. 一个图中连通三元组的最小度数
 * 提示
 * 困难
 * 45
 * 相关企业
 * 给你一个无向图，整数 n 表示图中节点的数目，edges 数组表示图中的边，其中 edges[i] = [ui, vi] ，表示 ui 和 vi 之间有一条无向边。
 * <p>
 * 一个 连通三元组 指的是 三个 节点组成的集合且这三个点之间 两两 有边。
 * <p>
 * 连通三元组的度数 是所有满足此条件的边的数目：一个顶点在这个三元组内，而另一个顶点不在这个三元组内。
 * <p>
 * 请你返回所有连通三元组中度数的 最小值 ，如果图中没有连通三元组，那么返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, edges = [[1,2],[1,3],[3,2],[4,1],[5,2],[3,6]]
 * 输出：3
 * 解释：只有一个三元组 [1,2,3] 。构成度数的边在上图中已被加粗。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[1,3],[4,1],[4,3],[2,5],[5,6],[6,7],[7,5],[2,6]]
 * 输出：0
 * 解释：有 3 个三元组：
 * 1) [1,4,3]，度数为 0 。
 * 2) [2,5,6]，度数为 2 。
 * 3) [5,6,7]，度数为 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 400
 * edges[i].length == 2
 * 1 <= edges.length <= n * (n-1) / 2
 * 1 <= ui, vi <= n
 * ui != vi
 * 图中没有重复的边。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-degree-of-a-connected-trio-in-a-graph/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1761_MinTrioDegree {
    public static void main(String[] args) {
        L1761_MinTrioDegree l1761MinTrioDegree = new L1761_MinTrioDegree();
        System.out.println(l1761MinTrioDegree.minTrioDegree(7, new int[][]{{1, 3}, {4, 1}, {4, 3}}));
    }

    public int minTrioDegree(int n, int[][] edges) {
        int[] edgesCount = new int[n];
        boolean[][] graph = new boolean[n][n];
        for (int[] i : edges) {
            int from = i[0] - 1;
            int to = i[1] - 1;
            graph[from][to] = true;
            graph[to][from] = true;
            edgesCount[from]++;
            edgesCount[to]++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (!graph[i][j]) {
                    continue;
                }
                for (int z = 0; z < graph[j].length; z++) {
                    if (graph[j][z] && graph[z][i]) {
                        res = Math.min(edgesCount[i] + edgesCount[j] + edgesCount[z] - 6, res);
                    }
                }
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
