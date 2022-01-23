package com.accompnay.TopicAlgorithms.practiceSet.backtracking;

import java.util.*;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubsetsWithDup {
	public static void main(String[] args) {
		SubsetsWithDup subsetsWithDup = new SubsetsWithDup();
		List<List<Integer>> lists = subsetsWithDup.subsetsWithDup(new int[]{2, 1, 2});
		System.out.println(lists);
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		//为什么要排序呢？
		//因为如果不排序的话，不能保证去除同一层的重复元素
		//像 212 和 122
		//212 : 2、21、212、22、1、12、2
		//122 : 1、12、122、12、2、22、2
		Arrays.sort(nums);
		backtracking(nums, 0, new LinkedList<>(), ans);
		return ans;
	}

	public void backtracking(int[] nums, int index, Deque<Integer> path, List<List<Integer>> ans) {
		ans.add(new ArrayList<>(path));
		if (index >= nums.length) return;

		for (int i = index; i < nums.length; i++) {
			if (i - 1 >= index && nums[i] == nums[i - 1]) {
				continue;
			}
			path.add(nums[i]);
			backtracking(nums, i + 1, path, ans);
			path.removeLast();
		}
	}
}
