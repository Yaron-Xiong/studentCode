package com.accompnay.swordFingerOffer.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径:https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * <p>
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和target = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 10000
 */
public class PathSum {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		PathSum pathSum = new PathSum();
		List<List<Integer>> list = pathSum.pathSum(root, 22);
		System.out.println(list);
	}

	public List<List<Integer>> pathSum(TreeNode root, int target) {
		dfs(root, target);
		return result;
	}

	private List<List<Integer>> result = new ArrayList<>();
	private LinkedList<Integer> path = new LinkedList<>();

	public void dfs(TreeNode root, int target) {
		if (root == null) {
			return;
		}
		target -= root.val;
		path.add(root.val);
		if (target == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList<>(path));
		}
		dfs(root.left, target);
		dfs(root.right, target);
		path.removeLast();
	}
}
