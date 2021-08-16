package com.accompnay.swordFingerOffer;

import java.util.Stack;

/**
 * @author Accompany
 * Date:2020/1/14
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 剑指offer-09：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
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
