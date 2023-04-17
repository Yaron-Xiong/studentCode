package com.accompnay.TopicAlgorithms.leetcode;

import java.util.Arrays;

public class L1 {
	public static void main(String[] args) {
		L1 l1 = new L1();
		int[] x = l1.rowAndMaximumOnes(new int[][]{{0, 1}, {1, 0}});
		System.out.println(Arrays.toString(x));
	}

	public int[] rowAndMaximumOnes(int[][] mat) {
		int resI = -1;
		int cnt = 0;
		for (int i = 0; i < mat.length; i++) {
			int temp = 0;
			for (int j = 0; j < mat[i].length; j++) {
				if (mat[i][j] == 1) {
					temp++;
				}
			}
			if (resI == -1 || temp > cnt) {
				resI = i;
				cnt = temp;
			}
		}
		return new int[]{resI, cnt};
	}
}
