package com.accompnay.swordFingerOffer.tree;

/**
 * 剑指 Offer 28. 对称的二叉树：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 */
public class IsSymmetric {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return recur(root.left, root.right);
	}

	public boolean recur(TreeNode A, TreeNode B) {
		if (A == null && B == null) {
			return true;
		}
		if (A == null || B == null || A.val != B.val) {
			return false;
		}
		boolean b = recur(A.left, B.right);
		boolean c = recur(A.right, B.left);
		return b && c;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(2);
		root.left.right = null;
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(2);
		;
		//root.right.right = new TreeNode(2);
		IsSymmetric isSymmetric = new IsSymmetric();
		boolean symmetric = isSymmetric.isSymmetric(root);
		System.out.println(symmetric);
	}

}
