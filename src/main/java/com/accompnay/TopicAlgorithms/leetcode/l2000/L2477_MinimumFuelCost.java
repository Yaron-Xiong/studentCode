package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.*;

/**
 * 2477. 到达首都的最少油耗
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，
 * 且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
 * <p>
 * 每个城市里有一个代表，他们都要去首都参加一个会议。
 * <p>
 * 每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
 * <p>
 * 城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
 * <p>
 * 请你返回到达首都最少需要多少升汽油。
 * <p>
 * 示例 1：
 * <p>
 * 输入：roads = [[0,1],[0,2],[0,3]], seats = 5
 * 输出：3
 * 解释：
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 2 直接到达首都，消耗 1 升汽油。
 * - 代表 3 直接到达首都，消耗 1 升汽油。
 * 最少消耗 3 升汽油。
 * 示例 2：
 * <p>
 * 输入：roads = [[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]], seats = 2
 * 输出：7
 * 解释：
 * - 代表 2 到达城市 3 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达城市 1 ，消耗 1 升汽油。
 * - 代表 2 和代表 3 一起到达首都，消耗 1 升汽油。
 * - 代表 1 直接到达首都，消耗 1 升汽油。
 * - 代表 5 直接到达首都，消耗 1 升汽油。
 * - 代表 6 到达城市 4 ，消耗 1 升汽油。
 * - 代表 4 和代表 6 一起到达首都，消耗 1 升汽油。
 * 最少消耗 7 升汽油。
 * 示例 3：
 * <p>
 * 输入：roads = [], seats = 1
 * 输出：0
 * 解释：没有代表需要从别的城市到达首都。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * roads.length == n - 1
 * roads[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * roads 表示一棵合法的树。
 * 1 <= seats <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-fuel-cost-to-report-to-the-capital/description/?envType=daily-question&envId=2023-12-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2477_MinimumFuelCost {
    public static void main(String[] args) {
        L2477_MinimumFuelCost l2477MinimumFuelCost = new L2477_MinimumFuelCost();
        System.out.println(l2477MinimumFuelCost.minimumFuelCost(new int[][]{{3, 1}, {3, 2}, {1, 0}, {0, 4}, {0, 5}, {4, 6}}, 2));
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        int n = roads.length + 1;
        List<Integer>[] graph = new List[n];
        int[] edgArr = new int[n];
        int[] personNum = new int[n];
        Arrays.fill(personNum, 1);
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
            edgArr[road[0]]++;
            edgArr[road[1]]++;
        }
        //通过拓扑排序删除节点
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < edgArr.length; i++) {
            if (edgArr[i] == 1) {
                deque.addFirst(i);
            }
        }
        long ans = 0;
        while (!deque.isEmpty()) {
            // 抵达父节点
            Integer node = deque.pollFirst();
            if (node == 0) {
                //抵达首都
                continue;
            }
            Integer parent = -1;
            for (int j = 0; j < graph[node].size(); j++) {
                if (personNum[graph[node].get(j)] == 0) {
                    continue;
                }
                parent = graph[node].get(j);
                break;
            }
            //修改parent的边数
            if (--edgArr[parent] == 1) {
                deque.addLast(parent);
            }
            //计算从node->parent的油耗
            ans += (personNum[node] - 1) / (seats + 1);
            //修改人数
            personNum[parent] += personNum[node];
            personNum[node] = 0;
        }
        return ans;
    }
}
