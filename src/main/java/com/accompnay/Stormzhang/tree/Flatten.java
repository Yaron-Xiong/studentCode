package com.accompnay.Stormzhang.tree;

/**
 * 114. 二叉树展开为链表:https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,5,3,4,null,6]
 * 输出：[1,null,2,null,3,null,4,null,5,null,6]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Flatten {
	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(2);
		treeNode.left.left = new TreeNode(3);
		treeNode.left.right = new TreeNode(4);
		treeNode.right = new TreeNode(5);
		treeNode.right.right = new TreeNode(6);
		Flatten flatten = new Flatten();
		flatten.flatten(treeNode);
		System.out.println();
	}

	public void flatten(TreeNode root) {
		if (root == null) return;
		flatten(root.left);
		flatten(root.right);
		TreeNode rightParent = root.left;
		if (rightParent == null) return;
		while (rightParent.right != null) {
			rightParent = rightParent.right;
		}
		rightParent.right = root.right;
		root.right = root.left;
		root.left = null;
	}
}
