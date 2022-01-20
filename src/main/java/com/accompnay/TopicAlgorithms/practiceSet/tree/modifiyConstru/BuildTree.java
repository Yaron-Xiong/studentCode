package com.accompnay.TopicAlgorithms.practiceSet.tree.modifiyConstru;

import com.accompnay.TopicAlgorithms.practiceSet.tree.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder =[9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTree {
	public static void main(String[] args) {
		BuildTree buildTree = new BuildTree();
		TreeNode node = buildTree.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
		System.out.println(node);
	}

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, postorder.length - 1, postorder, 0, postorder.length - 1);
	}

	private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if (inStart > inEnd) return null;
		if (postStart > postEnd) return null;
		TreeNode root = new TreeNode(postorder[postEnd]);
		int i = -1;
		for (int i1 = 0; i1 < inorder.length; i1++) {
			if (inorder[i1] == root.val) {
				i = i1;
				break;
			}
		}
		root.left = buildTree(inorder, inStart, i - 1, postorder, postStart, (i - inStart) + postStart - 1);
		root.right = buildTree(inorder, i + 1, inEnd, postorder, (i - inStart) + postStart, postEnd - 1);
		return root;
	}

}
