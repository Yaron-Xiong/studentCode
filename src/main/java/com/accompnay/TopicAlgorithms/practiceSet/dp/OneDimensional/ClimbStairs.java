package com.accompnay.TopicAlgorithms.practiceSet.dp.OneDimensional;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 45
 */
public class ClimbStairs {
	public static void main(String[] args) {
		ClimbStairs climbStairs = new ClimbStairs();
		int i = climbStairs.climbStairs2(3);
		System.out.println(i);
	}

	public int climbStairs2(int n) {
		if (n == 0) return 0;
		if (n <= 2) return n;
		int n_1 = 2;
		int n_2 = 1;
		int index = 3;
		while (index < n) {
			index++;
			int temp = n_1 + n_2;
			n_2 = n_1;
			n_1 = temp;
		}
		return n_1 + n_2;
	}


	private Map<Integer, Integer> memo = new HashMap<>();

	public int climbStairs(int n) {
		if (n == 0) {
			return 0;
		}
		if (n <= 2) {
			return n;
		}
		if (memo.containsKey(n)) {
			return memo.get(n);
		}
		int i = climbStairs(n - 1) + climbStairs(n - 2);
		memo.put(n, i);
		return i;
	}
}
