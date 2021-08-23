package com.accompnay.swordFingerOffer.tree;

/**
 * @author yaoyuanxiong
 */
public class IsSubStructure {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "TreeNode{" +
					"val=" + val +
					'}';
		}
	}

	/*public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (B == null || A == null) {
			return false;
		}
		if (A.val == B.val && B.left != null) {
			isSubStructure(A.left, B.left);

			isSubStructure(A.right, B.right);
			return true;
		}
		boolean containsLeft = isSubStructure(A.left, B);
		boolean containsRight = isSubStructure(A.right, B);
		return containsLeft || containsRight;
	}*/

	public boolean isSubStructure(TreeNode A, TreeNode B) {
		if (A == B) {
			return true;
		}
		if (B == null || A == null) {
			return false;
		}
		boolean flag = false;
		if (A.val == B.val) {
			boolean a = true;
			if (B.left != null) {
				a = isSubStructure(A.left, B.left);
			}
			boolean b = true;
			if (B.right != null) {

				b = isSubStructure(A.right, B.right);
			}
			flag = a && b;
		}
		return flag || isSubStructure(A.left, B) || isSubStructure(A.right, B);
	}


	public static void main(String[] args) {
		TreeNode treeNode = new TreeNode(1);
		treeNode.left = new TreeNode(0);
		treeNode.right = new TreeNode(1);
		treeNode.left.left = new TreeNode(-4);
		treeNode.left.right = new TreeNode(-3);

		TreeNode treeNode1 = new TreeNode(1);
		treeNode1.left = new TreeNode(-4);
		IsSubStructure isSubStructure = new IsSubStructure();
		boolean subStructure = isSubStructure.isSubStructure(treeNode, treeNode1);
		System.out.println(subStructure);
	}
}
