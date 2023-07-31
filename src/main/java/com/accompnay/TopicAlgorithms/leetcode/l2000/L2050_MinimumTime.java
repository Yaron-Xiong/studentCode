package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.*;

/**
 * 2050. 并行课程 III
 * 提示
 * 困难
 * 44
 * 相关企业
 * 给你一个整数 n ，表示有 n 节课，课程编号从 1 到 n 。
 * 同时给你一个二维整数数组 relations ，其中 relations[j] = [prevCoursej, nextCoursej] ，
 * 表示课程 prevCoursej 必须在课程 nextCoursej 之前 完成（先修课的关系）。
 * 同时给你一个下标从 0 开始的整数数组 time ，其中 time[i] 表示完成第 (i+1) 门课程需要花费的 月份 数。
 * <p>
 * 请你根据以下规则算出完成所有课程所需要的 最少 月份数：
 * <p>
 * 如果一门课的所有先修课都已经完成，你可以在 任意 时间开始这门课程。
 * 你可以 同时 上 任意门课程 。
 * 请你返回完成所有课程所需要的 最少 月份数。
 * <p>
 * 注意：测试数据保证一定可以完成所有课程（也就是先修课的关系构成一个有向无环图）。
 * <p>
 * 示例 1:
 * <p>
 * 输入：n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
 * 输出：8
 * 解释：上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
 * 你可以在月份 0 同时开始课程 1 和 2 。
 * 课程 1 花费 3 个月，课程 2 花费 2 个月。
 * 所以，最早开始课程 3 的时间是月份 3 ，完成所有课程所需时间为 3 + 5 = 8 个月。
 * 示例 2：
 * <p>
 * 输入：n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
 * 输出：12
 * 解释：上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
 * 你可以在月份 0 同时开始课程 1 ，2 和 3 。
 * 在月份 1，2 和 3 分别完成这三门课程。
 * 课程 4 需在课程 3 之后开始，也就是 3 个月后。课程 4 在 3 + 4 = 7 月完成。
 * 课程 5 需在课程 1，2，3 和 4 之后开始，也就是在 max(1,2,3,7) = 7 月开始。
 * 所以完成所有课程所需的最少时间为 7 + 5 = 12 个月。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 5 * 104
 * 0 <= relations.length <= min(n * (n - 1) / 2, 5 * 104)
 * relations[j].length == 2
 * 1 <= prevCoursej, nextCoursej <= n
 * prevCoursej != nextCoursej
 * 所有的先修课程对 [prevCoursej, nextCoursej] 都是 互不相同 的。
 * time.length == n
 * 1 <= time[i] <= 104
 * 先修课程图是一个有向无环图。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/parallel-courses-iii/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2050_MinimumTime {
    public static void main(String[] args) {
        L2050_MinimumTime l2050MinimumTime = new L2050_MinimumTime();
        int x = l2050MinimumTime.minimumTime(9, new int[][]{{2, 7}, {2, 6}, {3, 6}, {4, 6}, {7, 6}, {2, 1}, {3, 1}, {4, 1}, {6, 1}, {7, 1}, {3, 8}, {5, 8}, {7, 8}, {1, 9}, {2, 9}, {6, 9}, {7, 9}}, new int[]{9, 5, 9, 5, 8, 7, 7, 8, 4});
        System.out.println(x);
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] relation : relations) {
            graph.get(relation[0] - 1).add(relation[1] - 1);
            edges[relation[1] - 1]++;
        }
        //从边为0开始向外开始推
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != 0) {
                continue;
            }
            deque.offer(i);
        }
        int[] dp = new int[n];
        int res = 0;
        //计算每个节点的最短耗时= 每个临界点的最短耗时的最大值 + 当前点的耗时
        while (!deque.isEmpty()) {
            Integer node = deque.poll();
            dp[node] += time[node];
            res = Math.max(res, dp[node]);
            for (Integer neighbor : graph.get(node)) {
                //对于neighbor来讲node是临界点
                dp[neighbor] = Math.max(dp[neighbor], dp[node]);
                if (--edges[neighbor] == 0){
                    deque.offer(neighbor);
                }
            }
        }
        return res;
    }

}
