package com.accompnay.TopicAlgorithms.leetcode.weekly.w372;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class L4 {
    public static void main(String[] args) {
        L4 l4 = new L4();
        int[] ints = l4.leftmostBuildingQueries(new int[]{1, 2, 1, 2, 1, 2}, new int[][]{{0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {2, 0}, {2, 1}, {2, 2}, {2, 3}, {2, 4}, {2, 5}, {3, 0}, {3, 1}, {3, 2}, {3, 3}, {3, 4}, {3, 5}, {4, 0}, {4, 1}, {4, 2}, {4, 3}, {4, 4}, {4, 5}, {5, 0}, {5, 1}, {5, 2}, {5, 3}, {5, 4}, {5, 5}});
        System.out.println(Arrays.toString(ints));
    }
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        TreeSet<Integer>[] lists = new TreeSet[heights.length];
        Arrays.setAll(lists, a -> new TreeSet<>());
        for (int i = 0; i < heights.length; i++) {
            lists[i].add(i);
            for (int j = i; j < heights.length; j++) {
                if (heights[j] > heights[i]) {
                    lists[i].add(j);
                }
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int left = Math.min(query[0], query[1]);
            int right = Math.max(query[0], query[1]);
            //left能不能抵达right?
            if (lists[left].contains(right)) {
                ans[i] = right;
                continue;
            }
            //找到最近的right
            TreeSet<Integer> leftSet = lists[left];
            TreeSet<Integer> rightSet = lists[right];
            int temp = Integer.MAX_VALUE;
            for (Integer leftItem : leftSet) {
                if (rightSet.contains(leftItem)) {
                    temp = Math.min(temp, leftItem);
                }
            }
            ans[i] = temp == Integer.MAX_VALUE ? -1 : temp;
        }
        return ans;
    }
}
