package com.yaronxiong.algorithms.leetcode.weekly.w375;

import java.util.Arrays;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        System.out.println(l3.countSubarrays(new int[]{1, 3, 2, 3, 3}, 2));
    }

    public long countSubarrays(int[] nums, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 0;
        int ans = 0;
        int cntM = 0;
        for (int num : nums) {
            if (num == max) {
                cntM++;
            }
            while (cntM == k) {
                if (nums[left++] == max) {
                    cntM--;
                }
            }
            ans += left;
        }
        return ans;
    }
}
