package com.accompnay.TopicAlgorithms.swordFingerOffer.string;

/**
 * 剑指 Offer 20. 表示数值的字符串：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个小数或者整数
 * （可选）一个'e'或'E'，后面跟着一个整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * 部分数值列举如下：
 * <p>
 * ["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
 * 部分非数值列举如下：
 * <p>
 * ["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 */
public class IsNumber {
	public static void main(String[] args) {
		IsNumber isNumber = new IsNumber();
		boolean number = isNumber.isNumber("44e016912630333");
		System.out.println(number);
	}

	public boolean isNumber(String s) {
		s = s.trim();
		s = s.replace("f","q");
		s = s.replace("F","q");
		s = s.replace("d","w");
		s = s.replace("D","w");
		s = s.toLowerCase();
		String[] split = s.split("[e]");
		if (s.lastIndexOf('e') == s.length()-1) {
			return false;
		}
		if (split.length != 1 && split.length != 2) {
			return false;
		}
		if (s.contains("e") && split.length != 2) {
			return false;
		}
		try {
			if (split.length == 1) {
				getDouble(split[0]);
			} else {
				getDouble(split[0]);
				Long.valueOf(split[1]);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private void getDouble(String num) {
		int index = num.indexOf('.');
		if (num.equals(".") || num.contains(" ")) {
			throw new RuntimeException("滚蛋");
		}
		if (num.startsWith(".") && num.charAt(index + 1) <= '9' && num.charAt(index + 1) >= '0') {
			num = "0" + num;
		} else if (num.endsWith(".") && num.charAt(index - 1) <= '9' && num.charAt(index - 1) >= '0') {
			num = num + "0";
		}
		Double.valueOf(num);
	}

}
