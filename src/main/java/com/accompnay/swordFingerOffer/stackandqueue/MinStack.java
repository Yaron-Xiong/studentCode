package com.accompnay.swordFingerOffer.stackandqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 30. 包含min函数的栈：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * <p>
 * <p>
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * <p>
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 */
public class MinStack {
	private List<Integer> list = new ArrayList<>();
	private List<Integer> list2 = new ArrayList<>();

	public MinStack() {

	}

	public void push(int x) {
		list.add(x);
		if (list2.isEmpty()) {
			list2.add(x);
			return;
		}
		Integer lastMin = list2.get(list2.size() - 1);
		list2.add(Math.min(lastMin, x));
	}

	public void pop() {
		list.remove(list.size() - 1);
		list2.remove(list2.size() - 1);
	}

	public int top() {
		return list.get(list.size() - 1);
	}

	public int min() {
		return list2.get(list2.size() - 1);
	}
}
