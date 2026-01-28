package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3190. 使所有元素都可以被 3 整除的最少操作数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。一次操作中，你可以将 nums 中的 任意 一个元素增加或者减少 1 。
 * <p>
 * 请你返回将 nums 中所有元素都可以被 3 整除的 最少 操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 通过以下 3 个操作，数组中的所有元素都可以被 3 整除：
 * <p>
 * 将 1 减少 1 。
 * 将 2 增加 1 。
 * 将 4 减少 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,6,9]
 * <p>
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-minimum-operations-to-make-all-elements-divisible-by-three/description/?envType=daily-question&envId=2025-11-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3190_MinimumOperations {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (num % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }
}
