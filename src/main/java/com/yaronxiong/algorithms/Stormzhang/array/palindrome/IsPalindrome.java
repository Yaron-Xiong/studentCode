package com.yaronxiong.algorithms.Stormzhang.array.palindrome;

/**
 * 剑指 Offer II 018. 有效的回文:https://leetcode-cn.com/problems/XltzEq/
 * <p>
 * 给定一个字符串 s ，验证 s是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 本题中，将空字符串定义为有效的回文串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出: true
 * 解释："amanaplanacanalpanama" 是回文串
 * 示例 2:
 * <p>
 * 输入: s = "race a car"
 * 输出: false
 * 解释："raceacar" 不是回文串
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/XltzEq
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsPalindrome {
	public static void main(String[] args) {
		IsPalindrome isPalindrome = new IsPalindrome();
		boolean race_a_car = isPalindrome.isPalindrome("A man, a plan, a canal: Panama");
		System.out.println(race_a_car);
	}

	public boolean isPalindrome(String s) {
		int left = 0;
		int right = s.length() - 1;
		while (left <= right) {
			while ((left <= right
					&& (s.charAt(left) < 'a' || s.charAt(left) > 'z')
					&& (s.charAt(left) < 'A' || s.charAt(left) > 'Z')
					&& (s.charAt(left) < '0' || s.charAt(left) > '9')

			))
				left++;
			while ((left <= right
					&& (s.charAt(right) < 'a' || s.charAt(right) > 'z')
					&& (s.charAt(right) < 'A' || s.charAt(right) > 'Z')
					&& (s.charAt(right) < '0' || s.charAt(right) > '9')
			))
				right--;
			if (left > right) {
				return true;
			}

			if (s.charAt(left) != s.charAt(right)) {
				if ((s.charAt(left) < 'a' || s.charAt(left) > 'z') && (s.charAt(left) < 'A' || s.charAt(left) > 'Z')) {
					return false;
				}
				if ((s.charAt(right) < 'a' || s.charAt(right) > 'z') && (s.charAt(right) < 'A' || s.charAt(right) > 'Z')) {
					return false;
				}
				if (Math.abs(s.charAt(left) - s.charAt(right)) != 32) {
					return false;
				}
			}
			left++;
			right--;
		}
		return true;
	}
}
