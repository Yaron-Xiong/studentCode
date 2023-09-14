package com.accompnay.TopicAlgorithms.leetcode.l1500;

/**
 * 1653. 使字符串平衡的最少删除次数
 * 提示
 * 中等
 * 117
 * 相关企业
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。
 * <p>
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 * <p>
 * 请你返回使 s 平衡 的 最少 删除次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 * <p>
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 要么是 'a' 要么是 'b' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1653_MinimumDeletions {
	public static void main(String[] args) {
		L1653_MinimumDeletions l1653MinimumDeletions = new L1653_MinimumDeletions();
		System.out.println(l1653MinimumDeletions.minimumDeletions_dp("bbaaaaabb"));
	}

	public int minimumDeletions_dp(String s) {
		int n = s.length();
		//dp 记录了需要删除的值
		int dp = 0;
		int rightA = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (s.charAt(i) == 'a') {
				rightA++;
			} else {
				dp = Math.min(dp + 1, rightA);
			}
		}
		return dp;
	}


	public int minimumDeletions(String s) {
		int rightA = 0;
		for (char c : s.toCharArray()) {
			if (c == 'a') {
				rightA++;
			}
		}

		int minRes = rightA;
		int leftB = 0;
		for (char c : s.toCharArray()) {
			if (c == 'a') {
				rightA--;
			} else {
				leftB++;
			}
			minRes = Math.min(minRes, leftB + rightA);
		}
		return minRes;
	}

}
