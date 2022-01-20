package com.accompnay.TopicAlgorithms.practiceSet.tree.modifiyConstru;

import com.accompnay.TopicAlgorithms.practiceSet.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 617. 合并二叉树
 * <p>
 * 给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
 * <p>
 * 你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将他们的值相加作为节点合并后的新值，否则不为NULL 的节点将直接作为新二叉树的节点。
 * <p>
 * 示例1:
 * <p>
 * 输入:
 * Tree 1                     Tree 2
 * 1                         2
 * / \                       / \
 * 3   2                     1   3
 * /                           \   \
 * 5                             4   7
 * 输出:
 * 合并后的树:
 * 3
 * / \
 * 4   5
 * / \   \
 * 5   4   7
 * 注意:合并必须从两个树的根节点开始。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-binary-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MergeTrees {
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		TreeNode root = null;
		if (root1 != null && root2 != null) {
			root = new TreeNode(root1.val + root2.val);
			root.left = mergeTrees(root1.left, root2.left);
			root.right = mergeTrees(root1.right, root2.right);
		} else if (root1 != null) {
			root = new TreeNode(root1.val);
			root.left = mergeTrees(root1.left, root2);
			root.right = mergeTrees(root1.right, root2);
		} else if (root2 != null) {
			root = new TreeNode(root2.val);
			root.left = mergeTrees(root1, root2.left);
			root.right = mergeTrees(root1, root2.right);
		}
		return root;
	}

	/**
	 * 手动压栈
	 *
	 * @param root1
	 * @param root2
	 * @return
	 */
	public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
		if (root1 == null) return root2;
		if (root2 == null) return root1;
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<TreeNode> queue1 = new LinkedList<>();
		Queue<TreeNode> queue2 = new LinkedList<>();
		TreeNode newRoot = new TreeNode(root1.val + root2.val);
		queue.offer(newRoot);
		queue1.offer(root1);
		queue2.offer(root2);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			TreeNode node1 = queue1.poll();
			TreeNode node2 = queue2.poll();
			if (node1.left != null || node2.left != null) {
				if (node1.left != null && node2.left != null) {
					node.left = new TreeNode(node1.left.val + node2.left.val);
					queue.offer(node.left);
					queue1.offer(node1.left);
					queue2.offer(node2.left);
				} else if (node1.left != null) {
					node.left = node1.left;
				} else {
					node.left = node2.left;
				}
			}

			if (node1.right != null || node2.right != null) {
				if (node1.right != null && node2.right != null) {
					node.right = new TreeNode(node1.right.val + node2.right.val);
					queue.offer(node.right);
					queue1.offer(node1.right);
					queue2.offer(node2.right);
				}else if (node1.right != null) {
					node.right = node1.right;
				} else {
					node.right = node2.right;
				}
			}
		}

		return newRoot;
	}
}
