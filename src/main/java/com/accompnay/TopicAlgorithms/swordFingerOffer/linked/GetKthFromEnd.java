package com.accompnay.TopicAlgorithms.swordFingerOffer.linked;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点:https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
 * <p>
 * 输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * <p>
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * <p>
 * 返回链表 4->5.
 */
public class GetKthFromEnd {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode getKthFromEnd(ListNode head, int k) {
		if (head==null){
			return head;
		}
		ListNode cur = head;
		ListNode kNode = head;
		for (int i = 0; i < k; i++) {
			cur = cur.next;
		}
		while (cur != null) {
			cur = cur.next;
			kNode = kNode.next;
		}
		return kNode;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		GetKthFromEnd getKthFromEnd = new GetKthFromEnd();
		ListNode kthFromEnd = getKthFromEnd.getKthFromEnd(head, 2);
		System.out.println(kthFromEnd);
	}
}
