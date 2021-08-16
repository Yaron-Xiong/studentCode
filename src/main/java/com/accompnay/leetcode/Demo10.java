package com.accompnay.leetcode;

public class Demo10 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        Demo10 demo10 = new Demo10();
        int massage = demo10.massage(arr);
        System.out.println(massage);
    }

    public int massage(int[] nums) {
        if (nums.length==0){
            return 0;
        }
        int dp0 = 0;
        int dp1 = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tdp0 = Math.max(dp0, dp1);
            int tdp1 = dp0 + nums[i];
            dp0 = tdp0;
            dp1 = tdp1;
        }
        return Math.max(dp0, dp1);
    }


}
