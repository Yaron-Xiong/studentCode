package com.accompnay.TopicAlgorithms.practiceSet.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * <p>
 * 找出所有相加之和为n 的k个数的组合。
 * 组合中只允许含有 1 -9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSum3 {

	public static void main(String[] args) {
		CombinationSum3 combinationSum3 = new CombinationSum3();
		List<List<Integer>> lists = combinationSum3.combinationSum3(3, 7);
		System.out.println(lists);
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> res = new ArrayList<>();
		backtracking(k, n, 1, new LinkedList<>(), 0, res);
		return res;
	}


	public void backtracking(int k, int n, int index, Deque<Integer> path, int sum, List<List<Integer>> res) {
		if (path.size() == k) {
			if (sum == n) {
				res.add(new LinkedList<>(path));
			}
			return;
		}
		for (int i = index; i <= 9 - (k - path.size()) + 1 && sum + i <= n; i++) {
			path.add(i);
			backtracking(k, n, i + 1, path, sum + i, res);
			path.removeLast();
		}
	}
}
