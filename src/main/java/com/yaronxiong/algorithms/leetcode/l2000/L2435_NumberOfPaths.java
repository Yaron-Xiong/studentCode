package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2435. 矩阵中和能被 K 整除的路径
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 和一个整数 k 。
 * 你从起点 (0, 0) 出发，每一步只能往 下 或者往 右 ，你想要到达终点 (m - 1, n - 1) 。
 * <p>
 * 请你返回路径和能被 k 整除的路径数目，由于答案可能很大，返回答案对 109 + 7 取余 的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[5,2,4],[3,0,5],[0,7,2]], k = 3
 * 输出：2
 * 解释：有两条路径满足路径上元素的和能被 k 整除。
 * 第一条路径为上图中用红色标注的路径，和为 5 + 2 + 4 + 5 + 2 = 18 ，能被 3 整除。
 * 第二条路径为上图中用蓝色标注的路径，和为 5 + 3 + 0 + 5 + 2 = 15 ，能被 3 整除。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0]], k = 5
 * 输出：1
 * 解释：红色标注的路径和为 0 + 0 = 0 ，能被 5 整除。
 * 示例 3：
 * <p>
 * 输入：grid = [[7,3,4,9],[2,3,6,2],[2,3,7,0]], k = 1
 * 输出：10
 * 解释：每个数字都能被 1 整除，所以每一条路径的和都能被 k 整除。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 5 * 104
 * 1 <= m * n <= 5 * 104
 * 0 <= grid[i][j] <= 100
 * 1 <= k <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/paths-in-matrix-whose-sum-is-divisible-by-k/description/?envType=daily-question&envId=2025-11-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2435_NumberOfPaths {

    public static void main(String[] args) {
        L2435_NumberOfPaths l2435NumberOfPaths = new L2435_NumberOfPaths();
        System.out.println(l2435NumberOfPaths.numberOfPaths(new int[][]{{5, 2, 4}, {3, 0, 5}, {0, 7, 2}}, 3));
    }

    private static long MOD = (long) 1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        long[][][] memo = new long[grid.length][grid[0].length][k];
        for (long[][] ints : memo) {
            for (long[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return (int) (dfs2(0, 0, 0, grid, memo, k)% MOD);
    }

    private long dfs2(int x, int y, int curK, int[][] grid, long[][][] memo, int k) {
        if (x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        if (memo[x][y][curK] != -1) {
            return memo[x][y][curK];
        }

        if (x == grid.length - 1 && y == grid[0].length - 1) {
            //结算
            int nextK = (curK + grid[x][y]) % k;
            return nextK == 0 ? 1 : 0;
        }

        //向下跟向右
        int nextK = (curK + grid[x][y]) % k;
        long a = dfs2(x + 1, y, nextK, grid, memo, k);
        long b = dfs2(x, y + 1, nextK, grid, memo, k);
        return memo[x][y][curK] = (a + b) % MOD;
    }
}
