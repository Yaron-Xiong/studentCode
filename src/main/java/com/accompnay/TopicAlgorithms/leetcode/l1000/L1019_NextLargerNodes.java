package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 1019. 链表中的下一个更大节点
 * 提示
 * 中等
 * 252
 * 相关企业
 * 给定一个长度为 n 的链表 head
 * <p>
 * 对于列表中的每个节点，查找下一个 更大节点 的值。也就是说，对于每个节点，找到它旁边的第一个节点的值，这个节点的值 严格大于 它的值。
 * <p>
 * 返回一个整数数组 answer ，其中 answer[i] 是第 i 个节点( 从1开始 )的下一个更大的节点的值。
 * 如果第 i 个节点没有下一个更大的节点，设置 answer[i] = 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [2,1,5]
 * 输出：[5,5,0]
 * 示例 2：
 * <p>
 * 输入：head = [2,7,4,3,5]
 * 输出：[7,0,5,5,0]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数为 n
 * 1 <= n <= 104
 * 1 <= Node.val <= 109
 */
public class L1019_NextLargerNodes {
	public class ListNode {
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
	}

	public int[] nextLargerNodes(ListNode head) {
		List<Integer> list = new ArrayList<>();
		ListNode curNode = head;
		while (curNode != null) {
			list.add(curNode.val);
			curNode = curNode.next;
		}
		Stack<Integer> stack = new Stack<>();
		int[] res = new int[list.size()];
		for (int i = list.size() - 1; i >= 0; i--) {
			while (!stack.isEmpty() && list.get(i) >= stack.peek()) {
				stack.pop();
			}
			int maxV = stack.isEmpty() ? 0 : stack.peek();
			res[i] = maxV;
			stack.push(list.get(i));
		}
		return res;
	}
}
