package com.yaronxiong.algorithms.practiceSet.tree.search.searchTree;

import com.yaronxiong.algorithms.practiceSet.tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [5,1,4,null,null,3,6]
 * 输出：false
 * 解释：根节点的值是 5 ，但是右子节点的值是 4 。
 * <p>
 * 提示：
 * <p>
 * 树中节点数目范围在[1, 104] 内
 * -231 <= Node.val <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/validate-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IsValidBST {
	TreeNode preNode = null;

	public boolean isValidBST(TreeNode root) {
		if (root == null) return true;
		if (!isValidBST(root.left)) {
			return false;
		}
		if (preNode != null && preNode.val >= root.val) {
			return false;
		}
		preNode = root;
		if (!isValidBST(root.right)) {
			return false;
		}
		return true;
	}


	public boolean isValidBST2(TreeNode root) {
		if (root == null) return true;
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode pre = null;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode node = stack.pop();
			if (pre != null && node.val <= pre.val) {
				return false;
			}
			pre = node;
			root = node.right;
		}
		return true;
	}
}
