package com.accompnay.TopicAlgorithms.practiceSet.dp.OneDimensional;

import java.util.Arrays;

/**
 * 45. 跳跃游戏 II
 * 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 * 从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Jump {
	public static void main(String[] args) {
		Jump jump = new Jump();
		int jump1 = jump.jump2(new int[]{2, 3, 0, 1, 4});
		System.out.println(jump1);
	}

	public int jump2(int[] nums) {
		int end = 0;
		int maxPosition = 0;
		int step = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			maxPosition = Math.max(maxPosition, i + nums[i]);
			if (i == end) {
				step++;
				end = maxPosition;
			}
		}
		return step;
	}

	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			int num = nums[i];
			for (int j = 1; j <= num && j + i < nums.length; j++) {
				dp[j + i] = Math.min(dp[j + i], dp[i] + 1);
			}
		}
		return dp[nums.length - 1];
	}
}
