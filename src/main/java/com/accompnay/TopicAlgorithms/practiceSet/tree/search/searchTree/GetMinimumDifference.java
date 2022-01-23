package com.accompnay.TopicAlgorithms.practiceSet.tree.search.searchTree;


import com.accompnay.TopicAlgorithms.practiceSet.tree.TreeNode;

import java.util.*;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,6,1,3]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：root = [1,0,48,null,null,12,49]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目范围是 [2, 104]
 * 0 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GetMinimumDifference {
	/**
	 * @param root
	 * @return
	 */
	public int getMinimumDifference(TreeNode root) {
		List<TreeNode> treeNodeList = new ArrayList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size != 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
				size--;
				treeNodeList.add(node);
			}
		}
		int min = Integer.MAX_VALUE;
		for (TreeNode node : treeNodeList) {
			for (TreeNode treeNode : treeNodeList) {
				if (node != treeNode) {
					int value = Math.abs(node.val - treeNode.val);
					min = Math.min(value, min);
				}
			}
		}
		return min;
	}

	/**
	 * 二叉搜索树-有序性-中序遍历
	 */

	int minRes = Integer.MAX_VALUE;
	TreeNode pre = null;

	public int getMinimumDifference2(TreeNode root) {
		if (root == null) return 0;
		dfs(root);
		return minRes;
	}


	public void dfs(TreeNode node) {
		if (node == null) {
			return;
		}
		getMinimumDifference2(node.left);
		minRes = pre != null && Math.abs(pre.val - node.val) < minRes ? Math.abs(pre.val - node.val) : minRes;
		pre = node;
		getMinimumDifference2(node.right);
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		GetMinimumDifference getMinimumDifference = new GetMinimumDifference();
		int minimumDifference3 = getMinimumDifference.getMinimumDifference3(root);
		System.out.println(minimumDifference3);
	}

	/**
	 * 手动压栈
	 */
	public int getMinimumDifference3(TreeNode root) {
		if (root == null) return 0;
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode preNode = null;
		int res = Integer.MAX_VALUE;
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			TreeNode pop = stack.pop();
			res = preNode != null && Math.abs(preNode.val - pop.val) < res ? Math.abs(preNode.val - pop.val) : res;
			preNode = pop;
			root = pop.right;
		}
		return res;
	}

}
