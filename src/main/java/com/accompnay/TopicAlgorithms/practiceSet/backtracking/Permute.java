package com.accompnay.TopicAlgorithms.practiceSet.backtracking;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Permute {
	public static void main(String[] args) {
		Permute permute = new Permute();
		List<List<Integer>> permute1 = permute.permute(new int[]{1, 2, 3});
		System.out.println(permute1);
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtracking(nums, new LinkedList<>(), res);
		return res;
	}

	private void backtracking(int[] nums, Deque<Integer> path, List<List<Integer>> res) {
		if (path.size() == nums.length){
			res.add(new ArrayList<>(path));
			return;
		}
		for (int num : nums) {
			if (path.contains(num)) {
				continue;
			}
			path.add(num);
			backtracking(nums, path, res);
			path.removeLast();
		}
	}
}
