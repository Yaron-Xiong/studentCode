package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2535. 数组元素和与数字和的绝对差
 * 算术评级: 2
 * 第 328 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1222
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数数组 nums 。
 * <p>
 * 元素和 是 nums 中的所有元素相加求和。
 * 数字和 是 nums 中每一个元素的每一数位（重复数位需多次求和）相加求和。
 * 返回 元素和 与 数字和 的绝对差。
 * <p>
 * 注意：两个整数 x 和 y 的绝对差定义为 |x - y| 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,15,6,3]
 * 输出：9
 * 解释：
 * nums 的元素和是 1 + 15 + 6 + 3 = 25 。
 * nums 的数字和是 1 + 1 + 5 + 6 + 3 = 16 。
 * 元素和与数字和的绝对差是 |25 - 16| = 9 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 解释：
 * nums 的元素和是 1 + 2 + 3 + 4 = 10 。
 * nums 的数字和是 1 + 2 + 3 + 4 = 10 。
 * 元素和与数字和的绝对差是 |10 - 10| = 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2000
 * 1 <= nums[i] <= 2000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/difference-between-element-sum-and-digit-sum-of-an-array/description/?envType=daily-question&envId=2024-09-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2535_DifferenceOfSum {
    public int differenceOfSum(int[] nums) {
        int sum = 0;
        int digitSum = 0;
        for (int num : nums) {
            sum += num;
            while (num != 0) {
                digitSum += num % 10;
                num /= 10;
            }
        }
        return Math.abs(sum - digitSum);
    }
}
