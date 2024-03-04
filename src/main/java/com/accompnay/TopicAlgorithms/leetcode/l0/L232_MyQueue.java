package com.accompnay.TopicAlgorithms.leetcode.l0;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 232. 用栈实现队列
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 * <p>
 * 实现 MyQueue 类：
 * <p>
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 * <p>
 * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["MyQueue", "push", "push", "peek", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 1, 1, false]
 * <p>
 * 解释：
 * MyQueue myQueue = new MyQueue();
 * myQueue.push(1); // queue is: [1]
 * myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
 * myQueue.peek(); // return 1
 * myQueue.pop(); // return 1, queue is [2]
 * myQueue.empty(); // return false
 * <p>
 * 提示：
 * <p>
 * 1 <= x <= 9
 * 最多调用 100 次 push、pop、peek 和 empty
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 * <p>
 * 进阶：
 * <p>
 * 你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/implement-queue-using-stacks/description/?envType=daily-question&envId=2024-03-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L232_MyQueue {
    class MyQueue {
        private final Deque<Integer> deque1;
        private final Deque<Integer> deque2;

        public MyQueue() {
            deque1 = new LinkedList<>();
            deque2 = new LinkedList<>();
        }

        public void push(int x) {
            deque1.addFirst(x);
        }

        public int pop() {
            if (empty()) {
                return -1;
            }
            if (!deque2.isEmpty()) {
                return deque2.pollFirst();
            }
            migrate();
            return deque2.pollFirst();
        }

        public int peek() {
            if (empty()) {
                return -1;
            }
            if (!deque2.isEmpty()) {
                return deque2.peekFirst();
            }
            migrate();
            return deque2.peekFirst();
        }

        private void migrate() {
            while (!deque1.isEmpty()) {
                Integer item = deque1.pollFirst();
                deque2.addFirst(item);
            }
        }

        public boolean empty() {
            return deque1.isEmpty() && deque2.isEmpty();
        }
    }
}
