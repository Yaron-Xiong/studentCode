package com.accompnay.TopicAlgorithms.swordFingerOffer.search;

/**
 * 剑指 Offer 04. 二维数组中的查找：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * <p>
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 示例:
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 * <p>
 * 给定target=20，返回false
 * <p>
 */
public class FindNumberIn2DArray {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return false;
		}
		int x = matrix[0].length - 1;
		int y = 0;
		while (y < matrix.length && x >= 0) {
			int value = matrix[y][x];
			if (value > target) {
				x--;
			} else if (value < target) {
				y++;
			} else {
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {
		FindNumberIn2DArray findNumberIn2DArray = new FindNumberIn2DArray();
		int[][] matrix = new int[5][5];
		/*matrix[0] = new int[]{1, 4, 7, 11, 15};
		matrix[1] = new int[]{2, 5, 8, 12, 19};
		matrix[2] = new int[]{3, 6, 9, 16, 22};
		matrix[3] = new int[]{10, 13, 14, 17, 24};
		matrix[4] = new int[]{18, 21, 23, 26, 30};*/
		boolean bole = findNumberIn2DArray.findNumberIn2DArray(matrix, -1);
		System.out.println(bole);
	}
}
