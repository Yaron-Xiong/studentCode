package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3249. 统计好节点的数目
 * 算术评级: 5
 * 第 410 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1566
 * 相关标签
 * 相关企业
 * 提示
 * 现有一棵 无向 树，树中包含 n 个节点，按从 0 到 n - 1 标记。树的根节点是节点 0 。
 * 给你一个长度为 n - 1 的二维整数数组 edges，其中 edges[i] = [ai, bi] 表示树中节点 ai 与节点 bi 之间存在一条边。
 * <p>
 * 如果一个节点的所有子节点为根的子树包含的节点数相同，则认为该节点是一个 好节点。
 * <p>
 * 返回给定树中 好节点 的数量。
 * <p>
 * 子树 指的是一个节点以及它所有后代节点构成的一棵树。
 * <p>
 * 示例 1：
 * <p>
 * 输入：edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
 * <p>
 * 输出：7
 * <p>
 * 说明：
 * <p>
 * <p>
 * 树的所有节点都是好节点。
 * <p>
 * 示例 2：
 * <p>
 * 输入：edges = [[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]
 * <p>
 * 输出：6
 * <p>
 * 说明：
 * <p>
 * <p>
 * 树中有 6 个好节点。上图中已将这些节点着色。
 * <p>
 * 示例 3：
 * <p>
 * 输入：edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]
 * <p>
 * 输出：12
 * <p>
 * 解释：
 * <p>
 * <p>
 * 除了节点 9 以外其他所有节点都是好节点。
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * 输入确保 edges 总表示一棵有效的树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-the-number-of-good-nodes/description/?envType=daily-question&envId=2024-11-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3249_CountGoodNodes {
    public static void main(String[] args) {
        L3249_CountGoodNodes l3249CountGoodNodes = new L3249_CountGoodNodes();
        System.out.println(l3249CountGoodNodes.countGoodNodes(new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}}));
    }

    public int countGoodNodes(int[][] edges) {
        List<Integer>[] graph = new List[edges.length + 1];
        Arrays.setAll(graph, a -> new ArrayList<Integer>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs2(0, 0, graph);
        return ans;
    }

    int ans = 0;

    private int dfs2(int node, int parent, List<Integer>[] graph) {
        int childSize = -1;
        int allSize = 0;
        boolean match = true;
        for (Integer neighbor : graph[node]) {
            if (neighbor == parent) {
                continue;
            }
            int i = dfs2(neighbor, node, graph);
            if (childSize == -1) {
                childSize = i;
            }
            if (childSize != i) {
                match = false;
            }
            allSize += i;
        }
        if (match) {
            ans++;
        }
        return allSize + 1;
    }


}
