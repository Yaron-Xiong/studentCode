package com.yaronxiong.algorithms.practiceSet.list.linked;

import java.util.*;

/**
 * 23. 合并K个升序链表
 * 给你一个链表数组，每个链表都已经按升序排列。
 * <p>
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 * 1->4->5,
 * 1->3->4,
 * 2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 * 示例 2：
 * <p>
 * 输入：lists = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：lists = [[]]
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
public class MergeKLists {
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
		ListNode node1 = new ListNode(1);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(5);
		ListNode node2 = new ListNode(1);
		node2.next = new ListNode(3);
		node2.next.next = new ListNode(4);
		ListNode node3 = new ListNode(2);
		node3.next = new ListNode(6);
		MergeKLists mergeKLists = new MergeKLists();
		ListNode listNode = mergeKLists.mergeKLists(new ListNode[]{null});
		System.out.println(listNode);
	}

	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(-1);
		ListNode cur = dummy;
		PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
		for (ListNode listNode : lists) {
			if (listNode != null) {
				queue.add(listNode);
			}
		}

		while (!queue.isEmpty()) {
			ListNode poll = queue.poll();
			cur.next = poll;
			if (poll != null && poll.next != null) {
				queue.add(poll.next);
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}
