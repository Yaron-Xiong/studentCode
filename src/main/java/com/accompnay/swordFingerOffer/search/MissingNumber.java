package com.accompnay.swordFingerOffer.search;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字:https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof/
 * <p>
 * <p>
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (nums[mid] == mid) {
				left = mid + 1;
			} else if (nums[mid] > mid) {
				right = mid - 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		MissingNumber missingNumber = new MissingNumber();
		int number = missingNumber.missingNumber(new int[]{0});
		System.out.println(number);
	}
}
