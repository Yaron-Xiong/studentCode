package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.*;

/**
 * 2867. 统计树中的合法路径数目
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵 n 个节点的无向树，节点编号为 1 到 n 。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示节点 ui 和 vi 在树中有一条边。
 * <p>
 * 请你返回树中的 合法路径数目 。
 * <p>
 * 如果在节点 a 到节点 b 之间 恰好有一个 节点的编号是质数，那么我们称路径 (a, b) 是 合法的 。
 * 注意：
 * <p>
 * 路径 (a, b) 指的是一条从节点 a 开始到节点 b 结束的一个节点序列，序列中的节点 互不相同 ，且相邻节点之间在树上有一条边。
 * 路径 (a, b) 和路径 (b, a) 视为 同一条 路径，且只计入答案 一次 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, edges = [[1,2],[1,3],[2,4],[2,5]]
 * 输出：4
 * 解释：恰好有一个质数编号的节点路径有：
 * - (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
 * - (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
 * - (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
 * - (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
 * 只有 4 条合法路径。
 * 示例 2：
 * <p>
 * 输入：n = 6, edges = [[1,2],[1,3],[2,4],[3,5],[3,6]]
 * 输出：6
 * 解释：恰好有一个质数编号的节点路径有：
 * - (1, 2) 因为路径 1 到 2 只包含一个质数 2 。
 * - (1, 3) 因为路径 1 到 3 只包含一个质数 3 。
 * - (1, 4) 因为路径 1 到 4 只包含一个质数 2 。
 * - (1, 6) 因为路径 1 到 6 只包含一个质数 3 。
 * - (2, 4) 因为路径 2 到 4 只包含一个质数 2 。
 * - (3, 6) 因为路径 3 到 6 只包含一个质数 3 。
 * 只有 6 条合法路径。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * 输入保证 edges 形成一棵合法的树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-valid-paths-in-a-tree/description/?envType=daily-question&envId=2024-02-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2867_CountPaths {
    public static void main(String[] args) {
        L2867_CountPaths l2867CountPaths = new L2867_CountPaths();
        System.out.println(l2867CountPaths.countPaths(6, new int[][]{{1, 2}, {1, 3}, {2, 4}, {3, 5}, {3, 6}}));
    }

    private final static int MX = (int) 1e5;
    private final static boolean[] np = new boolean[MX + 1]; // 质数=false 非质数=true

    static {
        np[1] = true;
        for (int i = 2; i * i <= MX; i++) {
            if (!np[i]) {
                for (int j = i * i; j <= MX; j += i) {
                    np[j] = true;
                }
            }
        }
    }


    public long countPaths(int n, int[][] edges) {
        List<Integer>[] graph = new List[n + 1];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        long ans = 0;
        long[] sizes = new long[n + 1];
        for (int x = 1; x <= n; x++) {
            if (np[x] || graph[x].isEmpty()) {
                continue;
            }
            long curSize = 0;
            long countSize = 0;
            for (Integer neighbor : graph[x]) {
                if (!np[neighbor]) {
                    continue;
                }
                if (sizes[neighbor] == 0) {
                    List<Integer> list = new ArrayList<>();
                    getSize(graph, neighbor, x, list);
                    for (Integer item : list) {
                        sizes[item] = list.size();
                    }
                }
                long size = sizes[neighbor];
                countSize += curSize * size;
                curSize += size;
            }
            ans += countSize + curSize;
        }
        return ans;
    }

    private void getSize(List<Integer>[] graph, int node, int parent, List<Integer> list) {
        if (!np[node]) {
            return;
        }
        list.add(node);
        for (Integer neighbor : graph[node]) {
            if (neighbor == parent) {
                continue;
            }
            getSize(graph, neighbor, node, list);
        }
    }
}
