package com.yaronxiong.algorithms.leetcode.l0;

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
        System.out.println(l918MaxSubarraySumCircular.maxSubarraySumCircular(new int[]{1,-2,3,-2}));
    }

    public int maxSubarraySumCircular(int[] nums) {
        //找最小值
        int minValue = Integer.MAX_VALUE;
        int maxValue = Integer.MIN_VALUE;
        int[] minDp = new int[nums.length + 1];
        int[] maxDp = new int[nums.length + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            minDp[i + 1] = Math.min(minDp[i] + nums[i], nums[i]);
            maxDp[i + 1] = Math.max(maxDp[i] + nums[i], nums[i]);
            minValue = Math.min(minValue, minDp[i + 1]);
            maxValue = Math.max(maxValue, maxDp[i + 1]);
        }
        if (sum == minValue) {
            //说明全是负数此时最大值
            return maxValue;
        }
        return Math.max(maxValue, sum - minValue);
    }

}
