package com.accompnay.leetcode;

public class Demo7 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Demo7 demo7 = new Demo7();
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode listNode = demo7.getKthFromEnd(node, 2);
        print(listNode);
    }

    private static void print(ListNode listNode) {
        ListNode cur = listNode;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (k-- > 0) {
            fastNode = fastNode.next;
        }
        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        return slowNode;
    }

    /*public ListNode getKthFromEnd(ListNode head, int k) {
        int size = getListNodeSize(head);
        int index = 1;
        ListNode node = head;
        while (node != null && index <= size - k) {
            node = node.next;
            index++;
        }
        return node;
    }

    private int getListNodeSize(ListNode head) {
        int result = 0;
        ListNode cur = head;
        while (cur != null) {
            result++;
            cur = cur.next;
        }
        return result;
    }*/
}
