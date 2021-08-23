package com.accompnay.swordFingerOffer.search;

/**
 * 剑指 Offer 03. 数组中重复的数字：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * <p>
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 * <p>
 */
public class FindRepeatNumber {
	public int findRepeatNumber(int[] nums) {
		int i = 0;
		while (i < nums.length) {
			int numI = nums[i];
			if (numI != i && numI == nums[numI]) {
				return numI;
			}
			if (numI != i) {
				swap(nums, numI, i);
			} else {
				i++;
			}
		}
		return -1;
	}

	private void swap(int[] nums, int index1, int index2) {
		int temp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = temp;
	}

	public static void main(String[] args) {
		int[] arr = new int[]{2, 3, 1, 0, 2, 5, 3};
		FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
		int repeatNumber = findRepeatNumber.findRepeatNumber(arr);
		System.out.println(repeatNumber);
	}
}
