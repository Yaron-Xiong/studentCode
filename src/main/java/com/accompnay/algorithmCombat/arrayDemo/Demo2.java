package com.accompnay.algorithmCombat.arrayDemo;

import java.util.List;

/**
 * @author Accompany
 * Date:2020/1/16
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 提示：
 * 需要记录上个节点数据，否则会断链
 */
public class Demo2 {
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


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode node = swapPairs(head);
        System.out.println(node);
    }

    private static ListNode swapPairs(ListNode head) {
        ListNode pre = head;
        ListNode newHead = head==null||head.next==null?head:head.next;
        while (head!=null&&head.next!=null){
            ListNode one = head.next;
            ListNode two = head.next.next;
            pre.next = one;
            head.next = two;
            one.next = head;
            pre = head;
            head = two;
        }
        return newHead;
    }
}
