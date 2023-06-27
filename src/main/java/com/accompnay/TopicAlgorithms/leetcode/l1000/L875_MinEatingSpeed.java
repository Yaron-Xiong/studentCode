package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 875. 爱吃香蕉的珂珂
 * 中等
 * 482
 * 相关企业
 * 珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 h 小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 k 根。
 * 如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [3,6,7,11], h = 8
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 5
 * 输出：30
 * 示例 3：
 * <p>
 * 输入：piles = [30,11,23,4,20], h = 6
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 104
 * piles.length <= h <= 109
 * 1 <= piles[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/koko-eating-bananas/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L875_MinEatingSpeed {
	public static void main(String[] args) {
		L875_MinEatingSpeed l875MinEatingSpeed = new L875_MinEatingSpeed();
		System.out.println(l875MinEatingSpeed.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 5));
	}

	public int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int right = Arrays.stream(piles).max().getAsInt();
		while (left < right) {
			int mid = (left + right) >>> 1;
			//mid变大 check变小
			int check = check(piles, mid);
			if (check > h) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

	/**
	 * 假设我每次能吃target个我要吃多少个小时
	 */
	private int check(int[] piles, int target) {
		int res = 0;
		for (int pile : piles) {
			res += (pile + target - 1) / target;
		}
		return res;
	}
}
