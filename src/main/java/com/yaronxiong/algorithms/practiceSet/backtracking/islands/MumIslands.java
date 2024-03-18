package com.yaronxiong.algorithms.practiceSet.backtracking.islands;

/**
 * 200. 岛屿数量
 * 给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MumIslands {
	public static void main(String[] args) {
		MumIslands mumIslands = new MumIslands();
		int i = mumIslands.numIslands(new char[][]{{'0', '1', '0'}, {'1', '0', '1'}, {'0', '1', '0'}});
		System.out.println(i);
	}

	public int numIslands(char[][] grid) {
		int muns = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					backtracking(grid, i, j);
					muns++;
				}
			}
		}
		return muns;
	}

	private void backtracking(char[][] grid, int y, int x) {
		if (y < 0 || y >= grid.length || x < 0 || x >= grid[0].length) {
			return;
		}
		if (grid[y][x] == '0') {
			return;
		}
		grid[y][x] = '0';
		backtracking(grid, y + 1, x);
		backtracking(grid, y - 1, x);
		backtracking(grid, y, x + 1);
		backtracking(grid, y, x - 1);
	}
}
