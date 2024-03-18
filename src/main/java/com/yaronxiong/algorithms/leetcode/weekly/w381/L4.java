package com.yaronxiong.algorithms.leetcode.weekly.w381;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class L4 {
    public static void main(String[] args) {
        L4 l4 = new L4();
        System.out.println(Arrays.toString(l4.countOfPairs(5, 2, 4)));
    }
    public long[] countOfPairs(int n, int x, int y) {
        long[][] graph = new long[n][n];
        long[][] graph2 = new long[n][n];
        for (long[] ints : graph2) {
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
        long[] ans = new long[n];
        for (int i = 0; i < graph2.length; i++) {
            for (int j = 0; j < graph2[i].length; j++) {
                if (i != j) {
                    ans[(int) (graph2[i][j] - 1)]++;
                }
            }
        }
        return ans;
    }

    private void dfs(long[][] graph, long[][] graph2, int i) {
        Deque<long[]> deque = new LinkedList<>();
        deque.add(new long[]{i, 0});
        graph2[i][i] = 0;
        while (!deque.isEmpty()) {
            long[] node = deque.pollFirst();
            int index = (int) node[0];
            long[] neighbors = graph[index];
            for (int j = index + 1; j < neighbors.length; j++) {
                if (graph[index][j] != 0) {
                    long cost = node[1] + neighbors[j];
                    graph2[i][j] = graph2[i][j] == -1 ? cost : Math.min(graph2[i][j], cost);
                    graph2[j][i] = graph2[i][j];
                    deque.add(new long[]{j, cost});
                }
            }
        }
    }
}
