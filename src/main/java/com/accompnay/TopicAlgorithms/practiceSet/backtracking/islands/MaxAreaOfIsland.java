package com.accompnay.TopicAlgorithms.practiceSet.backtracking.islands;

/**
 * 695. 岛屿的最大面积
 * <p>
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * <p>
 * 岛屿是由一些相邻的1(代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。
 * 你可以假设grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * <p>
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 输出：6
 * 解释：答案不应该是 11 ，因为岛屿只能包含水平或垂直这四个方向上的 1 。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,0,0,0,0,0,0]]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * grid[i][j] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxAreaOfIsland {
	public int maxAreaOfIsland(int[][] grid) {
		int maxArea = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				maxArea = Math.max(maxArea, submerge(grid, i, j));
			}
		}
		return maxArea;
	}

	public int submerge(int[][] grid, int y, int x) {
		if (y < 0 || x < 0 || y >= grid.length || x >= grid[y].length) {
			return 0;
		}
		if (grid[y][x] == 0) {
			return 0;
		}
		grid[y][x] = 0;
		return 1 + submerge(grid, y + 1, x) + submerge(grid, y - 1, x) + submerge(grid, y, x + 1) + submerge(grid, y, x - 1);
	}

}
