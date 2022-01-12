package com.accompnay.TopicAlgorithms.Stormzhang.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。
 * 斐波那契数列的定义如下：
 * <p>
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：n = 5
 * 输出：5
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 100
 */
public class Fib {
	public static void main(String[] args) {
		Fib fib = new Fib();
		System.out.println(fib.fib(20));
		System.out.println(fib.fib2(20));
		System.out.println(fib.fib3(20));
	}

	private Map<Integer, Integer> memo = new HashMap<>();

	public int fib(int n) {
		if (n == 0) return 0;
		if (n == 1 || n == 2) return 1;
		Integer value = memo.getOrDefault(n, fib(n - 1) + fib(n - 2));
		memo.put(n, value);
		return value;
	}

	public int fib2(int n) {
		if (n == 0) return 0;
		int[] dpTable = new int[n + 1];
		dpTable[0] = 0;
		dpTable[1] = 1;
		dpTable[2] = 1;
		int curN = 3;
		while (curN <= n) {
			dpTable[curN] = dpTable[curN - 1] + dpTable[curN - 2];
			curN++;
		}
		return dpTable[n];
	}

	public int fib3(int n) {
		if (n == 0) return 0;
		if (n == 1 || n == 2) return 1;
		int cur_1 = 1;
		int cur_2 = 1;
		int cur_rs = cur_1 + cur_2;
		int curN = 3;
		while (curN <= n) {
			cur_rs = cur_1 + cur_2;
			cur_2 = cur_1;
			cur_1 = cur_rs;
			curN++;
		}
		return cur_rs;
	}
}
