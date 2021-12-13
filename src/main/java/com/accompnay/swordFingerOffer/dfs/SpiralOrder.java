package com.accompnay.swordFingerOffer.dfs;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵:https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix =[[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * 限制：
 * <p>
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length<= 100
 */
public class SpiralOrder {

	public static void main(String[] args) {
		SpiralOrder spiralOrder = new SpiralOrder();
		//int[] ints = spiralOrder.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
		int[] ints = spiralOrder.spiralOrder(new int[][]{});
		System.out.println(Arrays.toString(ints));
	}

	public int[] spiralOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
			return new int[]{};
		}
		int top = 0;
		int right = matrix[0].length - 1;
		int button = matrix.length - 1;
		int left = 0;
		int[] res = new int[(right + 1) * (button + 1)];
		int index = 0;
		while (true) {
			for (int i = left; i <= right; i++) {
				res[index++] = matrix[top][i];
			}
			if (++top > button) {
				break;
			}
			for (int i = top; i <= button; i++) {
				res[index++] = matrix[i][right];
			}
			if (--right < left) {
				break;
			}
			for (int i = right; i >= left; i--) {
				res[index++] = matrix[button][i];
			}
			if (--button < top) {
				break;
			}
			for (int i = button; i >= top; i--) {
				res[index++] = matrix[i][left];
			}
			if (++left > right) {
				break;
			}
		}
		return res;
	}

}
