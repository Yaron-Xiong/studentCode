package com.accompnay.TopicAlgorithms.swordFingerOffer.stackandqueue;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，
 * 请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 */
public class CQueue {
	private Stack<Object> stack1;
	private Stack<Object> stack2;

	public CQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}

	public void appendTail(int value) {
		stack1.push(value);
	}

	public int deleteHead() {
		shiftItem();
		if (stack2.isEmpty()) {
			return -1;
		}
		return (int) stack2.pop();
	}

	private void shiftItem() {
		if (!stack2.isEmpty()) {
			return;
		}
		//转移元素
		while (!stack1.isEmpty()) {
			Object item = stack1.pop();
			stack2.push(item);
		}
	}

	public static void main(String[] args) {
		CQueue cQueue = new CQueue();
		cQueue.appendTail(1);
		cQueue.appendTail(2);
		cQueue.appendTail(3);
		cQueue.appendTail(4);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		cQueue.appendTail(5);
		cQueue.appendTail(6);
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
		System.out.println(cQueue.deleteHead());
	}
}
