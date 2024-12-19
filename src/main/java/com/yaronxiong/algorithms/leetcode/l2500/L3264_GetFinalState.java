package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3264. K 次乘运算后的最终数组 I
 * 算术评级: 3
 * 第 412 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1178
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 * <p>
 * 你需要对 nums 执行 k 次操作，每次操作中：
 * <p>
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * 请你返回执行完 k 次乘运算之后，最终的 nums 数组。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3,5,6], k = 5, multiplier = 2
 * <p>
 * 输出：[8,4,6,5,6]
 * <p>
 * 解释：
 * <p>
 * 操作	结果
 * 1 次操作后	[2, 2, 3, 5, 6]
 * 2 次操作后	[4, 2, 3, 5, 6]
 * 3 次操作后	[4, 4, 3, 5, 6]
 * 4 次操作后	[4, 4, 6, 5, 6]
 * 5 次操作后	[8, 4, 6, 5, 6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], k = 3, multiplier = 4
 * <p>
 * 输出：[16,8]
 * <p>
 * 解释：
 * <p>
 * 操作	结果
 * 1 次操作后	[4, 2]
 * 2 次操作后	[4, 8]
 * 3 次操作后	[16, 8]
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 10
 * 1 <= multiplier <= 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-ii/description/?envType=daily-question&envId=2024-11-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3264_GetFinalState {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt((Integer a) -> nums[a]).thenComparingInt(a -> a));
        for (int i = 0; i < nums.length; i++) {
            queue.add(i);
        }
        while (k > 0) {
            Integer poll = queue.poll();
            nums[poll] = nums[poll] * multiplier;
            queue.add(poll);
            k--;
        }
        return nums;
    }
}
