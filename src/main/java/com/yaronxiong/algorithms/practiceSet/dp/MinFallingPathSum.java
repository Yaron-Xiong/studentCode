package com.yaronxiong.algorithms.practiceSet.dp;

/**
 * 931. 下降路径最小和
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
 * 链接：https://leetcode-cn.com/problems/minimum-falling-path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinFallingPathSum {
	public static void main(String[] args) {
		MinFallingPathSum minFallingPathSum = new MinFallingPathSum();
		int i = minFallingPathSum.minFallingPathSum(new int[][]{{2, 1, 3}, {6, 5, 4}, {7, 8, 9}});
		System.out.println(i);
	}

	public int minFallingPathSum(int[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				int best = matrix[i - 1][j];
				if (j > 0) {
					best = Math.min(best, matrix[i - 1][j - 1]);
				}
				if (j < matrix[i].length - 1) {
					best = Math.min(best, matrix[i - 1][j + 1]);
				}
				matrix[i][j] += best;
			}
		}
		int res = Integer.MAX_VALUE;
		for (int i : matrix[matrix.length - 1]) {
			res = Math.min(res, i);
		}
		return res;
	}
}
