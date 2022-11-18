package com.accompnay.TopicAlgorithms.practiceSet.list.duplicate_str;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1081. 不同字符的最小子序列
 * 返回 s 字典序最小的子序列，该子序列包含 s 的所有不同字符，且只包含一次。
 * <p>
 * 注意：该题与 316 https://leetcode.com/problems/remove-duplicate-letters/ 相同
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
 * 1 <= s.length <= 1000
 * s 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/smallest-subsequence-of-distinct-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SmallestSubsequence {
	public static void main(String[] args) {
		SmallestSubsequence smallestSubsequence = new SmallestSubsequence();
		String s = smallestSubsequence.smallestSubsequence("cbacdcbc");
		System.out.println(s);
	}

	public String smallestSubsequence(String s) {
		int[] counter = new int[123];
		for (char c : s.toCharArray()) {
			counter[c]++;
		}
		boolean[] hasUsed = new boolean[123];
		Deque<Character> deque = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			counter[c]--;
			if (hasUsed[c]) {
				continue;
			}
			while (!deque.isEmpty() && c < deque.peek() && counter[deque.peek()] > 0) {
				hasUsed[deque.pop()] = false;
			}
			deque.push(c);
			hasUsed[c] = true;
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (Character character : deque) {
			stringBuilder.append(character);
		}
		return stringBuilder.reverse().toString();
	}
}
