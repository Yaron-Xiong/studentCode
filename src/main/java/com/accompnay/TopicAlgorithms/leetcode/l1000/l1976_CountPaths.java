package com.accompnay.TopicAlgorithms.leetcode.l1000;

import javafx.util.Pair;

import java.util.*;

/**
 * 1976. 到达目的地的方案数
 * 第 59 场双周赛
 * Q3
 * 2095
 * 相关标签
 * 相关企业
 * 提示
 * 你在一个城市里，城市由 n 个路口组成，路口编号为 0 到 n - 1 ，某些路口之间有 双向 道路。输入保证你可以从任意路口出发到达其他任意路口，且任意两个路口之间最多有一条路。
 * <p>
 * 给你一个整数 n 和二维整数数组 roads ，其中 roads[i] = [ui, vi, timei] 表示在路口 ui 和 vi 之间有一条需要花费 timei 时间才能通过的道路。
 * 你想知道花费 最少时间 从路口 0 出发到达路口 n - 1 的方案数。
 * <p>
 * 请返回花费 最少时间 到达目的地的 路径数目 。由于答案可能很大，将结果对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7, roads = [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]
 * 输出：4
 * 解释：从路口 0 出发到路口 6 花费的最少时间是 7 分钟。
 * 四条花费 7 分钟的路径分别为：
 * - 0 ➝ 6
 * - 0 ➝ 4 ➝ 6
 * - 0 ➝ 1 ➝ 2 ➝ 5 ➝ 6
 * - 0 ➝ 1 ➝ 3 ➝ 5 ➝ 6
 * 示例 2：
 * <p>
 * 输入：n = 2, roads = [[1,0,10]]
 * 输出：1
 * 解释：只有一条从路口 0 到路口 1 的路，花费 10 分钟。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 200
 * n - 1 <= roads.length <= n * (n - 1) / 2
 * roads[i].length == 3
 * 0 <= ui, vi <= n - 1
 * 1 <= timei <= 109
 * ui != vi
 * 任意两个路口之间至多有一条路。
 * 从任意路口出发，你能够到达其他任意路口。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-ways-to-arrive-at-destination/description/?envType=daily-question&envId=2024-03-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class l1976_CountPaths {
    public static void main(String[] args) {
        l1976_CountPaths l1976CountPaths = new l1976_CountPaths();
        System.out.println(l1976CountPaths.countPaths(7, new int[][]{{0, 6, 7}, {0, 1, 2}, {1, 2, 3}, {1, 3, 3}, {6, 3, 3}, {3, 5, 1}, {6, 5, 1}, {2, 5, 1}, {0, 4, 5}, {4, 6, 2}}));
    }

    private long MOD = (long) (1e9 + 7);

    public int countPaths(int n, int[][] roads) {
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] road : roads) {
            graph[road[0]].add(new int[]{road[1], road[2]});
            graph[road[1]].add(new int[]{road[0], road[2]});
        }
        //距离数组，表示从 0-> i 的最小距离
        long[] dis = new long[n];
        //抵达路径数数组，表示从 0 -> i 一共有多少条
        long[] arrivalCnt = new long[n];
        //数据初始化 默认距离都为最大值
        Arrays.fill(dis, Long.MAX_VALUE);
        //0->0 的路径数为1
        arrivalCnt[0] = 1;
        PriorityQueue<Pair<Long, Integer>> queue = new PriorityQueue<>(Comparator.comparing(Pair::getKey));
        queue.add(new Pair<>(0L, 0));
        while (!queue.isEmpty()) {
            Pair<Long, Integer> node = queue.poll();
            if (node.getKey() > dis[node.getValue()]) {
                continue;
            }
            if (node.getValue() == n - 1) {
                return (int) arrivalCnt[n - 1];
            }
            for (int[] item : graph[node.getValue()]) {
                long newValue = item[1] + node.getKey();
                if (newValue == dis[item[0]]) {
                    arrivalCnt[item[0]] = (arrivalCnt[item[0]] + arrivalCnt[node.getValue()]) % MOD;
                } else if (newValue < dis[item[0]]) {
                    arrivalCnt[item[0]] = arrivalCnt[node.getValue()];
                    dis[item[0]] = newValue;
                    queue.add(new Pair<>(newValue, item[0]));
                }
            }
        }
        return -1;
    }


}
