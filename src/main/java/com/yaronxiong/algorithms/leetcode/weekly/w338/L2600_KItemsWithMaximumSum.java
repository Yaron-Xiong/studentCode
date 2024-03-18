package com.yaronxiong.algorithms.leetcode.weekly.w338;

/**
 * 6354. K 件物品的最大和
 * 提示
 * 简单
 * 3
 * 相关企业
 * 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
 * <p>
 * 给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
 * <p>
 * 袋子最初包含：
 * <p>
 * numOnes 件标记为 1 的物品。
 * numZeroes 件标记为 0 的物品。
 * numNegOnes 件标记为 -1 的物品。
 * 现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
 * 输出：2
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 2 件标记为 1 的物品，得到的数字之和为 2 。
 * 可以证明 2 是所有可行方案中的最大值。
 * 示例 2：
 * <p>
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4
 * 输出：3
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 3 件标记为 1 的物品，1 件标记为 0 的物品，得到的数字之和为 3 。
 * 可以证明 3 是所有可行方案中的最大值。
 * <p>
 * 提示：
 * <p>
 * 0 <= numOnes, numZeros, numNegOnes <= 50
 * 0 <= k <= numOnes + numZeros + numNegOnes
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/k-items-with-the-maximum-sum/solutions/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2600_KItemsWithMaximumSum {

	public static void main(String[] args) {
		L2600_KItemsWithMaximumSum l6354KItemsWithMaximumSum = new L2600_KItemsWithMaximumSum();
		System.out.println(l6354KItemsWithMaximumSum.kItemsWithMaximumSum(3, 2, 2, 8));
	}

	public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
		int res = Math.min(k, numOnes);
		k -= numOnes;
		if (k <= 0) {
			return res;
		}
		k -= numZeros;
		if (k <= 0) {
			return res;
		}
		if (k >= numNegOnes) {
			res -= numNegOnes;
		} else {
			res -= k;
		}
		return res;
	}
}
