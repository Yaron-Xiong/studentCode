package com.yaronxiong.algorithms.leetcode.weekly.w395;

import java.util.Arrays;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        System.out.println(l2.minimumAddedInteger(new int[]{3, 5, 5, 3}, new int[]{7, 7}));
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + 1; j < nums1.length; j++) {
                //检查nums[1] 跟nums[2]是否一致，跳过 i,j
                int nums1Index = 0;
                int diff = Integer.MIN_VALUE;
                boolean ans = true;
                for (int z = 0; z < nums2.length; z++) {
                    while (nums1Index == i || nums1Index == j) {
                        nums1Index++;
                    }
                    int tempDiff = nums2[z] - nums1[nums1Index++];
                    if (diff == Integer.MIN_VALUE) {
                        diff = tempDiff;
                    } else if (diff != tempDiff) {
                        ans = false;
                        break;
                    }
                }
                if (ans) {
                    return diff;
                }
            }
        }
        return -1;
    }
}
