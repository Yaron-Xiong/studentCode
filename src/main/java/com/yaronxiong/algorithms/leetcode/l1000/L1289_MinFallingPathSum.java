package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1289. 下降路径最小和 II
 * 提示
 * 困难
 * 116
 * 相关企业
 * 给你一个 n x n 整数矩阵 grid ，请你返回 非零偏移下降路径 数字和的最小值。
 * <p>
 * 非零偏移下降路径 定义为：从 grid 数组中的每一行选择一个数字，且按顺序选出来的数字中，相邻数字不在原数组的同一列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：13
 * 解释：
 * 所有非零偏移下降路径包括：
 * [1,5,9], [1,5,7], [1,6,7], [1,6,8],
 * [2,4,8], [2,4,9], [2,6,7], [2,6,8],
 * [3,4,8], [3,4,9], [3,5,7], [3,5,9]
 * 下降路径中数字和最小的是 [1,5,7] ，所以答案是 13 。
 * 示例 2：
 * <p>
 * 输入：grid = [[7]]
 * 输出：7
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 1 <= n <= 200
 * -99 <= grid[i][j] <= 99
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-falling-path-sum-ii/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1289_MinFallingPathSum {
    public static void main(String[] args) {
        L1289_MinFallingPathSum l1289MinFallingPathSum = new L1289_MinFallingPathSum();
        System.out.println(l1289MinFallingPathSum.minFallingPathSum(new int[][]{{50, -18, -38, 39, -20, -37, -61, 72, 22, 79}, {82, 26, 30, -96, -1, 28, 87, 94, 34, -89}, {55, -50, 20, 76, -50, 59, -58, 85, 83, -83}, {39, 65, -68, 89, -62, -53, 74, 2, -70, -90}, {1, 57, -70, 83, -91, -32, -13, 49, -11, 58}, {-55, 83, 60, -12, -90, -37, -36, -27, -19, -6}, {76, -53, 78, 90, 70, 62, -81, -94, -32, -57}, {-32, -85, 81, 25, 80, 90, -24, 10, 27, -55}, {39, 54, 39, 34, -45, 17, -2, -61, -81, 85}, {-77, 65, 76, 92, 21, 68, 78, -13, 39, 22}}));
        System.out.println(l1289MinFallingPathSum.minFallingPathSum2(new int[][]{{50, -18, -38, 39, -20, -37, -61, 72, 22, 79}, {82, 26, 30, -96, -1, 28, 87, 94, 34, -89}, {55, -50, 20, 76, -50, 59, -58, 85, 83, -83}, {39, 65, -68, 89, -62, -53, 74, 2, -70, -90}, {1, 57, -70, 83, -91, -32, -13, 49, -11, 58}, {-55, 83, 60, -12, -90, -37, -36, -27, -19, -6}, {76, -53, 78, 90, 70, 62, -81, -94, -32, -57}, {-32, -85, 81, 25, 80, 90, -24, 10, 27, -55}, {39, 54, 39, 34, -45, 17, -2, -61, -81, 85}, {-77, 65, 76, 92, 21, 68, 78, -13, 39, 22}}));
    }

    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        int topMinIndex = -1;
        int secondMinIndex = -1;
        for (int i = 0; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i];
            if (topMinIndex == -1 || dp[0][i] < dp[0][topMinIndex]) {
                secondMinIndex = topMinIndex;
                topMinIndex = i;
            } else if (secondMinIndex == -1 || dp[0][i] < dp[0][secondMinIndex]) {
                secondMinIndex = i;
            }
        }

        for (int i = 1; i < dp.length; i++) {
            int tempTopMinIndex = -1;
            int tempSecondMinIndex = -1;
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = j == topMinIndex ? dp[i - 1][secondMinIndex] : dp[i - 1][topMinIndex];
                dp[i][j] += grid[i][j];
                if (tempTopMinIndex == -1 || dp[i][j] < dp[i][tempTopMinIndex]) {
                    tempSecondMinIndex = tempTopMinIndex;
                    tempTopMinIndex = j;
                } else if (tempSecondMinIndex == -1 || dp[i][j] < dp[i][tempSecondMinIndex]) {
                    tempSecondMinIndex = j;
                }

            }
            topMinIndex = tempTopMinIndex;
            secondMinIndex = tempSecondMinIndex;
        }

        int res = Integer.MAX_VALUE;
        for (int value : dp[grid.length - 1]) {
            res = Math.min(value, res);
        }
        return res;
    }

    public int minFallingPathSum2(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        System.arraycopy(grid[0], 0, dp[0], 0, dp[0].length);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                int temp = Integer.MAX_VALUE;
                for (int z = 0; z < dp[i - 1].length; z++) {
                    if (z == j) {
                        continue;
                    }
                    temp = Math.min(temp, dp[i - 1][z]);
                }
                dp[i][j] = grid[i][j] + temp;
            }
        }

        int res = Integer.MAX_VALUE;
        for (int value : dp[grid.length - 1]) {
            res = Math.min(value, res);
        }
        return res;
    }
}
