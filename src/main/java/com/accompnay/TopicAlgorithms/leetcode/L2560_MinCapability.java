package com.accompnay.TopicAlgorithms.leetcode;

import java.util.Arrays;

/**
 * 2560. 打家劫舍 IV
 * 提示
 * 中等
 * 42
 * 相关企业
 * 沿街有一排连续的房屋。每间房屋内都藏有一定的现金。现在有一位小偷计划从这些房屋中窃取现金。
 * <p>
 * 由于相邻的房屋装有相互连通的防盗系统，所以小偷 不会窃取相邻的房屋 。
 * <p>
 * 小偷的 窃取能力 定义为他在窃取过程中能从单间房屋中窃取的 最大金额 。
 * <p>
 * 给你一个整数数组 nums 表示每间房屋存放的现金金额。形式上，从左起第 i 间房屋中放有 nums[i] 美元。
 * <p>
 * 另给你一个整数 k ，表示窃贼将会窃取的 最少 房屋数。小偷总能窃取至少 k 间房屋。
 * <p>
 * 返回小偷的 最小 窃取能力。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,5,9], k = 2
 * 输出：5
 * 解释：
 * 小偷窃取至少 2 间房屋，共有 3 种方式：
 * - 窃取下标 0 和 2 处的房屋，窃取能力为 max(nums[0], nums[2]) = 5 。
 * - 窃取下标 0 和 3 处的房屋，窃取能力为 max(nums[0], nums[3]) = 9 。
 * - 窃取下标 1 和 3 处的房屋，窃取能力为 max(nums[1], nums[3]) = 9 。
 * 因此，返回 min(5, 9, 9) = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,7,9,3,1], k = 2
 * 输出：2
 * 解释：共有 7 种窃取方式。窃取能力最小的情况所对应的方式是窃取下标 0 和 4 处的房屋。返回 max(nums[0], nums[4]) = 2 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= (nums.length + 1)/2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/house-robber-iv/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2560_MinCapability {
	public static void main(String[] args) {
		L2560_MinCapability l2560MinCapability = new L2560_MinCapability();
		System.out.println(l2560MinCapability.minCapability(new int[]{2, 3, 5, 9}, 2));
	}

	public int minCapability(int[] nums, int k) {
		int left = 0;
		//假设我能偷的最大价值的房子是r
		int right = Arrays.stream(nums).max().getAsInt();
		while (left < right) {
			int mid = (left + right) >>> 1;
			//偷取最大 mid元 我能偷多少间房子
			long check = check(nums, mid);
			if (check >= k) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}

	private long check(int[] nums, int target) {
		int index = 0;
		int[] dp = new int[nums.length + 2];
		dp[0] = 0;
		dp[1] = 0;
		while (index < nums.length) {
			if (nums[index] > target) {
				//不可以偷
				dp[index + 2] = dp[index + 1];
			} else {
				//可以选择偷 也可以选择不偷
				dp[index + 2] = Math.max(dp[index] + 1, dp[index + 1]);
			}
			index++;
		}
		return dp[dp.length - 1];
	}
}
