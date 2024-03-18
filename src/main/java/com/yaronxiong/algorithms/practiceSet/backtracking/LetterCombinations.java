package com.yaronxiong.algorithms.practiceSet.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LetterCombinations {

	public static void main(String[] args) {
		LetterCombinations letterCombinations = new LetterCombinations();
		List<String> strings = letterCombinations.letterCombinations("");
		System.out.println(strings);
	}

	String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		if (digits.length() == 0) {
			return new ArrayList<>();
		}
		ArrayList<String> res = new ArrayList<>();
		backtracking(digits, 0, new StringBuilder(), res);
		return res;
	}

	public void backtracking(String digits, int index, StringBuilder path, List<String> res) {
		if (index >= digits.length()) {
			res.add(path.toString());
			return;
		}
		int a = digits.charAt(index) - '0';
		String s = numString[a];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			path.append(c);
			backtracking(digits, index + 1, path, res);
			path.deleteCharAt(path.length() - 1);
		}
	}

}
