package com.accompnay.TopicAlgorithms.swordFingerOffer.tree;

/**
 * 剑指 Offer 55 - II. 平衡二叉树：https://leetcode-cn.com/problems/ping-heng-er-cha-shu-lcof
 * <p>
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 * <p>
 * 示例 1:
 * <p>
 * 给定二叉树 [3,9,20,null,null,15,7]
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回 true 。
 * <p>
 * 示例 2:
 * <p>
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 * <p>
 * 1
 * / \
 * 2   2
 * / \
 * 3   3
 * / \
 * 4   4
 * 返回false 。
 */
public class IsBalanced {
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

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		IsBalanced isBalanced = new IsBalanced();
		boolean balanced = isBalanced.isBalanced(root);
		System.out.println(Boolean.toString(balanced));
	}


	public boolean isBalanced(TreeNode root) {
		int dfs = dfs(root);
		return dfs != -1;
	}

	/**
	 * 如果不平衡 return -1
	 */
	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = dfs(root.left);
		if (left==-1) return -1;
		int right = dfs(root.right);
		if (right==-1) return -1;
		return Math.abs(left - right) > 1 ? -1 : Math.max(left, right) + 1;
	}
}
