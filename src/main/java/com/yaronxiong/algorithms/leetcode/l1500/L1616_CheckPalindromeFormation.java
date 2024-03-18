package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1616. 分割两个字符串得到回文串
 * 提示
 * 中等
 * 149
 * 相关企业
 * 给你两个字符串 a 和 b ，它们长度相同。请你选择一个下标，将两个字符串都在 相同的下标 分割开。
 * 由 a 可以得到两个字符串： aprefix 和 asuffix ，满足 a = aprefix + asuffix ，
 * 同理，由 b 可以得到两个字符串 bprefix 和 bsuffix ，满足 b = bprefix + bsuffix 。
 * 请你判断 aprefix + bsuffix 或者 bprefix + asuffix 能否构成回文串。
 * <p>
 * 当你将一个字符串 s 分割成 sprefix 和 ssuffix 时， ssuffix 或者 sprefix 可以为空。
 * 比方说， s = "abc" 那么 "" + "abc" ， "a" + "bc" ， "ab" + "c" 和 "abc" + "" 都是合法分割。
 * <p>
 * 如果 能构成回文字符串 ，那么请返回 true，否则返回 false 。
 * <p>
 * 注意， x + y 表示连接字符串 x 和 y 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = "x", b = "y"
 * 输出：true
 * 解释：如果 a 或者 b 是回文串，那么答案一定为 true ，因为你可以如下分割：
 * aprefix = "", asuffix = "x"
 * bprefix = "", bsuffix = "y"
 * 那么 aprefix + bsuffix = "" + "y" = "y" 是回文串。
 * 示例 2：
 * <p>
 * 输入：a = "abdef", b = "fecab"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：a = "ulacfd", b = "jizalu"
 * 输出：true
 * 解释：在下标为 3 处分割：
 * aprefix = "ula", asuffix = "cfd"
 * bprefix = "jiz", bsuffix = "alu"
 * 那么 aprefix + bsuffix = "ula" + "alu" = "ulaalu" 是回文串。
 * <p>
 * 提示：
 * <p>
 * 1 <= a.length, b.length <= 105
 * a.length == b.length
 * a 和 b 都只包含小写英文字母
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-subarrays-with-median-k/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1616_CheckPalindromeFormation {
	public static void main(String[] args) {
		L1616_CheckPalindromeFormation l1616CheckPalindromeFormation = new L1616_CheckPalindromeFormation();
		System.out.println(l1616CheckPalindromeFormation.checkPalindromeFormation("abdef", "fecab"));
	}

	public boolean checkPalindromeFormation(String a, String b) {
		return checkPalindrome(a, b) || checkPalindrome(b, a);
	}

	private boolean checkPalindrome(String a, String b) {
		int left = 0;
		int right = a.length() - 1;
		while (left <= right && a.charAt(left) == b.charAt(right)) {
			left++;
			right--;
		}
		if (left >= right) {
			return true;
		}
		return checkSelfPalindrome(a, left, right) || checkSelfPalindrome(b, left, right);
	}

	private boolean checkSelfPalindrome(String a, int left, int right) {
		while (left < right && a.charAt(left) == a.charAt(right)) {
			left++;
			right--;
		}
		return left >= right;
	}
}
