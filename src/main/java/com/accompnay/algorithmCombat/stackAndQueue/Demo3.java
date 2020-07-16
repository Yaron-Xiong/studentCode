package com.accompnay.algorithmCombat.stackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Accompany
 * LeetCode 225
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 *
 */
public class Demo3 {
    private Queue<Integer> queue ;
    /** Initialize your data structure here. */
    public Demo3() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        //将最新的元素添加到临时队列中
        Queue<Integer> tempQueue = new LinkedList<>();
        tempQueue.add(x);
        //将存储队列的值一一添加到临时队列，这样就完成了前入后出
        while (!queue.isEmpty()){
            tempQueue.add(queue.poll());
        }
        //将旧队列指向临时队列
        queue = tempQueue;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        return queue.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        Demo3 demo3 = new Demo3();
        demo3.push(1);
        demo3.push(2);
        System.out.println(demo3.top());
        System.out.println(demo3.pop());
    }
}
