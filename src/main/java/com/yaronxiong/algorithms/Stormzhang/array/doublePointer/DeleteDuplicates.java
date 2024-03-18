package com.yaronxiong.algorithms.Stormzhang.array.doublePointer;

/**
 * 83. 删除排序链表中的重复元素：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
 * <p>
 * 返回同样按升序排列的结果链表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteDuplicates {
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		DeleteDuplicates deleteDuplicates = new DeleteDuplicates();
		ListNode listNode = deleteDuplicates.deleteDuplicates(head.next.next);
		System.out.println(listNode);
	}

	public ListNode deleteDuplicates(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null) {
			if (fast.val != slow.val) {
				slow.next = fast;
				slow = fast;
			}
			fast = fast.next;
		}
		if (slow != null) {
			slow.next = null;
		}
		return head;
	}
}
