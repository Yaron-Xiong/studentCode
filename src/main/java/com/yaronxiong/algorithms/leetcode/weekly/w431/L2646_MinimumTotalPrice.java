package com.yaronxiong.algorithms.leetcode.weekly.w431;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 2646. 最小化旅行的价格总和
 * 提示
 * 困难
 * 25
 * 相关企业
 * 现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
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
 * <p>
 * <p>
 * 示例 1：
 * <p>
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
 * 链接：<a href="https://leetcode.cn/problems/minimize-the-total-price-of-the-trips/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2646_MinimumTotalPrice {

    public static void main(String[] args) {
        L2646_MinimumTotalPrice l2646MinimumTotalPrice = new L2646_MinimumTotalPrice();
        System.out.println(l2646MinimumTotalPrice.minimumTotalPrice(4, new int[][]{{0, 1}, {1, 2}, {1, 3}}, new int[]{2, 2, 10, 6}, new int[][]{{0, 3}, {2, 1}, {2, 3}}));
    }

    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        //寻找路径
        //计算每个节点出现的次数
        int[] emergency = new int[price.length];
        for (int[] trip : trips) {
            findPath(graph, trip[0], trip[1], emergency);
        }
        //计算各种可能的折扣
        int[] dfs = dfs(graph, price, 0, new boolean[price.length], emergency);
        return Math.min(dfs[0], dfs[1]);
    }

    //计算打折方案
    private int[] dfs(List<List<Integer>> graph, int[] price, int node, boolean[] visit, int[] emergency) {
        visit[node] = true;
        int[] res = new int[]{(price[node] * emergency[node]) / 2, price[node] * emergency[node]};
        for (Integer neighbor : graph.get(node)) {
            if (visit[neighbor]) {
                continue;
            }
            int[] dfs = dfs(graph, price, neighbor, visit, emergency);
            //如果当前节点打折了
            res[0] += dfs[1];
            //如果当前节点不打折
            res[1] += Math.min(dfs[0], dfs[1]);
        }
        return res;
    }

    public class Node {
        int val;
        Node preNode;

        public Node(int val, Node preNode) {
            this.val = val;
            this.preNode = preNode;
        }
    }

    public void findPath(List<List<Integer>> graph, int start, int end, int[] emergency) {
        //bfs
        Deque<Node> deque = new ArrayDeque<>();
        Node root = new Node(start, null);
        deque.add(root);
        Node res = null;
        boolean[] visit = new boolean[graph.size()];
        while (!deque.isEmpty()) {
            Node node = deque.pop();
            if (visit[node.val]) {
                continue;
            }
            visit[node.val] = true;
            if (node.val == end) {
                res = node;
                break;
            }
            for (Integer integer : graph.get(node.val)) {
                deque.offer(new Node(integer, node));
            }
        }
        while (res != null) {
            emergency[res.val]++;
            res = res.preNode;
        }
    }
}
