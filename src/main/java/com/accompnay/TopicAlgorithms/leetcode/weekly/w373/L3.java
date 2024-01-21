package com.accompnay.TopicAlgorithms.leetcode.weekly.w373;

import java.util.*;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        System.out.println(Arrays.toString(l3.lexicographicallySmallestArray(new int[]{5,100,44,45,16,30,14,65,83,64}, 15)));
    }

    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] temp = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            temp[i][0] = nums[i];
            temp[i][1] = i;
        }
        Arrays.sort(temp, (a, b) -> {
            return a[0] == b[0] ? a[1] - b[1] : a[0] - b[0];
        });
        int[] res = new int[nums.length];
        int index = 0;
        while (index < nums.length) {
            List<Integer> value = new ArrayList<>();
            List<Integer> indexList = new ArrayList<>();
            int max = temp[index][0];
            while (index < nums.length && temp[index][0] <= max) {
                max = temp[index][0] + limit;
                value.add(temp[index][0]);
                indexList.add(temp[index][1]);
                index++;
            }
            Collections.sort(value);
            Collections.sort(indexList);
            for (int i = 0; i < indexList.size(); i++) {
                res[indexList.get(i)] = value.get(i);
            }
        }
        return res;
    }

    public void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
