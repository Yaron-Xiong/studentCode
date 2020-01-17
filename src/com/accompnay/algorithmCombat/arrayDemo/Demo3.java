package com.accompnay.algorithmCombat.arrayDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Accompany
 * Date:2020/1/17
 * leetcode 141
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 */
public class Demo3 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
    public boolean hasCycle(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head!=null){
            if (list.contains(head.val)){
                return true;
            }
            list.add(head.val);
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Demo2.ListNode head = new Demo2.ListNode(3);
        head.next = new Demo2.ListNode(2);
        head.next.next = new Demo2.ListNode(0);
        head.next.next.next = new Demo2.ListNode(-4);
    }
}
