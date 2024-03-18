package com.yaronxiong.algorithms.practiceSet.list.slidingwindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * <p>
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "cbaebabacd", p = "abc"
 * 输出: [0,6]
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
 * 示例 2:
 * <p>
 * 输入: s = "abab", p = "ab"
 * 输出: [0,1,2]
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length, p.length <= 3 * 104
 * s 和 p 仅包含小写字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindAnagrams {
	public static void main(String[] args) {
		FindAnagrams findAnagrams = new FindAnagrams();
		List<Integer> anagrams = findAnagrams.findAnagrams("abab","ab");
		System.out.println(anagrams);
	}
	public List<Integer> findAnagrams(String s, String p) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : p.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int left = 0;
		int right = 0;
		int valid = map.size();
		List<Integer> res = new ArrayList<>();
		while (right < s.length()) {
			char rightChar = s.charAt(right);
			right++;
			if (map.containsKey(rightChar)) {
				map.put(rightChar, map.get(rightChar) - 1);
				if (map.get(rightChar) == 0) {
					valid--;
				}
			}

			if (valid == 0) {
				res.add(left);
			}

			while (right - left >= p.length()) {
				char leftChar = s.charAt(left);
				if (map.containsKey(leftChar)) {
					if (map.get(leftChar) == 0) {
						valid++;
					}
					map.put(leftChar, map.get(leftChar) + 1);
				}
				left++;
			}
		}
		return res;
	}
}
