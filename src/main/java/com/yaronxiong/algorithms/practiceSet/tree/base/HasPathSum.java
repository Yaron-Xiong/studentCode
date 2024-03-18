package com.yaronxiong.algorithms.practiceSet.tree.base;

import com.yaronxiong.algorithms.practiceSet.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。
 * 如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
 * 输出：true
 * 解释：等于目标和的根节点到叶节点路径如上图所示。
 * 示例 2：
 * <p>
 * 输入：root = [1,2,3], targetSum = 5
 * 输出：false
 * 解释：树中存在两条根节点到叶子节点的路径：
 * (1 --> 2): 和为 3
 * (1 --> 3): 和为 4
 * 不存在 sum = 5 的根节点到叶子节点的路径。
 * 示例 3：
 * <p>
 * 输入：root = [], targetSum = 0
 * 输出：false
 * 解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [0, 5000] 内
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/path-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HasPathSum {

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) return false;
		return backtracking(root, targetSum, 0);
	}

	public boolean backtracking(TreeNode node, int targetSum, int sum) {
		sum = sum + node.val;
		if (node.left != null && backtracking(node.left, targetSum, sum)) {
			return true;
		}
		if (node.right != null && backtracking(node.right, targetSum, sum)) {
			return true;
		}
		if (node.left == null && node.right == null) {
			return targetSum == sum;
		}
		return false;
	}

	public boolean hasPathSum2(TreeNode root, int targetSum) {
		if (root == null) return false;
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> sumQueue = new LinkedList<>();
		queue.offer(root);
		sumQueue.offer(root.val);
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.poll();
				Integer sum = sumQueue.poll();
				if (node.left == null && node.right == null) {
					if (sum == targetSum) {
						return true;
					}
				}
				if (node.left != null) {
					queue.offer(node.left);
					sumQueue.offer(node.left.val + sum);
				}
				if (node.right!=null){
					queue.offer(node.right);
					sumQueue.offer(node.right.val + sum);
				}
				size--;
			}
		}
		return false;
	}
}
