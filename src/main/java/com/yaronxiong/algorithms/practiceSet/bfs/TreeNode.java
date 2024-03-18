package com.yaronxiong.algorithms.practiceSet.bfs;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode() {
	}

	public TreeNode(int val) {
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder("TreeNode{");
		sb.append("val=").append(val);
		sb.append(", left=").append(left);
		sb.append(", right=").append(right);
		sb.append('}');
		return sb.toString();
	}
}
