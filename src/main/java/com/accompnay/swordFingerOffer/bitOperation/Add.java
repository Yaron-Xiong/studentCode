package com.accompnay.swordFingerOffer.bitOperation;

/**
 * 剑指 Offer 65. 不用加减乘除做加法：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 * <p>
 * 示例:
 * <p>
 * 输入: a = 1, b = 1
 * 输出: 2
 * <p>
 * 提示：
 * <p>
 * a,b均可能是负数或 0
 * 结果不会溢出 32 位整数
 */
public class Add {
	public static void main(String[] args) {
		Add add = new Add();
		int add1 = add.add(5, 7);
		System.out.println(add1);
	}

	public int add(int a, int b) {
		if (b == 0) {
			return a;
		}
		return add(a ^ b, (a & b) << 1);
	}
}
