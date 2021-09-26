package com.accompnay.swordFingerOffer.tree;

import org.apache.poi.ss.formula.functions.T;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 */
public class LowestCommonAncestor {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode{" +
					"val=" + val +
					'}';
		}
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return root;
		}
		boolean a = root == p || contains(root.left, p);
		boolean b = root == q || contains(root.right, q);
		if (a && b) {
			return root;
		}
		if (!a && b) {
			a = contains(root.right, p);
			return lowestCommonAncestor(root.right,p,q);
		}
		if (!b && a) {
			b = contains(root.left, q);
			if (a && b) return root;
		}
		if (a && b) {
			return root;
		}
		TreeNode result;
		boolean x = (result = lowestCommonAncestor(root.left, p, q)) != null || (result = lowestCommonAncestor(root.right, p, q)) != null;
		return result;
	}

	private boolean contains(TreeNode root, TreeNode p) {
		if (root == null) return false;
		if (root == p) {
			return true;
		}
		return contains(root.left, p) || contains(root.right, p);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		root.right = new TreeNode(8);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
		TreeNode treeNode = lowestCommonAncestor.lowestCommonAncestor(root, root.left.right, root.left);
		System.out.println(treeNode);
	}
}
