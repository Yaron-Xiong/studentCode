package com.accompnay.TopicAlgorithms.practiceSet.dp;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * 进阶：
 * <p>
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS {
	public static void main(String[] args) {
		LengthOfLIS lengthOfLIS = new LengthOfLIS();
		int i = lengthOfLIS.lengthOfLIS2(new int[]{0, 1, 0, 3, 2, 3});
		System.out.println(i);
	}

	public int lengthOfLIS2(int[] nums) {
		int[] dp = new int[nums.length];
		int dpSize = 0;
		for (int poker : nums) {
			int left = 0;
			int right = dpSize;
			while (left < right) {
				int mid = (left + right) >> 1;
				if (poker < dp[mid]) {
					right = mid;
				} else if (poker > dp[mid]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			if (left == dpSize) dpSize++;
			dp[left] = poker;
		}
		return dpSize;
	}

	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int maxDp = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					maxDp = Math.max(dp[j], maxDp);
				}
			}
			dp[i] = maxDp == Integer.MIN_VALUE ? 1 : maxDp + 1;
		}
		int maxDp = Integer.MIN_VALUE;
		for (int i : dp) {
			maxDp = Math.max(maxDp, i);
		}
		return maxDp;
	}
}
