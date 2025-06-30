package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3423. 循环数组中相邻元素的最大差值
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 循环 数组 nums ，请你找出相邻元素之间的 最大 绝对差值。
 * <p>
 * 注意：一个循环数组中，第一个元素和最后一个元素是相邻的。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,4]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 由于 nums 是循环的，nums[0] 和 nums[2] 是相邻的，它们之间的绝对差值是最大值 |4 - 1| = 3 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [-5,-10,-5]
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 相邻元素 nums[0] 和 nums[1] 之间的绝对差值为最大值 |-5 - (-10)| = 5 。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-difference-between-adjacent-elements-in-a-circular-array/description/?envType=daily-question&envId=2025-06-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3423_MaxAdjacentDistance {
    public int maxAdjacentDistance(int[] nums) {
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            ans = Math.max(ans, Math.abs(nums[i] - nums[i - 1]));
        }
        ans = Math.max(ans, Math.abs(nums[0] - nums[nums.length - 1]));
        return ans;
    }
}
