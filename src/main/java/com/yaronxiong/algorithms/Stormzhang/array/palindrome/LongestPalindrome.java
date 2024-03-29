package com.yaronxiong.algorithms.Stormzhang.array.palindrome;

/**
 * 5. 最长回文子串：https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * <p>
 * 输入：s = "cbbd"
 * 输出："bb"
 * 示例 3：
 * <p>
 * 输入：s = "a"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ac"
 * 输出："a"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {
	public static void main(String[] args) {
		LongestPalindrome longestPalindrome = new LongestPalindrome();
		String ac = longestPalindrome.longestPalindrome("babad");
		System.out.println(ac);
	}

	public String longestPalindrome(String s) {
		String temp = "";
		for (int i = 0; i < s.length(); i++) {
			String s1 = findPalindrome(s, i, i);
			String s2 = findPalindrome(s, i, i + 1);
			temp = temp.length() >= s1.length() ? temp : s1;
			temp = temp.length() >= s2.length() ? temp : s2;
		}
		return temp;
	}

	public String findPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) != s.charAt(right)) {
				break;
			}
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}
}
