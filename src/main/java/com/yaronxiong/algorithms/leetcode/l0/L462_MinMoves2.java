package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 462. 最小操作次数使数组元素相等 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最小操作数。
 * <p>
 * 在一次操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * 测试用例经过设计以使答案在 32 位 整数范围内。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两次操作（每次操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,2,9]
 * 输出：16
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-moves-to-equal-array-elements-ii/description/?envType=daily-question&envId=2026-11-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L462_MinMoves2 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length / 2];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - mid);
        }
        return ans;
    }
}
