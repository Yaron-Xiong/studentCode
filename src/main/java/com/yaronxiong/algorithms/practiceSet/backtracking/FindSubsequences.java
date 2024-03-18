package com.yaronxiong.algorithms.practiceSet.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 491. 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。
 * 你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,6,7,7]
 * 输出：[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,3,2,1]
 * 输出：[[4,4]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 15
 * -100 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/increasing-subsequences
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubsequences {
	public static void main(String[] args) {
		FindSubsequences findSubsequences = new FindSubsequences();
		List<List<Integer>> subsequences = findSubsequences.findSubsequences(new int[]{4, 6, 7, 7});
		System.out.println(subsequences);
	}

	public List<List<Integer>> findSubsequences(int[] nums) {
		if (nums == null || nums.length < 2) {
			return new ArrayList<>();
		}
		List<List<Integer>> ans = new ArrayList<>();
		backtracking(nums, 0, new LinkedList<>(), ans);
		return ans;
	}

	private void backtracking(int[] nums, int index, Deque<Integer> path, List<List<Integer>> ans) {
		if (path.size() > 1) ans.add(new ArrayList<>(path));
		if (index >= nums.length) {
			return;
		}
		int[] used = new int[201];
		int last;
		for (int i = index; i < nums.length; i++) {
			if (used[nums[i] + 100] == 1 || (!path.isEmpty() && path.peekLast() > nums[i])) {
				continue;
			}
			path.add(nums[i]);
			used[nums[i] + 100] = 1;
			backtracking(nums, i + 1, path, ans);
			path.removeLast();
		}
	}

}
