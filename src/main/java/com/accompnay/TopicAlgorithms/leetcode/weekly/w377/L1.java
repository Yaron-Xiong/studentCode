package com.accompnay.TopicAlgorithms.leetcode.weekly.w377;

import java.util.Arrays;
import java.util.PriorityQueue;

public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        System.out.println(Arrays.toString(l1.numberGame(new int[]{5, 4, 2, 3})));
    }
    public int[] numberGame(int[] nums) {
        int[] ans = new int[nums.length];
        Arrays.sort(nums);
        int index = 0;
        int ansIndex = 0;
        while (index < nums.length) {
            int n1 = nums[index++];
            int n2 = nums[index++];
            ans[ansIndex++] = n2;
            ans[ansIndex++] = n1;
        }
        return ans;
    }
}
