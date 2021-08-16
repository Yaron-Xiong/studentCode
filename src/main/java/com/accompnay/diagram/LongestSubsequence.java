package com.accompnay.diagram;

import org.springframework.util.StringUtils;

/**
 * 最长子序列
 */
public class LongestSubsequence {
	public static void main(String[] args) {
		int i = longestSubsequence("ABC", "ERT");
		System.out.println(i);
	}

	public static int longestSubsequence(String str1, String str2) {
		if (StringUtils.isEmpty(str1) || StringUtils.isEmpty(str2)) {
			return 0;
		}
		int[][] matrix = new int[str2.length() + 1][str1.length() + 1];
		for (int i = 1; i <= str1.length(); i++) {
			for (int j = 1; j <= str2.length(); j++) {
				char char1 = str1.charAt(i - 1);
				char char2 = str2.charAt(j - 1);
				if (char1 == char2) {
					matrix[j][i] = matrix[j - 1][i - 1] + 1;
					continue;
				}
				matrix[j][i] = Math.max(matrix[j - 1][i], matrix[j][i - 1]);
			}
		}
		return matrix[str2.length()][str1.length()];
	}
}
