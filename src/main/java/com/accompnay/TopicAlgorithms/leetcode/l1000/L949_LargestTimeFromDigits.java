package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 *
 */
public class L949_LargestTimeFromDigits {
	public static void main(String[] args) {
		L949_LargestTimeFromDigits l949LargestTimeFromDigits = new L949_LargestTimeFromDigits();
		String s = l949LargestTimeFromDigits.largestTimeFromDigits(new int[]{2, 0, 6, 6});
		System.out.println(s);
	}

	public String largestTimeFromDigits(int[] arr) {
		int[] memo = new int[10];
		for (int j : arr) {
			memo[j] += 1;
		}
		int[] res = new int[4];
		if (dfs(memo, res, 0)) {
			return String.valueOf(res[0]) + res[1] + ":" + res[2] + res[3];
		}
		return "";
	}

	public boolean dfs(int[] memo, int[] res, int curIndex) {
		if (curIndex >= 4) {
			int hour = res[0] * 10 + res[1];
			if (hour >= 24) {
				return false;
			}
			int min = res[2] * 10 + res[3];
			if (min >= 60) {
				return false;
			}
			return true;
		}
		for (int i = getMax(curIndex, res); i >= 0; i--) {
			if (memo[i] > 0) {
				res[curIndex] = i;
				memo[i] -= 1;
				if (dfs(memo, res, curIndex + 1)) {
					return true;
				}
				res[curIndex] = 0;
				memo[i] += 1;
			}
		}
		return false;
	}

	public int getMax(int curIndex, int[] res) {
		if (curIndex == 0) {
			return 2;
		}
		if (curIndex == 1) {
			if (res[0] == 2) {
				return 3;
			}
			return 9;
		}
		if (curIndex == 2) {
			return 5;
		}
		if (curIndex == 3) {
			return 9;
		}
		return -1;
	}
}
