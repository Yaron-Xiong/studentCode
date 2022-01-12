package com.accompnay.TopicAlgorithms.Stormzhang.array.difference;

import java.util.Arrays;

/**
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
 * <p>
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 * <p>
 * 请你返回 k 次操作后的数组。
 * <p>
 * 示例:
 * 示例:
 * <p>
 * 输入: length = 5, updates = [[1,3,2],[2,4,3],[0,2,-2]]
 * 输出: [-2,0,3,5,3]
 * 解释:
 * <p>
 * 初始状态:
 * [0,0,0,0,0]
 * <p>
 * 进行了操作 [1,3,2] 后的状态:
 * [0,2,2,2,0]
 * <p>
 * 进行了操作 [2,4,3] 后的状态:
 * [0,2,5,5,3]
 * <p>
 * 进行了操作 [0,2,-2] 后的状态:
 * [-2,0,3,5,3]
 */
public class GetModifiedArray {
	public static void main(String[] args) {
		GetModifiedArray getModifiedArray = new GetModifiedArray();
		int[] modifiedArray = getModifiedArray.getModifiedArray(5, new int[][]{{1, 3, 2}, {2, 4, 3}, {0, 2, -2}});
		System.out.println(Arrays.toString(modifiedArray));
	}

	int[] getModifiedArray(int length, int[][] updates) {
		int[] ints = new int[length];
		for (int[] update : updates) {
			ints[update[0]] += update[2];
			if (update[1] + 1 < length) {
				ints[update[1] + 1] -= update[2];
			}
		}
		int[] result = new int[length];
		result[0] = ints[0];
		for (int i = 1; i < result.length; i++) {
			result[i] = ints[i] + result[i - 1];
		}
		return result;
	}
}
