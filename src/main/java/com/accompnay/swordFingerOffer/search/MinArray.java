package com.accompnay.swordFingerOffer.search;

/**
 * 剑指 Offer 11. 旋转数组的最小数字：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组[3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1.
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 * <p>
 */
public class MinArray {
	public int minArray(int[] numbers) {
		int l = 0;
		int r = numbers.length - 1;
		while (l < r) {
			int mid = (l + r) >> 1;
			int midValue = numbers[mid];
			if (midValue < numbers[r]) {
				r = mid;
			} else if (midValue > numbers[r]) {
				l = mid + 1;
			} else {
				r--;
			}
		}
		return numbers[r];
	}

	public static void main(String[] args) {
		MinArray minArray = new MinArray();
		int i = minArray.minArray(new int[]{10, 1, 10, 10, 10});
		System.out.println(i);
	}
}