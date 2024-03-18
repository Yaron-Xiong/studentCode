package com.yaronxiong.algorithms.practiceSet.tree.base;

import com.yaronxiong.algorithms.practiceSet.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 222. 完全二叉树的节点个数
 * <p>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~2h个节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：6
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是[0, 5 * 104]
 * 0 <= Node.val <= 5 * 104
 * 题目数据保证输入的树是 完全二叉树
 * <p>
 * <p>
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-complete-tree-nodes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CountNodes {
	public int countNodes(TreeNode root) {
		return root == null ? 0 : countNodes(root.left) + countNodes(root.right) + 1;
	}

	public int countNodes2(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int countNode = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size != 0) {
				TreeNode node = queue.poll();
				countNode++;
				size--;
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
		}
		return countNode;
	}


	/**
	 * 利用满二叉树特性
	 * @param root
	 * @return
	 */
	public int countNodes3(TreeNode root) {
		if (root == null) return 0;
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);
		if (leftDepth == rightDepth) {
			return (1 << leftDepth)  + countNodes3(root.right);
		} else {
			return (1 << rightDepth) + countNodes3(root.left);
		}
	}

	private int getDepth(TreeNode node) {
		int depth = 0;
		while (node != null) {
			node = node.left;
			depth++;
		}
		return depth;
	}
}
