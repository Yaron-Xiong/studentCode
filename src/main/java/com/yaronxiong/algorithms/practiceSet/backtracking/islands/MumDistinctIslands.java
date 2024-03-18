package com.yaronxiong.algorithms.practiceSet.backtracking.islands;

import java.util.HashSet;
import java.util.Set;

/**
 * LeetCode 694. 不同岛屿的数量（BFS/DFS+set）
 * 给定一个非空01二维数组表示的网格，一个岛屿由四连通（上、下、左、右四个方向）的 1 组成，你可以认为网格的四周被海水包围。
 * <p>
 * 请你计算这个网格中共有多少个形状不同的岛屿。
 * 两个岛屿被认为是相同的，当且仅当一个岛屿可以通过平移变换（不可以旋转、翻转）和另一个岛屿重合。
 */
public class MumDistinctIslands {
	public static void main(String[] args) {
		MumDistinctIslands mumDistinctIslands = new MumDistinctIslands();
		int i = mumDistinctIslands.numDistinctIslands(new int[][]{{1,1,0,1,1},{1,0,0,0,0},{0,0,0,0,1},{1,1,0,1,1}});
		System.out.println(i);
	}
	public int numDistinctIslands(int[][] grid) {
		Set<String> paths = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					continue;
				}
				StringBuilder path = new StringBuilder();
				backtracking(grid, i, j, path, 666);
				paths.add(path.toString());
			}
		}
		return paths.size();
	}

	private void backtracking(int[][] grid, int i, int j, StringBuilder path, int dir) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length) {
			return;
		}
		if (grid[i][j] == 0) {
			return;
		}
		grid[i][j] = 0;
		path.append(dir).append(',');
		backtracking(grid, i + 1, j, path, 1);
		backtracking(grid, i - 1, j, path, 2);
		backtracking(grid, i, j + 1, path, 3);
		backtracking(grid, i, j - 1, path, 4);
		path.append(-dir).append(',');
	}
}
