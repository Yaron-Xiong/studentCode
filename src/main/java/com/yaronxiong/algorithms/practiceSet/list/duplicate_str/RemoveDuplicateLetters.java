package com.yaronxiong.algorithms.practiceSet.list.duplicate_str;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 316. 去除重复字母
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。
 * 需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "bcabc"
 * 输出："abc"
 * 示例 2：
 * <p>
 * 输入：s = "cbacdcbc"
 * 输出："acdb"
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-duplicate-letters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveDuplicateLetters {
	public static void main(String[] args) {
		RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
		String bcabc = removeDuplicateLetters.removeDuplicateLetters("cbacdcbc");
		System.out.println(bcabc);
	}

	public String removeDuplicateLetters(String s) {
		int[] counter = new int[123];
		for (char c : s.toCharArray()) {
			counter[c]++;
		}
		Deque<Character> deque = new ArrayDeque<>();
		boolean[] hasUsed = new boolean[123];
		for (char c : s.toCharArray()) {
			counter[c]--;
			if (hasUsed[c]) {
				continue;
			}
			while (!deque.isEmpty() && c < deque.peek() && counter[deque.peek()] > 0) {
				Character pop = deque.pop();
				hasUsed[pop] = false;
			}
			hasUsed[c] = true;
			deque.push(c);
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (Character character : deque) {
			stringBuilder.append(character);
		}
		return stringBuilder.reverse().toString();
	}
}
