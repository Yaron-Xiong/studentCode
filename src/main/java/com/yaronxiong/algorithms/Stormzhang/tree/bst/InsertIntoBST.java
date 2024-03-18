package com.yaronxiong.algorithms.Stormzhang.tree.bst;

import com.yaronxiong.algorithms.Stormzhang.tree.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * <p>
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
 * 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [4,2,7,1,3], val = 5
 * 输出：[4,2,7,1,3,5]
 * 解释：另一个满足题目要求可以通过的树是：
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [40,20,60,10,30,50,70], val = 25
 * 输出：[40,20,60,10,30,50,70,null,null,25]
 * 示例 3：
 * <p>
 * 输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
 * 输出：[4,2,7,1,3,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的树上的节点数介于 0 和 10^4 之间
 * 每个节点都有一个唯一整数值，取值范围从 0 到 10^8
 * -10^8 <= val <= 10^8
 * 新值和原始二叉搜索树中的任意节点值都不同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertIntoBST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(14);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(7);
		InsertIntoBST insertIntoBST = new InsertIntoBST();
		TreeNode treeNode = insertIntoBST.insertIntoBST(root, 4);
		System.out.println(treeNode);
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if (root == null) return new TreeNode(val);
		if (val > root.val) {
			root.right = insertIntoBST(root.right, val);
		} else if (val < root.val) {
			root.left = insertIntoBST(root.left, val);
		}
		return root;
	}
}
