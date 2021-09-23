package com.accompnay.swordFingerOffer.dfs;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 */
public class KthLargest {
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
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(1);
		node.left.right = new TreeNode(2);
		node.right = new TreeNode(4);
		KthLargest kthLargest = new KthLargest();
		int i = kthLargest.kthLargest(node, 1);
		System.out.println(i);
	}

	public int kthLargest(TreeNode root, int k) {
		this.k = k;
		dfs(root);
		return result;
	}

	int result = 0;
	int k = 0;

	public void dfs(TreeNode node) {
		if (node == null || k == 0) {
			return;
		}
		dfs(node.right);
		if (--k == 0) {
			result = node.val;
		}
		dfs(node.left);
	}
}
