package com.accompnay.TopicAlgorithms.practiceSet.list.diff;

/**
 * 1094. 拼车
 * 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
 * <p>
 * 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，
 * 接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
 * <p>
 * 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 4
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：trips = [[2,1,5],[3,3,7]], capacity = 5
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * 1 <= trips.length <= 1000
 * trips[i].length == 3
 * 1 <= numPassengersi <= 100
 * 0 <= fromi < toi <= 1000
 * 1 <= capacity <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/car-pooling
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CarPooling {
	public static void main(String[] args) {
		CarPooling carPooling = new CarPooling();
		boolean b = carPooling.carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3);
		System.out.println(b);
	}

	public boolean carPooling(int[][] trips, int capacity) {
		int maxStation = 1001;
		int[] diffArr = new int[maxStation];
		for (int[] trip : trips) {
			diffArr[trip[1]] += trip[0];
			if (trip[2] < maxStation) {
				diffArr[trip[2]] -= trip[0];
			}
		}
		if (diffArr[0] > capacity) {
			return false;
		}
		boolean res = true;
		for (int i = 1; i < diffArr.length; i++) {
			diffArr[i] = diffArr[i - 1] + diffArr[i];
			if (diffArr[i] > capacity) {
				res = false;
			}
		}
		return res;
	}
}
