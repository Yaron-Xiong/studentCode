package com.accompnay.algorithmCombat.arrayDemo;

import java.util.Collections;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Accompany
 * Date:2020/1/15
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class Demo1{
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    //迭代的做法
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev =null;
        while (cur!=null){
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        return prev;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        Demo1 demo1 = new Demo1();
        head = demo1.reverseList(head);
        System.out.println(head);
    }
}
