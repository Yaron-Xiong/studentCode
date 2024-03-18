package com.yaronxiong.algorithms.leetcode.weekly.w371;

import java.util.Arrays;

public class L1_maximumStrongPairXor {
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 2 * nums[i];
            for (int j = i + 1; j < nums.length && nums[j] <= temp; j++) {
                maxValue = Math.max(maxValue, nums[i] ^ nums[j]);
            }
        }
        return maxValue == Integer.MIN_VALUE ? 0 : maxValue;
    }
}
