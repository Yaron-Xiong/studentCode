package com.yaronxiong.algorithms.leetcode.weekly.w392;

import java.util.Arrays;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        long l = l3.minOperationsToMakeMedianK(new int[]{2,68,15,39,30,39,97,68}, 2);
        System.out.println(l);
    }

    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        if (nums.length % 2 == 0) {
            mid = nums[mid] >= nums[mid - 1] ? mid : mid - 1;
        }
        long ans = Math.abs(nums[mid] - k);
        nums[mid] = k;
        for (int i = mid - 1; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                ans += nums[i] - nums[i + 1];
                nums[i] = nums[i + 1];
            }
        }
        for (int i = mid + 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                ans += nums[i - 1] - nums[i];
                nums[i] = nums[i - 1];
            }
        }
        return ans;
    }
}
