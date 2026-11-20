package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2567. 修改两个元素的最小分数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * nums 的 最小 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最小值。
 * nums的 最大 得分是满足 0 <= i < j < nums.length 的 |nums[i] - nums[j]| 的最大值。
 * nums 的分数是 最大 得分与 最小 得分的和。
 * 我们的目标是最小化 nums 的分数。你 最多 可以修改 nums 中 2 个元素的值。
 * <p>
 * 请你返回修改 nums 中 至多两个 元素的值后，可以得到的 最小分数 。
 * <p>
 * |x| 表示 x 的绝对值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,3]
 * 输出：0
 * 解释：将 nums[1] 和 nums[2] 的值改为 1 ，nums 变为 [1,1,1] 。|nums[i] - nums[j]| 的值永远为 0 ，所以我们返回 0 + 0 = 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,7,8,5]
 * 输出：3
 * 解释：
 * 将 nums[0] 和 nums[1] 的值变为 6 ，nums 变为 [6,6,7,8,5] 。
 * 最小得分是 i = 0 且 j = 1 时得到的 |nums[i] - nums[j]| = |6 - 6| = 0 。
 * 最大得分是 i = 3 且 j = 4 时得到的 |nums[i] - nums[j]| = |8 - 5| = 3 。
 * 最大得分与最小得分之和为 3 。这是最优答案。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-score-by-changing-two-elements/description/?envType=daily-question&envId=2026-11-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2567_MinimizeSum {
    public static void main(String[] args) {
        L2567_MinimizeSum l2567MinimizeSum = new L2567_MinimizeSum();
        System.out.println(l2567MinimizeSum.minimizeSum(new int[] {59,27,9,81,33}));
        System.out.println(l2567MinimizeSum.minimizeSum(new int[] {58,42,8,75,28}));
    }
    public int minimizeSum(int[] nums) {
        if (nums.length == 3) {
            return 0;
        }
        Arrays.sort(nums);
        int a = nums[nums.length - 1] - nums[2];
        int b = nums[nums.length - 3] - nums[0];
        int c = nums[nums.length - 2] - nums[1];
        return Math.min(Math.min(a, b), c);
    }
}
