package com.yaronxiong.algorithms.leetcode.weekly.w441;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        System.out.println(l1.maxSum(new int[]{-100}));
        System.out.println(l1.maxSum(new int[]{-20, 20}));
        System.out.println(l1.maxSum(new int[]{2, -10, 6}));
        System.out.println(l1.maxSum(new int[]{1, 2, 3, 4, 5}));
        System.out.println(l1.maxSum(new int[]{1, 1, 0, 1, 1}));
        System.out.println(l1.maxSum(new int[]{1, 2, -1, -2, 1, 0, -1}));
    }

    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int ans = 0;
        int v2 = Integer.MIN_VALUE;
        for (int right = 0; right < nums.length; right++) {
            if (set.contains(nums[right])) {
                continue;
            }
            if (nums[right] < 0) {
                v2 = Math.max(v2, nums[right]);
                continue;
            }
            set.add(nums[right]);
            ans += nums[right];
        }
        return set.isEmpty() ? v2 : ans;
    }
}
