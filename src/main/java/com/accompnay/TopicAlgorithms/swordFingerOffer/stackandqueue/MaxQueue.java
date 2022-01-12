package com.accompnay.TopicAlgorithms.swordFingerOffer.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 59 - II. 队列的最大值：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
 * <p>
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:[null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出:[null,-1,-1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数<= 10000
 * 1 <= value <= 10^5
 */
public class MaxQueue {
	private Queue<Integer> queue;
	private Deque<Integer> dequeue;

	public MaxQueue() {
		queue = new LinkedList<>();
		dequeue = new LinkedList<>();
	}

	public int max_value() {
		return dequeue.isEmpty() ? -1 : dequeue.peekFirst();
	}

	public void push_back(int value) {
		queue.add(value);
		while (!dequeue.isEmpty() && value > dequeue.peekLast()) {
			dequeue.pollLast();
		}
		dequeue.addLast(value);
	}

	public int pop_front() {
		if (queue.isEmpty()){
			return -1;
		}
		Integer value = queue.poll();
		if (value.equals(dequeue.peekFirst())) {
			dequeue.pollFirst();
		}
		return value;
	}

	public static void main(String[] args) {
		MaxQueue maxQueue = new MaxQueue();
		int i = maxQueue.max_value();
		System.out.println(i);
		maxQueue.push_back(1);
		maxQueue.push_back(2);
		System.out.println(maxQueue.max_value());
		System.out.println(maxQueue.pop_front());
		System.out.println(maxQueue.max_value());
	}
}
