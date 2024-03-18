package com.yaronxiong.algorithms.practiceSet.dp;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		Test minimumDeleteSum = new Test();
		String i = minimumDeleteSum.minimumDeleteSum("intention", "execution");
		System.out.println(i);
	}
	public String minimumDeleteSum(String s1, String s2) {
		String[][] dp = new String[s1.length() + 1][s2.length() + 1];
		for (String[] strings : dp) {
			Arrays.fill(strings,"");
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
				} else {
					if (dp[i - 1][j].length() > dp[i][j - 1].length()) {
						dp[i][j] = dp[i-1][j];
					}else {
						dp[i][j] = dp[i][j-1];
					}
				}
			}
		}
		return dp[s1.length()][s2.length()];
	}

}
