package com.yaronxiong.algorithms.leetcode.weekly.w377;

import java.util.*;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        System.out.println(l3.minimumCost("abcd", "acbe", new char[]{'a', 'b', 'c', 'c', 'e', 'd'}, new char[]{'b', 'c', 'b', 'e', 'b', 'e'}, new int[]{2, 5, 5, 1, 2, 20}));
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] graph = new long[26][26];
        for (long[] ints : graph) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < graph.length; i++) {
            graph[i][i] = 0;
        }
        for (int i = 0; i < original.length; i++) {
            int x = original[i] - 'a';
            int y = changed[i] - 'a';
            if (graph[x][y] == -1 || graph[x][y] > cost[i]) {
                graph[x][y] = cost[i];
            }
        }
        boolean[] visit = new boolean[26];
        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            char x = source.charAt(i);
            char y = target.charAt(i);
            if (x == y) {
                continue;
            }
            if (!visit[x - 'a']) {
                //从 s[i] -> t[i] 的最短路径
                dfs(x - 'a', graph);
                visit[x - 'a'] = true;
            }
            long value = graph[x - 'a'][y - 'a'];
            if (value == -1) {
                //不可抵达
                return -1;
            }
            ans += value;
        }
        return ans;
    }

    static class Node {
        long value;
        int index;

        public Node(int index, long value) {
            this.value = value;
            this.index = index;
        }
    }

    private void dfs(int curNode, long[][] graph) {
        Deque<Node> deque = new LinkedList<>();
        for (int i = 0; i < graph[curNode].length; i++) {
            if (graph[curNode][i] == -1) {
                continue;
            }
            deque.add(new Node(i, graph[curNode][i]));
        }
        while (!deque.isEmpty()) {
            Node node = deque.poll();
            for (int i = 0; i < graph[node.index].length; i++) {
                if (graph[node.index][i] == -1) {
                    continue;
                }
                if (graph[curNode][i] == -1 || graph[node.index][i] + node.value < graph[curNode][i]) {
                    graph[curNode][i] = graph[node.index][i] + node.value;
                    deque.add(new Node(i, graph[curNode][i]));
                }
            }
        }
    }
}
