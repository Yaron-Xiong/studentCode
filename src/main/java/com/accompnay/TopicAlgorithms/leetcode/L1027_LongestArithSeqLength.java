package com.accompnay.TopicAlgorithms.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1027. 最长等差数列
 * 中等
 * 302
 * 相关企业
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 * <p>
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 * <p>
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 * <p>
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-arithmetic-subsequence/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1027_LongestArithSeqLength {
	public static void main(String[] args) {
		L1027_LongestArithSeqLength l1027LongestArithSeqLength = new L1027_LongestArithSeqLength();
		int x = l1027LongestArithSeqLength.longestArithSeqLength(new int[]{22, 8, 57, 41, 36, 46, 42, 28, 42, 14, 9, 43, 27, 51, 0, 0, 38, 50, 31, 60, 29, 31, 20, 23, 37, 53, 27, 1, 47, 42, 28, 31, 10, 35, 39, 12, 15, 6, 35, 31, 45, 21, 30, 19, 5, 5, 4, 18, 38, 51, 10, 7, 20, 38, 28, 53, 15, 55, 60, 56, 43, 48, 34, 53, 54, 55, 14, 9, 56, 52});
		System.out.println(x);
	}

	public int longestArithSeqLength(int[] nums) {
		//因为每个num 的最大值是500 那么方差范围 [-500,500]
		int[][] dp = new int[nums.length][1001];
		int maxV = 0;
		for (int i = 1; i < nums.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				int differ = nums[i] - nums[j] + 500;
				if (dp[i][differ] == 0) {
					dp[i][differ] = dp[j][differ] == 0 ? 2 : dp[j][differ] + 1;
					maxV = Math.max(maxV, dp[i][differ]);
				}
			}
		}
		return maxV;
	}
}
