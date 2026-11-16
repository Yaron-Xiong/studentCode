package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3105. 最长的严格递增或递减子数组
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 nums 。
 * <p>
 * 返回数组 nums 中 严格递增 或 严格递减 的最长非空子数组的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,3,3,2]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * nums 中严格递增的子数组有[1]、[2]、[3]、[3]、[4] 以及 [1,4] 。
 * <p>
 * nums 中严格递减的子数组有[1]、[2]、[3]、[3]、[4]、[3,2] 以及 [4,3] 。
 * <p>
 * 因此，返回 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,3,3,3]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 中严格递增的子数组有 [3]、[3]、[3] 以及 [3] 。
 * <p>
 * nums 中严格递减的子数组有 [3]、[3]、[3] 以及 [3] 。
 * <p>
 * 因此，返回 1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * nums 中严格递增的子数组有 [3]、[2] 以及 [1] 。
 * <p>
 * nums 中严格递减的子数组有 [3]、[2]、[1]、[3,2]、[2,1] 以及 [3,2,1] 。
 * <p>
 * 因此，返回 3 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/longest-strictly-increasing-or-strictly-decreasing-subarray/description/?envType=daily-question&envId=2026-11-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3105_LongestMonotonicSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int maxIncLength = 1;
        int maxDecLength = 1;
        int curIncLength = 1;
        int curDecLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                curIncLength++;
                curDecLength = 1;
            } else if (nums[i] < nums[i - 1]) {
                curIncLength = 1;
                curDecLength++;
            }else {
                curIncLength = 1;
                curDecLength = 1;
            }
            maxIncLength = Math.max(curIncLength, maxIncLength);
            maxDecLength = Math.max(curDecLength, maxDecLength);
        }
        return Math.max(maxIncLength, maxDecLength);
    }
}
