package com.yaronxiong.algorithms.practiceSet.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * 887. 鸡蛋掉落
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f， ，满足 0 <= f <= n 任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。如果鸡蛋碎了，你就不能再次使用它。
 * 如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。
 * * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 * 示例 2：
 * <p>
 * 输入：k = 2, n = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：k = 3, n = 14
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 100
 * 1 <= n <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/super-egg-drop
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SuperEggDrop {
	public static void main(String[] args) {
		SuperEggDrop superEggDrop = new SuperEggDrop();
		int i = superEggDrop.superEggDrop(3, 14);
		System.out.println(i);
	}


	public int superEggDrop(int k, int n) {
		return dp2(k, n);
	}

	private Map<Integer, Integer> memo = new HashMap<>();

	private int dp(int k, int n) {
		if (k == 1) {
			return n;
		}
		if (n == 0) {
			return 0;
		}
		Integer key = k * 100000 + n;
		if (memo.containsKey(key)) {
			return memo.get(key);
		}
		int res = Integer.MAX_VALUE;
		for (int i = 1; i <= n; i++) {
			int dp = dp(k - 1, i - 1);
			int dp1 = dp(k, n - i);
			res = Math.min(Math.max(dp, dp1) + 1, res);
		}
		memo.put(key, res);
		return res;
	}

	private Map<Integer, Integer> memo2 = new HashMap<>();

	private int dp2(int k, int n) {
		if (k == 1) {
			return n;
		}
		if (n == 0) {
			return 0;
		}
		Integer key = k * 100000 + n;
		if (memo2.containsKey(key)) {
			return memo.get(key);
		}
		int left = 1;
		int right = n;
		while (left + 1 < right) {
			int mid = (left + right) >> 1;
			int lowValue = dp2(k - 1, mid - 1);
			int highVal = dp2(k, n - mid);
			if (lowValue > highVal) {
				right = mid;
			} else if (lowValue < highVal) {
				left = mid;
			} else {
				left = right = mid;
			}
		}
		int res = 0;
		if (left == right) {
			res = 1 + Math.max(dp2(k - 1, left - 1), dp2(k, n - left));
		} else {
			int maxLeft = Math.max(dp2(k - 1, left - 1), dp2(k, n - left));
			int maxRight = Math.max(dp2(k - 1, right - 1), dp2(k, n - right));
			res = 1 + Math.min(maxLeft, maxRight);
		}
		memo.put(key, res);
		return res;
	}

}
