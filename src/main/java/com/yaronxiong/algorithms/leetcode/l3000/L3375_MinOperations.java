package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3375. 使数组的值全部为 K 的最少操作次数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 如果一个数组中所有 严格大于 h 的整数值都 相等 ，那么我们称整数 h 是 合法的 。
 * <p>
 * 比方说，如果 nums = [10, 8, 10, 8] ，那么 h = 9 是一个 合法 整数，因为所有满足 nums[i] > 9 的数都等于 10 ，但是 5 不是 合法 整数。
 * <p>
 * 你可以对 nums 执行以下操作：
 * <p>
 * 选择一个整数 h ，它对于 当前 nums 中的值是合法的。
 * 对于每个下标 i ，如果它满足 nums[i] > h ，那么将 nums[i] 变为 h 。
 * 你的目标是将 nums 中的所有元素都变为 k ，请你返回 最少 操作次数。如果无法将所有元素都变 k ，那么返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,5,4,5], k = 2
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 依次选择合法整数 4 和 2 ，将数组全部变为 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,2], k = 2
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * 没法将所有值变为 2 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [9,7,5,3], k = 1
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 依次选择合法整数 7 ，5 ，3 和 1 ，将数组全部变为 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-operations-to-make-array-values-equal-to-k/description/?envType=daily-question&envId=2025-04-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3375_MinOperations {
    public static void main(String[] args) {
        L3375_MinOperations l3375MinOperations = new L3375_MinOperations();
        System.out.println(l3375MinOperations.minOperations(new int[]{2,1,2}, 2));
    }

    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        if (nums[0] < k) {
            return -1;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1] && nums[i - 1] != k) {
                ans++;
            }
        }
        return nums[nums.length - 1] == k ? ans : ans + 1;
    }
}
