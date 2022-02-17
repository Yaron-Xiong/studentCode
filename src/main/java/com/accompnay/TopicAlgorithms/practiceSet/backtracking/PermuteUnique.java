package com.accompnay.TopicAlgorithms.practiceSet.backtracking;

import java.util.*;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermuteUnique {
	public static void main(String[] args) {
		PermuteUnique permuteUnique = new PermuteUnique();
		List<List<Integer>> lists = permuteUnique.permuteUnique(new int[]{1, 1, 2});
		System.out.println(lists);
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		Arrays.sort(nums);
		backtracking(nums, new LinkedList<>(), ans, new boolean[nums.length]);
		return ans;
	}

	private void backtracking(int[] nums, Deque<Integer> path, List<List<Integer>> ans, boolean[] used) {
		if (path.size() == nums.length) {
			ans.add(new ArrayList<>(path));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i] || (i >= 1 && nums[i] == nums[i - 1] && !used[i - 1])) {
				continue;
			}
			path.add(nums[i]);
			used[i] = true;
			backtracking(nums, path, ans, used);
			path.removeLast();
			used[i] = false;
		}
	}

}
