package com.accompnay.swordFingerOffer;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * <p>
 * 示例1：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * @author yaoyuanxiong
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
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);

		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		MergeTwoLists mergeTwoLists = new MergeTwoLists();
		ListNode listNode = mergeTwoLists.mergeTwoLists(l1, l2);
		System.out.println(listNode);
	}
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode result = new ListNode(-1);
		ListNode left = l1;
		ListNode right = l2;
		ListNode cur = result;
		while (left != null && right != null) {
			if (left.val< right.val){
				cur.next = left;
				left = left.next;
			}else {
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
		while (left!=null){
			cur.next = left;
			left = left.next;
			cur = cur.next;
		}
		while (right!=null){
			cur.next = right;
			right = right.next;
			cur = cur.next;
		}
		return result.next;

	}
}
