package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2958. 最多 K 个重复元素的最长子数组
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 一个元素 x 在数组中的 频率 指的是它在数组中的出现次数。
 * <p>
 * 如果一个数组中所有元素的频率都 小于等于 k ，那么我们称这个数组是 好 数组。
 * <p>
 * 请你返回 nums 中 最长好 子数组的长度。
 * <p>
 * 子数组 指的是一个数组中一段连续非空的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,2,3,1,2], k = 2
 * 输出：6
 * 解释：最长好子数组是 [1,2,3,1,2,3] ，值 1 ，2 和 3 在子数组中的频率都没有超过 k = 2 。
 * [2,3,1,2,3,1] 和 [3,1,2,3,1,2] 也是好子数组。
 * 最长好子数组的长度为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,1,2,1,2,1,2], k = 1
 * 输出：2
 * 解释：最长好子数组是 [1,2] ，值 1 和 2 在子数组中的频率都没有超过 k = 1 。[2,1] 也是好子数组。
 * 最长好子数组的长度为 2 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,5,5,5,5,5,5], k = 4
 * 输出：4
 * 解释：最长好子数组是 [5,5,5,5] ，值 5 在子数组中的频率没有超过 k = 4 。
 * 最长好子数组的长度为 4 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/length-of-longest-subarray-with-at-most-k-frequency/description/?envType=daily-question&envId=2026-08-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2958_MaxSubarrayLength {
    public static void main(String[] args) {
        L2958_MaxSubarrayLength l2958MaxSubarrayLength = new L2958_MaxSubarrayLength();
        System.out.println(l2958MaxSubarrayLength.maxSubarrayLength(new int[]{1, 2, 3, 1, 2, 3, 1, 2}, 2));
        System.out.println(l2958MaxSubarrayLength.maxSubarrayLength(new int[]{1, 2, 1, 2, 1, 2, 1, 2}, 1));
        System.out.println(l2958MaxSubarrayLength.maxSubarrayLength(new int[]{5, 5, 5, 5, 5, 5, 5}, 4));
    }

    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int left = -1;
        for (int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, Integer::sum);
            while (map.get(nums[i]) > k) {
                ++left;
                map.merge(nums[left], -1, Integer::sum);
            }
            ans = Math.max(ans, i - left);
        }
        return ans;
    }
}
