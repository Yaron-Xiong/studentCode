package com.accompnay.Stormzhang.linkedQueueStack.base;

/**
 * 19. 删除链表的倒数第 N 个结点：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
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
 * 链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveNthFromEnd {
	public static void main(String[] args) {
		ListNode root = new ListNode(1);
		/*root.next = new ListNode(2);
		root.next.next = new ListNode(3);
		root.next.next.next = new ListNode(4);
		root.next.next.next.next = new ListNode(5);*/
		RemoveNthFromEnd removeNthFromEnd = new RemoveNthFromEnd();
		ListNode listNode = removeNthFromEnd.removeNthFromEnd(root, 1);
		System.out.println(listNode);
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) return null;
		ListNode node = new ListNode(-1);
		node.next = head;
		ListNode pre = node;
		ListNode post = head;
		while (--n > 0) {
			post = post.next;
		}

		while (post != null && post.next != null) {
			post = post.next;
			pre = pre.next;
		}

		pre.next = pre.next.next;

		return node.next;
	}
}
