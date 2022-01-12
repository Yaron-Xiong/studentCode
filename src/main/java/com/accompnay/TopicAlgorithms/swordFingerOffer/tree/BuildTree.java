package com.accompnay.TopicAlgorithms.swordFingerOffer.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 示例 1:
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class BuildTree {

	public class TreeNode {
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


	int index = 0;
	private Map<Integer, Integer> value2Index = new HashMap<>();
	private int[] preorder;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			value2Index.put(inorder[i], i);
		}
		this.preorder = preorder;
		return buildTree(0, preorder.length - 1);
	}

	public TreeNode buildTree(int left, int right) {
		if (left > right) return null;
		TreeNode root = new TreeNode(preorder[this.index++]);
		int mid = value2Index.get(root.val);
		root.left = buildTree(left, mid - 1);
		root.right = buildTree(mid + 1, right);
		return root;
	}


	public static void main(String[] args) {
		BuildTree buildTree = new BuildTree();
		TreeNode node = buildTree.buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4});
		System.out.println(node);
	}
}
