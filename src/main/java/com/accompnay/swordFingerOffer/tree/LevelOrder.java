package com.accompnay.swordFingerOffer.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 剑指 Offer 32 - I. 从上到下打印二叉树 I ：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * <p>
 * 上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 * <p>
 */
public class LevelOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int[] levelOrder(TreeNode root) {
		List<Integer> result = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (node == null) {
				continue;
			}
			result.add(node.val);
			queue.add(node.left);
			queue.add(node.right);
		}
		return toArray(result);
	}

	private int[] toArray(List<Integer> list) {
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}


}
