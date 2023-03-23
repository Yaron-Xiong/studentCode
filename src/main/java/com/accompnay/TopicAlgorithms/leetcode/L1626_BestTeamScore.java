package com.accompnay.TopicAlgorithms.leetcode;

import java.util.*;

/**
 * 1626. 无矛盾的最佳球队
 * 提示
 * 中等
 * 88
 * 相关企业
 * 假设你是球队的经理。对于即将到来的锦标赛，你想组合一支总体得分最高的球队。球队的得分是球队中所有球员的分数 总和 。
 * <p>
 * 然而，球队中的矛盾会限制球员的发挥，所以必须选出一支 没有矛盾 的球队。
 * 如果一名年龄较小球员的分数 严格大于 一名年龄较大的球员，则存在矛盾。
 * 同龄球员之间不会发生矛盾。
 * <p>
 * 给你两个列表 scores 和 ages，其中每组 scores[i] 和 ages[i] 表示第 i 名球员的分数和年龄。请你返回 所有可能的无矛盾球队中得分最高那支的分数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：scores = [1,3,5,10,15], ages = [1,2,3,4,5]
 * 输出：34
 * 解释：你可以选中所有球员。
 * 示例 2：
 * <p>
 * 输入：scores = [4,5,6,5], ages = [2,1,2,1]
 * 输出：16
 * 解释：最佳的选择是后 3 名球员。注意，你可以选中多个同龄球员。
 * 示例 3：
 * <p>
 * 输入：scores = [1,2,3,5], ages = [8,9,10,1]
 * 输出：6
 * 解释：最佳的选择是前 3 名球员。
 * <p>
 * 提示：
 * <p>
 * 1 <= scores.length, ages.length <= 1000
 * scores.length == ages.length
 * 1 <= scores[i] <= 106
 * 1 <= ages[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/best-team-with-no-conflicts/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1626_BestTeamScore {
	public static void main(String[] args) {
		L1626_BestTeamScore l1626BestTeamScore = new L1626_BestTeamScore();
		System.out.println(l1626BestTeamScore.bestTeamScore(new int[]{9, 2, 8, 8, 2}, new int[]{4, 1, 3, 3, 5}));
	}

	public int bestTeamScore(int[] scores, int[] ages) {
		Integer[] ids = new Integer[scores.length];
		for (int i = 0; i < scores.length; i++) {
			ids[i] = i;
		}
		Arrays.sort(ids, Comparator.comparingInt((Integer a) -> ages[a]).thenComparingInt(a -> scores[a]));
		int[] scoreDp = new int[scores.length];
		int res;
		scoreDp[0] = scores[ids[0]];
		res = scoreDp[0];
		for (int i = 1; i < scoreDp.length; i++) {
			scoreDp[i] = scores[ids[i]];
			for (int j = 0; j < i; j++) {
				if (scores[ids[i]] >= scores[ids[j]]) {
					scoreDp[i] = Math.max(scoreDp[i], scoreDp[j] + scores[ids[i]]);
					res = Math.max(scoreDp[i], res);
				}
			}
		}
		return res;
	}


}
