package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.*;

/**
 * 3244. 新增道路查询后的最短距离 II
 * 尝试过
 * 算术评级: 8
 * 第 409 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 2270
 * 相关标签
 * 相关企业
 * 给你一个整数 n 和一个二维整数数组 queries。
 * <p>
 * 有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。
 * <p>
 * queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最短路径的长度。
 * <p>
 * 所有查询中不会存在两个查询都满足 queries[i][0] < queries[j][0] < queries[i][1] < queries[j][1]。
 * <p>
 * 返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，从城市 0 到城市 n - 1 的最短路径的长度。
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
 * 新增一条从 0 到 2 的道路后，从 0 到 3 的最短路径长度仍为 1。
 * <p>
 * 提示:
 * <p>
 * 3 <= n <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= queries[i][0] < queries[i][1] < n
 * 1 < queries[i][1] - queries[i][0]
 * 查询中不存在重复的道路。
 * 不存在两个查询都满足 i != j 且 queries[i][0] < queries[j][0] < queries[i][1] < queries[j][1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-distance-after-road-addition-queries-ii/description/?envType=daily-question&envId=2024-11-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3244_ShortestDistanceAfterQueries {
    public static void main(String[] args) {
        L3244_ShortestDistanceAfterQueries l3243ShortestDistanceAfterQueries = new L3244_ShortestDistanceAfterQueries();
        int[][] queries = {{3, 7}, {5, 7}, {2, 8}};
        int[] x = l3243ShortestDistanceAfterQueries.shortestDistanceAfterQueries(10, queries);
        System.out.println(Arrays.toString(x));
    }

    public static class UnionFind {
        private int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < this.parent.length; i++) {
                this.parent[i] = i;
            }
        }

    }

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        int[] nxt = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nxt[i] = i + 1;
        }

        int[] ans = new int[queries.length];
        int cnt = n - 1;
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];
            if (nxt[l] > 0 && nxt[l] < r) {
                for (int i = nxt[l]; i < r;) {
                    cnt--;
                    int tmp = nxt[i];
                    nxt[i] = 0;
                    i = tmp;
                }
                nxt[l] = r;
            }
            ans[qi] = cnt;
        }
        return ans;
    }


}
