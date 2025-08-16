package com.yaronxiong.algorithms.leetcode.weekly.w441;

import java.util.*;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
       // System.out.println(l2.solveQueries(new int[]{1, 3, 1, 4, 1, 3, 2}, new int[]{0, 3, 5}));
        //System.out.println(l2.solveQueries(new int[]{1, 2, 3, 4}, new int[]{0, 1, 2, 3}));
        System.out.println(l2.solveQueries(new int[]{6, 12, 17, 9, 16, 7, 6}, new int[]{5, 6, 0, 4}));
    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {
        Map<Integer, TreeSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], a -> new TreeSet<>()).add(i);
        }
        List<Integer> ans = new ArrayList<>();
        for (int query : queries) {
            int queryNum = nums[query];
            TreeSet<Integer> indexs = map.get(queryNum);
            if (indexs == null || indexs.isEmpty() || indexs.size() == 1) {
                ans.add(-1);
                continue;
            }
            //从indexs找到最近的
            int v = Integer.MAX_VALUE;
            //左边跟右边
            Integer higher = indexs.higher(query);
            if (higher != null) {
                v = Math.min(v, higher - query);
            } else {
                //右边没有即为最左边
                Integer first = indexs.first();
                v = Math.min(v, nums.length - query + first);
                v = Math.min(v, query - first);
            }
            Integer lower = indexs.lower(query);
            //左边没有即为最右边
            if (lower != null) {
                v = Math.min(v, query - lower);
            } else {
                Integer last = indexs.last();
                v = Math.min(v, last - query);
                v = Math.min(v, nums.length - last + query);
            }
            ans.add(v);
        }
        return ans;
    }
}
