package com.yaronxiong.algorithms.practiceSet.dp.OneDimensional;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSubArray {
	public static void main(String[] args) {
		MaxSubArray maxSubArray = new MaxSubArray();
		int i = maxSubArray.maxSubArray(new int[]{5,4,-1,7,8});
		System.out.println(i);
	}

	int maxDp = Integer.MIN_VALUE;

	public int maxSubArray(int[] nums) {
		dp(nums, nums.length - 1);
		return maxDp;
	}

	private int dp(int[] nums, int i) {
		if (i < 0) {
			return 0;
		}
		int res = Math.max(nums[i], dp(nums, i - 1) + nums[i]);
		maxDp = Math.max(maxDp, res);
		return res;
	}

	public int maxSubArray2(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(nums[i] + dp[i - 1], nums[i]);
		}
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			res = Math.max(dp[i], res);
		}
		return res;
	}
}
