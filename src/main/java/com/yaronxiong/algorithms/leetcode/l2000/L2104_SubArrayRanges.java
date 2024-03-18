package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 2104. 子数组范围和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * <p>
 * 返回 nums 中 所有 子数组范围的 和 。
 * <p>
 * 子数组是数组中一个连续 非空 的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [2]，范围 = 2 - 2 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,2]，范围 = 2 - 1 = 1
 * [2,3]，范围 = 3 - 2 = 1
 * [1,2,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [3]，范围 = 3 - 3 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,3]，范围 = 3 - 1 = 2
 * [3,3]，范围 = 3 - 3 = 0
 * [1,3,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 2 + 0 + 2 = 4
 * 示例 3：
 * <p>
 * 输入：nums = [4,-2,-3,4,1]
 * 输出：59
 * 解释：nums 中所有子数组范围的和是 59
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -109 <= nums[i] <= 109
 * <p>
 * 进阶：你可以设计一种时间复杂度为 O(n) 的解决方案吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sum-of-subarray-ranges/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2104_SubArrayRanges {
    public static void main(String[] args) {
        L2104_SubArrayRanges l2104SubArrayRanges = new L2104_SubArrayRanges();
        System.out.println(l2104SubArrayRanges.subArrayRanges(new int[]{4, -2, -3, 4, 1}));
    }

    public long subArrayRanges(int[] nums) {
        long ans = solve(nums);
        Arrays.setAll(nums, i -> -nums[i]);
        return ans + solve(nums);
    }

    private long solve(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(-1);
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        Arrays.fill(right, nums.length);
        for (int i = 0; i < nums.length; i++) {
            while (deque.size() > 1 && nums[deque.peekFirst()] <= nums[i]) {
                right[deque.pollFirst()] = i;
            }
            left[i] = deque.peekFirst();
            deque.addFirst(i);
        }
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int leftCnt = i - left[i];
            int rightCnt = right[i] - i;
            ans += nums[i] * ((long) rightCnt * leftCnt);
        }
        return ans;
    }
}
