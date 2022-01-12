package com.accompnay.TopicAlgorithms.Stormzhang.backtracking;
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

import java.util.ArrayList;
import java.util.List;

public class Permute {
	public static void main(String[] args) {
		Permute permute = new Permute();
		List<List<Integer>> permute1 = permute.permute(new int[]{1, 2, 3});
		System.out.println(permute1);
	}

	private List<Integer> temp;
	private List<List<Integer>> res;

	public List<List<Integer>> permute(int[] nums) {
		res = new ArrayList<>();
		temp = new ArrayList<>();
		backtracking(nums);
		return res;
	}

	public void backtracking(int[] nums) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}

		for (int i = 0; i < nums.length; i++) {
			if (temp.contains(nums[i])) {
				continue;
			}
			temp.add(nums[i]);
			backtracking(nums);
			temp.remove(Integer.valueOf(nums[i]));
		}
	}
}
