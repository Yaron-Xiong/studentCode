package com.yaronxiong.algorithms.practiceSet.tree.search.searchTree.modifiyConstru;

import com.yaronxiong.algorithms.practiceSet.tree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortedArrayToBST {
	public static void main(String[] args) {
		SortedArrayToBST sortedArrayToBST = new SortedArrayToBST();
		TreeNode node = sortedArrayToBST.sortedArrayToBST(new int[]{1,3});
		System.out.println(node);
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return builder(nums, 0, nums.length - 1);
	}

	private TreeNode builder(int[] nums, int start, int end) {
		if (start > end) return null;
		int mid = (start + end) >> 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = builder(nums, start, mid - 1);
		root.right = builder(nums, mid + 1, end);
		return root;
	}

}
