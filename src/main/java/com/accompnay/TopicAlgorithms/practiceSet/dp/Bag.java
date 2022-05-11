package com.accompnay.TopicAlgorithms.practiceSet.dp;

import java.util.Arrays;

/**
 * 给你⼀个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为
 * wt[i]，价值为 val[i]，现在让你⽤这个背包装物品，最多能装的价值是多少？
 */
public class Bag {
	public static void main(String[] args) {
		Bag bag = new Bag();
		int knapsack = bag.knapsack2(5, new int[]{2, 1, 3}, new int[]{4, 2, 3});
		System.out.println(knapsack);
	}

	public int knapsack2(int w, int[] wt, int[] val) {
		int[] dp = new int[w + 1];
		Arrays.fill(dp, -1);
		for (int i = 0; i < wt.length; i++) {
			dp[wt[i]] = val[i];
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < wt.length; j++) {
				if (i - wt[j] < 0) {
					continue;
				}
				if (dp[wt[j]] == -1) {
					continue;
				}
				if (i - wt[j] == 0) {
					dp[i] = Math.max(val[j], dp[i]);
				}
				dp[i] = Math.max(dp[i - wt[j]] + val[j], dp[i]);
			}
		}
		return dp[w];
	}

	public int knapsack(int w, int[] wt, int[] val) {
		if (w <= 0) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < wt.length; i++) {
			if (w - wt[i] < 0) {
				continue;
			}
			max = Math.max(max, knapsack(w - wt[i], wt, val) + val[i]);
		}
		return max;
	}
}
