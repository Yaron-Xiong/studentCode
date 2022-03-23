package com.accompnay.TopicAlgorithms.practiceSet.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 * 你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Subsets {
	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		List<List<Integer>> subsets1 = subsets.subsets(new int[]{1, 2, 3});
		System.out.println(subsets1);
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(new ArrayList<>());
		backtracking(nums, 0, new LinkedList<>(), result);
		return result;
	}

	private void backtracking(int[] nums, int index, Deque<Integer> path, List<List<Integer>> result) {
		//控制可选列表
		if (index == nums.length) {
			return;
		}
		for (int i = index; i < nums.length; i++) {
			path.add(nums[i]);
			result.add(new ArrayList<>(path));
			backtracking(nums, i + 1, path, result);
			path.removeLast();
		}
	}
}
