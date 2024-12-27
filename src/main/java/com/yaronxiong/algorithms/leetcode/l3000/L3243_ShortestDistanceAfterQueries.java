package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.*;

/**
 * 3243. 新增道路查询后的最短距离 I
 * 算术评级: 5
 * 第 409 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1568
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n 和一个二维整数数组 queries。
 * <p>
 * 有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。
 * <p>
 * queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最短路径的长度。
 * <p>
 * 返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，
 * answer[i] 是处理完前 i + 1 个查询后，从城市 0 到城市 n - 1 的最短路径的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 5, queries = [[2, 4], [0, 2], [0, 4]]
 * <p>
 * 输出： [3, 2, 1]
 * <p>
 * 解释：
 * <p>
 * 新增一条从 2 到 4 的道路后，从 0 到 4 的最短路径长度为 3。
 * <p>
 * 新增一条从 0 到 2 的道路后，从 0 到 4 的最短路径长度为 2。
 * <p>
 * 新增一条从 0 到 4 的道路后，从 0 到 4 的最短路径长度为 1。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 4, queries = [[0, 3], [0, 2]]
 * <p>
 * 输出： [1, 1]
 * <p>
 * 解释：
 * <p>
 * 新增一条从 0 到 3 的道路后，从 0 到 3 的最短路径长度为 1。
 * <p>
 * <p>
 * <p>
 * 新增一条从 0 到 2 的道路后，从 0 到 3 的最短路径长度仍为 1。
 * <p>
 * 提示：
 * <p>
 * 3 <= n <= 500
 * 1 <= queries.length <= 500
 * queries[i].length == 2
 * 0 <= queries[i][0] < queries[i][1] < n
 * 1 < queries[i][1] - queries[i][0]
 * 查询中没有重复的道路。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-i/description/?envType=daily-question&envId=2024-11-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3243_ShortestDistanceAfterQueries {
    public static void main(String[] args) {
        L3243_ShortestDistanceAfterQueries l3243ShortestDistanceAfterQueries = new L3243_ShortestDistanceAfterQueries();
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};
        int[] x = l3243ShortestDistanceAfterQueries.shortestDistanceAfterQueries(5, queries);
        System.out.println(Arrays.toString(x));
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<Integer>[] graph = new List[n];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            graph[i].add(i + 1);
        }
        int[] ans = new int[queries.length];
        int[] visited = new int[n + 1];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            graph[query[0]].add(query[1]);
            ans[i] = bfs(n, i + 1, graph, visited);
        }
        return ans;
    }

    private int bfs(int n, int i, List<Integer>[] graph, int[] visited) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(0);
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                int node = deque.pollFirst();
                if (node == n - 1) {
                    return level;
                }
                visited[node] = i;
                for (Integer neighbor : graph[node]) {
                    if (visited[neighbor] == i) {
                        continue;
                    }
                    deque.addLast(neighbor);
                }
                size--;
            }
            level++;
        }
        return -1;
    }

}
