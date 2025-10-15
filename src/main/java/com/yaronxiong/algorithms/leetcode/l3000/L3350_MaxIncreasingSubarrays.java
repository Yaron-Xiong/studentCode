package com.yaronxiong.algorithms.leetcode.l3000;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * 3350. 检测相邻递增子数组 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由 n 个整数组成的数组 nums ，请你找出 k 的 最大值，
 * 使得存在 两个 相邻 且长度为 k 的 严格递增 子数组。
 * 具体来说，需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
 * <p>
 * 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
 * 这两个子数组必须是 相邻的，即 b = a + k。
 * 返回 k 的 最大可能 值。
 * <p>
 * 子数组 是数组中的一个连续 非空 的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,7,8,9,2,3,4,3,1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 从下标 2 开始的子数组是 [7, 8, 9]，它是严格递增的。
 * 从下标 5 开始的子数组是 [2, 3, 4]，它也是严格递增的。
 * 这两个子数组是相邻的，因此 3 是满足题目条件的 最大 k 值。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,4,4,5,6,7]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 从下标 0 开始的子数组是 [1, 2]，它是严格递增的。
 * 从下标 2 开始的子数组是 [3, 4]，它也是严格递增的。
 * 这两个子数组是相邻的，因此 2 是满足题目条件的 最大 k 值。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2 * 105
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/adjacent-increasing-subarrays-detection-ii/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3350_MaxIncreasingSubarrays {
    public static void main(String[] args) {
        L3350_MaxIncreasingSubarrays l3350MaxIncreasingSubarrays = new L3350_MaxIncreasingSubarrays();
        System.out.println(l3350MaxIncreasingSubarrays.maxIncreasingSubarrays(Lists.newArrayList(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)));
    }
    public int maxIncreasingSubarrays(List<Integer> nums) {
        //找递增
        int preSize = 0;
        int curSize = 1;
        int ans = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) > nums.get(i - 1)) {
                curSize++;
            }else {
                //结算
                preSize = curSize;
                curSize = 1;
            }
            ans = Math.max(ans, Math.max(Math.min(preSize, curSize), curSize / 2));
        }
        return ans;
    }
}
