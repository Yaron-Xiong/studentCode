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
		int[] ints = numbers.getLeastNumbers2(new int[]{0, 0, 1, 2, 4, 2, 2, 3, 1, 4}, 8);
		System.out.println(Arrays.toString(ints));
	}


	public int[] getLeastNumbers2(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return arr;
		}
		quitSort(arr, 0, arr.length - 1, k);
		return Arrays.copyOf(arr, k);
	}

	private void quitSort(int[] arr, int left, int right, int k) {
		if (left > right) return;
		int l = left;
		int r = right;
		int index = left;
		int standard = arr[((l + r) >> 1)];
		while (index <= r) {
			if (arr[index] < standard) {
				swap(arr, index, l);
				index++;
				l++;
			} else if (arr[index] > standard) {
				swap(arr, index, r);
				r--;
			} else {
				index++;
			}
		}
		if (k >= l && k <= r) {
			return;
		}
		quitSort(arr, left, l - 1, k);
		quitSort(arr, r + 1, right, k);
	}

	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public int[] getLeastNumbers(int[] arr, int k) {
		PriorityQueue<Integer> integers = new PriorityQueue<>(k, (a, b) -> b - a);
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
