package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1052. 爱生气的书店老板
 * 算术评级: 4
 * 第 138 场周赛
 * Q2
 * 1418
 * 相关标签
 * 相关企业
 * 提示
 * 有一个书店老板，他的书店开了 n 分钟。每分钟都有一些顾客进入这家商店。
 * 给定一个长度为 n 的整数数组 customers ，其中 customers[i] 是在第 i 分钟开始时进入商店的顾客数量，所有这些顾客在第 i 分钟结束后离开。
 * <p>
 * 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 * <p>
 * 当书店老板生气时，那一分钟的顾客就会不满意，若老板不生气则顾客是满意的。
 * <p>
 * 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 minutes 分钟不生气，但却只能使用一次。
 * <p>
 * 请你返回 这一天营业下来，最多有多少客户能够感到满意 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], minutes = 3
 * 输出：16
 * 解释：书店老板在最后 3 分钟保持冷静。
 * 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.
 * 示例 2：
 * <p>
 * 输入：customers = [1], grumpy = [0], minutes = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == customers.length == grumpy.length
 * 1 <= minutes <= n <= 2 * 104
 * 0 <= customers[i] <= 1000
 * grumpy[i] == 0 or 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/grumpy-bookstore-owner/description/?envType=daily-question&envId=2024-04-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1052_MaxSatisfied {
    public static void main(String[] args) {
        L1052_MaxSatisfied l1052MaxSatisfied = new L1052_MaxSatisfied();
        System.out.println(l1052MaxSatisfied.maxSatisfied(new int[]{2, 6, 6, 9}, new int[]{0, 0, 1, 1}, 1));
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        //1,0,1,2,1,1,7,5
        //0,1,0,1,0,1,0,1
        //1,0,1,0,1,0,7,0
        //0,0,0,2,0,1,0,5
        //0,0,0,2,2,3,3,8
        //先计算不生气的时候 所有顾客总和
        int cnt = 0;
        int preSum = 0;
        int maxPreSum = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                cnt += customers[i];
            } else {
                preSum += customers[i];
            }
            if (i - minutes >= 0 && grumpy[i - minutes] == 1) {
                preSum -= customers[i - minutes];
            }
            maxPreSum = Math.max(maxPreSum, preSum);
        }
        return cnt + maxPreSum;
    }
}
