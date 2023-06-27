package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.*;

/**
 * 1377. T 秒后青蛙的位置
 * 提示
 * 困难
 * 62
 * 相关企业
 * 给你一棵由 n 个顶点组成的无向树，顶点编号从 1 到 n。青蛙从 顶点 1 开始起跳。规则如下：
 * <p>
 * 在一秒内，青蛙从它所在的当前顶点跳到另一个 未访问 过的顶点（如果它们直接相连）。
 * 青蛙无法跳回已经访问过的顶点。
 * 如果青蛙可以跳到多个不同顶点，那么它跳到其中任意一个顶点上的机率都相同。
 * 如果青蛙不能跳到任何未访问过的顶点上，那么它每次跳跃都会停留在原地。
 * 无向树的边用数组 edges 描述，其中 edges[i] = [ai, bi] 意味着存在一条直接连通 ai 和 bi 两个顶点的边。
 * <p>
 * 返回青蛙在 t 秒后位于目标顶点 target 上的概率。与实际答案相差不超过 10-5 的结果将被视为正确答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 2, target = 4
 * 输出：0.16666666666666666
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，第 1 秒 有 1/3 的概率跳到顶点 2 ，然后第 2 秒 有 1/2 的概率跳到顶点 4，因此青蛙在 2 秒后位于顶点 4 的概率是 1/3 * 1/2 = 1/6 = 0.16666666666666666 。
 * 示例 2：
 * <p>
 * 输入：n = 7, edges = [[1,2],[1,3],[1,7],[2,4],[2,6],[3,5]], t = 1, target = 7
 * 输出：0.3333333333333333
 * 解释：上图显示了青蛙的跳跃路径。青蛙从顶点 1 起跳，有 1/3 = 0.3333333333333333 的概率能够 1 秒 后跳到顶点 7 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ai, bi <= n
 * 1 <= t <= 50
 * 1 <= target <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/frog-position-after-t-seconds/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1377_FrogPosition {
    public static void main(String[] args) {
        L1377_FrogPosition l1377FrogPosition = new L1377_FrogPosition();
        System.out.println(l1377FrogPosition.frogPosition(7, new int[][]{{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}}, 20, 6));
    }

    public double frogPosition(int n, int[][] edges, int t, int target) {
        if (t == 0 && 0 == target) {
            return 1;
        }
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Deque<int[]> deque = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        deque.add(new int[]{1, 1});
        int level = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                size--;
                int[] node = deque.pop();
                visit.add(node[0]);
                if (node[0] == target) {
                    if (level < t) {
                        for (Integer neighbor : graph.get(node[0])) {
                            if (!visit.contains(neighbor)) {
                                return 0;
                            }
                        }
                        return (double) 1 / node[1];
                    } else if (level == t) {
                        return (double) 1 / node[1];
                    } else {
                        return 0;
                    }
                }
                for (Integer neighbor : graph.get(node[0])) {
                    if (visit.contains(neighbor)) {
                        continue;
                    }
                    if (node[0] == 1) {
                        deque.add(new int[]{neighbor, node[1] * (graph.get(node[0]).size())});
                    } else {
                        deque.add(new int[]{neighbor, node[1] * (graph.get(node[0]).size() - 1)});
                    }
                }
            }
            if (level == t) {
                return 0;
            }
            level++;
        }
        return 0;
    }
}
