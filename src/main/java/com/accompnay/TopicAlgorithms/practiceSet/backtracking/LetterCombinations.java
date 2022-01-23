package com.accompnay.TopicAlgorithms.practiceSet.backtracking;

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
		List<String> strings = letterCombinations.letterCombinations("23");
		System.out.println(strings);
	}

	String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		if (digits==null || digits.length()==0) return new ArrayList<>();
		backtracking(digits, numString, 0);
		return ans;
	}

	List<String> ans = new ArrayList<>();
	StringBuilder stringBuilder = new StringBuilder();

	public void backtracking(String digits, String[] numsString, int num) {
		if (digits.length() == num) {
			ans.add(stringBuilder.toString());
			return;
		}
		String groupString = numsString[digits.charAt(num) - '0'];
		for (int i = 0; i < groupString.length(); i++) {
			stringBuilder.append(groupString.charAt(i));
			backtracking(digits, numsString, num + 1);
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
	}
}
