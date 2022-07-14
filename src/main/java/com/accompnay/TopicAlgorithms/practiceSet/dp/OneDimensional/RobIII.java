package com.accompnay.TopicAlgorithms.practiceSet.dp.OneDimensional;

import java.util.HashMap;
import java.util.Map;

/**
 * 337. 打家劫舍 III
 * 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。
 * <p>
 * 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
 * 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。
 * <p>
 * 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,2,3,null,3,null,1]
 * 输出: 7
 * 解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 * 示例 2:
 * <p>
 * 输入: root = [3,4,5,1,3,null,1]
 * 输出: 9
 * 解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
 * <p>
 * 提示：
 * <p>
 * 树的节点数在 [1, 104] 范围内
 * 0 <= Node.val <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/house-robber-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RobIII {

	public static class TreeNode {
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

	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(3);
		root.right = new TreeNode(3);
		root.right.right = new TreeNode(1);
		RobIII rob = new RobIII();
		int rob1 = rob.rob2(root);
		System.out.println(rob1);
	}

	public int rob2(TreeNode root) {
		int[] res = dp2(root);
		return Math.max(res[0], res[1]);
	}

	private int[] dp2(TreeNode root) {
		if (root == null) {
			return new int[]{0, 0};
		}
		int[] left = dp2(root.left);
		int[] right = dp2(root.right);
		int rob = root.val + left[1] + right[1];
		int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		//0代表抢了root 1代表没有抢
		return new int[]{rob, not_rob};
	}

	private Map<TreeNode, Integer> memo = new HashMap<>();

	public int rob(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (memo.containsKey(root)) {
			return memo.get(root);
		}
		//当前节点选择偷
		int val = root.val;
		if (root.left != null) {
			val += rob(root.left.left) + rob(root.left.right);
		}
		if (root.right != null) {
			val += rob(root.right.left) + rob(root.right.right);
		}
		//当前节点选择不偷
		int val2 = rob(root.left) + rob(root.right);
		int res = Math.max(val, val2);
		memo.put(root, res);
		return res;
	}

}
