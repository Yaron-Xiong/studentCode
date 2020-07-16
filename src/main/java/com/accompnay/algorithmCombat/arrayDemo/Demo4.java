package com.accompnay.algorithmCombat.arrayDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Accompany
 * Date:2020/1/18
 * 给定一个链表，返回链表开始入环的第一个节点 也就是成环点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * 解决思路1：
 * 采用额外空间复杂度,记录每个节点是否已经存在了，当存在了两次则成环
 * <p>
 * 解决思路2：
 * 采用双指针，一个慢指针（一次走一步），一个快指针（一次走两步）
 * 双指针都从head开始走
 * 存在一个原则：Floyd算法
 * 在成环的条件下 快指针追上了慢指针
 * 1.记录快指针的位置
 * 2.慢指针指向头节点
 * 3.慢指针和快指针同时只走一步，再次相遇则为成环点
 */
public class Demo4 {
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
    /*
    需要额外空间复杂度记录成环点
    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head!=null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }*/

    /*public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                //在成环的基础上找成环点
                slow = head;
                while (slow != fast) {
                    //说明成环了
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }*/

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next;
        System.out.println(detectCycle(head));
    }

    private static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast.next == null || fast.next.next == null) {
            return null;
        }else {
            //说明成环
            fast = head;
            while (fast != slow) {
                //追击
                fast = fast.next;
                slow = slow.next;
                if (fast == slow) {
                    return fast;
                }
            }
        }
        return null;
    }
}

