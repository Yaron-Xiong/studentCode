package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2874. 有序三元组中的最大值 II
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 请你从所有满足 i < j < k 的下标三元组 (i, j, k) 中，找出并返回下标三元组的最大值。如果所有满足条件的三元组的值都是负数，则返回 0 。
 * <p>
 * 下标三元组 (i, j, k) 的值等于 (nums[i] - nums[j]) * nums[k] 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [12,6,1,2,7]
 * 输出：77
 * 解释：下标三元组 (0, 2, 4) 的值是 (nums[0] - nums[2]) * nums[4] = 77 。
 * 可以证明不存在值大于 77 的有序下标三元组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,3,4,19]
 * 输出：133
 * 解释：下标三元组 (1, 2, 4) 的值是 (nums[1] - nums[2]) * nums[4] = 133 。
 * 可以证明不存在值大于 133 的有序下标三元组。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * 解释：唯一的下标三元组 (0, 1, 2) 的值是一个负数，(nums[0] - nums[1]) * nums[2] = -3 。因此，答案是 0 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="hhttps://leetcode.cn/problems/maximum-value-of-an-ordered-triplet-ii/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2874_MaximumTripletValue {
    public long maximumTripletValue(int[] nums) {
        int[] suffixMax = new int[nums.length];
        suffixMax[nums.length - 1] = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(nums[i], suffixMax[i + 1]);
        }
        long ans = 0;
        int preMax = nums[0];
        for (int j = 1; j < nums.length-1; j++) {
            long temp = (long) (preMax - nums[j]) * suffixMax[j + 1];
            ans = Math.max(ans, temp);
            preMax = Math.max(nums[j], preMax);
        }
        return ans;
    }
}
