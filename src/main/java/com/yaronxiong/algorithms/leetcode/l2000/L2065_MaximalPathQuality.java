package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2065. 最大化一张图中的路径价值
 * 算术评级: 7
 * 第 266 场周赛
 * Q4
 * 2178
 * 相关标签
 * 相关企业
 * 提示
 * 给你一张 无向 图，图中有 n 个节点，节点编号从 0 到 n - 1 （都包括）。
 * 同时给你一个下标从 0 开始的整数数组 values ，其中 values[i] 是第 i 个节点的 价值 。
 * 同时给你一个下标从 0 开始的二维整数数组 edges ，其中 edges[j] = [uj, vj, timej] 表示节点 uj 和 vj 之间有一条需要 timej 秒才能通过的无向边。
 * 最后，给你一个整数 maxTime 。
 * <p>
 * 合法路径 指的是图中任意一条从节点 0 开始，最终回到节点 0 ，且花费的总时间 不超过 maxTime 秒的一条路径。
 * 你可以访问一个节点任意次。一条合法路径的 价值 定义为路径中 不同节点 的价值 之和 （每个节点的价值 至多 算入价值总和中一次）。
 * <p>
 * 请你返回一条合法路径的 最大 价值。
 * <p>
 * 注意：每个节点 至多 有 四条 边与之相连。
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [0,32,10,43], edges = [[0,1,10],[1,2,15],[0,3,10]], maxTime = 49
 * 输出：75
 * 解释：
 * 一条可能的路径为：0 -> 1 -> 0 -> 3 -> 0 。总花费时间为 10 + 10 + 10 + 10 = 40 <= 49 。
 * 访问过的节点为 0 ，1 和 3 ，最大路径价值为 0 + 32 + 43 = 75 。
 * 示例 2：
 * <p>
 * 输入：values = [5,10,15,20], edges = [[0,1,10],[1,2,10],[0,3,10]], maxTime = 30
 * 输出：25
 * 解释：
 * 一条可能的路径为：0 -> 3 -> 0 。总花费时间为 10 + 10 = 20 <= 30 。
 * 访问过的节点为 0 和 3 ，最大路径价值为 5 + 20 = 25 。
 * 示例 3：
 * <p>
 * 输入：values = [1,2,3,4], edges = [[0,1,10],[1,2,11],[2,3,12],[1,3,13]], maxTime = 50
 * 输出：7
 * 解释：
 * 一条可能的路径为：0 -> 1 -> 3 -> 1 -> 0 。总花费时间为 10 + 13 + 13 + 10 = 46 <= 50 。
 * 访问过的节点为 0 ，1 和 3 ，最大路径价值为 1 + 2 + 4 = 7 。
 * 示例 4：
 * <p>
 * 输入：values = [0,1,2], edges = [[1,2,10]], maxTime = 10
 * 输出：0
 * 解释：
 * 唯一一条路径为 0 。总花费时间为 0 。
 * 唯一访问过的节点为 0 ，最大路径价值为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == values.length
 * 1 <= n <= 1000
 * 0 <= values[i] <= 108
 * 0 <= edges.length <= 2000
 * edges[j].length == 3
 * 0 <= uj < vj <= n - 1
 * 10 <= timej, maxTime <= 100
 * [uj, vj] 所有节点对 互不相同 。
 * 每个节点 至多有四条 边。
 * 图可能不连通。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-path-quality-of-a-graph/description/?envType=daily-question&envId=2024-07-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2065_MaximalPathQuality {
    public static void main(String[] args) {
        L2065_MaximalPathQuality l2065MaximalPathQuality = new L2065_MaximalPathQuality();
        int x = l2065MaximalPathQuality.maximalPathQuality(new int[]{1, 2, 3, 4}, new int[][]{{0, 1, 10}, {1, 2, 11}, {2, 3, 12}, {1, 3, 13}}, 50);
        System.out.println(x);
    }

    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        //从0出发，经过不同的节点 重新回到0，在maxTime的限制下，拿到最高的价值
        List<int[]>[] graph = new List[values.length];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            int cost = edge[2];
            graph[a].add(new int[]{b, cost});
            graph[b].add(new int[]{a, cost});
        }
        boolean[] visit = new boolean[values.length];
        visit[0] = true;
        dfs2(0, values[0], maxTime, graph, values, visit);
        return ans;
    }

    int ans = 0;

    private void dfs2(int index, int value, int maxTime, List<int[]>[] graph, int[] values, boolean[] visit) {
        if (maxTime < 0) {
            return;
        }
        if (index == 0) {
            ans = Math.max(ans, value);
        }
        for (int[] neighbor : graph[index]) {
            if (!visit[index]) {
                visit[index] = true;
                dfs2(neighbor[0], value + values[index], maxTime - neighbor[1], graph, values, visit);
                visit[index] = false;
            } else {
                dfs2(neighbor[0], value, maxTime - neighbor[1], graph, values, visit);
            }
        }
    }


}