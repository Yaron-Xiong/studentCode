package com.accompnay.TopicAlgorithms.swordFingerOffer.string;

/**
 * 剑指 Offer 20. 表示数值的字符串
 * 中等
 * 479
 * 相关企业
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
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
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "e"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "."
 * 输出：false
 * 示例 4：
 * <p>
 * 输入：s = "    .1  "
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 20
 * s 仅含英文字母（大写和小写），数字（0-9），加号 '+' ，减号 '-' ，空格 ' ' 或者点 '.' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S20_IsNumber {
    public static void main(String[] args) {
        S20_IsNumber s20IsNumber = new S20_IsNumber();
        boolean number = s20IsNumber.isNumber("44e016912630333");
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
