package com.accompnay.TopicAlgorithms.leetcode.weekly.w431;

public class L2 {
	public static void main(String[] args) {
		L2 l2 = new L2();
		System.out.println(l2.maxDivScore(new int[]{73, 13, 20, 6}, new int[]{56, 75, 83, 26, 24, 53, 56, 61}));
	}

	public int maxDivScore(int[] nums, int[] divisors) {
		int resI = 0;
		int maxScore = -1;
		for (int i = 0; i < divisors.length; i++) {
			int temp = 0;
			for (int num : nums) {
				if (num % divisors[i] == 0) {
					temp++;
				}
			}
			if (temp > maxScore || (temp == maxScore && divisors[resI] > divisors[i])) {
				resI = i;
				maxScore = temp;
			}
		}
		return divisors[resI];

	}
}
