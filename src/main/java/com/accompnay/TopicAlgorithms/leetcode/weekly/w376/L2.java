package com.accompnay.TopicAlgorithms.leetcode.weekly.w376;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class L2 {
    public static void main(String[] args) {
        L2 l2 = new L2();
        System.out.println(Arrays.deepToString(l2.divideArray(new int[]{1, 3, 3, 2, 7, 3}, 3)));
    }

    public int[][] divideArray(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.add(num);
        }
        List<int[]> ans = new ArrayList<>();
        while (!queue.isEmpty() && queue.size() >= 3) {
            int[] temp = new int[3];
            int index = 0;
            temp[index++] = queue.poll();
            while (!queue.isEmpty() && index <= 2) {
                if (queue.peek() - temp[0] <= k) {
                    temp[index++] = queue.poll();
                    continue;
                }
                break;
            }
            if (index == 3) {
                ans.add(temp);
            }
        }
        if (ans.size() * 3 != nums.length) {
            return new int[][]{};
        }
        int[][] res = new int[ans.size()][3];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
