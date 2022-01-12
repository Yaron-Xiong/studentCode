package com.accompnay.TopicAlgorithms.swordFingerOffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 */
public class LevelOrder_III {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> result = new ArrayList<>();
		if (root != null) {
			queue.offer(root);
		}
		while (!queue.isEmpty()) {
			LinkedList<Integer> subList = new LinkedList<>();
			int depth = result.size() + 1;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				if (depth % 2 == 0) {
					subList.addFirst(node.val);
				} else {
					subList.addLast(node.val);
				}
			}
			result.add(subList);
		}
		return result;
	}

	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(3);
		treeNode.left = new TreeNode(9);
		treeNode.left.left = new TreeNode(15);
		treeNode.right = new TreeNode(20);
		treeNode.right.right = new TreeNode(7);
		LevelOrder_III levelOrder_ii = new LevelOrder_III();
		List<List<Integer>> lists = levelOrder_ii.levelOrder(treeNode);
		System.out.println(lists);
	}
}
