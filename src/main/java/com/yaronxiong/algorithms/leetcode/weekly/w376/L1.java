package com.yaronxiong.algorithms.leetcode.weekly.w376;

import java.util.Arrays;

public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        System.out.println(Arrays.toString(l1.findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] arr = new int[grid.length * grid.length + 1];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                arr[grid[i][j]]++;
            }
        }
        int[] ans = new int[2];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                ans[1] = i;
            } else if (arr[i] == 2) {
                ans[0] = i;
            }
        }
        return ans;
    }
}
