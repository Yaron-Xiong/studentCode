package com.yaronxiong.algorithms.leetcode.l2500;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * 3180. 执行操作可获得的最大总奖励 I
 * 已解答
 * 算术评级: 5
 * 第 401 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1849
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 rewardValues，长度为 n，代表奖励的值。
 * <p>
 * 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ：
 * <p>
 * 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。
 * 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + rewardValues[i]），并 标记 下标 i。
 * 以整数形式返回执行最优操作能够获得的 最大 总奖励。
 * <p>
 * 示例 1：
 * <p>
 * 输入：rewardValues = [1,1,3,3]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。
 * <p>
 * 示例 2：
 * <p>
 * 输入：rewardValues = [1,6,4,3,2]
 * <p>
 * 输出：11
 * <p>
 * 解释：
 * <p>
 * 依次标记下标 0、2 和 1。总奖励为 11，这是可获得的最大值。
 * <p>
 * 提示：
 * <p>
 * 1 <= rewardValues.length <= 2000
 * 1 <= rewardValues[i] <= 2000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-total-reward-using-operations-i/description/?envType=daily-question&envId=2024-10-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3180_MaxTotalReward {
    public static void main(String[] args) {
        L3180_MaxTotalReward l3180MaxTotalReward = new L3180_MaxTotalReward();
        System.out.println(l3180MaxTotalReward.maxTotalReward(new int[]{1, 6, 4, 3, 2}));
    }

    public int maxTotalReward(int[] rewardValues) {
        int m = 0;
        for (int v : rewardValues) {
            m = Math.max(m, v);
        }
        for (int v : rewardValues) {
            if (v == m - 1) {
                return m * 2 - 1;
            }
        }

        BigInteger f = BigInteger.ONE;
        for (int v : Arrays.stream(rewardValues).distinct().sorted().toArray()) {
            BigInteger mask = BigInteger.ONE.shiftLeft(v).subtract(BigInteger.ONE);
            f = f.or(f.and(mask).shiftLeft(v));
        }
        return f.bitLength() - 1;
    }

}
