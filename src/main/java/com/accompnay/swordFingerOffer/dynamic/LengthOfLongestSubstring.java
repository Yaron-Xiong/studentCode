package com.accompnay.swordFingerOffer.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 * 示例1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * <p>
 */
public class LengthOfLongestSubstring {

	public int lengthOfLongestSubstring(String s) {
		int maxLength = 0;
		int temp = 0;
		Map<Character, Integer> characters = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			temp = characters.containsKey(s.charAt(i)) ? i - characters.get(s.charAt(i)) : temp + 1;
			maxLength = Math.max(temp, maxLength);
			if (characters.containsKey(s.charAt(i))) characters.clear();
			characters.put(s.charAt(i), i);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
		int abcabcbb = lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
		System.out.println(abcabcbb);
	}
}
