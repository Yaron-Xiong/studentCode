package com.yaronxiong.algorithms.practiceSet.dp;

/**
 * 64. 最小路径和
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class MinPathSum {
	public static void main(String[] args) {
		MinPathSum minPathSum = new MinPathSum();
		int i = minPathSum.minPathSum(new int[][]{{1, 2, 3}, {4, 5, 6}});
		System.out.println(i);
	}

	public int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];
		for (int i = 0; i < dp[0].length; i++) {
			if (i == 0) {
				dp[0][i] = grid[0][0];
				continue;
			}
			dp[0][i] = dp[0][i - 1] + grid[0][i];
		}

		for (int i = 1; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][j] + grid[i][j];
					continue;
				}
				dp[i][j] = Math.min(dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j]);
			}
		}
		return dp[grid.length - 1][grid[0].length - 1];
	}
}
