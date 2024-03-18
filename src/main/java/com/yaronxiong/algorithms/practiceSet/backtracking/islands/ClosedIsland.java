package com.yaronxiong.algorithms.practiceSet.backtracking.islands;

/**
 * 1254. 统计封闭岛屿的数目
 * 二维矩阵 grid由 0（土地）和 1（水）组成。岛是由最大的4个方向连通的 0组成的群，封闭岛是一个完全 由1包围（左、上、右、下）的岛。
 * <p>
 * 请返回 封闭岛屿 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
 * 输出：2
 * 解释：
 * 灰色区域的岛屿是封闭岛屿，因为这座岛屿完全被水域包围（即被 1 区域包围）。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,1],
 * [1,0,0,0,0,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,1,0,1,0,1],
 * [1,0,1,1,1,0,1],
 * [1,0,0,0,0,0,1],
 * [1,1,1,1,1,1,1]]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[0].length <= 100
 * 0 <= grid[i][j] <=1
 * 通过次数19,522提交次数31,916
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-closed-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ClosedIsland {
	public static void main(String[] args) {
		ClosedIsland closedIsland = new ClosedIsland();
		int i = closedIsland.closedIsland(new int[][]{{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}});
		System.out.println(i);
	}

	public int closedIsland(int[][] grid) {
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
		//计算剩余岛屿
		int mun = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					mun++;
					submerged(grid, i, j);
				}
			}
		}
		return mun;
	}

	private void submerged(int[][] grid, int y, int x) {
		if (y < 0 || x < 0 || y >= grid.length || x >= grid[y].length) {
			return;
		}
		if (grid[y][x] == 1) {
			return;
		}
		grid[y][x] = 1;
		submerged(grid, y + 1, x);
		submerged(grid, y - 1, x);
		submerged(grid, y, x + 1);
		submerged(grid, y, x - 1);
	}
}
