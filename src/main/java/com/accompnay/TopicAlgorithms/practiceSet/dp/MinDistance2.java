package com.accompnay.TopicAlgorithms.practiceSet.dp;

/**
 * 72. 编辑距离
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * 示例 2：
 * <p>
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 提示：
 * <p>
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/edit-distance
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDistance2 {
	public static void main(String[] args) {
		MinDistance2 minDistance2 = new MinDistance2();
		int i = minDistance2.minDistance2("", "a");
		System.out.println(i);
	}

	public int minDistance2(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 0; i <= word1.length(); i++) {
			dp[i][0] = i;
		}
		for (int i = 0; i <= word2.length(); i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
				}
			}
		}
		return dp[word1.length()][word2.length()];
	}

	public int minDistance(String word1, String word2) {
		return dp(word1, word1.length() - 1, word2, word2.length() - 1);
	}

	private int dp(String word1, int i, String word2, int j) {
		if (i == -1) {
			return j + 1;
		}
		if (j == -1) {
			return i + 1;
		}
		if (word1.charAt(i) == word2.charAt(j)) {
			return dp(word1, i - 1, word2, j - 1);
		} else {
			//当t1插入时 t2可跳过一位
			//当t1修改时,t1和t2可跳过一位
			//当t1删除时,t1可跳过一位
			int dp1 = dp(word1, i - 1, word2, j) + 1;
			int dp2 = dp(word1, i, word2, j - 1) + 1;
			int dp3 = dp(word1, i - 1, word2, j - 1) + 1;
			return Math.min(Math.min(dp1, dp2), dp3);
		}
	}
}
