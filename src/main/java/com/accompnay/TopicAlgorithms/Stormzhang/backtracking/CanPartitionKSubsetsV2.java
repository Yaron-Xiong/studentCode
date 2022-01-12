package com.accompnay.TopicAlgorithms.Stormzhang.backtracking;

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
public class CanPartitionKSubsetsV2 {
	public static void main(String[] args) {
		CanPartitionKSubsetsV2 canPartitionKSubsets = new CanPartitionKSubsetsV2();
		boolean b = canPartitionKSubsets.canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4);
		System.out.println(b);
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k > nums.length) return false;
		int sum = 0;
		for (int num : nums) sum += num;
		//如果总和 不能被K整除 代表都不可能被划分到k个桶中
		if (sum % k != 0) return false;
		boolean[] used = new boolean[nums.length];
		int target = sum / k;
		int bucket = 0;
		return backtrack(k, bucket, nums, 0, used, target);
	}

	/**
	 * @param k      第几个桶
	 * @param bucket 当前桶容量
	 * @param nums   数组
	 * @param start  当前变量的数组下表
	 * @param used   已使用的数组
	 * @param target 目标值
	 * @return 是否能匹配
	 */
	private boolean backtrack(int k, int bucket, int[] nums, int start, boolean[] used, int target) {
		// k==0 说明所有的桶都等于了target
		if (k == 0) return true;
		// 如果桶中的值等于目标值，当前桶已经装完了
		if (bucket == target) return backtrack(k - 1, 0, nums, 0, used, target);
		//以下的意义在于 k 这个桶从 0~nums.length中选择一个数字
		for (int i = start; i < nums.length; i++) {
			if (used[i]) continue;
			if (nums[i] + bucket > target) continue;
			used[i] = true;
			bucket += nums[i];
			if (backtrack(k, bucket, nums, i + 1, used, target)) {
				return true;
			}
			used[i] = false;
			bucket -= nums[i];
		}
		return false;
	}

}
