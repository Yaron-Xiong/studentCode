package com.accompnay.swordFingerOffer.dynamic;

/**
 * 剑指 Offer 42. 连续子数组的最大和:https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * <p>
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 */
public class MaxSubArray {
	public static void main(String[] args) {
		MaxSubArray maxSubArray = new MaxSubArray();
		int i = maxSubArray.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});
		System.out.println(i);
	}

	public int maxSubArray(int[] nums) {
		int preMax = 0;
		int result = nums[0];
		for (int num : nums) {
			preMax = Math.max(preMax + num, num);
			result = Math.max(result, preMax);
		}
		return result;
	}

}
