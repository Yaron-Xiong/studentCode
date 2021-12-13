package com.accompnay.Stormzhang.array.slidingWindows;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串:https://leetcode-cn.com/problems/minimum-window-substring
 * <p>
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {
	public static void main(String[] args) {
		MinWindow minWindow = new MinWindow();
		String s = minWindow.minWindow("ADOBECODEBANC", "ABC");
		System.out.println(s);
	}

	public String minWindow(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> map2 = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int left = 0;
		int right = 0;
		int valid = 0;
		int subStart = 0;
		int subLen = Integer.MAX_VALUE;
		while (right < s.length()) {
			char c = s.charAt(right);
			right++;
			if (map.containsKey(c)) {
				map2.put(c, map2.getOrDefault(c, 0) + 1);
				if (map2.get(c) == map.get(c)) {
					valid++;
				}
			}
			//考虑缩减 并且已经生成了一个字符串
			while (valid == map.size()) {
				if (right - left < subLen) {
					subStart = left;
					subLen = right - left;
				}
				char d = s.charAt(left);
				left++;
				if (map.containsKey(d)) {
					if (map.get(d) == map2.get(d)) {
						valid--;
					}
					map2.put(d, map2.get(d) - 1);
				}
			}

		}
		return subLen == Integer.MAX_VALUE ? "" : s.substring(subStart, subStart + subLen);
	}
}
