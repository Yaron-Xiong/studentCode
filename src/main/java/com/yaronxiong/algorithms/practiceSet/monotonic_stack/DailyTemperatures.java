package com.yaronxiong.algorithms.practiceSet.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 739. 每日温度
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * <p>
 * 示例 1:
 * <p>
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 * 示例 2:
 * <p>
 * 输入: temperatures = [30,40,50,60]
 * 输出: [1,1,1,0]
 * 示例 3:
 * <p>
 * 输入: temperatures = [30,60,90]
 * 输出: [1,1,0]
 * <p>
 * 提示：
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {
	public static void main(String[] args) {
		DailyTemperatures dailyTemperatures = new DailyTemperatures();
		int[] ints = dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
		System.out.println(Arrays.toString(ints));
	}

	public int[] dailyTemperatures(int[] temperatures) {
		Deque<Integer> deque = new ArrayDeque<>();
		int[] res = new int[temperatures.length];
		for (int i = temperatures.length - 1; i >= 0; i--) {
			while (!deque.isEmpty() && temperatures[i] >= temperatures[deque.peek()]) {
				deque.pop();
			}
			res[i] = deque.isEmpty() ? 0 : deque.peek() - i;
			deque.push(i);
		}
		return res;
	}
}
