package com.yaronxiong.algorithms.practiceSet.dp.bag;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanPartition {
	public static void main(String[] args) {
		CanPartition canPartition = new CanPartition();
		boolean b = canPartition.canPartition2(new int[]{1, 2, 5});
		System.out.println(b);
	}

	public boolean canPartition2(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum % 2 != 0) {
			return false;
		}
		int halfSum = sum >> 1;
		boolean[] dp = new boolean[halfSum + 1];
		dp[0] = true;
		for (int num : nums) {
			//为什么这里是从大到小 而换硬币是从小到大呢？
			//换硬币的硬币数量是无限的 但此处的nums是有限的每次 只能使用一次
			//故此处需要使用上一层的dp结果
			for (int j = halfSum; j >= 0; j--) {
				if (j - num >= 0)
					dp[j] = dp[j] || dp[j - num];
			}
		}
		return dp[halfSum];
	}

	private int leftRes = 0;
	private int rightRes = 0;

	public boolean canPartition(int[] nums) {
		for (int num : nums) {
			leftRes += num;
		}
		return dp(nums, 0);
	}

	private boolean dp(int[] nums, int i) {
		if (i >= nums.length) {
			return false;
		}
		//right 不能大于left
		if (rightRes > leftRes) {
			return false;
		}
		if (leftRes == rightRes) {
			return true;
		}
		for (int j = i; j < nums.length; j++) {
			leftRes -= nums[j];
			rightRes += nums[j];
			if (dp(nums, j + 1)) {
				return true;
			}
			leftRes += nums[j];
			rightRes -= nums[j];
		}
		return false;
	}

}
