package com.accompnay.TopicAlgorithms.swordFingerOffer.stackandqueue;

import java.util.Stack;

/**
 * 剑指 Offer 30. 包含min函数的栈
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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S30_MinStack {
    class MinStack {
        Stack<Integer> s1;
        Stack<Integer> s2;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void push(int x) {
            s1.push(x);
            int s2Value =  s2.isEmpty() || x < s2.peek() ? x : s2.peek();
            s2.push(s2Value);
        }

        public void pop() {
            s1.pop();
            s2.pop();
        }

        public int top() {
            return s1.peek();
        }

        public int min() {
            return s2.peek();
        }
    }
}
