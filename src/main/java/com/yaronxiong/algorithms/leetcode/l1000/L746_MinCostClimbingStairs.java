package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 746. 使用最小花费爬楼梯
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [10,15,20]
 * 输出：15
 * 解释：你将从下标为 1 的台阶开始。
 * - 支付 15 ，向上爬两个台阶，到达楼梯顶部。
 * 总花费为 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1,100,1,1,1,100,1,1,100,1]
 * 输出：6
 * 解释：你将从下标为 0 的台阶开始。
 * - 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
 * - 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
 * - 支付 1 ，向上爬一个台阶，到达楼梯顶部。
 * 总花费为 6 。
 * <p>
 * 提示：
 * <p>
 * 2 <= cost.length <= 1000
 * 0 <= cost[i] <= 999
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/?envType=daily-question&envId=2023-12-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L746_MinCostClimbingStairs {
    public static void main(String[] args) {
        L746_MinCostClimbingStairs l746MinCostClimbingStairs = new L746_MinCostClimbingStairs();
        System.out.println(l746MinCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }

    public int minCostClimbingStairs(int[] cost) {
        int dp_0 = cost[0];
        int dp_1 = cost[1];
        for (int i = 2; i < cost.length; i++) {
            int temp = Math.min(dp_0, dp_1) + cost[i];
            dp_0 = dp_1;
            dp_1 = temp;
        }
        return Math.min(dp_0, dp_1);
    }
}
