package com.accompnay.Stormzhang.tree.bst;

import com.accompnay.Stormzhang.tree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点:https://leetcode-cn.com/problems/delete-node-in-a-bst/
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，
 * 删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * <p>
 * 示例 1:
 * <p>
 * 输入：root = [5,3,6,2,4,null,7], key = 3
 * 输出：[5,4,6,2,null,null,7]
 * 解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 * <p>
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,7], key = 0
 * 输出: [5,3,6,2,4,null,7]
 * 解释: 二叉树不包含值为 0 的节点
 * 示例 3:
 * <p>
 * 输入: root = [], key = 0
 * 输出: []
 * <p>
 * 提示:
 * <p>
 * 节点数的范围 [0, 104].
 * -105 <= Node.val <= 105
 * 节点值唯一
 * root 是合法的二叉搜索树
 * -105 <= key <= 105
 * <p>
 * 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteNode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(14);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		DeleteNode deleteNode = new DeleteNode();
		TreeNode node = deleteNode.deleteNode(root, 7);
		System.out.println(node);
	}

	public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) return root;
		if (key > root.val) {
			root.right = deleteNode(root.right, key);
			return root;
		} else if (key < root.val) {
			root.left = deleteNode(root.left, key);
			return root;
		} else {
			return removeNode(root);
		}
	}

	private TreeNode removeNode(TreeNode root) {
		if (root == null) {
			return null;
		}
		if (root.right == null) {
			return root.left;
		}
		TreeNode node = root.right;
		while (node.left != null) {
			node = node.left;
		}
		node.left = root.left;
		root.left = null;
		return root.right;
	}
}
