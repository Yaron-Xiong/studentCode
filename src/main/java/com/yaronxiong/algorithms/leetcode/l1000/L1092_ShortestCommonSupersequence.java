package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1092. 最短公共超序列
 * 提示
 * 困难
 * 142
 * 相关企业
 * 给出两个字符串 str1 和 str2，返回同时以 str1 和 str2 作为子序列的最短字符串。如果答案不止一个，则可以返回满足条件的任意一个答案。
 * <p>
 * （如果从字符串 T 中删除一些字符（也可能不删除，并且选出的这些字符可以位于 T 中的 任意位置），可以得到字符串 S，那么 S 就是 T 的子序列）
 * <p>
 * 示例：
 * <p>
 * 输入：str1 = "abac", str2 = "cab"
 * 输出："cabac"
 * 解释：
 * str1 = "abac" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 的第一个 "c"得到 "abac"。
 * str2 = "cab" 是 "cabac" 的一个子串，因为我们可以删去 "cabac" 末尾的 "ac" 得到 "cab"。
 * 最终我们给出的答案是满足上述属性的最短字符串。
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 都由小写英文字母组成。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-common-supersequence/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1092_ShortestCommonSupersequence {
	public static void main(String[] args) {
		L1092_ShortestCommonSupersequence l1092ShortestCommonSupersequence = new L1092_ShortestCommonSupersequence();
		System.out.println(l1092ShortestCommonSupersequence.shortestCommonSupersequence("abac", "cab"));
	}

	private int[][] memo;
	private String str1;
	private String str2;

	public String shortestCommonSupersequence(String str1, String str2) {
		this.str1 = str1;
		this.str2 = str2;
		memo = new int[str1.length()][str2.length()];
		return makeAns(str1.length() - 1, str2.length() - 1);
	}

	private String makeAns(int i, int j) {
		if (i < 0) {
			return str2.substring(0, j + 1);
		}
		if (j < 0) {
			return str1.substring(0, i + 1);
		}
		if (str1.charAt(i) == str2.charAt(j)) {
			return makeAns(i - 1, j - 1) + str1.charAt(i);
		}
		if (dfs(i, j) == dfs(i - 1, j) + 1) {
			return makeAns(i - 1, j) + str1.charAt(i);
		}
		return makeAns(i, j - 1) + str2.charAt(j);
	}

	private int dfs(int str1EndIndex, int str2EndIndex) {
		if (str2EndIndex == -1) {
			return str1EndIndex + 1;
		}
		if (str1EndIndex == -1) {
			return str2EndIndex + 1;
		}
		if (memo[str1EndIndex][str2EndIndex] != 0) {
			return memo[str1EndIndex][str2EndIndex];
		}
		int ans;
		if (str1.charAt(str1EndIndex) == str2.charAt(str2EndIndex)) {
			ans = dfs(str1EndIndex - 1, str2EndIndex - 1) + 1;
		} else {
			int ans1 = dfs(str1EndIndex - 1, str2EndIndex);
			int ans2 = dfs(str1EndIndex, str2EndIndex - 1);
			ans = Math.min(ans1, ans2) + 1;
		}
		memo[str1EndIndex][str2EndIndex] = ans;
		return memo[str1EndIndex][str2EndIndex];
	}
}
