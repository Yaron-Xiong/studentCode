package com.accompnay.TopicAlgorithms.practiceSet.list.linked;

/**
 * 19. 删除链表的倒数第 N 个结点
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], n = 2
 * 输出：[1,2,3,5]
 * 示例 2：
 * <p>
 * 输入：head = [1], n = 1
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1,2], n = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中结点的数目为 sz
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 * <p>
 * 进阶：你能尝试使用一趟扫描实现吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {
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
		/*head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);*/
		RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
		ListNode listNode = removeNthFromEnd.removeNthFromEnd(head, 1);
		System.out.println(listNode);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode fast = dummy;
		ListNode slow = dummy;
		for (int i = 0; i < n; i++) {
			fast = fast.next;
		}
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		return dummy.next;
	}
}
