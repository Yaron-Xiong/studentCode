package com.accompnay.TopicAlgorithms.swordFingerOffer.linked;

import java.util.Stack;

/**
 * 剑指 Offer 06. 从尾到头打印链表 : https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * <p>
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
public class ReversePrint {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public int[] reversePrint(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		ListNode cur = head;
		while (cur != null) {
			stack.add(cur.val);
			cur = cur.next;
		}
		int [] result = new int[stack.size()];
		int index = 0;
		while (!stack.isEmpty()){
			result[index++] = stack.pop();
		}
		return result;
	}
}