package com.accompnay.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Demo14 {
	public static void main(String[] args) {
		Demo14 demo14 = new Demo14();
		int[] ints = {1,2,3,4};
		boolean b = demo14.containsDuplicate(ints);
		System.out.println(b);
	}

	public boolean containsDuplicate(int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (int num : nums) {
			set.add(num);
		}
		return nums.length != set.size();
	}
}
