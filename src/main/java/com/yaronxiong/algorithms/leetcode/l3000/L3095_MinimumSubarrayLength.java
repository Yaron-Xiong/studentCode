package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3095. 或值至少 K 的最短子数组 I
 * 算术评级: 2
 * 第 127 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1369
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * <p>
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * <p>
 * 请你返回 nums 中 最短特别非空子数组的长度，如果特别子数组不存在，那么返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3], k = 2
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。
 * <p>
 * 注意，[2] 也是一个特别子数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,8], k = 10
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2], k = 0
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 50
 * 0 <= k < 64
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-i/description/?envType=daily-question&envId=2025-01-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3095_MinimumSubarrayLength {
    public static void main(String[] args) {
        L3095_MinimumSubarrayLength l3095MinimumSubarrayLength = new L3095_MinimumSubarrayLength();
        System.out.println(l3095MinimumSubarrayLength.minimumSubarrayLength(new int[]{16, 1, 2, 20, 32}, 45));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curK = 0;
            for (int j = i; j >= 0; j--) {
                curK |= nums[j];
                if (curK >= k) {
                    ans = Math.min(ans, i - j + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
