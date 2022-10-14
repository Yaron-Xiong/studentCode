package com.accompnay.TopicAlgorithms.practiceSet.list.linked;

/**
 * 21. 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTwoLists {
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
		ListNode list1 = new ListNode(1);
		list1.next = new ListNode(2);
		list1.next.next = new ListNode(4);

		ListNode list2 = new ListNode(1);
		list2.next = new ListNode(3);
		list2.next.next = new ListNode(4);
		MergeTwoLists mergeTwoLists = new MergeTwoLists();
		ListNode listNode = mergeTwoLists.mergeTwoLists(list1, list2);
		System.out.println(listNode);
	}

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode newHead = new ListNode(-1);
		ListNode newNodeCur = newHead;
		ListNode cur1 = list1;
		ListNode cur2 = list2;
		while (cur1 != null && cur2 != null) {
			if (cur1.val < cur2.val) {
				newNodeCur.next = cur1;
				cur1 = cur1.next;
			} else {
				newNodeCur.next = cur2;
				cur2 = cur2.next;
			}
			newNodeCur = newNodeCur.next;
		}
		if (cur1 != null) {
			newNodeCur.next = cur1;
		}
		if (cur2 != null) {
			newNodeCur.next = cur2;
		}
		return newHead.next;
	}
}
