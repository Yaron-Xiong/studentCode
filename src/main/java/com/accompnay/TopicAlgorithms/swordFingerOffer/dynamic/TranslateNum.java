package com.accompnay.TopicAlgorithms.swordFingerOffer.dynamic;

/**
 * 剑指 Offer 46. 把数字翻译成字符串:https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * <p>
 * 给定一个数字，我们按照如下规则把它翻译为字符串：
 * 0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 */
public class TranslateNum {
	public int translateNum(int num) {
		int dpN_2 = 1;
		int dpN_1 = 1;
		String str = String.valueOf(num);
		for (int i = 1; i < str.length(); i++) {
			int temp;
			String subStr = str.substring(i - 1, i + 1);
			if (subStr.compareTo("10") >= 0 && subStr.compareTo("26")<0) {
				temp = dpN_1 + dpN_2;
			} else {
				temp = dpN_1;
			}
			dpN_2 = dpN_1;
			dpN_1 = temp;
		}
		return dpN_1;
	}

	public static void main(String[] args) {
		TranslateNum translateNum = new TranslateNum();
		int i = translateNum.translateNum(1068385902);
		System.out.println(i);
	}
}
