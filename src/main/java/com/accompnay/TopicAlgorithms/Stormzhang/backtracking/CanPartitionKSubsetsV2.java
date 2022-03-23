package com.accompnay.TopicAlgorithms.Stormzhang.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
		boolean b = canPartitionKSubsets.canPartitionKSubsets(new int[]{129, 17, 74, 57, 1421, 99, 92, 285, 1276, 218, 1588, 215, 369, 117, 153, 22}, 3);
		System.out.println(b);
	}

	public boolean canPartitionKSubsets(int[] nums, int k) {
		if (k > nums.length) return false;
		int count = 0;
		for (int item : nums) {
			count += item;
		}
		if (count % k != 0) {
			return false;
		}
		Arrays.sort(nums);
		int target = count / k;
		return backtracking(nums, 0, 0, 0, target, 0, k);
	}

	private Map<Integer, Boolean> memo = new HashMap<>();

	private boolean backtracking(int[] nums, int bucket, int bucketValue, int index, int target, int used, int k) {
		if (bucket == k) {
			return true;
		}
		if (bucketValue == target) {
			return backtracking(nums, bucket + 1, 0, 0, target, used, k);
		}
		for (int i = index; i < nums.length; i++) {
			if ((used >> i & 1) == 1) {
				continue;
			}
			if (nums[i] + bucketValue > target) {
				break;
			}
			bucketValue += nums[i];
			used = used | 1 << i;
			boolean backtracking = memo.containsKey(used) ? memo.get(used) : backtracking(nums, bucket, bucketValue, i + 1, target, used, k);
			memo.put(used, backtracking);
			if (backtracking) {
				return true;
			}
			used = used ^ 1 << i;
			bucketValue -= nums[i];
		}
		return false;
	}

}
