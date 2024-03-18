package com.yaronxiong.algorithms.practiceSet.backtracking.islands;

/**
 * 1905. 统计子岛屿
 * 给你两个m x n的二进制矩阵grid1 和grid2，它们只包含0（表示水域）和 1（表示陆地）。
 * 一个 岛屿是由 四个方向（水平或者竖直）上相邻的1组成的区域。任何矩阵以外的区域都视为水域。
 * <p>
 * 如果 grid2的一个岛屿，被 grid1的一个岛屿完全 包含，
 * 也就是说 grid2中该岛屿的每一个格子都被 grid1中同一个岛屿完全包含，
 * 那么我们称 grid2中的这个岛屿为 子岛屿。
 * <p>
 * 请你返回 grid2中 子岛屿的 数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid1 = [[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]],
 * grid2 = [[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]
 * <p>
 * 输出：3
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 3 个子岛屿。
 * 示例 2：
 * <p>
 * 输入：grid1 = [[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]],
 * grid2 = [[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]
 * <p>
 * 输出：2
 * 解释：如上图所示，左边为 grid1 ，右边为 grid2 。
 * grid2 中标红的 1 区域是子岛屿，总共有 2 个子岛屿。
 * <p>
 * 提示：
 * <p>
 * m == grid1.length == grid2.length
 * n == grid1[i].length == grid2[i].length
 * 1 <= m, n <= 500
 * grid1[i][j] 和grid2[i][j]都要么是0要么是1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-sub-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountSubIslands {
	public static void main(String[] args) {
		CountSubIslands countSubIslands = new CountSubIslands();
		int i = countSubIslands.countSubIslands(new int[][]{{1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}}, new int[][]{{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}});
		System.out.println(i);
	}

	public int countSubIslands(int[][] grid1, int[][] grid2) {
		//先判断 再淹没 再计算
		for (int i = 0; i < grid2.length; i++) {
			for (int j = 0; j < grid2[i].length; j++) {
				if (grid1[i][j] != grid2[i][j]) {
					submerge(grid2, i, j);
				}
			}
		}
		int subIslands = 0;
		for (int i = 0; i < grid2.length; i++) {
			for (int j = 0; j < grid2[i].length; j++) {
				if (grid2[i][j] == 1) {
					submerge(grid2, i, j);
					subIslands++;
				}
			}
		}
		return subIslands;
	}

	private void submerge(int[][] grid2, int y, int x) {
		if (y < 0 || x < 0 || y >= grid2.length || x >= grid2[y].length) {
			return;
		}
		if (grid2[y][x] == 0) {
			return;
		}
		grid2[y][x] = 0;
		submerge(grid2, y + 1, x);
		submerge(grid2, y - 1, x);
		submerge(grid2, y, x + 1);
		submerge(grid2, y, x - 1);
	}

}
