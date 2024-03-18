package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 213. 打家劫舍 II
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/house-robber-ii/description/?envType=daily-question&envId=2023-09-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L213_RobII {
    public int rob(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int v1 = dp(nums, 0, nums.length - 2);
        int v2 = dp(nums, 1, nums.length - 1);
        return Math.max(v1, v2);
    }

    public int dp(int[] nums, int left, int right) {
        int dp0 = 0;
        int dp1 = nums[left];
        for (int i = left + 1; i <= right; i++) {
            int temp = Math.max(dp1, dp0);
            dp1 = dp0 + nums[i];
            dp0 = temp;
        }
        return Math.max(dp1, dp0);
    }
}
