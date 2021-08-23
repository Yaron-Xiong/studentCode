package com.accompnay.swordFingerOffer.string;

/**
 * 剑指 Offer 58 - II. 左旋转字符串：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 */
public class ReverseLeftWords {
	public static void main(String[] args) {
		ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
		String s = reverseLeftWords.reverseLeftWords("abcdefg", 2); //cdefgab
		System.out.println(s);
	}

	public String reverseLeftWords(String s, int n) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = n; i < s.length() + n; i++) {
			stringBuilder.append(s.charAt(i % s.length()));
		}
		return stringBuilder.toString();
	}
}
