package com.yaronxiong.algorithms.practiceSet.tree.modifiyConstru;

import com.yaronxiong.algorithms.practiceSet.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 226. 翻转二叉树
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
	/**
	 * 递归 压栈
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null) return root;
		TreeNode leftNode = invertTree(root.left);
		TreeNode rightNode = invertTree(root.right);
		root.right = leftNode;
		root.left = rightNode;
		return root;
	}

	/**
	 * 迭代
	 */
	public TreeNode invertTree2(TreeNode root) {
		if (root == null) return root;
		TreeNode head = root;
		Deque<TreeNode> stack = new LinkedList<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				TreeNode leftNode = root.left;
				root.left = root.right;
				root.right = leftNode;
				stack.push(root);
				root = root.left;
			}
			root = stack.pop().right;
		}
		return head;
	}
}
