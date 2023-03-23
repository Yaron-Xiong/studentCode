package com.accompnay.TopicAlgorithms.leetcode;

import java.util.Arrays;

/**
 * 1605. 给定行和列的和求可行矩阵
 * 提示
 * 中等
 * 69
 * 相关企业
 * 给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 * <p>
 * 请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。
 * <p>
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
 * <p>
 * 示例 1：
 * <p>
 * 输入：rowSum = [3,8], colSum = [4,7]
 * 输出：[[3,0],
 * [1,7]]
 * 解释：
 * 第 0 行：3 + 0 = 3 == rowSum[0]
 * 第 1 行：1 + 7 = 8 == rowSum[1]
 * 第 0 列：3 + 1 = 4 == colSum[0]
 * 第 1 列：0 + 7 = 7 == colSum[1]
 * 行和列的和都满足题目要求，且所有矩阵元素都是非负的。
 * 另一个可行的矩阵为：[[1,2],
 * [3,5]]
 * 示例 2：
 * <p>
 * 输入：rowSum = [5,7,10], colSum = [8,6,8]
 * 输出：[[0,5,0],
 * [6,1,0],
 * [2,0,8]]
 * 示例 3：
 * <p>
 * 输入：rowSum = [14,9], colSum = [6,9,8]
 * 输出：[[0,9,5],
 * [6,0,3]]
 * 示例 4：
 * <p>
 * 输入：rowSum = [1,0], colSum = [1]
 * 输出：[[1],
 * [0]]
 * 示例 5：
 * <p>
 * 输入：rowSum = [0], colSum = [0]
 * 输出：[[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= rowSum.length, colSum.length <= 500
 * 0 <= rowSum[i], colSum[i] <= 108
 * sum(rowSum) == sum(colSum)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-subtrees-with-max-distance-between-cities/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1605_RestoreMatrix {
	public static void main(String[] args) {
		L1605_RestoreMatrix l1605RestoreMatrix = new L1605_RestoreMatrix();
		int[][] x = l1605RestoreMatrix.restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8});
		for (int[] ints : x) {
			System.out.println(Arrays.toString(ints));
		}
	}

	public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
		int[][] res = new int[rowSum.length][colSum.length];
		int i = 0;
		int j = 0;
		while (i < res.length && j < colSum.length) {
			res[i][j] = Math.min(rowSum[i], colSum[j]);
			colSum[j] -= res[i][j];
			rowSum[i] -= res[i][j];
			if (colSum[j] == 0) {
				j++;
			}
			if (rowSum[i] == 0) {
				i++;
			}
		}
		return res;
	}
}
