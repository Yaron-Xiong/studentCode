package com.yaronxiong.algorithms.swordFingerOffer.stackandqueue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

/**
 * 剑指 Offer 59 - II. 队列的最大值
 * <p>
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value需要返回 -1
 * <p>
 * 示例 1：
 * <p>
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出:[null,null,null,2,1,2]
 * 示例 2：
 * <p>
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出:[null,-1,-1]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= push_back,pop_front,max_value的总操作数<= 10000
 * 1 <= value <= 10^5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S59_MaxQueue {
    static class MaxQueue {
        Deque<Integer> deque;
        Deque<Integer> maxDeque;

        public MaxQueue() {
            deque = new LinkedList<>();
            maxDeque = new LinkedList<>();
        }

        public int max_value() {
            return maxDeque.isEmpty() ? -1 : maxDeque.peekFirst();
        }

        public void push_back(int value) {
            deque.addLast(value);
            while (!maxDeque.isEmpty() && value > maxDeque.peekLast()) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(value);
        }

        public int pop_front() {
            if (deque.isEmpty()) {
                return -1;
            }
            Integer value = deque.pollFirst();
            if (Objects.equals(maxDeque.peekFirst(), value)) {
                maxDeque.pollFirst();
            }
            return value;
        }
    }


    public static void main(String[] args) {
        S59_MaxQueue.MaxQueue s59MaxQueue = new S59_MaxQueue.MaxQueue();
        int i = s59MaxQueue.max_value();
        System.out.println(i);
        s59MaxQueue.push_back(1);
        s59MaxQueue.push_back(2);
        System.out.println(s59MaxQueue.max_value());
        System.out.println(s59MaxQueue.pop_front());
        System.out.println(s59MaxQueue.max_value());
    }
}
