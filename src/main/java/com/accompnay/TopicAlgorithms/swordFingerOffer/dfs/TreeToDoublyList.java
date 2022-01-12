package com.accompnay.TopicAlgorithms.swordFingerOffer.dfs;

/**
 * 剑指 Offer 36. 二叉搜索树与双向链表：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof
 * <p>
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
 * <p>
 * 为了让您更好地理解问题，以下面的二叉搜索树为例：
 * <p>
 * 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。
 * 对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是第一个节点。
 * <p>
 * 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
 * <p>
 * 特别地，我们希望可以就地完成转换操作。
 * 当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。
 * 还需要返回链表中的第一个节点的指针。
 */
public class TreeToDoublyList {
	static class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}

		@Override
		public String toString() {
			return "Node{" +
					"val=" + val +
					'}';
		}
	}

	public static void main(String[] args) {
		Node node = new Node(4);
		node.left = new Node(2);
		node.right = new Node(5);
		node.left.left = new Node(1);
		node.left.right = new Node(3);
		TreeToDoublyList treeToDoublyList = new TreeToDoublyList();
		Node node1 = treeToDoublyList.treeToDoublyList(node);
		System.out.println(node1);
	}

	private Node head = null;
	private Node pre = null;

	public Node treeToDoublyList(Node root) {
		if (root == null) return root;
		dfs(root);
		head.left = pre;
		pre.right = head;
		return head;
	}

	public void dfs(Node root) {
		if (root == null) {
			return;
		}
		dfs(root.left);
		if (pre != null) {
			pre.right = root;
		} else {
			head = root;
		}
		root.left = pre;
		pre = root;
		dfs(root.right);
	}
}