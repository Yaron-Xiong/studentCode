package com.accompnay.swordFingerOffer.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数:https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i]<= 10000
 */
public class GetLeastNumbers {

	public static void main(String[] args) {
		GetLeastNumbers numbers = new GetLeastNumbers();
		int[] ints = numbers.getLeastNumbers(new int[]{0, 1, 2, 1}, 1);
		System.out.println(Arrays.toString(ints));
	}

	public int[] getLeastNumbers(int[] arr, int k) {
		PriorityQueue<Integer> integers = new PriorityQueue<>(k,(a, b) -> b - a);
		for (int i : arr) {
			integers.add(i);
			if (integers.size() > k) {
				integers.poll();
			}
		}
		int[] result = new int[k];
		int index = 0;
		while (!integers.isEmpty()) {
			result[index++] = integers.poll();
		}
		return result;
	}
}
