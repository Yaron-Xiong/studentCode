package com.accompnay.swordFingerOffer.linked;

/**
 * 剑指 Offer 25. 合并两个排序的链表:https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
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
 */
public class MergeTwoLists {
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
		MergeTwoLists mergeTwoLists = new MergeTwoLists();
		ListNode listNode = mergeTwoLists.mergeTwoLists(l1, l2);
		System.out.println(listNode);
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode resultCur = result;
		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				resultCur.next = l1;
				l1 = l1.next;
			} else {
				resultCur.next = l2;
				l2 = l2.next;
			}
			resultCur = resultCur.next;
		}
		resultCur.next = l1 != null ? l1 : l2;
		return result.next;
	}
}
