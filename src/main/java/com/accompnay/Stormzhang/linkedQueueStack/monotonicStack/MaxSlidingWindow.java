package com.accompnay.Stormzhang.linkedQueueStack.monotonicStack;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值：https://leetcode-cn.com/problems/sliding-window-maximum/
 * 给你一个整数数组 nums，有一个大小为k的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回滑动窗口中的最大值。
 * <p>
 * <p>
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
 * 示例 3：
 * <p>
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 * <p>
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 * <p>
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104<= nums[i] <= 104
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxSlidingWindow {
	public static void main(String[] args) {
		MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
		int[] ints = maxSlidingWindow.maxSlidingWindow(new int[]{7,2,4}, 2);
		System.out.println(Arrays.toString(ints));
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] ans = new int[nums.length - k + 1];
		if (nums.length < k) {
			return ans;
		}
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < k; i++) {
			while (!list.isEmpty() && nums[list.peekLast()] < nums[i]) {
				list.removeLast();
			}
			list.addLast(i);
		}
		ans[0] = nums[list.peekFirst()];

		for (int i = k; i < nums.length; i++) {
			while (!list.isEmpty() && nums[list.peekLast()] < nums[i]) {
				list.removeLast();
			}
			list.addLast(i);
			int kStart = i - k + 1;
			while (list.peekFirst() < kStart) {
				list.pollFirst();
			}
			ans[i - k + 1] = nums[list.peekFirst()];
		}
		return ans;
	}
}
