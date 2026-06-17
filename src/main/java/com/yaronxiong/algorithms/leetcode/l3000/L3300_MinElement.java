package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3300. 替换为数位和以后的最小元素
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。
 * <p>
 * 请你将 nums 中每一个元素都替换为它的各个数位之 和 。
 * <p>
 * 请你返回替换所有元素以后 nums 中的 最小 元素。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,12,13,14]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 替换后变为 [1, 3, 4, 5] ，最小元素为 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 替换后变为 [1, 2, 3, 4] ，最小元素为 1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [999,19,199]
 * <p>
 * 输出：10
 * <p>
 * 解释：
 * <p>
 * nums 替换后变为 [27, 10, 19] ，最小元素为 10 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-element-after-replacement-with-digit-sum/description/?envType=daily-question&envId=2026-05-29">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3300_MinElement {
    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int j : nums) {
            int num = j;
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            ans = Math.min(ans, temp);
        }
        return ans;
    }
}
