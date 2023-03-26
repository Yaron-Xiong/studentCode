package com.accompnay.TopicAlgorithms.leetcode;

import javax.sound.midi.Track;
import java.util.*;

public class L6357_MinOperations {
	public static void main(String[] args) {
		L6357_MinOperations l6357MinOperations = new L6357_MinOperations();
		System.out.println(l6357MinOperations.minOperations(new int[]{3, 1, 6, 8}, new int[]{1, 5}));
	}

	public List<Long> minOperations(int[] nums, int[] queries) {
		Arrays.sort(nums);
		long[] preSum = new long[nums.length];
		preSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			preSum[i] = preSum[i - 1] + nums[i];
		}
		List<Long> res = new ArrayList<>();
		for (int i = 0; i < queries.length; i++) {
			int left = 0;
			int right = nums.length;
			int mid = 0;
			while (left < right) {
				mid = (left + right) >> 1;
				if (nums[mid] > queries[i]) {
					right = mid;
				} else if (nums[mid] < queries[i]) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			long abs = 0;
			if (right > 0) {
				abs += Math.abs(preSum[right - 1] - ((long) queries[i] * (right)));
			}
			if (right < nums.length) {
				abs += Math.abs((preSum[nums.length  - 1] - preSum[right] + nums[right]) - ((long) queries[i] * (nums.length - right)));
			}
			res.add(abs);
		}
		return res;
	}
}
