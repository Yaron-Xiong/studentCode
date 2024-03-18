package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1026. 节点与其祖先之间的最大差值
 * 提示
 * 中等
 * 148
 * 相关企业
 * 给定二叉树的根节点 root，找出存在于 不同 节点 A 和 B 之间的最大值 V，其中 V = |A.val - B.val|，且 A 是 B 的祖先。
 * <p>
 * （如果 A 的任何子节点之一为 B，或者 A 的任何子节点是 B 的祖先，那么我们认为 A 是 B 的祖先）
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [8,3,10,1,6,null,14,null,null,4,7,13]
 * 输出：7
 * 解释：
 * 我们有大量的节点与其祖先的差值，其中一些如下：
 * |8 - 3| = 5
 * |3 - 7| = 4
 * |8 - 1| = 7
 * |10 - 13| = 3
 * 在所有可能的差值中，最大值 7 由 |8 - 1| = 7 得出。
 * 示例 2：
 * <p>
 * 输入：root = [1,null,2,null,0,3]
 * 输出：3
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 2 到 5000 之间。
 * 0 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1026_MaxAncestorDiff {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public int maxAncestorDiff(TreeNode root) {
		int v1 = dfs(root.left, root.val, root.val);
		int v2 = dfs(root.right, root.val, root.val);
		return Math.max(v1, v2);
	}

	private int dfs(TreeNode root, int max, int min) {
		if (root == null) {
			return 0;
		}
		int rootRes = Math.max(Math.abs(root.val - max), Math.abs(root.val - min));
		int v1 = dfs(root.left, Math.max(max, root.val), Math.min(min, root.val));
		int v2 = dfs(root.right, Math.max(max, root.val), Math.min(min, root.val));
		return Math.max(Math.max(v1, v2), rootRes);
	}
}
