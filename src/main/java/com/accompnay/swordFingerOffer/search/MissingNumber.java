package com.accompnay.swordFingerOffer.search;

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
