package com.accompnay.swordFingerOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Accompany
 * Date:2020/1/14
 * 斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * 斐波那契数列 = f(n-1)+f(n-2);
 * <p>
 * 实现方式1：
 * 递归 时间复杂度 n^2
 * <p>
 * 实现方式2：
 * 自低向上，维护一个缓存，负责保存每次的计算结果  时间复杂度 n 空间复杂度 n
 * <p>
 * 实现方式3
 * 自顶向下，在递归的基础上完成 时间复杂度 n 空间复杂度 n
 *
 * 剑指offer-10：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 *
 */
public class Fibonacci {
	/**
	 * 方式1:暴力
	 *
	 * @param n
	 * @return
	 */
	public int fib(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	Map<Integer, Integer> map = new HashMap<>();

	public int fib2(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (map.containsKey(n)) {
			return map.get(n);
		}
		int result = (fib2(n - 1) + fib2(n - 2)) % 1000000007;
		map.put(n, result);
		return result;
	}

	public int fib3(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int n_1 = 0;
		int n_2 = 1;
		int n_r = n_1 + n_2; // 这是f(2)
        for (int i = 3; i <= n; i++) {
            n_1 = n_2;
            n_2 = n_r;
            n_r = (n_1 + n_2) % 1000000007;
        }
        return n_r;
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		int fib = fibonacci.fib3(48);
		int fib2 = fibonacci.fib2(48);
		System.out.println(fib);
		System.out.println(fib2);
	}
}
