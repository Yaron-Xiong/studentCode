package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 310. 最小高度树
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 树是一个无向图，其中任何两个顶点只通过一条路径连接。 换句话说，一个任何没有简单环路的连通图都是一棵树。
 * <p>
 * 给你一棵包含 n 个节点的树，标记为 0 到 n - 1 。
 * 给定数字 n 和一个有 n - 1 条无向边的 edges 列表（每一个边都是一对标签），其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条无向边。
 * <p>
 * 可选择树中任何一个节点作为根。当选择节点 x 作为根节点时，设结果树的高度为 h 。
 * 在所有可能的树中，具有最小高度的树（即，min(h)）被称为 最小高度树 。
 * <p>
 * 请你找到所有的 最小高度树 并按 任意顺序 返回它们的根节点标签列表。
 * <p>
 * 树的 高度 是指根节点和叶子节点之间最长向下路径上边的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, edges = [[1,0],[1,2],[1,3]]
 * 输出：[1]
 * 解释：如图所示，当根是标签为 1 的节点时，树的高度是 1 ，这是唯一的最小高度树。
 * 示例 2：
 * <p>
 * 输入：n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
 * 输出：[3,4]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2 * 104
 * edges.length == n - 1
 * 0 <= ai, bi < n
 * ai != bi
 * 所有 (ai, bi) 互不相同
 * 给定的输入 保证 是一棵树，并且 不会有重复的边
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-height-trees/description/?envType=daily-question&envId=2024-03-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L310_FindMinHeightTrees {
    public static void main(String[] args) {
        L310_FindMinHeightTrees l310FindMinHeightTrees = new L310_FindMinHeightTrees();
        System.out.println(l310FindMinHeightTrees.findMinHeightTrees(7, new int[][]{{0, 1},{0, 2},{1, 3},{3, 4},{2, 5},{2, 6}}));
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        //求以0为根的最大深度
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        minHeight = dfs(0, 0, dp, graph);
        //此时换根的最大深度
        reRoot(0, 0, dp, dp2, graph);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < dp2.length; i++) {
            if (dp2[i] == minHeight) {
                ans.add(i);
            }
        }
        return ans;
    }

    int minHeight = Integer.MAX_VALUE;


    private void reRoot(int curNode, int parent, int[] dp, int[] dp2, List<Integer>[] graph) {
        int first = 0;
        int second = 0;
        for (Integer neighbor : graph[curNode]) {
            if (dp[neighbor] > first) {
                second = first;
                first = dp[neighbor];
            } else if (dp[neighbor] > second) {
                second = dp[neighbor];
            }
        }
        dp2[curNode] = first + 1;
        minHeight = Math.min(minHeight, dp2[curNode]);
        for (Integer neighbor : graph[curNode]) {
            if (neighbor == parent) {
                continue;
            }
            //为什么这里不用还原呢？
            //因为first 跟 second 已经在外部记录了.
            dp[curNode] = (dp[neighbor] == first ? second : first) + 1;
            reRoot(neighbor, curNode, dp, dp2, graph);
        }
    }

    private int dfs(int curNode, int parent, int[] dp, List<Integer>[] graph) {
        int minHeight = 1;
        for (Integer neighbor : graph[curNode]) {
            if (neighbor == parent) {
                continue;
            }
            minHeight = Math.max(minHeight, dfs(neighbor, curNode, dp, graph) + 1);
        }
        return dp[curNode] = minHeight;
    }
}
