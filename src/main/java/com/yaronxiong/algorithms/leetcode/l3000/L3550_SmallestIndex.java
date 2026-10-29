package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3550. 数位和等于下标的最小下标
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。
 * <p>
 * 返回满足 nums[i] 的数位和（每一位数字相加求和）等于 i 的 最小 下标 i 。
 * <p>
 * 如果不存在满足要求的下标，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * nums[2] = 2，其数位和等于 2 ，与其下标 i = 2 相等。因此，输出为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,11]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums[1] = 10，其数位和等于 1 + 0 = 1，与其下标 i = 1 相等。
 * nums[2] = 11，其数位和等于是 1 + 1 = 2，与其下标 i = 2 相等。
 * 由于下标 1 是满足要求的最小下标，输出为 1 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * 由于不存在满足要求的下标，输出为 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-index-with-digit-sum-equal-to-index/description/?envType=daily-question&envId=2026-09-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3550_SmallestIndex {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int x = 0;
            while (num > 0) {
                x += num % 10;
                num /= 10;
            }
            if (x == i) {
                return i;
            }
        }
        return -1;
    }
}
