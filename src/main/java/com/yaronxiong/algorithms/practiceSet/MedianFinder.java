package com.yaronxiong.algorithms.practiceSet;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 295. 数据流的中位数
 * 困难
 * 774
 * 相关企业
 * 中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。
 * <p>
 * 例如，
 * <p>
 * [2,3,4] 的中位数是 3
 * <p>
 * [2,3] 的中位数是 (2 + 3) / 2 = 2.5
 * <p>
 * 设计一个支持以下两种操作的数据结构：
 * <p>
 * void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 * double findMedian() - 返回目前所有元素的中位数。
 * 示例：
 * <p>
 * addNum(1)
 * addNum(2)
 * findMedian() -> 1.5
 * addNum(3)
 * findMedian() -> 2
 * 进阶:
 * <p>
 * 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？
 * 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/insert-delete-getrandom-o1/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianFinder {
	private PriorityQueue<Integer> maxQueue;
	private PriorityQueue<Integer> minQueue;

	public MedianFinder() {
		maxQueue = new PriorityQueue<>((a, b) -> b - a);
		minQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
	}

	//minQueue 所有元素比maxQueue大
	//minQueue.size() - maxQueue.size() <=1
	public void addNum(int num) {
		//随便丢一个堆
		if (!maxQueue.isEmpty() && num > maxQueue.peek()) {
			minQueue.add(num);
		} else {
			maxQueue.add(num);
		}
		//平衡两个堆
		if (Math.abs(maxQueue.size() - minQueue.size()) > 1) {
			if (maxQueue.size() > minQueue.size()) {
				minQueue.add(maxQueue.poll());
			} else {
				maxQueue.add(minQueue.poll());
			}
		}
	}

	public double findMedian() {
		if (maxQueue.isEmpty() && minQueue.isEmpty()) {
			return -1;
		}
		//说明是偶数
		if (maxQueue.size() == minQueue.size()) {
			return (double) (maxQueue.peek() + minQueue.peek()) / 2;
		} else {
			//s说明是奇数
			return maxQueue.size() > minQueue.size() ? maxQueue.peek() : minQueue.peek();
		}
	}

	public static void main(String[] args) {
		MedianFinder medianFinder = new MedianFinder();
		medianFinder.addNum(1);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(2);
		System.out.println(medianFinder.findMedian());
		medianFinder.addNum(3);
		System.out.println(medianFinder.findMedian());
	}
}
