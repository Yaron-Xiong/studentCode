package com.yaronxiong.algorithms.practiceSet.sliding_indow;

import java.util.*;

/**
 * 239. 滑动窗口最大值
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class MaxSlidingWindow {
	public static void main(String[] args) {
		MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
		int[] ints = maxSlidingWindow.maxSlidingWindow(new int[]{-7,-8,7,5,7,1,6,0}, 4);
		System.out.println(Arrays.toString(ints));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] res = new int[nums.length - k + 1];
		int index = 0;
		Deque<Integer> deque = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && nums[i] > deque.getFirst()) {
				deque.removeFirst();
			}
			deque.addFirst(nums[i]);
			//检查左边界是否合法
			int outLeft = i - k;
			if (outLeft >= 0 && deque.getLast() == nums[outLeft]) {
				deque.removeLast();
			}
			if (i >= k - 1) {
				res[index++] = deque.getLast();
			}
		}
		return res;
	}
}
