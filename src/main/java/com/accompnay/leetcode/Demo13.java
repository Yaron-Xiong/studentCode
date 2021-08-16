package com.accompnay.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Demo13 {
	public static void main(String[] args) {
		Demo13 demo13 = new Demo13();
		int[] arr = new int[]{0};
		int i = demo13.missingNumber(arr);
		System.out.println(i);
	}

	public int missingNumber(int[] nums) {
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			result ^= nums[i];
			result ^= i;
		}
		result ^= nums.length;
		return result;
	}
}
