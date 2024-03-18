package com.yaronxiong.algorithms.leetcode.weekly.w338;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2603. 收集树中金币
 * 提示
 * 困难
 * 27
 * 相关企业
 * 给你一个 n 个节点的无向无根树，节点编号从 0 到 n - 1 。给你整数 n 和一个长度为 n - 1 的二维整数数组 edges ，
 * 其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间有一条边。再给你一个长度为 n 的数组 coins ，
 * 其中 coins[i] 可能为 0 也可能为 1 ，1 表示节点 i 处有一个金币。
 * <p>
 * 一开始，你需要选择树中任意一个节点出发。你可以执行下述操作任意次：
 * <p>
 * 收集距离当前节点距离为 2 以内的所有金币，或者
 * 移动到树中一个相邻节点。
 * 你需要收集树中所有的金币，并且回到出发节点，请你返回最少经过的边数。
 * <p>
 * 如果你多次经过一条边，每一次经过都会给答案加一。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1,0,0,0,0,1], edges = [[0,1],[1,2],[2,3],[3,4],[4,5]]
 * 输出：2
 * 解释：从节点 2 出发，收集节点 0 处的金币，移动到节点 3 ，收集节点 5 处的金币，然后移动回节点 2 。
 * 示例 2：
 * <p>
 * 输入：coins = [0,0,0,1,1,0,0,1], edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[5,6],[5,7]]
 * 输出：2
 * 解释：从节点 0 出发，收集节点 4 和 3 处的金币，移动到节点 2 处，收集节点 7 处的金币，移动回节点 0 。
 * <p>
 * 提示：
 * <p>
 * n == coins.length
 * 1 <= n <= 3 * 104
 * 0 <= coins[i] <= 1
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges 表示一棵合法的树。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/collect-coins-in-a-tree/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2603_CollectTheCoins {
    public static void main(String[] args) {
        L2603_CollectTheCoins l2603CollectTheCoins = new L2603_CollectTheCoins();
        System.out.println(l2603CollectTheCoins.collectTheCoins(new int[]{0,0,0,1,1,0,0,1}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{5,6},{5,7}}));
    }

    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        List<List<Integer>> graph = new ArrayList<>();
        int[] edgesCount = new int[n];
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
            edgesCount[from]++;
            edgesCount[to]++;
        }
        //找到没有金币 && 边数只有1 的节点
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (edgesCount[i] == 1 && coins[i] == 0) {
                deque.add(i);
            }
        }

        int leftNode = n - 1;
        //移除deque中的节点 中 边为1 并且没有钱的叶子节点
        while (!deque.isEmpty()) {
            leftNode--;
            //扫描临界边
            for (Integer neighbor : graph.get(deque.pop())) {
                if (--edgesCount[neighbor] == 1 && coins[neighbor] == 0) {
                    deque.add(neighbor);
                }
            }
        }

        //此时deque内容为空 可以复用
        //找到 边为1  的节点
        for (int i = 0; i < n; i++) {
            if (edgesCount[i] == 1 && coins[i] == 1) {
                deque.add(i);
            }
        }
        //叶子节点都不考虑
        leftNode -= deque.size();
        for (Integer node : deque) {
            for (Integer neighbor : graph.get(node)) {
                if (--edgesCount[neighbor] == 1) {
                    leftNode--;
                }
            }
        }
        return Math.max(leftNode * 2, 0);

    }
}
