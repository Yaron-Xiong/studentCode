package com.accompnay.TopicAlgorithms.practiceSet.tree.search.searchTree;

import com.accompnay.TopicAlgorithms.practiceSet.tree.TreeNode;

import java.util.*;

/**
 * 501. 二叉搜索树中的众数
 * <p>
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
 * <p>
 * 假定 BST 有如下定义：
 * <p>
 * 结点左子树中所含结点的值小于等于当前结点的值
 * 结点右子树中所含结点的值大于等于当前结点的值
 * 左子树和右子树都是二叉搜索树
 * 例如：
 * 给定 BST [1,null,2,2],
 * <p>
 * 1
 * \
 * 2
 * /
 * 2
 * 返回[2].
 * <p>
 * 提示：如果众数超过1个，不需考虑输出顺序
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-mode-in-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMode {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.left.left = new TreeNode(1);
		root.left.left.left = new TreeNode(1);
		root.left.left.left.left = new TreeNode(0);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(3);
		root.right.left.left = new TreeNode(3);

		FindMode findMode = new FindMode();
		int[] mode = findMode.findMode2(root);
		System.out.println(Arrays.toString(mode));
	}

	/**
	 * 中序遍历-二叉搜索树特性
	 */
	int curCount = 0;
	int maxCount = -1;
	TreeNode pre = null;
	List<Integer> list = new ArrayList<>();

	public int[] findMode(TreeNode root) {
		dfs(root);
		int[] ints = new int[list.size()];
		int index = 0;
		for (Integer item : list) {
			ints[index++] = item;
		}
		return ints;
	}

	public void dfs(TreeNode node) {
		if (node == null) return;
		dfs(node.left);
		if (pre == null || node.val != pre.val) {
			curCount = 1;
		} else {
			curCount++;
		}
		if (curCount > maxCount) {
			list.clear();
			list.add(node.val);
			maxCount = curCount;
		} else if (curCount == maxCount) {
			list.add(node.val);
		}
		pre = node;
		dfs(node.right);
	}

	/**
	 * 人工压栈
	 */
	public int[] findMode2(TreeNode root) {
		Deque<TreeNode> stack = new LinkedList<>();
		TreeNode pre = null;
		int curCount = 0;
		int maxCount = -1;
		List<Integer> list = new ArrayList<>();
		while (root != null || !stack.isEmpty()) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			TreeNode node = stack.poll();
			if (pre == null || pre.val != node.val) {
				curCount = 1;
			} else {
				curCount++;
			}

			if (curCount > maxCount) {
				list.clear();
				list.add(node.val);
				maxCount = curCount;
			}else if (curCount == maxCount){
				list.add(node.val);
			}

			pre = node;
			root = node.right;
		}

		int[] ints = new int[list.size()];
		int index = 0;
		for (Integer item : list) {
			ints[index++] = item;
		}
		return ints;
	}

}
