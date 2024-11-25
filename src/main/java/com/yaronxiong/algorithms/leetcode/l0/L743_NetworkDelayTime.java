package com.yaronxiong.algorithms.leetcode.l0;

import java.util.*;

/**
 * 743. 网络延迟时间
 * 已解答
 * 算术评级: 5
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，
 * 其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/network-delay-time/description/?envType=daily-question&envId=2024-11-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L743_NetworkDelayTime {
    public static void main(String[] args) {
        L743_NetworkDelayTime l743NetworkDelayTime = new L743_NetworkDelayTime();
        int[][] times = {{1, 2, 1}, {2, 3, 2}, {1, 3, 2}};
        System.out.println(l743NetworkDelayTime.networkDelayTime(times, 3, 1));
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<int[]>[] graph = new ArrayList[n + 1];
        Arrays.setAll(graph, i -> new ArrayList<>());
        for (int[] time : times) {
            graph[time[0]].add(time);
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.add(new int[]{k, 0});
        int[] cost = new int[n + 1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        int ans = 0;
        int cnt = n;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            if (node[1] >= cost[node[0]]) {
                continue;
            }
            cost[node[0]] = node[1];
            cnt--;
            ans = Math.max(ans, cost[node[0]]);
            for (int[] neighbor : graph[node[0]]) {
                int nextCost = neighbor[2] + node[1];
                if (nextCost >= cost[neighbor[1]]) {
                    continue;
                }
                queue.add(new int[]{neighbor[1], nextCost});
            }
        }
        return cnt == 0 ? ans : -1;
    }
}
