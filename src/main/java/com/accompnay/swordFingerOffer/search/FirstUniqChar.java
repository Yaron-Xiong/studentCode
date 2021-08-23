package com.accompnay.swordFingerOffer.search;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 * <p>
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 */
public class FirstUniqChar {
	/**
	 * map记录次数
	 * 时间复杂度 2N
	 * 空间复杂度 26 (小写单词一共就26个）
	 */
	public char firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char charAt = s.charAt(i);
			map.compute(charAt, (k, v) -> {
				if (v == null) {
					v = 0;
				}
				return ++v;
			});
		}
		for (char c : s.toCharArray()) {
			if (map.get(c) == 1) {
				return c;
			}
		}
		return ' ';
	}

	/**
	 * 在第一种的基础上做的优化
	 * map记录索引
	 * 当重复了索引值记录为 -1
	 * 时间复杂度：N + M（单词去重后的数量）
	 * 空间复杂度：26
	 *
	 */
	public char firstUniqChar2(String s) {
		if (s.length() == 0) {
			return ' ';
		}
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char charAt = s.charAt(i);
			if (map.containsKey(charAt)) {
				map.put(charAt, -1);
			} else {
				map.put(charAt, i);
			}
		}
		int resultIndex = s.length();
		for (Character character : map.keySet()) {
			Integer value = map.get(character);
			if (value != null && value != -1 && value < resultIndex) {
				resultIndex = value;
			}
		}
		return s.charAt(resultIndex);
	}

	/**
	 *
	 * 在方法2的基础上做优化，将时间复杂度从2N->N 空间复杂度从 26->52
	 *
	 * 使用map和queue
	 * map负责记录索引，queue保证单词的顺序
	 *
	 * 时间复杂度：N（由于While循环检测队头 数量级很小 不纳入计算）
	 * 空间复杂度：两个26个小写字母组成 52个
	 */
	public char firstUniqChar3(String s) {
		Map<Character, Integer> map = new HashMap<>();
		Queue<Character> queue = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i), -1);
				while (!queue.isEmpty() && map.get(queue.peek()) == -1) {
					queue.poll();
				}
			} else {
				queue.offer(s.charAt(i));
				map.put(s.charAt(i), i);
			}
		}
		return queue.isEmpty() ? ' ' : queue.poll();
	}

	public static void main(String[] args) {
		FirstUniqChar firstUniqChar = new FirstUniqChar();
		char abaccdeff = firstUniqChar.firstUniqChar2("abcdba");
		System.out.println(abaccdeff);
	}
}
