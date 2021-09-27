package com.accompnay.swordFingerOffer.sort;

import com.google.common.collect.Lists;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 剑指 Offer 41. 数据流中的中位数:https://leetcode-cn.com/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
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
 */
public class MedianFinder {
	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		System.out.println(medianFinder.findMedian());
		for (Integer integer : Lists.newArrayList(-1, -2, -3,-4)) {
			medianFinder.addNum(integer);
		}
		System.out.println(medianFinder.findMedian());
	}

	private Queue<Integer> maxQueue;
	private Queue<Integer> minQueue;

	/**
	 * initialize your data structure here.
	 */
	public MedianFinder() {
		maxQueue = new PriorityQueue<>((a, b) -> b - a);
		minQueue = new PriorityQueue<>();
	}

	/**
	 * 1.先往list丢数字
	 * 2.判断list的长度是否大于list2的长度
	 *
	 * @param num
	 */
	public void addNum(int num) {
		if (maxQueue.size() != minQueue.size()) {
			maxQueue.add(num);
			minQueue.add(maxQueue.poll());
		} else {
			minQueue.add(num);
			maxQueue.add(minQueue.poll());
		}
	}

	public double findMedian() {
		if (maxQueue.isEmpty()) {
			return 0;
		}
		return minQueue.size() != maxQueue.size() ? (double) maxQueue.peek() : (double) (minQueue.peek() + maxQueue.peek()) / 2;
	}

}
