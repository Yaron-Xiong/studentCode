package com.yaronxiong.algorithms.practiceSet.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 示例 1：
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * 提示：
 * 1 <= n <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
	public static void main(String[] args) {
		GenerateParenthesis generateParenthesis = new GenerateParenthesis();
		List<String> strings = generateParenthesis.generateParenthesis(3);
		System.out.println(strings);
	}

	private int leftN;
	private int rightR;

	public List<String> generateParenthesis(int n) {
		leftN = n;
		rightR = n;
		List<String> res = new ArrayList<>();
		backtracking(res, new StringBuilder());
		return res;
	}

	private void backtracking(List<String> res, StringBuilder path) {
		if (leftN > rightR) {
			return;
		}
		if (leftN == rightR && leftN == 0) {
			res.add(path.toString());
			return;
		}
		if (leftN > 0) {
			leftN--;
			path.append('(');
			backtracking(res, path);
			leftN++;
			path.deleteCharAt(path.length() - 1);
		}
		if (rightR > 0){
			rightR--;
			path.append(')');
			backtracking(res, path);
			rightR++;
			path.deleteCharAt(path.length() - 1);
		}

	}
}
