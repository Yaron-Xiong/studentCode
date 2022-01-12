package com.accompnay.TopicAlgorithms.Stormzhang.tree.base;

import com.accompnay.TopicAlgorithms.Stormzhang.tree.TreeNode;

/**
 * 226. 翻转二叉树:https://leetcode-cn.com/problems/invert-binary-tree/
 * 翻转一棵二叉树。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * <p>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * 输出：
 * <p>
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/invert-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InvertTree {
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(4);
		treeNode.left = new TreeNode(2);
		treeNode.left.left = new TreeNode(1);
		treeNode.left.right = new TreeNode(3);
		treeNode.right = new TreeNode(7);
		treeNode.right.left = new TreeNode(6);
		InvertTree invertTree = new InvertTree();
		TreeNode root = invertTree.invertTree(treeNode);
		System.out.println(root);
	}
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
