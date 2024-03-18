package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.*;

/**
 * 2304. 网格中的最小路径代价
 * 提示
 * 中等
 * 21
 * 相关企业
 * 给你一个下标从 0 开始的整数矩阵 grid ，矩阵大小为 m x n ，由从 0 到 m * n - 1 的不同整数组成。
 * 你可以在此矩阵中，从一个单元格移动到 下一行 的任何其他单元格。如果你位于单元格 (x, y) ，且满足 x < m - 1 ，
 * 你可以移动到 (x + 1, 0), (x + 1, 1), ..., (x + 1, n - 1) 中的任何一个单元格。注意： 在最后一行中的单元格不能触发移动。
 * <p>
 * 每次可能的移动都需要付出对应的代价，代价用一个下标从 0 开始的二维数组 moveCost 表示，该数组大小为 (m * n) x n ，
 * 其中 moveCost[i][j] 是从值为 i 的单元格移动到下一行第 j 列单元格的代价。从 grid 最后一行的单元格移动的代价可以忽略。
 * <p>
 * grid 一条路径的代价是：所有路径经过的单元格的 值之和 加上 所有移动的 代价之和 。从 第一行 任意单元格出发，返回到达 最后一行 任意单元格的最小路径代价。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[5,3],[4,0],[2,1]], moveCost = [[9,8],[1,5],[10,12],[18,6],[2,4],[14,3]]
 * 输出：17
 * 解释：最小代价的路径是 5 -> 0 -> 1 。
 * - 路径途经单元格值之和 5 + 0 + 1 = 6 。
 * - 从 5 移动到 0 的代价为 3 。
 * - 从 0 移动到 1 的代价为 8 。
 * 路径总代价为 6 + 3 + 8 = 17 。
 * 示例 2：
 * <p>
 * 输入：grid = [[5,1,2],[4,0,3]], moveCost = [[12,10,15],[20,23,8],[21,7,1],[8,1,13],[9,10,25],[5,3,2]]
 * 输出：6
 * 解释：
 * 最小代价的路径是 2 -> 3 。
 * - 路径途经单元格值之和 2 + 3 = 5 。
 * - 从 2 移动到 3 的代价为 1 。
 * 路径总代价为 5 + 1 = 6 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 50
 * grid 由从 0 到 m * n - 1 的不同整数组成
 * moveCost.length == m * n
 * moveCost[i].length == n
 * 1 <= moveCost[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-path-cost-in-a-grid/?envType=daily-question&envId=Invalid%20Date">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2304_MinPathCost {
    public static void main(String[] args) {
        L2304_MinPathCost l2304MinPathCost = new L2304_MinPathCost();
        System.out.println(l2304MinPathCost.minPathCost2(new int[][]{{5, 3}, {4, 0}, {2, 1}}, new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}}));
    }

    public int minPathCost2(int[][] grid, int[][] moveCost) {
        int ans = Integer.MAX_VALUE;
        int[][] memo = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid[0].length; i++) {
            ans = Math.min(ans, dfs(0, i, grid, moveCost, memo));
        }
        return ans;
    }

    private int dfs(int x, int y, int[][] grid, int[][] moveCost, int[][] memo) {
        if (x == grid.length - 1) {
            return grid[x][y];
        }
        if (memo[x][y] != 0) {
            return memo[x][y];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < grid[x].length; i++) {
            ans = Math.min(ans, dfs(x + 1, i, grid, moveCost, memo) + moveCost[grid[x][y]][i]);
        }
        return memo[x][y] = ans + grid[x][y];
    }


    /**
     * 超时
     *
     * @param grid
     * @param moveCost
     * @return
     */
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < grid[0].length; i++) {
            deque.add(new int[]{0, i, grid[0][i]});
        }
        int minValue = Integer.MAX_VALUE;
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            //开始移动
            int x = poll[0];
            int y = poll[1];
            dp[x][y] = poll[2];
            if (x == grid.length - 1) {
                minValue = Math.min(minValue, dp[x][y]);
            }
            for (int i = 0; i < grid[x].length && x + 1 < grid.length; i++) {
                int nx = x + 1;
                int ny = i;
                int newCost = poll[2] + moveCost[grid[x][y]][i] + grid[nx][ny];
                if (newCost >= dp[nx][ny]) {
                    continue;
                }
                deque.add(new int[]{nx, ny, newCost});
            }
        }
        return minValue;
    }
}
