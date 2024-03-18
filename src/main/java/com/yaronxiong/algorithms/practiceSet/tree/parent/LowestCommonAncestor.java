package com.yaronxiong.algorithms.practiceSet.tree.parent;

import com.yaronxiong.algorithms.practiceSet.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 236. 二叉树的最近公共祖先
 * <p>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * 示例 2：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * 示例 3：
 * <p>
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LowestCommonAncestor {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
		TreeNode node = lowestCommonAncestor.lowestCommonAncestor(root, root.left.right, root.left);
		System.out.println(node);
	}

	/**
	 * 优化压栈算法
	 */
	public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q) {
			return root;
		}
		TreeNode leftNode = lowestCommonAncestor3(root.left, p, q);
		TreeNode rightNode = lowestCommonAncestor3(root.right, p, q);
		if (leftNode != null && rightNode != null) {
			return root;
		}
		if (leftNode != null) {
			return leftNode;
		}
		if (rightNode != null) {
			return rightNode;
		}
		return null;
	}


	/**
	 * 路径式搜索
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pPaths = new ArrayList<>();
		getPath(root, p, pPaths);

		List<TreeNode> qPaths = new ArrayList<>();
		getPath(root, q, qPaths);

		int index = 0;
		while (index < pPaths.size() && index < qPaths.size()) {
			if (pPaths.get(index) != qPaths.get(index)) {
				return pPaths.get(index - 1);
			}
			index++;
		}
		if (index < pPaths.size()) {
			return pPaths.get(index - 1);
		}
		if (index < qPaths.size()) {
			return qPaths.get(index - 1);
		}

		return null;
	}

	public boolean getPath(TreeNode root, TreeNode target, List<TreeNode> paths) {
		if (root == null) return false;
		paths.add(root);
		if (root == target) {
			return true;
		}
		if (getPath(root.left, target, paths)) {
			return true;
		}
		if (getPath(root.right, target, paths)) {
			return true;
		}
		paths.remove(root);
		return false;
	}

	/**
	 * 傻逼式搜索
	 */
	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == p || root == q) {
			return root;
		}
		if (contains(root.left, p)) {
			if (contains(root.right, q)) {
				return root;
			}
			return lowestCommonAncestor2(root.left, p, q);
		} else {
			if (contains(root.left, q)) {
				return root;
			}
			return lowestCommonAncestor2(root.right, p, q);
		}
	}

	public boolean contains(TreeNode root, TreeNode target) {
		if (root == target) return true;
		if (root == null) return false;
		if (contains(root.left, target)) {
			return true;
		}
		if (contains(root.right, target)) {
			return true;
		}
		return false;
	}
}
