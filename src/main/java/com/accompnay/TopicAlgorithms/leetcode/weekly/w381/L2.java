package com.accompnay.TopicAlgorithms.leetcode.weekly.w381;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        System.out.println(Arrays.toString(l2.countOfPairs(5, 2, 4)));
    }

    public int[] countOfPairs(int n, int x, int y) {
        int[][] graph = new int[n][n];
        int[][] graph2 = new int[n][n];
        for (int[] ints : graph2) {
            Arrays.fill(ints, -1);
        }
        graph[x - 1][y - 1] = x == y ? 0 : 1;
        graph[y - 1][x - 1] = x == y ? 0 : 1;
        for (int i = 0; i < graph.length; i++) {
            if (i + 1 >= n) {
                continue;
            }
            graph[i][i + 1] = 1;
            graph[i + 1][i] = 1;
        }
        //算出所有点到所有点的距离
        for (int i = 0; i < n; i++) {
            dfs(graph, graph2, i);
        }
        int[] ans = new int[n];
        for (int i = 0; i < graph2.length; i++) {
            for (int j = 0; j < graph2[i].length; j++) {
                if (i != j) {
                    ans[graph2[i][j] - 1]++;
                }
            }
        }
        return ans;
    }

    private void dfs(int[][] graph, int[][] graph2, int i) {
        Deque<int[]> deque = new LinkedList<>();
        deque.add(new int[]{i, 0});
        graph2[i][i] = 0;
        boolean[] visit = new boolean[graph.length];
        while (!deque.isEmpty()) {
            int[] node = deque.pollFirst();
            if (visit[node[0]]) {
                continue;
            }
            visit[node[0]] = true;
            int[] neighbors = graph[node[0]];
            for (int j = 0; j < neighbors.length; j++) {
                if (graph[node[0]][j] != 0) {
                    int cost = node[1] + neighbors[j];
                    graph2[i][j] = graph2[i][j] == -1 ? cost : Math.min(graph2[i][j], cost);
                    deque.add(new int[]{j, cost});
                }
            }
        }
    }
}
