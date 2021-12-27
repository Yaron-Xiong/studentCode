package com.accompnay.Stormzhang.tree;

/**
 * 98. 验证二叉搜索树:https://leetcode-cn.com/problems/validate-binary-search-tree/
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 */
public class IsValidBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(20);
		IsValidBST isValidBST = new IsValidBST();
		boolean validBST = isValidBST.isValidBST(root);
		System.out.println(validBST);
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, null, null);
	}

	public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
		if (root == null) return true;
		if (max != null && root.val >= max.val) return false;
		if (min != null && root.val <= min.val) return false;
		if (!isValidBST(root.left, min, root)) return false;
		if (!isValidBST(root.right, root, max)) return false;
		return true;
	}
}
