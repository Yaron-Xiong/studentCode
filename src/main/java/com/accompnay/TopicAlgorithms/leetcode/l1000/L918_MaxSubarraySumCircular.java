package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 918. 环形子数组的最大和
 * 提示
 * 中等
 * 499
 * 相关企业
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * <p>
 * 环形数组 意味着数组的末端将会与开头相连呈环状。
 * 形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * <p>
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
 * 形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-2,3,-2]
 * 输出：3
 * 解释：从子数组 [3] 得到最大和 3
 * 示例 2：
 * <p>
 * 输入：nums = [5,-3,5]
 * 输出：10
 * 解释：从子数组 [5,5] 得到最大和 5 + 5 = 10
 * 示例 3：
 * <p>
 * 输入：nums = [3,-2,2,-3]
 * 输出：3
 * 解释：从子数组 [3] 和 [3,-2,2] 都可以得到最大和 3
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 3 * 104
 * -3 * 104 <= nums[i] <= 3 * 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-sum-circular-subarray/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L918_MaxSubarraySumCircular {
    public static void main(String[] args) {
        L918_MaxSubarraySumCircular l918MaxSubarraySumCircular = new L918_MaxSubarraySumCircular();
        System.out.println(l918MaxSubarraySumCircular.maxSubarraySumCircular(new int[]{-3, -2, -3}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int maxValue = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            maxValue = Math.max(maxValue, dp[i]);
        }
        int minValue = nums[0];
        int sum = nums[0];
        for (int i = 1; i < dp.length; i++) {
            sum += nums[i];
            dp[i] = Math.min(nums[i], dp[i - 1] + nums[i]);
            minValue = Math.min(minValue, dp[i]);
        }
        //如果maxValue 小于0 说明整个数组都是负数
        return maxValue < 0 ? maxValue : Math.max(maxValue, sum - minValue);
    }

}
