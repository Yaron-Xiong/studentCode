package com.accompnay.TopicAlgorithms.leetcode.weekly.w340;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 6353. 网格图中最少访问的格子数
 * 提示
 * 困难
 * 1
 * 相关企业
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 。你一开始的位置在 左上角 格子 (0, 0) 。
 * <p>
 * 当你在格子 (i, j) 的时候，你可以移动到以下格子之一：
 * <p>
 * 满足 j < k <= grid[i][j] + j 的格子 (i, k) （向右移动），或者
 * 满足 i < k <= grid[i][j] + i 的格子 (k, j) （向下移动）。
 * 请你返回到达 右下角 格子 (m - 1, n - 1) 需要经过的最少移动格子数，如果无法到达右下角格子，请你返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]
 * 输出：4
 * 解释：上图展示了到达右下角格子经过的 4 个格子。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]
 * 输出：3
 * 解释：上图展示了到达右下角格子经过的 3 个格子。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[2,1,0],[1,0,0]]
 * 输出：-1
 * 解释：无法到达右下角格子。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 0 <= grid[i][j] < m * n
 * grid[m - 1][n - 1] == 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L6353_MinimumVisitedCells {
	public static void main(String[] args) {
		L6353_MinimumVisitedCells l6353MinimumVisitedCells = new L6353_MinimumVisitedCells();
		System.out.println(l6353MinimumVisitedCells.minimumVisitedCells(new int[][]{{3, 4, 2, 1}, {4, 2, 3, 1}, {2, 1, 0, 0}, {2, 4, 0, 0}}));
	}


	public int minimumVisitedCells(int[][] grid) {
		boolean[][] isVisited = new boolean[grid.length][grid[0].length];
		Deque<int[]> queue = new LinkedList<>();
		queue.add(new int[]{0, 0});
		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				size--;
				int[] pop = queue.pop();
				int i = pop[0];
				int j = pop[1];
				if (i == grid.length - 1 && j == grid[0].length - 1) {
					return step + 1;
				}
				//可以走的地方，向右边移动
				for (int indexJ = Math.min(grid[i][j] + j, grid[i].length - 1); indexJ > j; indexJ--) {
					if (!isVisited[i][indexJ]) {
						isVisited[i][indexJ] = true;
						queue.add(new int[]{i, indexJ});
					}
				}
				//向下移动
				for (int indexI = Math.min(grid[i][j] + i, grid.length - 1); indexI > i; indexI--) {
					if (!isVisited[indexI][j]) {
						isVisited[indexI][j] = true;
						queue.add(new int[]{indexI, j});
					}
				}
			}
			step++;
		}
		return -1;
	}

}
