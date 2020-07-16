package com.accompnay.algorithmCombat.stackAndQueue;

import java.util.Stack;

/**
 * @author Accompany
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 *
 */
public class Demo2 {
    private Stack<Integer> stack ;
    private Stack<Integer> stack2 ;
    /** Initialize your data structure here. */
    public Demo2() {
        stack = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (stack2.isEmpty()){
            //将statck的数据全部转移到statck2
            while (!stack.isEmpty()){
                stack2.push(stack.pop());
            }
        }
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()){
            //将statck的数据全部转移到statck2
            while (!stack.isEmpty()){
                stack2.push(stack.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        if (stack.isEmpty()&&stack2.isEmpty()){
            return true;
        }
        return false;
    }
}
