package com.accompnay.swordFingerOffer;

import java.util.Stack;

/**
 * @author Accompany
 * Date:2020/1/14
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class Demo5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (!stack2.isEmpty()){
            //表示还有数据先取
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            Integer node = stack1.pop();
            stack2.push(node);
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        Demo5 demo = new Demo5();
        demo.push(1);
        demo.push(2);
        System.out.println(demo.pop());
        demo.push(3);
        demo.push(4);
        System.out.println(demo.pop());
    }
}
