package com.accompnay.TopicAlgorithms.practiceSet.brackets;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValid {
	public static void main(String[] args) {
		IsValid isValid = new IsValid();
		boolean valid = isValid.isValid("((");
		System.out.println(valid);
	}

	public boolean isValid(String s) {
		if (s.length() <= 1) {
			return false;
		}
		Map<Character, Character> map = new HashMap<>();
		map.put(']', '[');
		map.put('}', '{');
		map.put(')', '(');
		Stack<Character> stack = new Stack<>();
		for (char curChar : s.toCharArray()) {
			if (map.containsKey(curChar)) {
				Character leftBracket = map.get(curChar);
				if (stack.isEmpty() || !stack.peek().equals(leftBracket)) {
					return false;
				}
				stack.pop();
			} else {
				stack.push(curChar);
			}
		}
		return stack.isEmpty();
	}
}
