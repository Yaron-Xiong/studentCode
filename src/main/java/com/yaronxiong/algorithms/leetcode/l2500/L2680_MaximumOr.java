package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2680. 最大或值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k 。每一次操作中，你可以选择一个数并将它乘 2 。
 * <p>
 * 你最多可以进行 k 次操作，请你返回 nums[0] | nums[1] | ... | nums[n - 1] 的最大值。
 * <p>
 * a | b 表示两个整数 a 和 b 的 按位或 运算。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [12,9], k = 1
 * 输出：30
 * 解释：如果我们对下标为 1 的元素进行操作，新的数组为 [12,18] 。此时得到最优答案为 12 和 18 的按位或运算的结果，也就是 30 。
 * 示例 2：
 * <p>
 * 输入：nums = [8,1,2], k = 2
 * 输出：35
 * 解释：如果我们对下标 0 处的元素进行操作，得到新数组 [32,1,2] 。此时得到最优答案为 32|1|2 = 35 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 15
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-or/description/?envType=daily-question&envId=2025-03-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2680_MaximumOr {
    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        // suf[i] 表示 nums[i+1] 到 nums[n-1] 的 OR
        int[] suf = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] | nums[i + 1];
        }

        long ans = 0;
        // pre 表示 nums[0] 到 nums[i-1] 的 OR
        int pre = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, pre | ((long) nums[i] << k) | suf[i]);
            pre |= nums[i];
        }
        return ans;
    }
}
