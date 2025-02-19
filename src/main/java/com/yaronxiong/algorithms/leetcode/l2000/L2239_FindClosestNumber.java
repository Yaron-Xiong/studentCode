package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2239. 找到最接近 0 的数字
 * 算术评级: 1
 * 第 76 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1256
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-4,-2,1,4,8]
 * 输出：1
 * 解释：
 * -4 到 0 的距离为 |-4| = 4 。
 * -2 到 0 的距离为 |-2| = 2 。
 * 1 到 0 的距离为 |1| = 1 。
 * 4 到 0 的距离为 |4| = 4 。
 * 8 到 0 的距离为 |8| = 8 。
 * 所以，数组中距离 0 最近的数字为 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,-1,1]
 * 输出：1
 * 解释：1 和 -1 都是距离 0 最近的数字，所以返回较大值 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * -105 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-closest-number-to-zero/description/?envType=daily-question&envId=2025-01-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2239_FindClosestNumber {
    public int findClosestNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (Math.abs(nums[i]) < Math.abs(ans)) {
                ans = nums[i];
            } else if (Math.abs(nums[i]) == Math.abs(ans) && nums[i] > ans) {
                ans = nums[i];
            }
        }
        return ans;
    }
}
