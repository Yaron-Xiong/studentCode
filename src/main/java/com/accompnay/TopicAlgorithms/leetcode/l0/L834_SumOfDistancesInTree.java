package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 834. 树中距离之和
 * 困难
 * 467
 * 相关企业
 * 给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。
 * <p>
 * 给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。
 * <p>
 * 返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 6, edges = [[0,1],[0,2],[2,3],[2,4],[2,5]]
 * 输出: [8,12,6,10,10,10]
 * 解释: 树如图所示。
 * 我们可以计算出 dist(0,1) + dist(0,2) + dist(0,3) + dist(0,4) + dist(0,5)
 * 也就是 1 + 1 + 2 + 2 + 2 = 8。 因此，answer[0] = 8，以此类推。
 * 示例 2:
 * <p>
 * 输入: n = 1, edges = []
 * 输出: [0]
 * 示例 3:
 * <p>
 * <p>
 * 输入: n = 2, edges = [[1,0]]
 * 输出: [1,1]
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 3 * 104
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * 给定的输入保证为有效的树
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sum-of-distances-in-tree/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L834_SumOfDistancesInTree {
    public static void main(String[] args) {
        L834_SumOfDistancesInTree l834SumOfDistancesInTree = new L834_SumOfDistancesInTree();
        int[] ints = l834SumOfDistancesInTree.sumOfDistancesInTree(6, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}, {2, 5}});
        System.out.println(Arrays.toString(ints));
    }

    private List<List<Integer>> graph;
    private int[] dp;
    private int[] size;

    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        this.graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        this.dp = new int[n];
        this.size = new int[n];
        //计算从 0开始到所有节点的长度
        int dfs = dfs(0, 0, -1);
        this.dp[0] = dfs;
        reRoot(0, -1);
        return this.dp;
    }

    private void reRoot(int node, int parent) {
        for (int child : this.graph.get(node)) {
            if (child == parent) {
                continue;
            }
            this.dp[child] = this.dp[node] + this.graph.size() - (2 * this.size[child]);
            reRoot(child, node);
        }
    }

    private int dfs(int node, int depth, int parent) {
        int res = depth;
        this.size[node] = 1;
        for (Integer child : graph.get(node)) {
            if (child == parent) {
                continue;
            }
            res += dfs(child, depth + 1, node);
            this.size[node] += this.size[child];
        }
        return res;
    }
}
