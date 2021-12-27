package com.accompnay.Stormzhang.linkedQueueStack.monotonicStack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度：https://leetcode-cn.com/problems/daily-temperatures/
 *
 * 请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
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
 * <p>
 * 提示：
 * <p>
 * 1 <= temperatures.length <= 105
 * 30 <= temperatures[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {
	public static void main(String[] args) {
		DailyTemperatures dailyTemperatures = new DailyTemperatures();
		int[] ints = dailyTemperatures.dailyTemperatures(new int[]{89,62,70,58,47,47,46,76,100,70});
		System.out.println(Arrays.toString(ints));
	}
	public int[] dailyTemperatures(int[] temperatures) {
		Deque<Integer> stack = new LinkedList<>();
		int[] ans = new int[temperatures.length];
		for (int i = temperatures.length - 1; i >= 0; i--) {
			int todayTemperature = temperatures[i];
			while (!stack.isEmpty() && temperatures[stack.peek()] <= todayTemperature) {
				stack.poll();
			}
			ans[i] = stack.peek() == null ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return ans;
	}
}
