package com.accompnay.swordFingerOffer.greed;

/**
 * 剑指 Offer 45. 把数组排成最小的数：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof
 * <p>
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: "102"
 * 示例2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 */
public class MinNumber {

	public static void main(String[] args) {
		MinNumber minNumber = new MinNumber();
		String s = minNumber.minNumber(new int[]{});
		System.out.println(s);
	}

	public String minNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] strArr = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			strArr[i] = String.valueOf(nums[i]);
		}
		sort(strArr, 0, nums.length - 1);
		StringBuilder builder = new StringBuilder();
		for (String str : strArr) {
			builder.append(str);
		}
		return builder.toString();
	}

	private void sort(String[] nums, int l, int r) {
		if (l >= r) {
			return;
		}
		//选取基准值
		String value = nums[(l + r) >> 1];
		int left = l;
		int right = r;
		int cur = l;
		while (cur <= right) {
			String temp1 = nums[cur] + value;
			String temp2 = value + nums[cur];
			int compare = temp1.compareTo(temp2);
			if (compare < 0) {
				swap(nums, cur, left);
				left++;
				cur++;
			} else if (compare > 0) {
				swap(nums, cur, right);
				right--;
			} else {
				cur++;
			}
		}
		sort(nums, l, left - 1);
		sort(nums, right + 1, r);
	}

	private void swap(String[] nums, int cur, int r) {
		String temp = nums[cur];
		nums[cur] = nums[r];
		nums[r] = temp;
	}

}
