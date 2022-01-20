package com.accompnay.TopicAlgorithms.practiceSet.tree.base;

import com.accompnay.TopicAlgorithms.practiceSet.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101. 对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 1000] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/symmetric-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsSymmetric {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(2);
		root.right.right = new TreeNode(3);
		IsSymmetric isSymmetric = new IsSymmetric();
		boolean symmetric = isSymmetric.isSymmetric(root);
		System.out.println(symmetric);
	}

	public boolean isSymmetric(TreeNode root) {
		return check(root.left, root.right);
	}

	public boolean check(TreeNode nodeA, TreeNode nodeB) {
		if (nodeA == null && nodeB == null) {
			return true;
		}
		if (nodeA == null || nodeB == null) {
			return false;
		}
		return nodeA.val == nodeB.val && check(nodeA.right, nodeB.left) && check(nodeA.left, nodeB.right);
	}


	/**
	 * 迭代的做法
	 *
	 * @param root
	 * @return
	 */
	public boolean isSymmetric2(TreeNode root) {
		return check2(root, root);
	}

	public boolean check2(TreeNode nodeA, TreeNode nodeB) {
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(nodeA);
		queue.offer(nodeB);

		while (!queue.isEmpty()) {
			nodeA = queue.poll();
			nodeB = queue.poll();
			if (nodeA == null && nodeB == null) {
				continue;
			}
			if (nodeA == null || nodeB == null) {
				return false;
			}
			if (nodeA.val != nodeB.val) {
				return false;
			}
			queue.offer(nodeA.left);
			queue.offer(nodeB.right);

			queue.offer(nodeA.right);
			queue.offer(nodeB.left);
		}
		return true;
	}
}
