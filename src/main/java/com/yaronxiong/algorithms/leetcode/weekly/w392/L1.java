package com.yaronxiong.algorithms.leetcode.weekly.w392;

import java.util.Arrays;

public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        int i = l1.longestMonotonicSubarray(new int[]{1,1,5});
        System.out.println(i);
    }

    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int[] preSum = new int[nums.length];
        int[] subSum = new int[nums.length];
        Arrays.fill(preSum,1);
        Arrays.fill(subSum,1);
        for (int i = 1; i < nums.length; i++) {
            int j = i - 1;
            if (nums[i] > nums[j]) {
                preSum[i] = Math.max(preSum[i], preSum[j] + 1);
            }
            if (nums[i] < nums[j]) {
                subSum[i] = Math.max(subSum[i], subSum[j] + 1);
            }
            max = Math.max(max, preSum[i]);
            max = Math.max(max, subSum[i]);
        }
        return max;
    }
}
