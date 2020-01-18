package com.accompnay.algorithmCombat.arrayDemo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Accompany
 * Date:2020/1/17
 * leetcode 141
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 解决思路1：
 * 采用额外空间复杂度,记录每个节点是否已经存在了，当存在了两次则成环
 * <p>
 * 解决思路2：
 * 采用双指针，一个慢指针（一次走一步），一个快指针（一次走两步
 * 如果成环：
 * 快指针会追上满指针
 * 如果不成环：
 * 快指针会先到达null值
 * 时间复杂度 N+K K为成环的节点个数
 * 空间复杂度 O（1）
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
    /*
    借助额外空间复杂度去记录每个节点，遍历链表看是否成环
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> list = new HashSet<>();
        while (head!=null){
            if (list.contains(head)){
                return true;
            }
            list.add(head);
            head = head.next;
        }
        return false;
    }*/

    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode high = head.next;
        //相等说明快指针追上了慢指针，存在环
        while (slow != high) {
            if (high == null || high.next == null) {
                //说明到了结尾
                return false;
            }
            slow = slow.next;
            high = high.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        System.out.println(hasCycle(head));
    }
}
