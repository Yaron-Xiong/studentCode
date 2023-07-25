package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class L1_TwoSum {
    public static void main(String[] args) {
        L1_TwoSum l1TwoSum = new L1_TwoSum();
        System.out.println(Arrays.toString(l1TwoSum.twoSum(new int[]{3, 2, 4}, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{i, map.get(temp)};
            }
        }

        return new int[2];
    }
}
