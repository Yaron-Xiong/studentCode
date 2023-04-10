package com.accompnay.TopicAlgorithms.leetcode;

import java.util.Arrays;

/**
 * 1000. 合并石头的最低成本
 * 困难
 * 242
 * 相关企业
 * 有 N 堆石头排成一排，第 i 堆中有 stones[i] 块石头。
 * <p>
 * 每次移动（move）需要将连续的 K 堆石头合并为一堆，而这个移动的成本为这 K 堆石头的总数。
 * <p>
 * 找出把所有石头合并成一堆的最低成本。如果不可能，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [3,2,4,1], K = 2
 * 输出：20
 * 解释：
 * 从 [3, 2, 4, 1] 开始。
 * 合并 [3, 2]，成本为 5，剩下 [5, 4, 1]。
 * 合并 [4, 1]，成本为 5，剩下 [5, 5]。
 * 合并 [5, 5]，成本为 10，剩下 [10]。
 * 总成本 20，这是可能的最小值。
 * 示例 2：
 * <p>
 * 输入：stones = [3,2,4,1], K = 3
 * 输出：-1
 * 解释：任何合并操作后，都会剩下 2 堆，我们无法再进行合并。所以这项任务是不可能完成的。.
 * 示例 3：
 * <p>
 * 输入：stones = [3,5,1,2,6], K = 3
 * 输出：25
 * 解释：
 * 从 [3, 5, 1, 2, 6] 开始。
 * 合并 [5, 1, 2]，成本为 8，剩下 [3, 8, 6]。
 * 合并 [3, 8, 6]，成本为 17，剩下 [17]。
 * 总成本 25，这是可能的最小值。
 * <p>
 * 提示：
 * <p>
 * 1 <= stones.length <= 30
 * 2 <= K <= 30
 * 1 <= stones[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-cost-to-merge-stones/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1000_MergeStones {
	public static void main(String[] args) {
		L1000_MergeStones l1000MergeStones = new L1000_MergeStones();
		System.out.println(l1000MergeStones.mergeStones(new int[]{3, 2, 4, 1}, 3));
	}

	int[] preStonesSum;
	int[][][] memo;
	int k;

	public int mergeStones(int[] stones, int k) {
		if ((stones.length - 1) % (k - 1) > 0) // 无法合并成一堆
			return -1;
		this.k = k;
		preStonesSum = new int[stones.length + 1];
		for (int i = 0; i < stones.length; i++) {
			preStonesSum[i + 1] = preStonesSum[i] + stones[i];
		}
		memo = new int[stones.length][stones.length][k + 1];
		for (int[][] ints : memo) {
			for (int[] anInt : ints) {
				Arrays.fill(anInt, -1);
			}
		}
		return dfs(0, stones.length - 1, 1);
	}

	private int dfs(int i, int j, int p) {
		if (memo[i][j][p] != -1) {
			return memo[i][j][p];
		}
		if (p == 1) {
			//说明当前构成最小合并单位
			//1堆的构成是由k堆 合并成一堆
			return memo[i][j][p] = i == j ? 0 : dfs(i, j, k) + preStonesSum[j + 1] - preStonesSum[i];
		}
		int res = Integer.MAX_VALUE;
		for (int m = i; m < j; m = m + k - 1) {
			res = Math.min(res, dfs(i, m, 1) + dfs(m + 1, j, p - 1));
		}
		return memo[i][j][p] = res;
	}
}
