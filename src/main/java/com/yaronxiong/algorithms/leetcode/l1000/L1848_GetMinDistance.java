package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1848. 到目标元素的最小距离
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数 target 和 start ，
 * 请你找出一个下标 i ，满足 nums[i] == target 且 abs(i - start) 最小化 。注意：abs(x) 表示 x 的绝对值。
 * <p>
 * 返回 abs(i - start) 。
 * <p>
 * 题目数据保证 target 存在于 nums 中。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5], target = 5, start = 3
 * 输出：1
 * 解释：nums[4] = 5 是唯一一个等于 target 的值，所以答案是 abs(4 - 3) = 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1, start = 0
 * 输出：0
 * 解释：nums[0] = 1 是唯一一个等于 target 的值，所以答案是 abs(0 - 0) = 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1,1,1,1,1,1,1], target = 1, start = 0
 * 输出：0
 * 解释：nums 中的每个值都是 1 ，但 nums[0] 使 abs(i - start) 的结果得以最小化，所以答案是 abs(0 - 0) = 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 104
 * 0 <= start < nums.length
 * target 存在于 nums 中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-distance-to-the-target-element/description/?envType=daily-question&envId=2026-04-13/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1848_GetMinDistance {
    public int getMinDistance(int[] nums, int target, int start) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                ans = Math.min(ans, Math.abs(i - start));
            }
        }
        return ans;
    }
}
