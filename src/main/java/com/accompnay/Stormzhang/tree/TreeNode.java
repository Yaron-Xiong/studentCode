package com.accompnay.Stormzhang.tree;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TreeNode{");
		sb.append("val=").append(val);
		sb.append(", left=").append(left);
		sb.append(", right=").append(right);
		sb.append('}');
		return sb.toString();
	}

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
