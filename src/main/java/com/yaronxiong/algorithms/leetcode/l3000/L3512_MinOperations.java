package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3512. 使数组和能被 K 整除的最少操作次数
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k。你可以执行以下操作任意次：
 * <p>
 * 选择一个下标 i，并将 nums[i] 替换为 nums[i] - 1。
 * 返回使数组元素之和能被 k 整除所需的最小操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [3,9,7], k = 5
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 对 nums[1] = 9 执行 4 次操作。现在 nums = [3, 5, 7]。
 * 数组之和为 15，可以被 5 整除。
 * 示例 2：
 * <p>
 * 输入： nums = [4,1,3], k = 4
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组之和为 8，已经可以被 4 整除。因此不需要操作。
 * 示例 3：
 * <p>
 * 输入： nums = [3,2], k = 6
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 对 nums[0] = 3 执行 3 次操作，对 nums[1] = 2 执行 2 次操作。现在 nums = [0, 0]。
 * 数组之和为 0，可以被 6 整除。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * 1 <= k <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-operations-to-make-array-sum-divisible-by-k/?envType=daily-question&envId=2025-11-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3512_MinOperations {
    public int minOperations(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        return sum % k;
    }
}
