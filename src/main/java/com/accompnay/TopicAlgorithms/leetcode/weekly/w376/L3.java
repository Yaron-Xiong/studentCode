package com.accompnay.TopicAlgorithms.leetcode.weekly.w376;

import java.util.*;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        System.out.println(l3.minimumCost(new int[]{302, 315, 317, 320}));
    }

    TreeSet<Integer> list = new TreeSet<>();

    public void init() {
        for (int i = 0; i <= 1000000000; i++) {
            if (check(i)) {
                list.add(i);
            }
        }
    }

    public long minimumCost(int[] nums) {
        init();
        Arrays.sort(nums);
        Set<Integer> newList = new HashSet<>();
        for (int num : nums) {
            newList.add(list.higher(num));
            newList.add(list.lower(num));
        }
        long ans = Integer.MAX_VALUE;
        for (Integer temp : newList) {
            long tempAns = 0;
            for (int num : nums) {
                tempAns += Math.abs(num - temp);
            }
            ans = Math.min(ans, tempAns);
        }
        return ans;
    }

    public boolean check(int num) {
        String str = String.valueOf(num);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
                continue;
            }
            return false;
        }
        return true;
    }


}
