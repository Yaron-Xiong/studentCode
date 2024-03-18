package com.yaronxiong.algorithms.swordFingerOffer.linked;

/**
 * 剑指 Offer 25. 合并两个排序的链表:
 * <p>
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S25_MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        S25_MergeTwoLists s25MergeTwoLists = new S25_MergeTwoLists();
        ListNode listNode = s25MergeTwoLists.mergeTwoLists(l1, l2);
        System.out.println(listNode);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curNode = dummy;
        ListNode emptyNode = new ListNode(Integer.MAX_VALUE);
        while (l1 != null || l2 != null) {
            ListNode t1 = l1 == null ? emptyNode : l1;
            ListNode t2 = l2 == null ? emptyNode : l2;
            if (t1.val > t2.val) {
                curNode.next = t2;
                l2 = l2.next;
            } else {
                l1 = l1.next;
                curNode.next = t1;
            }
            curNode = curNode.next;
        }
        return dummy.next;
    }
}
