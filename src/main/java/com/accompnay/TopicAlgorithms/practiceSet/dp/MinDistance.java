package com.accompnay.TopicAlgorithms.practiceSet.dp;

/**
 * 583. 两个字符串的删除操作
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * <p>
 * 每步 可以删除任意一个字符串中的一个字符。
 * <p>
 * 示例 1：
 * <p>
 * 输入: word1 = "sea", word2 = "eat"
 * 输出: 2
 * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
 * 示例  2:
 * <p>
 * 输入：word1 = "leetcode", word2 = "etco"
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 500
 * word1 和 word2 只包含小写英文字母
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-operation-for-two-strings
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDistance {
	public static void main(String[] args) {
		MinDistance minDistance = new MinDistance();
		int i = minDistance.minDistance("sea", "eat");
		System.out.println(i);
	}
	public int minDistance(String word1, String word2) {
		int[][] dp = new int[word1.length() + 1][word2.length() + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[i].length; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
				}
			}
		}
		int longestCommonSubStringSize = dp[word1.length()][word2.length()];
		return word1.length() + word2.length() - longestCommonSubStringSize - longestCommonSubStringSize;
	}
}
