package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Deque;
import java.util.LinkedList;

public class L1670_FrontMiddleBackQueue {
    public static void main(String[] args) {
        FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
        queue.pushFront(1);
        queue.pushBack(2);
        queue.pushMiddle(3);
        queue.pushMiddle(4);
        System.out.println(queue.popFront());
        System.out.println(queue.popMiddle());
        System.out.println(queue.popMiddle());
        System.out.println(queue.popBack());
        System.out.println(queue.popFront());
    }

    static class FrontMiddleBackQueue {
        private Deque<Integer> leftDeque;
        private Deque<Integer> rightDeque;

        public FrontMiddleBackQueue() {
            /**
             * 1.left.size >= right.size
             * 2.left.size - right.size <= 1
             */
            leftDeque = new LinkedList<>();
            rightDeque = new LinkedList<>();
        }

        public void pushFront(int val) {
            rightDeque.addFirst(val);
            balance();
        }

        private void balance() {
            if (leftDeque.size() - rightDeque.size() > 1) {
                while (leftDeque.size() - rightDeque.size() > 1) {
                    Integer first = leftDeque.pollFirst();
                    rightDeque.addLast(first);
                }
            } else if (leftDeque.size() < rightDeque.size()) {
                while (leftDeque.size() < rightDeque.size()) {
                    Integer last = rightDeque.pollLast();
                    leftDeque.addFirst(last);
                }
            }
        }

        public void pushMiddle(int val) {
            if (leftDeque.size() == rightDeque.size()) {
                leftDeque.addFirst(val);
            } else {
                rightDeque.addLast(val);
            }
        }

        public void pushBack(int val) {
            leftDeque.addLast(val);
            balance();
        }

        public int popFront() {
            if (rightDeque.isEmpty() && leftDeque.isEmpty()) {
                return -1;
            }
            Integer ans;
            if (!rightDeque.isEmpty()) {
                ans = rightDeque.pollFirst();
            } else {
                ans = leftDeque.pollFirst();
            }
            balance();
            return ans;
        }

        public int popMiddle() {
            if (leftDeque.isEmpty() && rightDeque.isEmpty()) {
                return -1;
            }
            int ans;
            if (rightDeque.size() < leftDeque.size()) {
                ans = leftDeque.pollFirst();
            } else {
                ans = rightDeque.pollLast();
            }
            return ans;
        }

        public int popBack() {
            if (leftDeque.isEmpty() && rightDeque.isEmpty()) {
                return -1;
            }
            int ans;
            if (!leftDeque.isEmpty()) {
                ans = leftDeque.pollLast();
            } else {
                ans = rightDeque.pollLast();
            }
            balance();
            return ans;
        }
    }
}
