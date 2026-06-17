package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2574. 左右元素和的差值
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的长度为 n 的整数数组 nums。
 * <p>
 * 定义两个数组 leftSum 和 rightSum，其中：
 * <p>
 * leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
 * rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
 * 返回长度为 n 数组 answer，其中 answer[i] = |leftSum[i] - rightSum[i]|。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,4,8,3]
 * 输出：[15,1,11,22]
 * 解释：数组 leftSum 为 [0,10,14,22] 且数组 rightSum 为 [15,11,3,0] 。
 * 数组 answer 为 [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[0]
 * 解释：数组 leftSum 为 [0] 且数组 rightSum 为 [0] 。
 * 数组 answer 为 [|0 - 0|] = [0] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/left-and-right-sum-differences/description/?envType=daily-question&envId=2026-06-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2574_LeftRightDifference {
    public static void main(String[] args) {
        L2574_LeftRightDifference l2574LeftRightDifference = new L2574_LeftRightDifference();
        System.out.println(Arrays.toString(l2574LeftRightDifference.leftRightDifference(new int[]{10, 4, 8, 3})));
        System.out.println(Arrays.toString(l2574LeftRightDifference.leftRightDifference(new int[]{1})));
    }

    public int[] leftRightDifference(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            ans[i] = ans[i - 1] + nums[i - 1];
        }
        int rightSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            ans[i] = Math.abs(ans[i] - rightSum);
            rightSum += nums[i];
        }
        return ans;
    }
}
