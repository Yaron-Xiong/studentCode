package com.yaronxiong.algorithms.Stormzhang.linkedQueueStack.monotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II:https://leetcode-cn.com/problems/next-greater-element-ii/
 * <p>
 * 给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。
 * 数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 注意: 输入数组的长度不会超过 10000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/next-greater-element-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextGreaterElements_II {
	public static void main(String[] args) {
		NextGreaterElements_II nextGreaterElements_ii = new NextGreaterElements_II();
		int[] ints = nextGreaterElements_ii.nextGreaterElements(new int[]{4, 2, 1});
		System.out.println(Arrays.toString(ints));
	}

	public int[] nextGreaterElements(int[] nums) {
		Deque<Integer> stack = new LinkedList<>();
		int length = nums.length + nums.length - 1;
		int[] ans = new int[nums.length];
		for (int i = length - 1; i >= 0; i--) {
			int value = nums[i % nums.length];
			while (!stack.isEmpty() && stack.peek() <= value) {
				stack.poll();
			}
			if (i < nums.length) {
				ans[i] = stack.peek() == null ? -1 : stack.peek();
			}
			stack.push(value);
		}
		return ans;
	}
}
