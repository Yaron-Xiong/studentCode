package com.accompnay.TopicAlgorithms.leetcode.weekly.w349;

import java.util.HashSet;
import java.util.Set;

public class L6470_findNonMinOrMax {
    public static void main(String[] args) {
        L6470_findNonMinOrMax l6470FindNonMinOrMax = new L6470_findNonMinOrMax();
        System.out.println(l6470FindNonMinOrMax.findNonMinOrMax(new int[]{3,2,1,4}));
    }
    public int findNonMinOrMax(int[] nums) {
        if (nums.length == 2) {
            return -1;
        }
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Math.max(num, max);
            min = Math.min(num, min);
            set.add(num);
        }
        set.remove(max);
        set.remove(min);
        for (Integer item : set) {
            return item;
        }
        return -1;
    }
}
