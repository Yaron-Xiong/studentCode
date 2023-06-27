package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.*;

/**
 * 1172. 餐盘栈
 * 提示
 * 困难
 * 66
 * 相关企业
 * 我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。
 * <p>
 * 实现一个叫「餐盘」的类 DinnerPlates：
 * <p>
 * DinnerPlates(int capacity) - 给出栈的最大容量 capacity。
 * void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。
 * int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。
 * int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -1。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["DinnerPlates","push","push","push","push","push","popAtStack","push","push","popAtStack","popAtStack","pop","pop","pop","pop","pop"]
 * [[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
 * 输出：
 * [null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
 * <p>
 * 解释：
 * DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
 * D.push(1);
 * D.push(2);
 * D.push(3);
 * D.push(4);
 * D.push(5);         // 栈的现状为：    2  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 2。栈的现状为：      4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(20);        // 栈的现状为：  20  4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.push(21);        // 栈的现状为：  20  4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.popAtStack(2);   // 返回 21。栈的现状为：       4
 * 1  3  5
 * ﹈ ﹈ ﹈
 * D.pop()            // 返回 5。栈的现状为：        4
 * 1  3
 * ﹈ ﹈
 * D.pop()            // 返回 4。栈的现状为：    1  3
 * ﹈ ﹈
 * D.pop()            // 返回 3。栈的现状为：    1
 * ﹈
 * D.pop()            // 返回 1。现在没有栈。
 * D.pop()            // 返回 -1。仍然没有栈。
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 20000
 * 1 <= val <= 20000
 * 0 <= index <= 100000
 * 最多会对 push，pop，和 popAtStack 进行 200000 次调用。
 * <p>
  */
public class L1172_DinnerPlates {

	public static void main(String[] args) {
		DinnerPlates l1172DinnerPlates = new DinnerPlates(2);
		l1172DinnerPlates.push(1);
		l1172DinnerPlates.push(2);
		l1172DinnerPlates.push(3);
		l1172DinnerPlates.push(4);
		l1172DinnerPlates.push(5);

		System.out.println(l1172DinnerPlates.popAtStack(0));
		l1172DinnerPlates.push(20);
		l1172DinnerPlates.push(21);
		System.out.println(l1172DinnerPlates.popAtStack(0));
		System.out.println(l1172DinnerPlates.popAtStack(2));
		System.out.println(l1172DinnerPlates.pop());
		System.out.println(l1172DinnerPlates.pop());
		System.out.println(l1172DinnerPlates.pop());
		System.out.println(l1172DinnerPlates.pop());
		System.out.println(l1172DinnerPlates.pop());
	}

	public static class DinnerPlates {
		int capacity;
		PriorityQueue<Integer> idx;
		List<Deque<Integer>> stacks;

		public DinnerPlates(int capacity) {
			this.capacity = capacity;
			this.idx = new PriorityQueue<>();
			this.stacks = new ArrayList<>();
		}

		public void push(int val) {
			//从所有未满的队列中找到最小的
			if (idx.isEmpty()) {
				//说明当前都满了
				Deque<Integer> deque = new LinkedList<>();
				deque.push(val);
				this.stacks.add(deque);
				if (this.capacity > 1) {
					//说明未满
					this.idx.add(this.stacks.size() - 1);
				}
			} else {
				Integer index = this.idx.peek();
				Deque<Integer> deque = this.stacks.get(index);
				deque.push(val);
				if (deque.size() >= capacity) {
					this.idx.poll();
				}
			}
		}

		public int pop() {
			return popAtStack(this.stacks.size() - 1);
		}

		public int popAtStack(int index) {
			if (index < 0 || index >= this.stacks.size()) {
				return -1;
			}
			Deque<Integer> deque = this.stacks.get(index);
			if (deque.isEmpty()) {
				return -1;
			}

			if (deque.size() == this.capacity && this.capacity != 1) {
				//放进idx
				this.idx.add(index);
			}
			Integer val = deque.pop();
			if (deque.isEmpty()) {
				//从队列中移除
				this.stacks.remove(index);

			}
			return val;
		}
	}

}
