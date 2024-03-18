package com.yaronxiong.algorithms.practiceSet.backtracking.islands;

/**
 * 1020. 飞地的数量
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid ，其中 0 表示一个海洋单元格、1 表示一个陆地单元格。
 * <p>
 * 一次 移动 是指从一个陆地单元格走到另一个相邻（上、下、左、右）的陆地单元格或跨过 grid 的边界。
 * <p>
 * 返回网格中 无法 在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：所有 1 都在边界上或可以到达边界。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 500
 * grid[i][j] 的值为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-enclaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MumEnclaves {
	public int numEnclaves(int[][] grid) {
		//淹没边缘岛屿
		//淹没 第一行和最后一行
		for (int i = 0; i < grid[0].length; i++) {
			submerged(grid, 0, i);
			submerged(grid, grid.length - 1, i);
		}
		//淹没 第一列和最后一列
		for (int i = 0; i < grid.length; i++) {
			submerged(grid, i, 0);
			submerged(grid, i, grid[i].length - 1);
		}
		//计算剩余岛屿数量
		int num = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1){
					num++;
				}
			}
		}
		return num;
	}

	private void submerged(int[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
			return;
		}
		if (grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		submerged(grid, i + 1, j);
		submerged(grid, i - 1, j);
		submerged(grid, i, j + 1);
		submerged(grid, i, j - 1);
	}
}
