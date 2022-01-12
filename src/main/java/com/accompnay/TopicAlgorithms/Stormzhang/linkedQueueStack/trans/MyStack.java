package com.accompnay.TopicAlgorithms.Stormzhang.linkedQueueStack.trans;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * <p>
 * 注意：
 * <p>
 * 你只能使用队列的基本操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * <p>
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-stack-using-queues
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MyStack {
	Queue<Integer> queue1;
	int topItem;

	public MyStack() {
		queue1 = new LinkedList<>();
	}

	public void push(int x) {
		queue1.offer(x);
		topItem = x;
	}

	public int pop() {
		int size = queue1.size();
		while (size > 2) {
			queue1.offer(queue1.poll());
			size--;
		}
		topItem = queue1.peek();
		queue1.offer(queue1.poll());
		return queue1.poll();
	}

	public int top() {
		return topItem;
	}

	public boolean empty() {
		return queue1.isEmpty();
	}

	public static void main(String[] args) {
		MyStack myQueue = new MyStack();
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);
		System.out.println(myQueue.pop());
		System.out.println(myQueue.top());
		System.out.println(myQueue.pop());
		myQueue.push(4);
		System.out.println(myQueue.pop());
		System.out.println(myQueue.pop());
	}
}
