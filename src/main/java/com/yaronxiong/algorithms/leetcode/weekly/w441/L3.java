package com.yaronxiong.algorithms.leetcode.weekly.w441;

import java.util.HashMap;
import java.util.Map;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        //System.out.println(l3.minZeroArray(new int[]{2, 0, 2}, new int[][]{{0, 2, 1}, {0, 2, 1}, {1, 1, 3}}));
        //System.out.println(l3.minZeroArray(new int[]{4, 3, 2, 1}, new int[][]{{1, 3, 2}, {0, 2, 1}}));
        //System.out.println(l3.minZeroArray(new int[]{1, 2, 3, 2, 1}, new int[][]{{0, 1, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 4, 1}}));
        //System.out.println(l3.minZeroArray(new int[]{1, 2, 3, 2, 6}, new int[][]{{0, 1, 1}, {0, 2, 1}, {1, 4, 2}, {4, 4, 4}, {3, 4, 1}, {4, 4, 5}}));
        //System.out.println(l3.minZeroArray(new int[]{2}, new int[][]{{0, 0, 6}, {0, 0, 2}, {0, 0, 9}, {0, 0, 5}, {0, 0, 10}}));
        //System.out.println(l3.minZeroArray(new int[]{10}, new int[][]{{0, 0, 4}, {0, 0, 8}, {0, 0, 1}, {0, 0, 10}, {0, 0, 10}}));
        System.out.println(l3.minZeroArray(new int[]{5, 23, 49, 38, 17}, new int[][]{{1, 4, 8}, {2, 3, 3}, {3, 4, 10}, {2, 2, 6}, {0, 1, 1}, {1, 4, 3}, {4, 4, 2}, {3, 4, 5}, {1, 3, 1}, {2, 3, 3}, {1, 1, 3}, {2, 3, 3}, {3, 3, 3}, {2, 3, 6}, {2, 2, 7}, {0, 1, 3}, {0, 3, 1}, {1, 1, 9}, {0, 1, 5}, {2, 3, 7}, {2, 4, 3}, {0, 2, 4}, {2, 2, 1}, {1, 4, 10}, {0, 0, 8}, {3, 4, 6}, {0, 0, 1}, {4, 4, 1}, {0, 0, 2}, {1, 3, 9}, {4, 4, 5}, {3, 3, 1}, {4, 4, 3}, {3, 4, 9}, {0, 0, 6}, {4, 4, 5}, {1, 1, 4}, {0, 1, 4}, {0, 2, 8}, {1, 2, 2}, {1, 1, 2}, {3, 4, 1}, {1, 3, 1}, {4, 4, 9}, {4, 4, 3}, {1, 3, 1}, {3, 3, 4}, {0, 4, 6}, {1, 2, 6}, {3, 4, 8}, {1, 2, 9}, {0, 4, 9}, {2, 3, 8}, {2, 4, 4}, {1, 2, 3}, {2, 4, 6}, {1, 1, 6}, {1, 3, 2}, {0, 2, 7}, {2, 3, 5}, {4, 4, 4}, {0, 1, 6}, {2, 4, 7}, {2, 3, 9}, {3, 4, 5}, {4, 4, 4}}));
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int maxK = 0;
        //每一位最快到k的时候变成0?
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            //求querys 中的val之和等于nums[i]
            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            int dfs = dfs(i, nums[i], 0, 0, queries, map);
            if (dfs == Integer.MAX_VALUE) {
                return -1;
            }
            maxK = Math.max(maxK, dfs);
        }
        return maxK;
    }

    public int dfs(int index, int num, int cur, int qIndex, int[][] queries, Map<Integer, Map<Integer, Integer>> map) {
        if (num == cur) {
            return qIndex;
        }
        if (cur > num || qIndex >= queries.length) {
            return Integer.MAX_VALUE;
        }
        if (map.containsKey(qIndex) && map.get(qIndex).containsKey(cur)) {
            return map.get(qIndex).get(cur);
        }
        //遍历query
        int left = queries[qIndex][0];
        int right = queries[qIndex][1];
        int val = queries[qIndex][2];
        int ans = Integer.MAX_VALUE;
        if (index < left || index > right) {
            ans = Math.min(ans, dfs(index, num, cur, qIndex + 1, queries, map));
        }else {
            int v1 = dfs(index, num, cur + val, qIndex + 1, queries, map);
            int v2 = dfs(index, num, cur, qIndex + 1, queries, map);
            ans =  Math.min(v1, v2);
        }
        map.computeIfAbsent(qIndex, k -> new HashMap<>()).put(cur, ans);
        return ans;
    }
}
