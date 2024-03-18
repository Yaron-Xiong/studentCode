package com.yaronxiong.algorithms.practiceSet.backtracking;

/**
 * 494. 目标和
 * 给你一个整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindTargetSumWays {
	public static void main(String[] args) {
		FindTargetSumWays findTargetSumWays = new FindTargetSumWays();
		int targetSumWays = findTargetSumWays.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
		System.out.println(targetSumWays);
	}

	private int res = 0;

	public int findTargetSumWays(int[] nums, int target) {
		backtracking(nums, target, 0, 0);
		return res;
	}

	private void backtracking(int[] nums, int target, int index, int curNumber) {
		if (index >= nums.length) {
			if (curNumber == target)
				res++;
		} else {
			backtracking(nums, target, index + 1, curNumber + nums[index]);
			backtracking(nums, target, index + 1, curNumber - nums[index]);
		}
	}
}
