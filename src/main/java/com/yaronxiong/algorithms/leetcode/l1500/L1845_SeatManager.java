package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.PriorityQueue;

public class L1845_SeatManager {
    static class SeatManager {
        PriorityQueue<Integer> queue;
        int minValue = 1;

        public SeatManager(int n) {
            queue = new PriorityQueue<>(n);
        }

        public int reserve() {
            if (!queue.isEmpty()) {
                return queue.poll();
            }
            return minValue++;
        }

        public void unreserve(int seatNumber) {
            queue.add(seatNumber);
        }
    }
}
