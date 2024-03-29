package com.yaronxiong.algorithms.practiceSet.list.binarysearch;

/**
 * 1011. 在 D 天内送达包裹的能力
 * 传送带上的包裹必须在 days 天内从一个港口运送到另一个港口。
 * <p>
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量（weights）的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 * <p>
 * 返回能在 days 天内将传送带上的所有包裹送达的船的最低运载能力。
 * <p>
 * 示例 1：
 * <p>
 * 输入：weights = [1,2,3,4,5,6,7,8,9,10], days = 5
 * 输出：15
 * 解释：
 * 船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
 * 第 1 天：1, 2, 3, 4, 5
 * 第 2 天：6, 7
 * 第 3 天：8
 * 第 4 天：9
 * 第 5 天：10
 * <p>
 * 请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) 是不允许的。
 * 示例 2：
 * <p>
 * 输入：weights = [3,2,2,4,1,4], days = 3
 * 输出：6
 * 解释：
 * 船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
 * 第 1 天：3, 2
 * 第 2 天：2, 4
 * 第 3 天：1, 4
 * 示例 3：
 * <p>
 * 输入：weights = [1,2,3,1,1], days = 4
 * 输出：3
 * 解释：
 * 第 1 天：1
 * 第 2 天：2
 * 第 3 天：3
 * 第 4 天：1, 1
 * <p>
 * 提示：
 * <p>
 * 1 <= days <= weights.length <= 5 * 104
 * 1 <= weights[i] <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/capacity-to-ship-packages-within-d-days
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ShipWithinDays {
	public static void main(String[] args) {
		ShipWithinDays shipWithinDays = new ShipWithinDays();
		int i = shipWithinDays.shipWithinDays(new int[]{1, 2, 3, 1, 1}, 4);
		System.out.println(i);
	}

	public int shipWithinDays(int[] weights, int days) {
		int left = Integer.MIN_VALUE;
		int right = 0;
		for (int weight : weights) {
			left = Math.max(weight, left);
			right += weight;
		}
		while (left <= right) {
			int mid = (left + right) >> 1;
			int midValue = getShipWithinDays(weights, mid);
			if (midValue == days) {
				right = mid - 1;
			} else if (days < midValue) {
				left = mid + 1;
			} else if (days > midValue) {
				right = mid - 1;
			}
		}
		return left;
	}

	private int getShipWithinDays(int[] weights, int k) {
		int surplus = k;
		int res = 1;
		for (int weight : weights) {
			if (weight > surplus) {
				res++;
				surplus = k;
			}
			surplus -= weight;
		}
		return res;
	}
}
