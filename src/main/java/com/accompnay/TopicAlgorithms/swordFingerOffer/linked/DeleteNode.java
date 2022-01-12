package com.accompnay.TopicAlgorithms.swordFingerOffer.linked;

/**
 * 剑指 Offer 18. 删除链表的节点:https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof
 * <p>
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * <p>
 * 返回删除后的链表的头节点。
 * <p>
 * 注意：此题对比原题有改动
 * <p>
 * 示例 1:
 * <p>
 * 输入: head = [4,5,1,9], val = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 * 示例 2:
 * <p>
 * 输入: head = [4,5,1,9], val = 1
 * 输出: [4,5,9]
 * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 */
public class DeleteNode {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);
		head.next.next.next.next = new ListNode(10);
		DeleteNode deleteNode = new DeleteNode();
		ListNode node = deleteNode.deleteNode(head, 1);
		System.out.println(node);
	}

	public ListNode deleteNode(ListNode head, int val) {
		if (head.val == val) {
			return head.next;
		}

		ListNode cur = head.next;
		ListNode pre = head;
		while (cur != null) {
			ListNode next = cur.next;
			if (cur.val == val) {
				pre.next = next;
				cur.next = null;
				break;
			}
			pre = cur;
			cur = next;
		}
		return head;
	}
}
