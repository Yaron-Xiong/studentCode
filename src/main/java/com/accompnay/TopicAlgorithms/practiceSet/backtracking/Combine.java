package com.accompnay.TopicAlgorithms.practiceSet.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, k = 2
 * 输出：
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * 示例 2：
 * <p>
 * 输入：n = 1, k = 1
 * 输出：[[1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * 1 <= k <= n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Combine {

	public static void main(String[] args) {
		Combine combine = new Combine();
		List<List<Integer>> lists = combine.combine(4, 3);
		System.out.println(lists);

	}

	private List<List<Integer>> res = new ArrayList<>();

	public List<List<Integer>> combine(int n, int k) {
		backtracking(n, 1, k, new LinkedList<>());
		return res;
	}

	public void backtracking(int n, int curN, int k, Deque<Integer> path) {
		if (path.size() == k) {
			res.add(new ArrayList<>(path));
			return;
		}
		for (int i = curN; i <= n - (k - path.size()) + 1; i++) {
			path.add(i);
			backtracking(n, i + 1, k, path);
			path.removeLast();
		}
	}

}
