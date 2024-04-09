package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.*;

/**
 * 2009. 使数组连续的最少操作数
 * 第 61 场双周赛
 * Q4
 * 2084
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。每一次操作中，你可以将 nums 中 任意 一个元素替换成 任意 整数。
 * <p>
 * 如果 nums 满足以下条件，那么它是 连续的 ：
 * <p>
 * nums 中所有元素都是 互不相同 的。
 * nums 中 最大 元素与 最小 元素的差等于 nums.length - 1 。
 * 比方说，nums = [4, 2, 5, 3] 是 连续的 ，但是 nums = [1, 2, 3, 5, 6] 不是连续的 。
 * <p>
 * 请你返回使 nums 连续 的 最少 操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,5,3]
 * 输出：0
 * 解释：nums 已经是连续的了。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5,6]
 * 输出：1
 * 解释：一个可能的解是将最后一个元素变为 4 。
 * 结果数组为 [1,2,3,5,4] ，是连续数组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,10,100,1000]
 * 输出：3
 * 解释：一个可能的解是：
 * - 将第二个元素变为 2 。
 * - 将第三个元素变为 3 。
 * - 将第四个元素变为 4 。
 * 结果数组为 [1,2,3,4] ，是连续数组。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-array-continuous/description/?envType=daily-question&envId=2024-04-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2009_MinOperations {
    public static void main(String[] args) {
        L2009_MinOperations l2009MinOperations = new L2009_MinOperations();
        System.out.println(l2009MinOperations.minOperations(new int[]{1, 10, 100, 100, 1000}));
    }

    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int notRepeatIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[notRepeatIndex++] = nums[i];
            }
        }
        int ans = Integer.MAX_VALUE;
        int leftIndex = 0;
        for (int i = 0; i < notRepeatIndex; i++) {
            //假设以nums[i] 作为连续数组的开始 那么区间值会包含 [nums[i] , nums[i]+nums.length-1]
            int left = nums[i] - nums.length + 1;
            while (nums[leftIndex] < left) {
                leftIndex++;
            }
            int complete = i - leftIndex + 1;
            ans = Math.min(ans, nums.length - complete);
        }
        return ans;
    }
}
