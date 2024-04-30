package com.yaronxiong.algorithms.leetcode.weekly.w395;

import java.util.Arrays;

public class L1 {
    public static void main(String[] args) {

    }

    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }

}
