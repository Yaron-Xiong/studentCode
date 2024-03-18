package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 931. 下降路径最小和
 * 中等
 * 252
 * 相关企业
 * 给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。
 * <p>
 * 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。
 * 在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第一个元素）。
 * 具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1, col + 1) 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
 * 输出：13
 * 解释：如图所示，为和最小的两条下降路径
 * 示例 2：
 * <p>
 * 输入：matrix = [[-19,57],[-40,-5]]
 * 输出：-59
 * 解释：如图所示，为和最小的下降路径
 * <p>
 * 提示：
 * <p>
 * n == matrix.length == matrix[i].length
 * 1 <= n <= 100
 * -100 <= matrix[i][j] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-falling-path-sum/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L931_MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = matrix[i][j] + dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = Math.min(matrix[i][j] + dp[i - 1][j - 1], dp[i][j]);
                }
                if (j + 1 < dp[i].length) {
                    dp[i][j] = Math.min(matrix[i][j] + dp[i - 1][j + 1], dp[i][j]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int value : dp[matrix.length - 1]) {
            res = Math.min(value, res);
        }
        return res;
    }
}
