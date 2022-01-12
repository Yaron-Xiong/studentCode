package com.accompnay.TopicAlgorithms.swordFingerOffer.dfs;

/**
 * 剑指 Offer 64. 求1+2+…+n : https://leetcode-cn.com/problems/qiu-12n-lcof
 * 求 1+2+...+n ，要求不能使用乘除法、
 * for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3
 * 输出:6
 * 示例 2：
 * <p>
 * 输入: n = 9
 * 输出:45
 * <p>
 * 限制：
 * <p>
 * 1 <= n<= 10000
 */
public class SumNums {

	public int sumNums(int n) {
		boolean x = (n > 0) && (n += sumNums(n - 1)) > 0;
		return n;
	}

	public static void main(String[] args) {
		SumNums sumNums = new SumNums();
		int nums = sumNums.sumNums(100);
		System.out.println(nums);
	}
}
