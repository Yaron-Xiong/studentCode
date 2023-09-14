package com.accompnay.TopicAlgorithms.leetcode.l1500;

import java.util.Arrays;

/**
 * 1641. 统计字典序元音字符串的数目
 * 提示
 * 中等
 * 96
 * 相关企业
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * <p>
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * 示例 3：
 * <p>
 * 输入：n = 33
 * 输出：66045
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-sorted-vowel-strings/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1641_CountVowelStrings {
	public static void main(String[] args) {
		L1641_CountVowelStrings l1641CountVowelStrings = new L1641_CountVowelStrings();
		System.out.println(l1641CountVowelStrings.countVowelStrings(33));
	}

	public int countVowelStrings(int n) {
		int[][] dp = new int[n + 1][5];
		Arrays.fill(dp[0], 1);
		for (int i = 1; i < dp.length; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[n][4];
	}

}

