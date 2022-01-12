package com.accompnay.TopicAlgorithms.swordFingerOffer.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 37. 序列化二叉树:https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例：
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 */
public class Codec {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		if (root==null) return "[]";
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		StringBuilder builder = new StringBuilder();
		builder.append('[');
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			String value = node == null ? "null" : String.valueOf(node.val);
			builder.append(value);
			builder.append(',');
			if (node != null) {
				queue.add(node.left);
				queue.add(node.right);
			}
		}
		builder.deleteCharAt(builder.length() - 1);
		builder.append(']');
		return builder.toString();
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		if (data == null || data.length() < 2 || data.equals("[]")) return null;
		String[] strings = data.substring(1, data.length() - 1).split(",");
		TreeNode root = new TreeNode(Integer.parseInt(strings[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int index = 1;
		while (index < strings.length && !queue.isEmpty()) {
			TreeNode node = queue.poll();
			if (!strings[index].equals("null")) {
				node.left = new TreeNode(Integer.parseInt(strings[index]));
				queue.add(node.left);
			}
			index++;
			if (!strings[index].equals("null")) {
				node.right = new TreeNode(Integer.parseInt(strings[index]));
				queue.add(node.right);
			}
			index++;
		}
		return root;
	}

	public static void main(String[] args) {
		Codec codec = new Codec();
		String data = "[1,2,3,null,null,4,5]";
		String serialize = codec.serialize(null);
		TreeNode node = codec.deserialize(serialize);
		System.out.println(serialize);
		System.out.println(node);
	}
}
