package com.accompnay.swordFingerOffer.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 55 - I. 二叉树的深度:https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 * <p>
 * 例如：
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度3 。
 */

public class MaxDepth {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(3);
		treeNode.left = new TreeNode(9);
		treeNode.left.left = new TreeNode(15);
		treeNode.right = new TreeNode(20);
		treeNode.right.right = new TreeNode(7);
		treeNode.right.right.right = new TreeNode(14);
		MaxDepth maxDepth = new MaxDepth();
		int i = maxDepth.maxDepth2(null);
		System.out.println(i);
	}

	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
	}

	public int maxDepth2(TreeNode root) {
		if (root==null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 0;
		while (!queue.isEmpty()) {
			Queue<TreeNode> temp = new LinkedList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (node.left != null) temp.add(node.left);
				if (node.right != null) temp.add(node.right);
			}
			level++;
			queue.addAll(temp);
		}
		return level;
	}

}
