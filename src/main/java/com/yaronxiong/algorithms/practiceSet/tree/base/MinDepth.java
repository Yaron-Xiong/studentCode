package com.yaronxiong.algorithms.practiceSet.tree.base;

import com.yaronxiong.algorithms.practiceSet.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
 *  
 * <p>
 * 提示：
 * <p>
 * 树中节点数的范围在 [0, 105] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinDepth {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.right = new TreeNode(20);
		root.right.right = new TreeNode(7);
		root.right.right.right = new TreeNode(8);
		MinDepth minDepth = new MinDepth();
		int depth = minDepth.minDepth2(root);
		System.out.println(depth);
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}

		int leftDepth = minDepth(root.left);
		int rightDepth = minDepth(root.right);
		if (root.left == null) {
			return rightDepth + 1;
		}
		if (root.right == null) {
			return leftDepth + 1;
		}
		return Math.min(leftDepth, rightDepth) + 1;
	}


	/**
	 * 层序遍历，如果某一层的节点不存在左右节点直接返回
	 */
	public int minDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int level = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			level++;
			while (size != 0) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) {
					return level;
				}
				if (node.left != null) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
				size--;
			}
		}
		return -1;
	}
}
