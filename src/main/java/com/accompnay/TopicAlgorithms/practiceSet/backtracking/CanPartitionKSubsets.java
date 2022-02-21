package com.accompnay.TopicAlgorithms.practiceSet.backtracking;

/**
 * 698. 划分为k个相等的子集
 * <p>
 * 给定一个整数数组nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * 输出： True
 * 说明： 有可能将其分成 4 个子集（5），（1,4），（2,3），（2,3）等于总和。
 * <p>
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
		boolean b = canPartitionKSubsets.canPartitionKSubsets2(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
		System.out.println(b);
	}

	/**
	 * 做法：
	 *  每个桶的目标，当装到了某个值就递归下个桶
	 *
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean canPartitionKSubsets2(int[] nums, int k) {
		//合法性判断
		if (nums.length < k) return false;
		int sum = 0;
		for (int num : nums) sum += num;
		if (sum % k != 0) return false;
		int target = sum / k;
		//递归目标每个桶都能装到target值
		return backtracking2(nums, target, k, 0, 0, new boolean[nums.length]);
	}

	public boolean backtracking2(int[] nums, int target, int k, int bucket, int start, boolean[] used) {
		if (k == 0) return true;
		if (target == bucket) return backtracking2(nums, target, k - 1, 0, 0, used);
		for (int i = start; i < nums.length; i++) {
			if (used[i]) continue;
			if (bucket + nums[i] > target) continue;
			used[i] = true;
			if (backtracking2(nums, target, k, bucket + nums[i], i, used)) {
				return true;
			}
			used[i] = false;
		}
		return false;
	}


	/**
	 * 将数字放进桶里
	 */
	public boolean canPartitionKSubsets(int[] nums, int k) {
		int[] kBuk = new int[k];
		return backtracking(nums, 0, kBuk);
	}

	private boolean backtracking(int[] nums, int i, int[] kBuk) {
		if (i == nums.length) {
			int min = kBuk[0];
			int max = kBuk[0];
			for (int j : kBuk) {
				min = Math.min(j, min);
				max = Math.max(j, max);
			}
			return max == min;
		}
		for (int j = 0; j < kBuk.length; j++) {
			kBuk[j] = kBuk[j] + nums[i];
			if (backtracking(nums, i + 1, kBuk)) {
				return true;
			}
			kBuk[j] = kBuk[j] - nums[i];
		}
		return false;
	}
}
