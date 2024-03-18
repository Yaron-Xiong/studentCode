package com.yaronxiong.algorithms.leetcode.weekly.w374;

public class L4 {
    public int numberOfSequence(int n, int[] sick) {
        int[] arr = new int[n];
        int ans = 0;
        for (int i : sick) {
            ans += dfs(n, i);
        }
        return ans;
    }

    private int dfs(int n, int i) {
        return 0;
    }
}
