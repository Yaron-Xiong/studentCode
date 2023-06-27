package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.*;

/**
 * 1096. 花括号展开 II
 * 提示
 * 困难
 * 87
 * 相关企业
 * 如果你熟悉 Shell 编程，那么一定了解过花括号展开，它可以用来生成任意字符串。
 * <p>
 * 花括号展开的表达式可以看作一个由 花括号、逗号 和 小写英文字母 组成的字符串，定义下面几条语法规则：
 * <p>
 * 如果只给出单一的元素 x，那么表达式表示的字符串就只有 "x"。R(x) = {x}
 * 例如，表达式 "a" 表示字符串 "a"。
 * 而表达式 "w" 就表示字符串 "w"。
 * 当两个或多个表达式并列，以逗号分隔，我们取这些表达式中元素的并集。R({e_1,e_2,...}) = R(e_1) ∪ R(e_2) ∪ ...
 * 例如，表达式 "{a,b,c}" 表示字符串 "a","b","c"。
 * 而表达式 "{{a,b},{b,c}}" 也可以表示字符串 "a","b","c"。
 * 要是两个或多个表达式相接，中间没有隔开时，我们从这些表达式中各取一个元素依次连接形成字符串。R(e_1 + e_2) = {a + b for (a, b) in R(e_1) × R(e_2)}
 * 例如，表达式 "{a,b}{c,d}" 表示字符串 "ac","ad","bc","bd"。
 * 表达式之间允许嵌套，单一元素与表达式的连接也是允许的。
 * 例如，表达式 "a{b,c,d}" 表示字符串 "ab","ac","ad"​​​​​​。
 * 例如，表达式 "a{b,c}{d,e}f{g,h}" 可以表示字符串 "abdfg", "abdfh", "abefg", "abefh", "acdfg", "acdfh", "acefg", "acefh"。
 * 给出表示基于给定语法规则的表达式 expression，返回它所表示的所有字符串组成的有序列表。
 * <p>
 * 假如你希望以「集合」的概念了解此题，也可以通过点击 “显示英文描述” 获取详情。
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "{a,b}{c,{d,e}}"
 * 输出：["ac","ad","ae","bc","bd","be"]
 * 示例 2：
 * <p>
 * 输入：expression = "{{a,z},a{b,c},{ab,z}}"
 * 输出：["a","ab","ac","z"]
 * 解释：输出中 不应 出现重复的组合结果。
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 60
 * expression[i] 由 '{'，'}'，',' 或小写英文字母组成
 * 给出的表达式 expression 用以表示一组基于题目描述中语法构造的字符串
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/brace-expansion-ii/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1096_BraceExpansionII {
	public static void main(String[] args) {
		L1096_BraceExpansionII l1096BraceExpansionII = new L1096_BraceExpansionII();
		System.out.println(l1096BraceExpansionII.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
	}

	public List<String> braceExpansionII(String expression) {
		Deque<Character> op = new ArrayDeque<>();
		Deque<Set<String>> stk = new ArrayDeque<>();
		for (int i = 0; i < expression.toCharArray().length; i++) {
			char item = expression.charAt(i);
			if (item == ',') {
				while (!op.isEmpty() && op.peek() == '*') {
					//开始结算
					operate(op, stk);
				}
				op.push('+');
			} else if (item == '{') {
				if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
					op.push('*');
				}
				op.push('{');
			} else if (item == '}') {
				while (!op.isEmpty() && op.peek() != '{') {
					//开始结算
					operate(op, stk);
				}
				op.pop();
			} else {
				if (i > 0 && (expression.charAt(i - 1) == '}' || Character.isLetter(expression.charAt(i - 1)))) {
					op.push('*');
				}
				stk.push(new TreeSet<String>() {{
					add(String.valueOf(item));
				}});
			}
		}
		while (!op.isEmpty()) {
			operate(op, stk);
		}
		return new ArrayList<>(stk.peek());
	}

	public void operate(Deque<Character> op, Deque<Set<String>> stk) {
		char operate = op.pop();
		if (operate == '+') {
			Set<String> p1 = stk.pop();
			Set<String> p2 = stk.pop();
			p1.addAll(p2);
			stk.push(p1);
		} else if (operate == '*') {
			Set<String> p1 = stk.pop();
			Set<String> p2 = stk.pop();
			Set<String> p3 = new TreeSet<>();
			for (String s : p1) {
				for (String s1 : p2) {
					p3.add(s1 + s);
				}
			}
			stk.push(p3);
		}
	}

}
