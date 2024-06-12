package com.yaronxiong.algorithms.leetcode.weekly.w401;

import java.util.Arrays;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        System.out.println(l2.valueAfterKSeconds(36, 39));
    }

    public int valueAfterKSeconds(int n, int k) {
        long[] nums = new long[n];
        Arrays.fill(nums, 1);
        long Mod = 1000000007L;
        while (k > 0) {
            long preSum = 0;
            for (int i = 0; i < nums.length; i++) {
                nums[i] = (preSum + nums[i]) % Mod;
                preSum = nums[i];
            }
            k--;
        }
        return (int) (nums[n - 1] % Mod);
    }
}
