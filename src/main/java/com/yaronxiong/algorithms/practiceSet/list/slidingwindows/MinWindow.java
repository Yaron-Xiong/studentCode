package com.yaronxiong.algorithms.practiceSet.list.slidingwindows;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
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
 * 链接：https://leetcode.cn/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinWindow {
	public static void main(String[] args) {
		MinWindow minWindow = new MinWindow();
		String s = minWindow.minWindow("cabwefgewcwaefgcf", "cae");
		System.out.println(s);
	}

	public String minWindow(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		int left = 0;
		int right = 0;
		//当前校验字符串个数
		int valid = map.size();
		int len = Integer.MAX_VALUE;
		int startIndex = 0;
		while (right < s.length()) {
			char rightChar = s.charAt(right);
			right++;

			if (map.containsKey(rightChar)) {
				map.put(rightChar, map.get(rightChar) - 1);
				if (map.get(rightChar) == 0) {
					valid--;
				}
			}

			//移动左指针
			while (valid == 0 && left <= right) {
				//此时窗口是满足条件的
				char leftChar = s.charAt(left);
				if (right - left < len) {
					len = right - left;
					startIndex = left;
				}
				if (!map.containsKey(leftChar)) {
					//直接移动
					left++;
					continue;
				}
				//此时窗口大小即为满足t的其中一个子串
				map.put(leftChar, map.get(leftChar) + 1);
				if (map.get(leftChar) > 0) {
					valid++;
				}
				left++;
			}
		}
		return len == Integer.MAX_VALUE ? "" : s.substring(startIndex, startIndex + len);
	}
}
