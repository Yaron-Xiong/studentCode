package com.yaronxiong.algorithms.practiceSet.tree.base;

import com.yaronxiong.algorithms.practiceSet.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 404. 左叶子之和
 * 计算给定二叉树的所有左叶子之和。
 * <p>
 * 示例：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-of-left-leaves
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SumOfLeftLeaves {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(1);
		root.right.left = new TreeNode(3);
		root.right.right = new TreeNode(-1);
		root.left.left.left = new TreeNode(5);
		root.left.left.right = new TreeNode(1);
		root.right.left.right = new TreeNode(6);
		root.right.right.right = new TreeNode(8);
		SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
		int i = sumOfLeftLeaves.sumOfLeftLeaves2(root);
		System.out.println(i);
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) return 0;
		int left = sumOfLeftLeaves(root.left);
		int right = sumOfLeftLeaves(root.right);
		int sum = left + right;
		if (left == 0 && root.left != null && root.left.left == null && root.left.right == null) {
			sum = sum + root.left.val;
		}
		return sum;
	}


	public int sumOfLeftLeaves2(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int sum = 0;
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				if (node.left.left == null && node.left.right == null)
					sum += node.left.val;
				queue.offer(node.left);
			}
			if (node.right != null)
				queue.offer(node.right);
		}
		return sum;
	}
}
