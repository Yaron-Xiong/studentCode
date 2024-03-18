package com.yaronxiong.algorithms.Stormzhang.array.search;

/**
 * 875. 爱吃香蕉的珂珂：https://leetcode-cn.com/problems/koko-eating-bananas/
 * 珂珂喜欢吃香蕉。这里有N堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在H小时后回来。
 * <p>
 * 珂珂可以决定她吃香蕉的速度K（单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。
 * 如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
 * <p>
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 * <p>
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: piles = [3,6,7,11], H = 8
 * 输出: 4
 * 示例2：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 5
 * 输出: 30
 * 示例3：
 * <p>
 * 输入: piles = [30,11,23,4,20], H = 6
 * 输出: 23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/koko-eating-bananas
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinEatingSpeed {
	public int minEatingSpeed(int[] piles, int h) {
		int left = 1;
		int rightMax = 1000000000;
		int right = rightMax;
		int mid;
		while (left <= right) {
			mid = left + right >> 1;
			int f = f(piles, mid);
			if (f == h) {
				right = mid - 1;
			} else if (f < h) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		if (left > rightMax) {
			return -1;
		}
		return left;
	}

	private int f(int[] piles, int x) {
		int result = 0;
		for (int pile : piles) {
			result += (pile - 1) / x + 1;
		}
		return result;
	}

	public static void main(String[] args) {
		MinEatingSpeed minEatingSpeed = new MinEatingSpeed();
		int i = minEatingSpeed.minEatingSpeed(new int[]{312884470}, 312884469);
		System.out.println(i);
	}
}
