package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3097. 或值至少为 K 的最短子数组 II
 * 算术评级: 6
 * 第 127 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1891
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
 * 1 <= nums.length <= 2 * 105
 * 0 <= nums[i] <= 109
 * 0 <= k <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-subarray-with-or-at-least-k-ii/description/?envType=daily-question&envId=2025-01-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3097_MinimumSubarrayLength {
    public static void main(String[] args) {
        L3097_MinimumSubarrayLength l3097MinimumSubarrayLength = new L3097_MinimumSubarrayLength();
        System.out.println(l3097MinimumSubarrayLength.minimumSubarrayLength(new int[]{1, 81, 32, 2, 73, 43}, 107));
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];
        int bitValue = 0;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            //先加入窗口
            bitValue |= nums[i];
            int v = nums[i];
            int index = 0;
            while (v > 0) {
                bits[index++] += (v & 1) == 1 ? 1 : 0;
                v >>= 1;
            }
            //判断窗口是否溢出
            while (bitValue >= k && left < i) {
                ans = Math.min(ans, i - left + 1);
                //移除左边
                v = nums[left++];
                index = 0;
                while (v > 0) {
                    if (bits[index] == 1 && (v & 1) == 1) {
                        //bitValue的这一位要归零
                        int t = ~(1 << index);
                        bitValue &= t;
                    }
                    bits[index++] += (v & 1) == 1 ? -1 : 0;
                    v >>= 1;
                }
            }
            if (bitValue >= k) {
                ans = Math.min(ans, i - left + 1);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
