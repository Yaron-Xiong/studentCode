package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.*;

/**
 * 2646. 最小化旅行的价格总和
 * 已解答
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
 * <p>
 * 每个节点都关联一个价格。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价格。
 * <p>
 * 给定路径的 价格总和 是该路径上所有节点的价格之和。
 * <p>
 * 另给你一个二维整数数组 trips ，其中 trips[i] = [starti, endi] 表示您从节点 starti 开始第 i 次旅行，并通过任何你喜欢的路径前往节点 endi 。
 * <p>
 * 在执行第一次旅行之前，你可以选择一些 非相邻节点 并将价格减半。
 * <p>
 * 返回执行所有旅行的最小价格总和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, edges = [[0,1],[1,2],[1,3]], price = [2,2,10,6], trips = [[0,3],[2,1],[2,3]]
 * 输出：23
 * 解释：
 * 上图表示将节点 2 视为根之后的树结构。第一个图表示初始树，第二个图表示选择节点 0 、2 和 3 并使其价格减半后的树。
 * 第 1 次旅行，选择路径 [0,1,3] 。路径的价格总和为 1 + 2 + 3 = 6 。
 * 第 2 次旅行，选择路径 [2,1] 。路径的价格总和为 2 + 5 = 7 。
 * 第 3 次旅行，选择路径 [2,1,3] 。路径的价格总和为 5 + 2 + 3 = 10 。
 * 所有旅行的价格总和为 6 + 7 + 10 = 23 。可以证明，23 是可以实现的最小答案。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 2, edges = [[0,1]], price = [2,2], trips = [[0,0]]
 * 输出：1
 * 解释：
 * 上图表示将节点 0 视为根之后的树结构。第一个图表示初始树，第二个图表示选择节点 0 并使其价格减半后的树。
 * 第 1 次旅行，选择路径 [0] 。路径的价格总和为 1 。
 * 所有旅行的价格总和为 1 。可以证明，1 是可以实现的最小答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * edges.length == n - 1
 * 0 <= ai, bi <= n - 1
 * edges 表示一棵有效的树
 * price.length == n
 * price[i] 是一个偶数
 * 1 <= price[i] <= 1000
 * 1 <= trips.length <= 100
 * 0 <= starti, endi <= n - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimize-the-total-price-of-the-trips/description/?envType=daily-question&envId=2023-12-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2646_MinimumTotalPrice {
    public static void main(String[] args) {
        L2646_MinimumTotalPrice l2646MinimumTotalPrice = new L2646_MinimumTotalPrice();
        int i = l2646MinimumTotalPrice.minimumTotalPrice(50, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}, {7, 8}, {8, 9}, {9, 10}, {10, 11}, {11, 12}, {12, 13}, {13, 14}, {14, 15}, {15, 16}, {16, 17}, {17, 18}, {18, 19}, {19, 20}, {20, 21}, {21, 22}, {22, 23}, {23, 24}, {24, 25}, {25, 26}, {26, 27}, {27, 28}, {28, 29}, {29, 30}, {30, 31}, {31, 32}, {32, 33}, {33, 34}, {34, 35}, {35, 36}, {36, 37}, {37, 38}, {38, 39}, {39, 40}, {40, 41}, {41, 42}, {42, 43}, {43, 44}, {44, 45}, {45, 46}, {46, 47}, {47, 48}, {48, 49}},
                new int[]{2, 820, 460, 262, 598, 192, 758, 922, 266, 628, 74, 720, 614, 304, 716, 764, 110, 328, 344, 160, 884, 80, 154, 424, 858, 466, 602, 114, 432, 140, 726, 438, 774, 346, 944, 596, 974, 552, 536, 564, 938, 888, 376, 980, 502, 196, 80, 870, 1000, 998},
                new int[][]{{9, 9}});
        System.out.println(i);
    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        List<Integer>[] graph = new ArrayList[n];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        int[] emergency = new int[n];

        for (int[] trip : trips) {
            findPath(graph, trip[0], trip[1], emergency);
        }
        //开始计算打折方案
        boolean[] visit = new boolean[n];
        int[] dfs = dfs(0, graph, emergency, price, visit);
        return Math.min(dfs[0], dfs[1]);
    }

    private int[] dfs(int curNode, List<Integer>[] graph, int[] emergency, int[] price, boolean[] visit) {
        //当前节点是否可以打折
        visit[curNode] = true;
        int[] ans = new int[]{(price[curNode] / 2) * emergency[curNode], emergency[curNode] * price[curNode]};
        for (Integer neighbor : graph[curNode]) {
            if (visit[neighbor]) {
                continue;
            }
            int[] dfs = dfs(neighbor, graph, emergency, price, visit);
            ans[0] += dfs[1];
            ans[1] += Math.min(dfs[0], dfs[1]);
        }
        visit[curNode] = false;
        return ans;
    }

    public static class Node {
        Node preNode;
        int val;

        public Node(Node preNode, int val) {
            this.preNode = preNode;
            this.val = val;
        }
    }

    private void findPath(List<Integer>[] graph, int cur, int target, int[] emergency) {
        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(null, cur));
        Node res = null;
        boolean[] visit = new boolean[emergency.length];
        while (!deque.isEmpty()) {
            Node pop = deque.pop();
            if (pop.val == target) {
                res = pop;
                break;
            }
            if (visit[pop.val]) {
                continue;
            }
            visit[pop.val] = true;
            for (Integer neighbor : graph[pop.val]) {
                if (neighbor == pop.val) {
                    continue;
                }
                deque.add(new Node(pop, neighbor));
            }
        }
        while (res != null) {
            emergency[res.val]++;
            res = res.preNode;
        }
    }

}
