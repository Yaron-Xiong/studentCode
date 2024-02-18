package com.accompnay.TopicAlgorithms.leetcode.l2000;

/**
 * 2765. 最长交替子数组
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。如果 nums 中长度为 m 的子数组 s 满足以下条件，我们称它是一个 交替子数组 ：
 * <p>
 * m 大于 1 。
 * s1 = s0 + 1 。
 * 下标从 0 开始的子数组 s 与数组 [s0, s1, s0, s1,...,s(m-1) % 2] 一样。
 * 也就是说，s1 - s0 = 1 ，s2 - s1 = -1 ，s3 - s2 = 1 ，s4 - s3 = -1 ，以此类推，直到 s[m - 1] - s[m - 2] = (-1)m 。
 * 请你返回 nums 中所有 交替 子数组中，最长的长度，如果不存在交替子数组，请你返回 -1 。
 * <p>
 * 子数组是一个数组中一段连续 非空 的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,4,3,4]
 * 输出：4
 * 解释：交替子数组有 [3,4] ，[3,4,3] 和 [3,4,3,4] 。最长的子数组为 [3,4,3,4] ，长度为4 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,5,6]
 * 输出：2
 * 解释：[4,5] 和 [5,6] 是仅有的两个交替子数组。它们长度都为 2 。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-alternating-subarray/description/?envType=daily-question&envId=2024-01-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2765_AlternatingSubarray {
    public static void main(String[] args) {
        L2765_AlternatingSubarray l2765AlternatingSubarray = new L2765_AlternatingSubarray();
        System.out.println(l2765AlternatingSubarray.alternatingSubarray(new int[]{2, 3, 4, 3, 4}));
    }

    public int alternatingSubarray(int[] nums) {
        int ans = -1;
        int index = 1;
        while (index < nums.length) {
            int symbol = 1;
            if (nums[index] - nums[index - 1] != symbol) {
                index++;
                continue;
            }
            int start = index;
            while (index < nums.length && nums[index] - nums[index - 1] == symbol) {
                index++;
                symbol *= -1;
                ans = Math.max(ans, index - start + 1);
            }
        }
        return ans;
    }
}
