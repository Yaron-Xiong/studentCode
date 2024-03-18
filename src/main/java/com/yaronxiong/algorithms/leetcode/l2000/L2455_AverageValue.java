package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2455. 可被三整除的偶数的平均值
 * 提示
 * 简单
 * 20
 * 相关企业
 * 给你一个由正整数组成的整数数组 nums ，返回其中可被 3 整除的所有偶数的平均值。
 * <p>
 * 注意：n 个元素的平均值等于 n 个元素 求和 再除以 n ，结果 向下取整 到最接近的整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,6,10,12,15]
 * 输出：9
 * 解释：6 和 12 是可以被 3 整除的偶数。(6 + 12) / 2 = 9 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,4,7,10]
 * 输出：0
 * 解释：不存在满足题目要求的整数，所以返回 0 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/average-value-of-even-numbers-that-are-divisible-by-three/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2455_AverageValue {
    public static void main(String[] args) {
        L2455_AverageValue l2455AverageValue = new L2455_AverageValue();
        System.out.println(l2455AverageValue.averageValue(new int[]{1, 3, 6, 10, 12, 15}));
    }

    public int averageValue(int[] nums) {
        int res = 0;
        int n = 0;
        for (int num : nums) {
            if (num % 2 == 0 && num % 3 == 0) {
                res += num;
                n++;
            }
        }
        return n == 0 ? 0 : res / n;
    }
}
