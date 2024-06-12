package com.yaronxiong.algorithms.leetcode.weekly.w401;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        System.out.println(l3.maxTotalReward(new int[]{1, 14, 13, 19}));
    }

    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        //肯定是从小的开始选？
        Set<Integer> set = new HashSet<>();
        int maxValue = 0;
        for (int i = 0; i < rewardValues.length; i++) {
            Set<Integer> tempSet = new HashSet<>();
            for (Integer item : set) {
                if (rewardValues[i] > item) {
                    int e = rewardValues[i] + item;
                    maxValue = Math.max(maxValue, e);
                    tempSet.add(e);
                }
            }
            set.add(rewardValues[i]);
            set.addAll(tempSet);
            maxValue = Math.max(maxValue, rewardValues[i]);
        }
        return maxValue;
    }
}
