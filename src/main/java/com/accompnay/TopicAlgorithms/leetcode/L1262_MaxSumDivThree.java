package com.accompnay.TopicAlgorithms.leetcode;

/**
 * 1262. 可被三整除的最大和
 * 提示
 * 中等
 * 248
 * 相关企业
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素最大和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * <p>
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/greatest-sum-divisible-by-three/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1262_MaxSumDivThree {
    public static void main(String[] args) {
        L1262_MaxSumDivThree l1262MaxSumDivThree = new L1262_MaxSumDivThree();
        System.out.println(l1262MaxSumDivThree.maxSumDivThree(new int[]{1, 2, 3, 4, 4}));
    }

    public int maxSumDivThree(int[] nums) {
        int[][] dp = new int[nums.length + 1][3];
        dp[0][1] = Integer.MIN_VALUE;
        dp[0][2] = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i + 1][j] = Math.max(dp[i][j], dp[i][(nums[i] + j) % 3] + nums[i]);
            }
        }
        return dp[nums.length - 1][0] == Integer.MIN_VALUE ? 0 : dp[nums.length - 1][0];
    }

}
