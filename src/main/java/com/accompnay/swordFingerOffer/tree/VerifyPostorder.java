package com.accompnay.swordFingerOffer.tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 */
public class VerifyPostorder {

	int index;
	int[] postorder;
	private Map<Integer, Integer> map;

	/**
	 * 排序找到中序遍历数组，通过对比中后序数组，判断是否为一棵树
	 */
	public boolean verifyPostorder(int[] postorder) {
		int[] pre = Arrays.copyOf(postorder, postorder.length);
		Arrays.sort(pre);
		this.postorder = postorder;
		this.index = postorder.length - 1;
		map = new HashMap<>();
		for (int i = 0; i < pre.length; i++) {
			map.put(pre[i], i);
		}
		return verify(0, postorder.length - 1);
	}

	public boolean verify(int left, int right) {
		if (left > right) return true;
		int root = postorder[index--];
		Integer rootIndex = map.get(root);
		if (rootIndex < left || rootIndex > right) return false;
		return verify(rootIndex + 1, right) && verify(left, rootIndex - 1);
	}


	/**
	 * 通过二叉搜索树后序遍历的特点，left->mid 都是小于 root mid->right 都是大于root的
	 */
	public boolean verifyPostorder2(int[] postorder) {
		return verify2(postorder, 0, postorder.length - 1);
	}

	public boolean verify2(int[] postorder, int left, int right) {
		if (left >= right) return true;
		int p = left;
		while (postorder[p] < postorder[right]) p++;
		int mid = p;
		while (postorder[p] > postorder[right]) p++;
		return p == right && verify2(postorder, left, mid - 1) && verify2(postorder, mid, right - 1);
	}

	/**
	 * 单调栈
	 */
	public boolean verifyPostorder3(int[] postorder) {
		Stack<Integer> stack = new Stack<>();
		int root = Integer.MAX_VALUE;
		for (int i = postorder.length - 1; i >= 0; i--) {
			if (postorder[i] > root) return false;
			while (!stack.isEmpty() && stack.peek() > postorder[i])
				root = stack.pop();
			stack.add(postorder[i]);
		}
		return true;
	}

	public static void main(String[] args) {
		VerifyPostorder verifyPostorder = new VerifyPostorder();
		boolean b = verifyPostorder.verifyPostorder2(new int[]{7, 4, 6, 5});
		System.out.println(b);
	}
}
