package com.accompnay.TopicAlgorithms.practiceSet.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 257. 二叉树的所有路径
 * <p>
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：["1"]
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BinaryTreePaths {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
		List<String> strings = binaryTreePaths.binaryTreePaths(root);
		System.out.println(strings);
	}


	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) return new ArrayList<>();
		List<String> res = new ArrayList<>();
		backtracking(root, res, "");
		return res;
	}

	public void backtracking(TreeNode node, List<String> res, String path) {
		if (node != null) {
			StringBuilder pathSb = new StringBuilder(path);
			pathSb.append(node.val);
			if (node.left == null && node.right == null) {
				res.add(pathSb.toString());
			} else {
				pathSb.append("->");
				backtracking(node.left, res, pathSb.toString());
				backtracking(node.right, res, pathSb.toString());
			}
		}
	}


	public List<String> binaryTreePaths2(TreeNode root) {
		if (root == null) return new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<String> paths = new LinkedList<>();
		List<String> res = new ArrayList<>();
		queue.offer(root);
		paths.offer(String.valueOf(root.val));
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			String path = paths.poll();
			if (node.left == null && node.right == null) {
				res.add(path);
				continue;
			}
			if (node.left != null) {
				queue.offer(node.left);
				paths.offer(path + "->" + node.left.val);
			}
			if (node.right != null) {
				queue.offer(node.right);
				paths.offer(path + "->" + node.right.val);
			}
		}
		return res;
	}
}
