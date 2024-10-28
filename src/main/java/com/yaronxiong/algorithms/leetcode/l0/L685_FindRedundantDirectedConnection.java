package com.yaronxiong.algorithms.leetcode.l0;

import java.util.*;

/**
 * 685. 冗余连接 II
 * 算术评级: 8
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * 相关企业
 * 在本问题中，有根树指满足以下条件的 有向 图。该树只有一个根节点，所有其他节点都是该根节点的后继。
 * 该树除了根节点之外的每一个节点都有且只有一个父节点，而根节点没有父节点。
 * <p>
 * 输入一个有向图，该图由一个有着 n 个节点（节点值不重复，从 1 到 n）的树及一条附加的有向边构成。
 * 附加的边包含在 1 到 n 中的两个不同顶点间，这条附加的边不属于树中已存在的边。
 * <p>
 * 结果图是一个以边组成的二维数组 edges 。 每个元素是一对 [ui, vi]，用以表示 有向 图中连接顶点 ui 和顶点 vi 的边，其中 ui 是 vi 的一个父节点。
 * <p>
 * 返回一条能删除的边，使得剩下的图是有 n 个节点的有根树。若有多个答案，返回最后出现在给定二维数组的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：edges = [[1,2],[1,3],[2,3]]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：edges = [[1,2],[2,3],[3,4],[4,1],[1,5]]
 * 输出：[4,1]
 * <p>
 * 提示：
 * <p>
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/redundant-connection-ii/description/?envType=daily-question&envId=2024-10-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L685_FindRedundantDirectedConnection {

    public static void main(String[] args) {
        L685_FindRedundantDirectedConnection l685FindRedundantDirectedConnection = new L685_FindRedundantDirectedConnection();
        int[][] edges = {{5,2},{5,1},{3,1},{3,4},{3,5}};
        int[] redundantDirectedConnection = l685FindRedundantDirectedConnection.findRedundantDirectedConnection(edges);
        System.out.println(Arrays.toString(redundantDirectedConnection));
    }

    public class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void connect(int nodeA, int nodeB) {
            //nodeA—>nodeB = parent[B] = A
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);
            parent[parentB] = parentA;
        }

        public int findParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            return parent[node] = findParent(parent[node]);
        }

        public boolean isConnected(int nodeA, int nodeB) {
            int parentA = findParent(nodeA);
            int parentB = findParent(nodeB);
            return parentA == parentB;
        }
    }

    public int[] findRedundantDirectedConnection(int[][] edges) {
        //判断是否有入度=2
        int[] ingress = new int[edges.length + 1];
        for (int[] edge : edges) {
            ingress[edge[1]]++;
        }
        Set<Integer> dup = new HashSet<>();
        for (int i = 0; i < edges.length; i++) {
            if (ingress[edges[i][1]] == 2) {
                dup.add(i);
            }
        }
        //说明存在入度=2的节点，这时候要思考删除这个节点的什么边
        if (!dup.isEmpty()) {
            //先不把需要删除的节点加入
            UnionFind unionFind = new UnionFind(edges.length + 1);
            for (int i = 0; i < edges.length; i++) {
                if (dup.contains(i)) {
                    continue;
                }
                unionFind.connect(edges[i][0], edges[i][1]);
            }
            int maxI = 0;
            for (Integer i : dup) {
                if (unionFind.isConnected(edges[i][0], edges[i][1])) {
                    return edges[i];
                }
                maxI = Math.max(maxI, i);
            }
            return edges[maxI];
        }
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            int parentA = unionFind.findParent(edge[0]);
            int parentB = unionFind.findParent(edge[1]);
            if (parentA == parentB) {
                return edge;
            }
            unionFind.connect(parentA, parentB);
        }
        return new int[]{};
    }
}
