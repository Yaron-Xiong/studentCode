package com.accompnay.TopicAlgorithms.leetcode.weekly.w375;

public class L1 {
    public static void main(String[] args) {
        L1 l1 = new L1();
        System.out.println(l1.countTestedDevices(new int[]{1,1,2,1,3}));
    }

    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int i = 0; i < batteryPercentages.length; i++) {
            batteryPercentages[i] -= ans;
            if (batteryPercentages[i] > 0) {
                ans++;
            }
        }
        return ans;
    }
}
