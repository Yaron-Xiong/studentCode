package com.accompnay.TopicAlgorithms.practiceSet.tree.base;

import com.accompnay.TopicAlgorithms.practiceSet.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513. 找树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的最底层最左边节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [2,1,3]
 * 输出: 1
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,null,5,6,null,null,7]
 * 输出: 7
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [1,104]
 * -231<= Node.val <= 231- 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-bottom-left-tree-value
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindBottomLeftValue {
	public static void main(String[] args) {

	}

	int value;
	int maxLevel;

	public int findBottomLeftValue(TreeNode root) {
		value = root.val;
		maxLevel = 0;
		dfs(root, maxLevel);
		return value;
	}

	private void dfs(TreeNode node, int level) {
		if (node == null) return;
		if (node.left != null) {
			dfs(node.left, level + 1);
		}
		if (node.right != null) {
			dfs(node.right, level + 1);
		}
		if (level > maxLevel) {
			maxLevel = level;
			value = node.val;
		}
	}

	/**
	 * 层序解决
	 */
	public int findBottomLeftValue2(TreeNode root) {
		if (root == null) return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		boolean isUse = false;
		int result = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
				if (!isUse) {
					isUse = true;
					result = node.val;
				}
				size--;
			}
			isUse = false;
		}
		return result;
	}
}
