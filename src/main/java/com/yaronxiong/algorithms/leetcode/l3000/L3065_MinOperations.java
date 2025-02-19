package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3065. 超过阈值的最少操作数 I
 * 算术评级: 2
 * 第 125 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1150
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一次操作中，你可以删除 nums 中的最小元素。
 * <p>
 * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,11,10,1,3], k = 10
 * 输出：3
 * 解释：第一次操作后，nums 变为 [2, 11, 10, 3] 。
 * 第二次操作后，nums 变为 [11, 10, 3] 。
 * 第三次操作后，nums 变为 [11, 10] 。
 * 此时，数组中的所有元素都大于等于 10 ，所以我们停止操作。
 * 使数组中所有元素都大于等于 10 需要的最少操作次数为 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,4,9], k = 1
 * 输出：0
 * 解释：数组中的所有元素都大于等于 1 ，所以不需要对 nums 做任何操作。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,4,9], k = 9
 * 输出：4
 * 解释：nums 中只有一个元素大于等于 9 ，所以需要执行 4 次操作。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 * 输入保证至少有一个满足 nums[i] >= k 的下标 i 存在。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-value-i/description/?envType=daily-question&envId=2025-01-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3065_MinOperations {
    public int minOperations(int[] nums, int k) {
        int ans = 0;
        for (int num : nums) {
            if (num < k) {
                ans++;
            }
        }
        return ans;
    }
}
