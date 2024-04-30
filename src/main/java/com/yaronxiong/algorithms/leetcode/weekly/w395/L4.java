package com.yaronxiong.algorithms.leetcode.weekly.w395;

import java.util.*;

public class L4 {
    public static void main(String[] args) {
        L4 l4 = new L4();
        System.out.println(l4.medianOfUniquenessArray(new int[]{3, 4, 3, 4, 5}));
    }

    public int medianOfUniquenessArray(int[] nums) {
        Set<Integer>[] setIndex = new Set[nums.length];
        List<Integer>[] listIndex = new ArrayList[nums.length];
        Arrays.setAll(setIndex, a -> new HashSet<Integer>());
        Arrays.setAll(listIndex, a -> new ArrayList<>());
        Map<Integer, Integer> itemMap = new HashMap<>();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();
            List<Integer> tempList = new ArrayList<>();
            int j = 0;
            if (itemMap.containsKey(nums[i])) {
                j = itemMap.get(nums[i]);
                set.addAll(setIndex[j]);
                tempList.addAll(listIndex[j]);
                j++;
            }
            for (int z = i; z >= j; z--) {
                set.add(nums[z]);
                tempList.add(set.size());
            }
            setIndex[i] = set;
            listIndex[i] = tempList;
            itemMap.put(nums[i], i);
            list.addAll(tempList);
        }
        list.sort(Integer::compare);
        if (list.size() % 2 == 0) {
            int mid = list.size() / 2;
            return Math.min(list.get(mid - 1), list.get(mid));
        } else {
            return list.get(list.size() / 2);
        }
    }
}
