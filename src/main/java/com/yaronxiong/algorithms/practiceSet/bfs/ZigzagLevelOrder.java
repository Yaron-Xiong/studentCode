package com.yaronxiong.algorithms.practiceSet.bfs;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class ZigzagLevelOrder {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		if (root == null) {
			return new ArrayList<>();
		}
		List<List<Integer>> res = new ArrayList<>();
		Deque<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean reversion = false;
		while (!queue.isEmpty()) {
			int size = queue.size();
			LinkedList<Integer> list = new LinkedList<>();
			while (size > 0) {
				TreeNode poll = queue.poll();
				if (reversion) {
					list.addFirst(poll.val);
				} else {
					list.addLast(poll.val);
				}
				if (poll.left != null) {
					queue.add(poll.left);
				}
				if (poll.right != null) {
					queue.add(poll.right);
				}
				size--;
			}
			reversion = !reversion;
			res.add(list);
		}
		return res;
	}
}
