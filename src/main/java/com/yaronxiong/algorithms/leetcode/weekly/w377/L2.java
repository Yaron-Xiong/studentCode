package com.yaronxiong.algorithms.leetcode.weekly.w377;

import java.util.*;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        System.out.println(l2.maximizeSquareArea(4, 3, new int[]{2, 3}, new int[]{2}));
    }

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Arrays.sort(hFences);
        Arrays.sort(vFences);
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        for (int hFence : hFences) {
            list1.add(hFence);
        }
        list1.add(m);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        for (int v : vFences) {
            list2.add(v);
        }
        list2.add(n);
        Set<Integer> ans1 = new HashSet<>();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list1.size(); j++) {
                ans1.add(list1.get(j) - list1.get(i));
            }
        }
        long ans = -1;
        for (int i = 0; i < list2.size(); i++) {
            for (int j = i + 1; j < list2.size(); j++) {
                int value = list2.get(j) - list2.get(i);
                if (ans1.contains(value)) {
                    ans = Math.max(ans, (long) value * value);
                }
            }
        }
        return (int) (ans % 1000000007);
    }
}
