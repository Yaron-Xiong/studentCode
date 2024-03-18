package com.yaronxiong.algorithms.leetcode.l1000;

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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/dinner-plate-stacks/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
        private int capacity;
        /**
         * 存储未满的栈下标，用以快速找到一个可以放进item的栈
         */
        private PriorityQueue<Integer> idx;
        private List<Deque<Integer>> dequeList;

        public DinnerPlates(int capacity) {
            this.capacity = capacity;
            this.idx = new PriorityQueue<>();
            this.dequeList = new ArrayList<>();
        }

        public void push(int val) {
            if (!idx.isEmpty() && idx.peek() >= this.dequeList.size()) {
                idx.clear();
            }
            if (idx.isEmpty()) {
                Deque<Integer> deque = new LinkedList<>();
                dequeList.add(deque);
                deque.addFirst(val);
                if (deque.size() < this.capacity) {
                    idx.add(dequeList.size() - 1);
                }
            } else {
                Deque<Integer> deque = this.dequeList.get(idx.peek());
                deque.addFirst(val);
                if (deque.size() == this.capacity) {
                    idx.poll();
                }
            }
        }

        public int pop() {
            return popAtStack(this.dequeList.size() - 1);
        }

        public int popAtStack(int index) {
            if (index < 0 || index >= this.dequeList.size() || this.dequeList.get(index).isEmpty()) {
                return -1;
            }
            Deque<Integer> deque = this.dequeList.get(index);
            if (deque.size() == this.capacity) {
                this.idx.add(index);
            }
            int val = deque.pollFirst();
            while (!this.dequeList.isEmpty() && this.dequeList.get(this.dequeList.size() - 1).isEmpty()) {
                this.dequeList.remove(this.dequeList.size() - 1);
            }
            return val;
        }
    }

}
