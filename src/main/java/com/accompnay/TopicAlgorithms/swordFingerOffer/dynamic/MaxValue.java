package com.accompnay.TopicAlgorithms.swordFingerOffer.dynamic;

/**
 * 剑指 Offer 47. 礼物的最大价值:https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * <p>
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [1,3,1],
 * [1,5,1],
 * [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 */
public class MaxValue {
	public int maxValue(int[][] grid) {
		if (grid == null || grid.length == 0 || grid[0].length == 0) {
			return 0;
		}
		int[][] result = new int[grid.length][grid[0].length];
		result[0][0] = grid[0][0];
		for (int i = 1; i < result[0].length; i++) {
			result[0][i] = result[0][i - 1] + grid[0][i];
		}
		for (int i = 1; i < result.length; i++) {
			result[i][0] = result[i - 1][0] + grid[i][0];
		}
		int y = result.length;
		int x = result[0].length;
		for (int i = 1; i < y; i++) {
			for (int j = 1; j < x; j++) {
				result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]) + grid[i][j];
			}
		}
		return result[y - 1][x - 1];
	}

	public static void main(String[] args) {
		MaxValue maxValue = new MaxValue();
		int i = maxValue.maxValue(new int[][]{});
		System.out.println(i);
	}
}
