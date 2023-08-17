package com.accompnay.TopicAlgorithms.swordFingerOffer.stackandqueue;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S09_CQueue {
    static class CQueue {
        Stack<Integer> s1;
        Stack<Integer> s2;

        public CQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        public void appendTail(int value) {
            s1.push(value);
        }

        public int deleteHead() {
            if (!s2.isEmpty()) {
                return s2.pop();
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            return s2.isEmpty() ? -1 : s2.pop();
        }
    }

    public static void main(String[] args) {
        S09_CQueue.CQueue s09CQueue = new S09_CQueue.CQueue();
        s09CQueue.appendTail(1);
        s09CQueue.appendTail(2);
        s09CQueue.appendTail(3);
        s09CQueue.appendTail(4);
        System.out.println(s09CQueue.deleteHead());
        System.out.println(s09CQueue.deleteHead());
        s09CQueue.appendTail(5);
        s09CQueue.appendTail(6);
        System.out.println(s09CQueue.deleteHead());
        System.out.println(s09CQueue.deleteHead());
        System.out.println(s09CQueue.deleteHead());
        System.out.println(s09CQueue.deleteHead());
        System.out.println(s09CQueue.deleteHead());
    }
}
