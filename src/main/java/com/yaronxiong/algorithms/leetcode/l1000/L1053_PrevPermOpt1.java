package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1053. 交换一次的先前排列
 * 提示
 * 中等
 * 69
 * 相关企业
 * 给你一个正整数数组 arr（可能存在重复的元素），请你返回可在 一次交换（交换两数字 arr[i] 和 arr[j] 的位置）后得到的、按字典序排列小于 arr 的最大排列。
 * <p>
 * 如果无法这么操作，就请返回原数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1]
 * 输出：[3,1,2]
 * 解释：交换 2 和 1
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,5]
 * 输出：[1,1,5]
 * 解释：已经是最小排列
 * 示例 3：
 * <p>
 * 输入：arr = [1,9,4,6,7]
 * 输出：[1,7,4,6,9]
 * 解释：交换 9 和 7
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 104
 * 1 <= arr[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/previous-permutation-with-one-swap/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1053_PrevPermOpt1 {
	public static void main(String[] args) {
		L1053_PrevPermOpt1 l1053PrevPermOpt1 = new L1053_PrevPermOpt1();
		int[] arr = {9,4,8,7};
		int[] a = l1053PrevPermOpt1.prevPermOpt1(arr);
		System.out.println(Arrays.toString(a));
	}

	public int[] prevPermOpt1(int[] arr) {
		for (int i = arr.length - 2; i >= 0; i--) {
			int maxIndex = -1;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					maxIndex = maxIndex == -1 ? j : maxIndex;
					if (arr[j] > arr[maxIndex]) {
						maxIndex = j;
					}
				}
			}
			if (maxIndex != -1) {
				int temp = arr[maxIndex];
				arr[maxIndex] = arr[i];
				arr[i] = temp;
				return arr;
			}
		}
		return arr;
	}
}
