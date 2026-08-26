package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashSet;
import java.util.Set;

/**
 * 2996. 大于等于顺序前缀和的最小缺失整数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 如果一个前缀 nums[0..i] 满足对于 1 <= j <= i 的所有元素都有 nums[j] = nums[j - 1] + 1 ，
 * 那么我们称这个前缀是一个 顺序前缀 。特殊情况是，只包含 nums[0] 的前缀也是一个 顺序前缀 。
 * <p>
 * 请你返回 nums 中没有出现过的 最小 整数 x ，满足 x 大于等于 最长 顺序前缀的和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2,5]
 * 输出：6
 * 解释：nums 的最长顺序前缀是 [1,2,3] ，和为 6 ，6 不在数组中，所以 6 是大于等于最长顺序前缀和的最小整数。
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5,1,12,14,13]
 * 输出：15
 * 解释：nums 的最长顺序前缀是 [3,4,5] ，和为 12 ，12、13 和 14 都在数组中，但 15 不在，所以 15 是大于等于最长顺序前缀和的最小整数。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/description/?envType=daily-question&envId=2026-08-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2996_MissingInteger {
    public static void main(String[] args) {
        L2996_MissingInteger l2996MissingInteger = new L2996_MissingInteger();
        System.out.println(l2996MissingInteger.missingInteger(new int[]{3, 4, 5, 1, 12, 14, 13}));
        System.out.println(l2996MissingInteger.missingInteger(new int[]{29, 30, 31, 32, 33, 34, 35, 36, 37}));
        System.out.println(l2996MissingInteger.missingInteger(new int[]{37, 1, 2, 9, 5, 8, 5, 2, 9, 4}));
        System.out.println(l2996MissingInteger.missingInteger(new int[]{46, 8, 2, 4, 1, 4, 10, 2, 4, 10, 2, 5, 7, 3, 1}));
        System.out.println(l2996MissingInteger.missingInteger(new int[]{1, 2, 3, 2, 5}));
    }

    public int missingInteger(int[] nums) {
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] == nums[i - 1] + 1) {
                preSum += nums[i];
            } else {
                break;
            }
        }
        Set<Integer> set = new HashSet<>();
        int maxValue = Integer.MIN_VALUE;
        for (int num : nums) {
            set.add(num);
            maxValue = Math.max(maxValue, num);
        }
        for (int i = preSum; i <= maxValue + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return preSum;
    }
}
