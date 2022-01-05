package com.accompnay.Stormzhang.backtracking;

/**
 * 698. 划分为k个相等的子集:https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= len(nums) <= 16
 * 0 < nums[i] < 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-to-k-equal-sum-subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartitionKSubsets {
	public static void main(String[] args) {
		CanPartitionKSubsets canPartitionKSubsets = new CanPartitionKSubsets();
		canPartitionKSubsets.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
	}

	private int[] bucket;

	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k > nums.length) return false;
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		//如果总和 不能被K整除 代表都不可能被划分到k个桶中

		if (sum % k != 0) return false;
		bucket = new int[k];
		int target = sum / k;
		return backtracking(nums, 0, target);
	}

	private boolean backtracking(int[] nums, int index, int target) {
		if (index == nums.length) {
			for (int bucketValue : bucket) {
				if (bucketValue != target) {
					return false;
				}
			}
			return true;
		}
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] + nums[index] > target) continue;
			bucket[i] += nums[index];
			if (backtracking(nums, index + 1, target)) {
				return true;
			}
			bucket[i] -= nums[index];
		}

		return false;
	}

}
