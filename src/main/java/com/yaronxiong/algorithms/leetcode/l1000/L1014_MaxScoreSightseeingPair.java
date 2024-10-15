package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1014. 最佳观光组合
 * 算术评级: 4
 * 第 129 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1730
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。
 * <p>
 * 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。
 * <p>
 * 返回一对观光景点能取得的最高分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [8,1,5,2,6]
 * 输出：11
 * 解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 * 示例 2：
 * <p>
 * 输入：values = [1,2]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 2 <= values.length <= 5 * 104
 * 1 <= values[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/best-sightseeing-pair/description/?envType=daily-question&envId=2024-09-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1014_MaxScoreSightseeingPair {
    public static void main(String[] args) {
        L1014_MaxScoreSightseeingPair l1014MaxScoreSightseeingPair = new L1014_MaxScoreSightseeingPair();
        System.out.println(l1014MaxScoreSightseeingPair.maxScoreSightseeingPair(new int[]{7, 8, 8, 10}));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int preSum = values[0];
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, preSum + (values[i] - i));
            //判断当前位置能不能替代pre
            if (values[i] + i >= preSum) {
                preSum = values[i] + i;
            }
        }
        return ans;
    }
}
