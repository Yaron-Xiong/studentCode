package com.accompnay.TopicAlgorithms.practiceSet.brackets;

import java.util.Stack;

/**
 * 921. 使括号有效的最少添加
 * 只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 * <p>
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "())"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：s = "((("
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 只包含 '(' 和 ')' 字符。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/minimum-add-to-make-parentheses-valid
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinAddToMakeValid {
	public static void main(String[] args) {
		MinAddToMakeValid minAddToMakeValid = new MinAddToMakeValid();
		int i = minAddToMakeValid.minAddToMakeValid2("()))((");
		System.out.println(i);
	}

	public int minAddToMakeValid2(String s) {
		int res = 0;
		int needRight = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				needRight++;
			}
			if (c == ')') {
				if (needRight > 0) {
					needRight--;
				} else {
					res++;
				}
			}
		}
		return res + needRight;
	}

	public int minAddToMakeValid(String s) {
		Stack<Character> stack = new Stack<>();
		char[] chars = s.toCharArray();
		int res = 0;
		for (char aChar : chars) {
			if (aChar == '(') {
				stack.push(aChar);
			} else {
				if (stack.isEmpty() || stack.peek() == ')') {
					res++;
				}
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
		}
		return res + stack.size();
	}
}
