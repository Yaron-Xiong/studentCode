package com.yaronxiong.algorithms.leetcode.weekly.w371;

public class L3_minOperations {
    public static void main(String[] args) {
        L3_minOperations l3MinOperations = new L3_minOperations();
        //[17,13,19,9,6,14]
        //[17,14,15,1,19,19]
        System.out.println(l3MinOperations.minOperations(new int[]{17, 13, 19, 9, 6, 14}, new int[]{17, 14, 15, 1, 19, 19}));
    }

    public int minOperations(int[] nums1, int[] nums2) {
        //假设不需要交换最后一位
        int v1 = getChange(nums1.clone(), nums2.clone(), 0);
        //假设需要交换最后一位
        swap(nums1, nums2, nums1.length - 1);
        int v2 = getChange(nums1, nums2, 1);
        if (v1 == -1 && v2 == -1) {
            return -1;
        }
        if (v1 == -1 || v2 == -1) {
            return Math.max(v1, v2);
        }
        return Math.min(v1, v2);
    }

    public void swap(int[] nums1, int[] nums2, int index) {
        int temp = nums1[index];
        nums1[index] = nums2[index];
        nums2[index] = temp;
    }

    public int getChange(int[] nums1, int[] nums2, int initSwapTimes) {
        //假设在不需要交换的情况 他们达到平衡需要的次数
        int swapTimes = initSwapTimes;
        int lastValue1 = nums1[nums1.length - 1];
        int lastValue2 = nums2[nums2.length - 1];
        for (int i = 0; i < nums1.length - 1; i++) {
            if (nums1[i] <= lastValue1 && nums2[i] <= lastValue2) {
                continue;
            }
            swap(nums1, nums2, i);
            if (nums1[i] > lastValue1 || nums2[i] > lastValue2) {
                return -1;
            }
            swapTimes++;
        }
        return swapTimes;
    }
}
