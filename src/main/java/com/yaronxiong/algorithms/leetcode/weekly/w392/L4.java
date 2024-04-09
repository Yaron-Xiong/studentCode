package com.yaronxiong.algorithms.leetcode.weekly.w392;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L4 {
    public static void main(String[] args) {
        L4 l4 = new L4();
        int[] ints = l4.minimumCost(5, new int[][]{{0, 1, 7}, {1, 3, 7}, {1, 2, 1}}, new int[][]{{0, 3}, {3, 4}});
        System.out.println(Arrays.toString(ints));
    }

    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        List<int[]>[] graph = new ArrayList[n];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] idx = new int[n];
        Arrays.fill(idx, -1);
        List<Integer> ccAnd = new ArrayList<>();
        for (int i = 0; i < idx.length; i++) {
            //<0 说明当前节点没有跟其他节点联通
            if (idx[i] < 0) {
                ccAnd.add(dfs(i, ccAnd.size(), graph, idx));
            }
        }
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int[] q = query[i];
            if (q[0] == q[1]) {
                ans[i] = 0;
            } else if (idx[q[0]] == idx[q[1]]) {
                ans[i] = ccAnd.get(idx[q[0]]);
            }else {
                ans[i] = -1;
            }
        }
        return ans;
    }

    private int dfs(int curNode, int parent, List<int[]>[] graph, int[] idx) {
        idx[curNode] = parent;
        int and = -1;
        for (int[] neighbor : graph[curNode]) {
            and &= neighbor[1];
            if (idx[neighbor[0]] < 0) {
                and &= dfs(neighbor[0], parent, graph, idx);
            }
        }
        return and;
    }

}
