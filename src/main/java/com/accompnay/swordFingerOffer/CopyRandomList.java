package com.accompnay.swordFingerOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * 示例 1：
 * 输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 * 示例 2：
 * 输入：head = [[1,1],[2,1]]
 * 输出：[[1,1],[2,1]]
 *
 * 剑指 Offer 35. 复杂链表的复制
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 */
public class CopyRandomList {
	private Map<Node,Node> copyMap = new HashMap<>();
	public static class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	public Node copyRandomList(Node head) {
		Node copyHead = copyList(head);
		Node cur = head;
		while (cur!=null){
			Node copyRandom = copyMap.get(cur.random);
			Node copyNode = copyMap.get(cur);
			copyNode.random = copyRandom;
			cur = cur.next;
		}
		return copyHead;
	}

	public Node copyList(Node head) {
		if (head == null) {
			return head;
		}
		Node copyNode = new Node(head.val);
		copyNode.next = copyRandomList(head.next);
		copyMap.put(head, copyNode);
		return copyNode;
	}

	public static void main(String[] args) {
		Node node = new Node(7);
		node.next =  new Node(13);
		node.random = null;

		node.next.next =  new Node(11);
		node.next.random = node;

		node.next.next.next =  new Node(10);
		node.next.next.next.next =  new Node(1);
		node.next.next.random = node.next.next.next.next;
		node.next.next.next.random = node.next.next;
		node.next.next.next.next.random =  node;
		CopyRandomList copyRandomList = new CopyRandomList();
		Node list = copyRandomList.copyRandomList(node);
		System.out.println(list);
	}
}
