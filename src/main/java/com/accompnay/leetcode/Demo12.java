package com.accompnay.leetcode;


public class Demo12 {
	public static void main(String[] args) {
		Demo12 demo12 = new Demo12();
		demo12.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
	}

	public int majorityElement(int[] nums) {
		int num = nums[0];
		int voteNum = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == num) {
				voteNum++;
			} else {
				voteNum--;
			}
			if (voteNum < 0) {
				num = nums[i];
				voteNum = 0;
			}
		}
		int count = 0;
		for (int item : nums) {
			if (item == num) {
				count++;
			}
		}
		return count > nums.length / 2 ? num : -1;
	}
}
