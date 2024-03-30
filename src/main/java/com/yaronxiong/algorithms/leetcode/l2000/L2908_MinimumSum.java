package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2908. 元素和最小的山形三元组 I
 * 第 368 场周赛
 * Q1
 * 1254
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
 * <p>
 * i < j < k
 * nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,6,1,5,3]
 * 输出：9
 * 解释：三元组 (2, 3, 4) 是一个元素和等于 9 的山形三元组，因为：
 * - 2 < 3 < 4
 * - nums[2] < nums[3] 且 nums[4] < nums[3]
 * 这个三元组的元素和等于 nums[2] + nums[3] + nums[4] = 9 。可以证明不存在元素和小于 9 的山形三元组。
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,8,7,10,2]
 * 输出：13
 * 解释：三元组 (1, 3, 5) 是一个元素和等于 13 的山形三元组，因为：
 * - 1 < 3 < 5
 * - nums[1] < nums[3] 且 nums[5] < nums[3]
 * 这个三元组的元素和等于 nums[1] + nums[3] + nums[5] = 13 。可以证明不存在元素和小于 13 的山形三元组。
 * 示例 3：
 * <p>
 * 输入：nums = [6,5,4,3,4,5]
 * 输出：-1
 * 解释：可以证明 nums 中不存在山形三元组。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-sum-of-mountain-triplets-i/description/?envType=daily-question&envId=2024-03-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2908_MinimumSum {
    public static void main(String[] args) {
        L2908_MinimumSum l2908MinimumSum = new L2908_MinimumSum();
        System.out.println(l2908MinimumSum.minimumSum(new int[]{1, 2, 1, 2}));
    }
    public int minimumSum(int[] nums) {
        int[] left = new int[nums.length];
        int minValue = nums[0];
        for (int i = 0; i < nums.length; i++) {
            left[i] = nums[i] <= minValue ? -1 : minValue;
            minValue = Math.min(minValue, nums[i]);
        }
        int ans = Integer.MAX_VALUE;
        minValue = nums[nums.length - 1];
        for (int i = nums.length - 1; i >= 0; i--) {
            int right = nums[i] <= minValue ? -1 : minValue;
            minValue = Math.min(minValue, nums[i]);
            if (left[i] == -1 || right == -1) {
                continue;
            }
            ans = Math.min(ans, left[i] + nums[i] + right);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
