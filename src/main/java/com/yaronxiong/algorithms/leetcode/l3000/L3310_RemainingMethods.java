package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.*;

/**
 * 3310. 移除可疑的方法
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你正在维护一个项目，该项目有 n 个方法，编号从 0 到 n - 1。
 * <p>
 * 给你两个整数 n 和 k，以及一个二维整数数组 invocations，其中 invocations[i] = [ai, bi] 表示方法 ai 调用了方法 bi。
 * <p>
 * 已知如果方法 k 存在一个已知的 bug。那么方法 k 以及它直接或间接调用的任何方法都被视为 可疑方法 ，我们需要从项目中移除这些方法。
 * <p>
 * 只有当一组方法没有被这组之外的任何方法调用时，这组方法才能被移除。
 * <p>
 * 返回一个数组，包含移除所有 可疑方法 后剩下的所有方法。你可以以任意顺序返回答案。如果无法移除 所有 可疑方法，则 不 移除任何方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]
 * <p>
 * 输出: [0,1,2,3]
 * <p>
 * 解释:
 * <p>
 * 方法 2 和方法 1 是可疑方法，但它们分别直接被方法 3 和方法 0 调用。
 * 由于方法 3 和方法 0 不是可疑方法，我们无法移除任何方法，故返回所有方法。
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]
 * <p>
 * 输出: [3,4]
 * <p>
 * 解释:
 * <p>
 * 方法 0、方法 1 和方法 2 是可疑方法，且没有被任何其他方法直接调用。我们可以移除它们。
 * <p>
 * 示例 3:
 * <p>
 * 输入: n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]
 * <p>
 * 输出: []
 * <p>
 * 解释:
 * <p>
 * 所有方法都是可疑方法。我们可以移除它们。
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 105
 * 0 <= k <= n - 1
 * 0 <= invocations.length <= 2 * 105
 * invocations[i] == [ai, bi]
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * invocations[i] != invocations[j]
 */
public class L3310_RemainingMethods {
    public static void main(String[] args) {
        L3310_RemainingMethods l3310RemainingMethods = new L3310_RemainingMethods();
        System.out.println(l3310RemainingMethods.remainingMethods(2, 1, new int[][]{{0, 1}}));
        System.out.println(l3310RemainingMethods.remainingMethods(5, 0, new int[][]{{1, 2}, {0, 2}, {0, 1}, {3, 4}}));
        System.out.println(l3310RemainingMethods.remainingMethods(4, 1, new int[][]{{1, 2}, {0, 1}, {3, 2}}));
        System.out.println(l3310RemainingMethods.remainingMethods(3, 2, new int[][]{{1, 2}, {0, 1}, {2, 0}}));
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] graph = new List[n];
        int[] ingress = new int[n];
        Arrays.setAll(graph, i -> new ArrayList<>());
        //初始化图
        for (int[] invocation : invocations) {
            graph[invocation[0]].add(invocation[1]);
            ingress[invocation[1]]++;
        }
        //1. 先找到调用链
        Set<Integer> linked = new HashSet<>();
        boolean[] visited = new boolean[n];
        dfs2(k, visited, linked, graph, ingress);
        boolean canMove = true;
        for (Integer i : linked) {
            if (i == k && ingress[i] == 0) {
                canMove = false;
                break;
            } else if (ingress[i] > 0) {
                canMove = false;
                break;
            }
        }
        //2. 判断是否消耗完毕
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            if (canMove && linked.contains(i)) {
                continue;
            }
            result.add(i);
        }
        return result;
    }

    private void dfs2(int node, boolean[] visited, Set<Integer> linked, List<Integer>[] graph, int[] ingress) {
        --ingress[node];
        if (visited[node]) return;
        linked.add(node);
        visited[node] = true;
        for (Integer neighbor : graph[node]) {
            dfs2(neighbor, visited, linked, graph, ingress);
        }
    }
}
