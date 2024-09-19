package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2398. 预算内的最多机器人数目
 * 算术评级: 7
 * 第 86 场双周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1917
 * 相关标签
 * 相关企业
 * 提示
 * 你有 n 个机器人，给你两个下标从 0 开始的整数数组 chargeTimes 和 runningCosts ，两者长度都为 n 。
 * 第 i 个机器人充电时间为 chargeTimes[i] 单位时间，花费 runningCosts[i] 单位时间运行。再给你一个整数 budget 。
 * <p>
 * 运行 k 个机器人 总开销 是 max(chargeTimes) + k * sum(runningCosts) ，
 * 其中 max(chargeTimes) 是这 k 个机器人中最大充电时间，sum(runningCosts) 是这 k 个机器人的运行时间之和。
 * <p>
 * 请你返回在 不超过 budget 的前提下，你 最多 可以 连续 运行的机器人数目为多少。
 * <p>
 * 示例 1：
 * <p>
 * 输入：chargeTimes = [3,6,1,3,4], runningCosts = [2,1,3,4,5], budget = 25
 * 输出：3
 * 解释：
 * 可以在 budget 以内运行所有单个机器人或者连续运行 2 个机器人。
 * 选择前 3 个机器人，可以得到答案最大值 3 。总开销是 max(3,6,1) + 3 * sum(2,1,3) = 6 + 3 * 6 = 24 ，小于 25 。
 * 可以看出无法在 budget 以内连续运行超过 3 个机器人，所以我们返回 3 。
 * 示例 2：
 * <p>
 * 输入：chargeTimes = [11,12,19], runningCosts = [10,8,7], budget = 19
 * 输出：0
 * 解释：即使运行任何一个单个机器人，还是会超出 budget，所以我们返回 0 。
 * <p>
 * 提示：
 * <p>
 * chargeTimes.length == runningCosts.length == n
 * 1 <= n <= 5 * 104
 * 1 <= chargeTimes[i], runningCosts[i] <= 105
 * 1 <= budget <= 1015
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-robots-within-budget/description/?envType=daily-question&envId=2024-09-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2398_MaximumRobots {
    public static void main(String[] args) {
        L2398_MaximumRobots l2398MaximumRobots = new L2398_MaximumRobots();
        System.out.println(l2398MaximumRobots.maximumRobots(new int[]{19, 63, 21, 8, 5, 46, 56, 45, 54, 30, 92, 63, 31, 71, 87, 94, 67, 8, 19, 89, 79, 25},
                new int[]{91, 92, 39, 89, 62, 81, 33, 99, 28, 99, 86, 19, 5, 6, 19, 94, 65, 86, 17, 10, 8, 42}, 85));
    }

    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        //滑动窗口
        int left = 0;
        long sum = 0;
        int maxK = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int right = 0; right < chargeTimes.length; right++) {
            while (!stack.isEmpty() && chargeTimes[right] >= chargeTimes[stack.peekFirst()]) {
                stack.pollFirst();
            }
            stack.addFirst(right);

            sum += runningCosts[right];

            while (!stack.isEmpty() && chargeTimes[stack.peekLast()] + ((right - left + 1) * sum) > budget) {
                if (stack.peekLast() == left) {
                    stack.pollLast();
                }
                sum -= runningCosts[left++];
            }

            maxK = Math.max(maxK, right - left + 1);
        }
        return maxK;
    }

}
