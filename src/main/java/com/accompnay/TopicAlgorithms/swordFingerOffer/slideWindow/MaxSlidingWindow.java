package com.accompnay.TopicAlgorithms.swordFingerOffer.slideWindow;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值:https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 * <p>
 * 示例:
 * <p>
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * <p>
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤输入数组的大小。
 */
public class MaxSlidingWindow {
	public static void main(String[] args) {
		MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
		int[] ints = maxSlidingWindow.maxSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7}, 3);
		System.out.println(Arrays.toString(ints));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums.length == 0) return new int[]{};
		LinkedList<Integer> queue = new LinkedList<>();
		int[] res = new int[nums.length - k + 1];
		for (int i = 0, j = 1 - k; i < nums.length; i++, j++) {
			if (j > 0 && queue.peekFirst() == nums[j - 1]) {
				queue.removeFirst();
			}
			//维护单调栈
			while (!queue.isEmpty() && nums[i] > queue.peekLast())
				queue.removeLast();
			queue.addLast(nums[i]);
			if (j >= 0) {
				//说明开始记录结果集
				res[j] = queue.peekFirst();
			}
		}
		return res;
	}
}
