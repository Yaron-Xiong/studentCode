package com.accompnay.TopicAlgorithms.swordFingerOffer.linked;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 35. 复杂链表的复制 ：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * <p>
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 * <p>
 */
public class CopyRandomList {
	public static class Node {
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

	public Node copyRandomList2(Node head) {
		if (head == null) {
			return head;
		}
		//1.copy所有节点为当前的节点的next
		Node cur = head;
		while (cur != null) {
			Node newNode = new Node(cur.val);
			Node next = cur.next;
			cur.next = newNode;
			newNode.next = next;
			cur = next;
		}
		//2.将复制出的节点的random指针指向copy节点
		cur = head;
		while (cur != null) {
			Node copyNode = cur.next;
			Node nextNode = copyNode.next;
			if (cur.random != null) {
				copyNode.random = cur.random.next;
			}
			cur = nextNode;
		}
		//3.将链表脱离
		Node copyHead = head.next;
		cur = head;
		while (cur != null) {
			Node copyNode = cur.next;
			Node nextNode = cur.next.next;
			cur.next = nextNode;
			copyNode.next = nextNode == null ? null : nextNode.next;
			cur = nextNode;
		}

		return copyHead;
	}


	public static void main(String[] args) {
		Node node = new Node(7);
		node.next = new Node(13);
		node.random = null;

		node.next.next = new Node(11);
		node.next.random = node;

		node.next.next.next = new Node(10);
		node.next.next.next.next = new Node(1);
		node.next.next.random = node.next.next.next.next;
		node.next.next.next.random = node.next.next;
		node.next.next.next.next.random = node;
		CopyRandomList copyRandomList = new CopyRandomList();
		Node list = copyRandomList.copyRandomList2(node);
		System.out.println(list);
	}
}
