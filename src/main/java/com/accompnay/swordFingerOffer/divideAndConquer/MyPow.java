package com.accompnay.swordFingerOffer.divideAndConquer;

/**
 * 剑指 Offer 16. 数值的整数次方：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * <p>
 * 实现pow(x,n)，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 示例 2：
 * <p>
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 示例 3：
 * <p>
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 * <p>
 * 提示：
 * <p>
 * -100.0 <x< 100.0
 * -231<= n <=231-1
 * -104<= xn<= 104
 */
public class MyPow {

	public double myPow(double x, int n) {
		double v = myPow2(x, Math.abs(n));
		return n < 0 ? 1 / v : v;
	}

	public double myPow2(double x, int n) {
		if (n == 0) return 1;
		if (n == 1) return x;
		double v = myPow2(x, n / 2);
		double v2 = n % 2 == 0 ? v : myPow2(x, n / 2 + 1);
		return v * v2;
	}

	public static void main(String[] args) {
		MyPow myPow = new MyPow();
		double pow = myPow.myPow(2, -3);
		System.out.println(pow);
	}
}
