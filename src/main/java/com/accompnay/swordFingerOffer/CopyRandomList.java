package com.accompnay.swordFingerOffer;

import lombok.val;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 示例 1：
 */
public class CopyRandomList {
	static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}

		@Override
		public String toString() {
			return "Node{" +
					"val=" + val +
					'}';
		}
	}

	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.random = node;
		CopyRandomList copyRandomList = new CopyRandomList();
		copyRandomList.copyRandomList(node);
	}

	private Map<Node, Node> map = new HashMap<>();

	/**
	 * 递归
	 */
	public Node copyRandomList(Node head) {
		if (head == null) {
			return head;
		}
		//origin -> newNode
		if (!map.containsKey(head)) {
			Node newNode = new Node(head.val);
			map.put(head, newNode);
			//这里会将所有的next创建好
			newNode.next = copyRandomList(head.next);
			//这里会将所有的random创建好
			newNode.random = copyRandomList(head.random);
		}
		return map.get(head);
	}

}
