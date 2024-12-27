package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3194. 最小元素和最大元素的最小平均值
 * 算术评级: 2
 * 第 403 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1195
 * 相关标签
 * 相关企业
 * 提示
 * 你有一个初始为空的浮点数数组 averages。另给你一个包含 n 个整数的数组 nums，其中 n 为偶数。
 * <p>
 * 你需要重复以下步骤 n / 2 次：
 * <p>
 * 从 nums 中移除 最小 的元素 minElement 和 最大 的元素 maxElement。
 * 将 (minElement + maxElement) / 2 加入到 averages 中。
 * 返回 averages 中的 最小 元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [7,8,3,4,15,13,4,1]
 * <p>
 * 输出： 5.5
 * <p>
 * 解释：
 * <p>
 * 步骤	nums	averages
 * 0	[7,8,3,4,15,13,4,1]	[]
 * 1	[7,8,3,4,13,4]	[8]
 * 2	[7,8,4,4]	[8,8]
 * 3	[7,4]	[8,8,6]
 * 4	[]	[8,8,6,5.5]
 * 返回 averages 中最小的元素，即 5.5。
 * 示例 2：
 * <p>
 * 输入： nums = [1,9,8,3,10,5]
 * <p>
 * 输出： 5.5
 * <p>
 * 解释：
 * <p>
 * 步骤	nums	averages
 * 0	[1,9,8,3,10,5]	[]
 * 1	[9,8,3,5]	[5.5]
 * 2	[8,5]	[5.5,6]
 * 3	[]	[5.5,6,6.5]
 * 示例 3：
 * <p>
 * 输入： nums = [1,2,3,7,8,9]
 * <p>
 * 输出： 5.0
 * <p>
 * 解释：
 * <p>
 * 步骤	nums	averages
 * 0	[1,2,3,7,8,9]	[]
 * 1	[2,3,7,8]	[5]
 * 2	[3,7]	[5,5]
 * 3	[]	[5,5,5]
 * <p>
 * 提示：
 * <p>
 * 2 <= n == nums.length <= 50
 * n 为偶数。
 * 1 <= nums[i] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-average-of-smallest-and-largest-elements/description/?envType=daily-question&envId=2024-10-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3194_MinimumAverage {
    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length / 2; i++) {
            ans = Math.min(ans, nums[i] + nums[nums.length - 1 - i]);
        }
        return ans / 2.0;
    }
}
