package com.yaronxiong.algorithms.practiceSet.dp;

/**
 * 712. 两个字符串的最小ASCII删除和
 * 给定两个字符串s1 和 s2，返回 使两个字符串相等所需删除字符的 ASCII 值的最小和 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例 2:
 * <p>
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * <p>
 * 提示:
 * <p>
 * 0 <= s1.length, s2.length <= 1000
 * s1 和 s2 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-ascii-delete-sum-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumDeleteSum {
	public static void main(String[] args) {
		MinimumDeleteSum minimumDeleteSum = new MinimumDeleteSum();
		int i = minimumDeleteSum.minimumDeleteSum("sea", "eat");
		System.out.println(i);
	}

	public int minimumDeleteSum(String s1, String s2) {
		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		int lcs = dp[s1.length()][s2.length()];
		int s1ASCIIValue = 0;
		for (char c : s1.toCharArray()) {
			s1ASCIIValue += c;
		}
		int s2ASCIIValue = 0;
		for (char c : s2.toCharArray()) {
			s2ASCIIValue += c;
		}
		return s1ASCIIValue - lcs + s2ASCIIValue - lcs;
	}
}
