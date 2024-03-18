package com.yaronxiong.algorithms.Stormzhang.array.slidingWindows;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串:https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 给定一个字符串 s ，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * 示例1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLongestSubstring {
	public static void main(String[] args) {
		LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
		int pwwkew = lengthOfLongestSubstring.lengthOfLongestSubstring("pwww");
		System.out.println(pwwkew);
	}

	public int lengthOfLongestSubstring(String s) {
		if (s==null) return 0;
		int left = 0;
		int right = 0;
		int result = 0;
		Set<Character> set = new HashSet<>();
		while (right < s.length()) {
			char c = s.charAt(right++);
			while (set.contains(c)) {
				char c2 = s.charAt(left++);
				set.remove(c2);
			}
			result = Math.max(result, (right - left));
			set.add(c);
		}
		return result;
	}


}
