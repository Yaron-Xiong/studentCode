package com.accompnay.TopicAlgorithms.swordFingerOffer.sort;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 41. 数据流中的中位数
 * <p>
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4]的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例 1：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","addNum","findMedian","addNum","findMedian"]
 * [[],[1],[2],[],[3],[]]
 * 输出：[null,null,null,1.50000,null,2.00000]
 * 示例 2：
 * <p>
 * 输入：
 * ["MedianFinder","addNum","findMedian","addNum","findMedian"]
 * [[],[2],[],[3],[]]
 * 输出：[null,null,2.00000,null,2.50000]
 * <p>
 * 限制：
 * <p>
 * 最多会对addNum、findMedian 进行50000次调用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S41_MedianFinder {
    public static void main(String[] args) {
        S41_MedianFinder.MedianFinder s41MedianFinder = new S41_MedianFinder.MedianFinder();
        s41MedianFinder.addNum(1);
        s41MedianFinder.addNum(2);
        System.out.println(s41MedianFinder.findMedian());
        s41MedianFinder.addNum(3);
        System.out.println(s41MedianFinder.findMedian());
    }

    static class MedianFinder {
        PriorityQueue<Integer> minQueue;
        PriorityQueue<Integer> maxQueue;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            //最小放大的不放呢 最大放小的部分
            //如果两边大小不一致
            minQueue = new PriorityQueue<>((a, b) -> b - a);
            maxQueue = new PriorityQueue<>((a, b) -> a - b);
        }

        public void addNum(int num) {
            //保持两个queue的大小一致
            if (maxQueue.isEmpty() || num > maxQueue.peek()) {
                maxQueue.add(num);
            } else {
                minQueue.add(num);
            }
            //如果两边size不一致 开始保持
            if (Math.abs(minQueue.size() - maxQueue.size()) > 1) {
                if (minQueue.size() > maxQueue.size()) {
                    Integer poll = minQueue.poll();
                    maxQueue.add(poll);
                } else {
                    Integer poll = maxQueue.poll();
                    minQueue.add(poll);
                }
            }
        }

        public double findMedian() {
            if (minQueue.isEmpty() && maxQueue.isEmpty()) {
                return -1;
            }
            if (minQueue.size() == maxQueue.size()) {
                return (double) (minQueue.peek() + maxQueue.peek()) / 2;
            }
            if (minQueue.size() > maxQueue.size()) {
                return minQueue.peek();
            }else {
                return maxQueue.peek();
            }
        }
    }

}