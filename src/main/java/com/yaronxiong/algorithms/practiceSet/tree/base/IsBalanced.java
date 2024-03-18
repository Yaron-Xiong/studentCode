package com.yaronxiong.algorithms.practiceSet.tree.base;

import com.yaronxiong.algorithms.practiceSet.tree.TreeNode;

/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,3,3,null,null,4,4]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在范围 [0, 5000] 内
 * -104 <= Node.val <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/balanced-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsBalanced {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.right.right = new TreeNode(3);
		root.left.left.left = new TreeNode(4);
		root.right.right.right = new TreeNode(4);
		IsBalanced isBalanced = new IsBalanced();
		boolean balanced = isBalanced.isBalanced(root);
		System.out.println(balanced);
	}

	/**
	 * 后序遍历，保证左右节点都是平衡的
	 * @param root
	 * @return
	 */
	public boolean isBalanced(TreeNode root) {
		return dfs(root) != -1;
	}

	public int dfs(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = dfs(root.left);
		if (leftDepth == -1) {
			return leftDepth;
		}
		int rightDepth = dfs(root.right);
		if (rightDepth == -1) {
			return rightDepth;
		}
		//代表不平衡了
		if (Math.abs(leftDepth - rightDepth) > 1) {
			return -1;
		}
		return Math.max(leftDepth, rightDepth) + 1;
	}

}
