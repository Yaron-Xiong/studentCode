package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 3186. 施咒的最大总伤害
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个魔法师有许多不同的咒语。
 * <p>
 * 给你一个数组 power ，其中每个元素表示一个咒语的伤害值，可能会有多个咒语有相同的伤害值。
 * <p>
 * 已知魔法师使用伤害值为 power[i] 的咒语时，
 * 他们就 不能 使用伤害为 power[i] - 2 ，power[i] - 1 ，power[i] + 1 或者 power[i] + 2 的咒语。
 * <p>
 * 每个咒语最多只能被使用 一次 。
 * <p>
 * 请你返回这个魔法师可以达到的伤害值之和的 最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：power = [1,1,3,4]
 * <p>
 * 输出：6
 * <p>
 * 解释：
 * <p>
 * 可以使用咒语 0，1，3，伤害值分别为 1，1，4，总伤害值为 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：power = [7,1,6,6]
 * <p>
 * 输出：13
 * <p>
 * 解释：
 * <p>
 * 可以使用咒语 1，2，3，伤害值分别为 1，6，6，总伤害值为 13 。
 * <p>
 * 提示：
 * <p>
 * 1 <= power.length <= 105
 * 1 <= power[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-total-damage-with-spell-casting/description/?envType=daily-question&envId=2025-10-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3186_MaximumTotalDamage {
    public static void main(String[] args) {
        L3186_MaximumTotalDamage l3186MaximumTotalDamage = new L3186_MaximumTotalDamage();
        System.out.println(l3186MaximumTotalDamage.maximumTotalDamage(new int[]{1, 1, 3, 4}));
        System.out.println(l3186MaximumTotalDamage.maximumTotalDamage(new int[]{7, 1, 6, 6}));
    }

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        long[] dp = new long[power.length];
        dp[0] = power[0];
        //还不满足 伤害的队列
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(0);
        int maxIndex = -1;

        long ans = dp[0];

        for (int i = 1; i < power.length; i++) {
            //找到满足条件的伤害值
            while (!deque.isEmpty()) {
                if (power[i] - 2 <= power[deque.peekFirst()]) {
                    break;
                }
                Integer i1 = deque.pollFirst();
                if (maxIndex == -1) {
                    maxIndex = i1;
                } else if (dp[maxIndex] < dp[i1]) {
                    maxIndex = i1;
                }
            }
            deque.addLast(i);

            if (power[i] == power[i - 1]) {
                dp[i] = dp[i - 1] + power[i];
            } else {
                dp[i] = maxIndex == -1 ? power[i] : power[i] + dp[maxIndex];
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
