package com.accompnay.TopicAlgorithms.Stormzhang.tree.bfs;

import com.accompnay.TopicAlgorithms.Stormzhang.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度：https://leetcode-cn.com/problems/minimum-depth-of-binary-tree
 * 给定一个二叉树，找出其最小深度。
 * <p>
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * <p>
 * 说明：叶子节点是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：root = [2,null,3,null,4,null,5,null,6]
 * 输出：5
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
		root.right.right = new TreeNode(15);
		root.right.right.right = new TreeNode(7);
		MinDepth minDepth = new MinDepth();
		int i = minDepth.minDepth(root);
		System.out.println(i);
	}

	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int depth = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (node.left == null && node.right == null) {
					return depth;
				}
				if (node.left != null) queue.add(node.left);
				if (node.right != null) queue.add(node.right);
			}
			depth++;
		}
		return depth;
	}
}
