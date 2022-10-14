package com.accompnay.TopicAlgorithms.practiceSet.list.linked;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4,5], left = 2, right = 4
 * 输出：[1,4,3,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [5], left = 1, right = 1
 * 输出：[5]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目为 n
 * 1 <= n <= 500
 * -500 <= Node.val <= 500
 * 1 <= left <= right <= n
 * <p>
 * 进阶： 你可以使用一趟扫描完成反转吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseBetween {
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
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);
		listNode.next.next.next = new ListNode(4);
		listNode.next.next.next.next = new ListNode(5);
		ReverseBetween reverseBetween = new ReverseBetween();
		ListNode listNode1 = reverseBetween.reverseBetween(listNode, 1, 5);
		System.out.println(listNode1);
	}

	public ListNode reverseBetween(ListNode head, int left, int right) {
		ListNode dummy = new ListNode(-1);
		dummy.next = head;
		ListNode pre = dummy;
		ListNode cur = head;
		ListNode leftNode = head;
		for (int i = 1; i < left; i++) {
			pre = cur;
			cur = cur.next;
			leftNode = pre;
		}
		ListNode reverseRightNode = leftNode.next;
		ListNode nextNode = cur.next;
		//reverse
		for (int i = 0; i < right - left + 1; i++) {
			nextNode = cur.next;
			cur.next = pre;
			pre = cur;
			cur = nextNode;
		}
		reverseRightNode.next = nextNode;
		leftNode.next = pre;
		return dummy.next;
	}

}
