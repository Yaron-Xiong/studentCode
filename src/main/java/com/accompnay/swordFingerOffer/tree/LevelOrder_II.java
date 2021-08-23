package com.accompnay.swordFingerOffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - II. 从上到下打印二叉树 II：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * <p>
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
 * [9,20],
 * [15,7]
 * ]
 */
public class LevelOrder_II {
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
			ArrayList<Integer> subList = new ArrayList<>();
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				subList.add(node.val);
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
		LevelOrder_II levelOrder_ii = new LevelOrder_II();
		List<List<Integer>> lists = levelOrder_ii.levelOrder(treeNode);
		System.out.println(lists);
	}
}
