package com.accompnay.TopicAlgorithms.practiceSet.dp;

/**
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * 进阶：
 * <p>
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LengthOfLIS {
	public static void main(String[] args) {
		LengthOfLIS lengthOfLIS = new LengthOfLIS();
		int i = lengthOfLIS.lengthOfLIS2(new int[]{7, 7, 7, 7, 7, 7, 7});
		System.out.println(i);
	}

	private int[] bucket;
	private int bucketCount;

	public int lengthOfLIS2(int[] nums) {
		bucket = new int[nums.length];
		bucketCount = 0;
		for (int num : nums) {
			int index = findIndex(num);
			if (index < 0) {
				bucketCount++;
				index = bucketCount - 1;
			}
			bucket[index] = num;
		}
		return bucketCount;
	}

	/**
	 * 从左到右找到第一个大于value值的桶
	 */
	public int findIndex(int value) {
		int left = 0;
		int right = bucketCount;
		while (left < right) {
			int mid = (left + right) >> 1;
			if (value > bucket[mid]) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left == bucketCount ? -1 : left;
	}


	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			int dpI = find(nums, dp, i);
			dp[i] = dpI == 0 ? 1 : dpI + 1;
		}
		int max = 0;
		for (int i : dp) {
			max = Math.max(max, i);
		}
		return max;
	}

	public int find(int[] nums, int[] dp, int index) {
		int maxDp = 0;
		for (int i = 0; i < index; i++) {
			if (nums[i] < nums[index]) {
				maxDp = Math.max(maxDp, dp[i]);
			}
		}
		return maxDp;
	}

}
