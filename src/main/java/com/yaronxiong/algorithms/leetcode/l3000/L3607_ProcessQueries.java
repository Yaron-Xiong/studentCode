package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.*;

/**
 * 3607. 电网维护
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 c，表示 c 个电站，每个电站有一个唯一标识符 id，从 1 到 c 编号。
 * <p>
 * 这些电站通过 n 条 双向 电缆互相连接，表示为一个二维数组 connections，其中每个元素 connections[i] = [ui, vi] 表示电站 ui 和电站 vi 之间的连接。直接或间接连接的电站组成了一个 电网 。
 * <p>
 * 最初，所有 电站均处于在线（正常运行）状态。
 * <p>
 * 另给你一个二维数组 queries，其中每个查询属于以下 两种类型之一 ：
 * <p>
 * [1, x]：请求对电站 x 进行维护检查。如果电站 x 在线，则它自行解决检查。如果电站 x 已离线，则检查由与 x 同一 电网 中 编号最小 的在线电站解决。如果该电网中 不存在 任何 在线 电站，则返回 -1。
 * <p>
 * [2, x]：电站 x 离线（即变为非运行状态）。
 * <p>
 * 返回一个整数数组，表示按照查询中出现的顺序，所有类型为 [1, x] 的查询结果。
 * <p>
 * 注意：电网的结构是固定的；离线（非运行）的节点仍然属于其所在的电网，且离线操作不会改变电网的连接性。
 * <p>
 * 示例 1：
 * <p>
 * 输入： c = 5, connections = [[1,2],[2,3],[3,4],[4,5]], queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]
 * <p>
 * 输出： [3,2,3]
 * <p>
 * 解释：
 * <p>
 * 最初，所有电站 {1, 2, 3, 4, 5} 都在线，并组成一个电网。
 * 查询 [1,3]：电站 3 在线，因此维护检查由电站 3 自行解决。
 * 查询 [2,1]：电站 1 离线。剩余在线电站为 {2, 3, 4, 5}。
 * 查询 [1,1]：电站 1 离线，因此检查由电网中编号最小的在线电站解决，即电站 2。
 * 查询 [2,2]：电站 2 离线。剩余在线电站为 {3, 4, 5}。
 * 查询 [1,2]：电站 2 离线，因此检查由电网中编号最小的在线电站解决，即电站 3。
 * 示例 2：
 * <p>
 * 输入： c = 3, connections = [], queries = [[1,1],[2,1],[1,1]]
 * <p>
 * 输出： [1,-1]
 * <p>
 * 解释：
 * <p>
 * 没有连接，因此每个电站是一个独立的电网。
 * 查询 [1,1]：电站 1 在线，且属于其独立电网，因此维护检查由电站 1 自行解决。
 * 查询 [2,1]：电站 1 离线。
 * 查询 [1,1]：电站 1 离线，且其电网中没有其他电站，因此结果为 -1。
 * <p>
 * 提示：
 * <p>
 * 1 <= c <= 105
 * 0 <= n == connections.length <= min(105, c * (c - 1) / 2)
 * connections[i].length == 2
 * 1 <= ui, vi <= c
 * ui != vi
 * 1 <= queries.length <= 2 * 105
 * queries[i].length == 2
 * queries[i][0] 为 1 或 2。
 * 1 <= queries[i][1] <= c
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/power-grid-maintenance/description/?envType=daily-question&envId=2025-11-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3607_ProcessQueries {

    public static void main(String[] args) {
        L3607_ProcessQueries l3607ProcessQueries = new L3607_ProcessQueries();
        System.out.println(Arrays.toString(l3607ProcessQueries.processQueries(4, new int[][]{{2, 3}, {1, 3}, {4, 1}, {3, 4}}, new int[][]{{1, 2}, {2, 4}, {2, 1}, {1, 4}, {2, 1}, {1, 1}, {2, 2}, {1, 4}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 1}, {1, 1}, {2, 3}, {2, 2}, {2, 3}, {1, 4}, {2, 4}})));
        System.out.println(Arrays.toString(l3607ProcessQueries.processQueries(3, new int[][]{}, new int[][]{{1, 1}, {2, 1}, {1, 1}})));
        System.out.println(Arrays.toString(l3607ProcessQueries.processQueries(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, new int[][]{{1, 3}, {2, 1}, {1, 1}, {2, 2}, {1, 2}})));
    }

    public static class Unique {
        private int[] parent;
        private TreeSet<Integer>[] treeSet;

        public Unique(int n) {
            parent = new int[n];
            treeSet = new TreeSet[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                treeSet[i] = new TreeSet<>();
                treeSet[i].add(i);
            }
        }

        public void connect(int a, int b) {
            int aParent = findParent(a);
            int bParent = findParent(b);
            if (aParent == bParent) {
                return;
            }
            if (treeSet[aParent].size() > treeSet[bParent].size()) {
                treeSet[aParent].addAll(treeSet[bParent]);
                parent[bParent] = aParent;
            }else {
                treeSet[bParent].addAll(treeSet[aParent]);
                parent[aParent] = bParent;
            }
        }

        public TreeSet<Integer> getTreeSet(int node) {
            return treeSet[findParent(node)];
        }

        public int findParent(int node) {
            if (parent[node] != node) {
                parent[node] = findParent(parent[node]);
            }
            return parent[node];
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        Unique unique = new Unique(c + 1);
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];
            unique.connect(u, v);
        }
        List<Integer> ans = new ArrayList<>();
        boolean[] broken = new boolean[c + 1];
        for (int[] query : queries) {
            int node = query[1];
            if (query[0] == 2) {
                broken[node] = true;
                continue;
            }

            if (!broken[node]) {
                ans.add(query[1]);
                continue;
            }
            //找到最小值
            TreeSet<Integer> treeSet = unique.getTreeSet(node);
            while (treeSet != null && !treeSet.isEmpty() && broken[treeSet.first()]) {
                treeSet.pollFirst();
            }
            if (treeSet == null || treeSet.isEmpty()) {
                ans.add(-1);
                continue;
            }
            ans.add(treeSet.first());
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
