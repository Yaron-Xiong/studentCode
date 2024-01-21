package com.accompnay.TopicAlgorithms.leetcode.weekly.w381;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class L3 {
    public static void main(String[] args) {
        L3 l3 = new L3();
        System.out.println(l3.minimumPushes("aabbccddeeffgghhiiiiii"));
    }

    public int minimumPushes(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            map.merge(word.charAt(i), 1, Integer::sum);
        }
        int ans = 0;
        int[] arr = new int[8];
        int cur = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        queue.addAll(map.values());
        //一共有8个键盘，大的安排在第一个格子
        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            ans += (++arr[cur]) * node;
            cur = (cur + 1) % 8;
        }
        return ans;
    }


}
