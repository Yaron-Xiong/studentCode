package com.yaronxiong.algorithms.leetcode.l3000;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 3349. 检测相邻递增子数组 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由 n 个整数组成的数组 nums 和一个整数 k，
 * 请你确定是否存在 两个 相邻 且长度为 k 的 严格递增 子数组。具体来说，
 * 需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
 * <p>
 * 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
 * 这两个子数组必须是 相邻的，即 b = a + k。
 * 如果可以找到这样的 两个 子数组，请返回 true；否则返回 false。
 * <p>
 * 子数组 是数组中的一个连续 非空 的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,7,8,9,2,3,4,3,1], k = 3
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 从下标 2 开始的子数组为 [7, 8, 9]，它是严格递增的。
 * 从下标 5 开始的子数组为 [2, 3, 4]，它也是严格递增的。
 * 两个子数组是相邻的，因此结果为 true。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,4,4,5,6,7], k = 5
 * <p>
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= 2 * k <= nums.length
 * -1000 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-i/description/?envType=daily-question&envId=2025-10-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3349_HasIncreasingSubarrays {
    public static void main(String[] args) {
        L3349_HasIncreasingSubarrays l3349HasIncreasingSubarrays = new L3349_HasIncreasingSubarrays();
        System.out.println(l3349HasIncreasingSubarrays.hasIncreasingSubarrays(Lists.newArrayList(-15, 9), 1));
        System.out.println(l3349HasIncreasingSubarrays.hasIncreasingSubarrays(Lists.newArrayList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1), 3));
    }

    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        for (int i = 0; i <= nums.size() - k - k; i++) {
            boolean flag = true;
            for (int j = i + 1; j < i + k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    flag = false;
                    break;
                }
            }
            for (int j = i + k + 1; j < i + k + k; j++) {
                if (nums.get(j) <= nums.get(j - 1)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return true;
            }
        }
        return false;
    }
}
