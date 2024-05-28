package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2681. 英雄的力量
 * 提示
 * 困难
 * 41
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums ，它表示英雄的能力值。如果我们选出一部分英雄，这组英雄的 力量 定义为：
 * <p>
 * i0 ，i1 ，... ik 表示这组英雄在数组中的下标。
 * 那么这组英雄的力量为 max(nums[i0],nums[i1] ... nums[ik])2 * min(nums[i0],nums[i1] ... nums[ik]) 。
 * 请你返回所有可能的 非空 英雄组的 力量 之和。由于答案可能非常大，请你将结果对 109 + 7 取余。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4]
 * 输出：141
 * 解释：
 * 第 1 组：[2] 的力量为 22 * 2 = 8 。
 * 第 2 组：[1] 的力量为 12 * 1 = 1 。
 * 第 3 组：[4] 的力量为 42 * 4 = 64 。
 * 第 4 组：[2,1] 的力量为 22 * 1 = 4 。
 * 第 5 组：[2,4] 的力量为 42 * 2 = 32 。
 * 第 6 组：[1,4] 的力量为 42 * 1 = 16 。
 * 第 7 组：[2,1,4] 的力量为 42 * 1 = 16 。
 * 所有英雄组的力量之和为 8 + 1 + 64 + 4 + 32 + 16 + 16 = 141 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：7
 * 解释：总共有 7 个英雄组，每一组的力量都是 1 。所以所有英雄组的力量之和为 7 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/power-of-heroes/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2681_SumOfPower {
    public static void main(String[] args) {
        L2681_SumOfPower l2681SumOfPower = new L2681_SumOfPower();
        System.out.println(l2681SumOfPower.sumOfPower(new int[]{658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206}));
    }

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        final long MOD = (long) 1e9 + 7;
        long pre = 0;
        long res = 0;
        for (int num : nums) {
            res = (res + (((long) num * num % MOD) * (num + pre)) % MOD) % MOD;
            pre = (2 * pre + num) % MOD;
        }
        return (int) res;
    }
}
