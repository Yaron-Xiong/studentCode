package com.accompnay.leetcode;

public class Demo9 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5};
        //int[] arr = new int[]{1};
        Demo9 demo9 = new Demo9();
        int i = demo9.maxSubArray(arr);
        System.out.println(i);
    }

    public int maxSubArray(int[] nums) {
        int dp = nums[0];
        int max = dp;
        for (int i = 1; i < nums.length; i++) {
            if (dp < 0) {
                dp = nums[i];
            } else {
                dp = dp + nums[i];
            }
            max = Math.max(dp, max);
        }
        return max;
    }


}
