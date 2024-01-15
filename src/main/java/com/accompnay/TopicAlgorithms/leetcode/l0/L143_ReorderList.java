package com.accompnay.TopicAlgorithms.leetcode.l0;

/**
 * 143. 重排链表
 * 中等
 * 1.3K
 * 相关企业
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reorder-list/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L143_ReorderList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        L143_ReorderList l143ReorderList = new L143_ReorderList();
        l143ReorderList.reorderList(head);
        System.out.println(head);
    }

    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode midNode = getMidNode(head);
        ListNode l1 = head;
        ListNode l2 = reverse(midNode.next);
        midNode.next = null;

        ListNode curNode = new ListNode(-1);
        while (l1 != null && l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;

            curNode.next = l1;
            curNode.next.next = l2;

            l1 = temp1;
            l2 = temp2;
            curNode = curNode.next.next;
        }
        if (l1 != null) {
            curNode.next = l1;
        }

    }

    private static ListNode getMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode l2) {
        ListNode pre = null;
        ListNode cur = l2;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
