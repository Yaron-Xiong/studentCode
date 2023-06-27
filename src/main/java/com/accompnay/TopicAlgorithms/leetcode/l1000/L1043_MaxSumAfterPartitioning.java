package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 1043. 分隔数组以得到最大和
 * 提示
 * 中等
 * 235
 * 相关企业
 * 给你一个整数数组 arr，请你将该数组分隔为长度 最多 为 k 的一些（连续）子数组。分隔完成后，每个子数组的中的所有值都会变为该子数组中的最大值。
 * <p>
 * 返回将数组分隔变换后能够得到的元素最大和。本题所用到的测试用例会确保答案是一个 32 位整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,15,7,9,2,5,10], k = 3
 * 输出：84
 * 解释：数组变为 [15,15,15,9,10,10,10]
 * 示例 2：
 * <p>
 * 输入：arr = [1,4,1,5,7,3,6,1,9,9,3], k = 4
 * 输出：83
 * 示例 3：
 * <p>
 * 输入：arr = [1], k = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 500
 * 0 <= arr[i] <= 109
 * 1 <= k <= arr.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/partition-array-for-maximum-sum/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1043_MaxSumAfterPartitioning {

	public static void main(String[] args) {
		L1043_MaxSumAfterPartitioning l1043MaxSumAfterPartitioning = new L1043_MaxSumAfterPartitioning();
		int x = l1043MaxSumAfterPartitioning.maxSumAfterPartitioning(new int[]{1, 4, 1, 5, 7, 3, 6, 1, 9, 9, 3}, 4);
		System.out.println(x);
	}

	int[] arr;
	int k;
	int[] dp;

	public int maxSumAfterPartitioning(int[] arr, int k) {
		this.arr = arr;
		this.k = k;
		this.dp = new int[arr.length];
		return dfs(0);
	}

	private int dfs(int left) {
		if (left >= arr.length) {
			return 0;
		}
		if (dp[left] != 0) {
			return dp[left];
		}
		//left+k 是否能够构成一个组
		int mx = arr[left];
		int res = Integer.MIN_VALUE;
		for (int i = left; i < left + k && i < arr.length; i++) {
			mx = Math.max(arr[i], mx);
			res = Math.max((i - left + 1) * mx + dfs(i + 1), res);
		}
		return dp[left] = res;
	}
}
