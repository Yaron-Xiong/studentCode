package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1295. 统计位数为偶数的数字
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，请你返回其中包含 偶数 个数位的数字的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [12,345,2,6,7896]
 * 输出：2
 * 解释：
 * 12 是 2 位数字（位数为偶数）
 * 345 是 3 位数字（位数为奇数）
 * 2 是 1 位数字（位数为奇数）
 * 6 是 1 位数字 位数为奇数）
 * 7896 是 4 位数字（位数为偶数）
 * 因此只有 12 和 7896 是位数为偶数的数字
 * 示例 2：
 * <p>
 * 输入：nums = [555,901,482,1771]
 * 输出：1
 * 解释：
 * 只有 1771 是位数为偶数的数字。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-numbers-with-even-number-of-digits/description/?envType=daily-question&envId=2025-04-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1295_FindNumbers {
    public static void main(String[] args) {
        L1295_FindNumbers l1295FindNumbers = new L1295_FindNumbers();
        System.out.println(l1295FindNumbers.findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }

    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (getDigitCount(num) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    private int getDigitCount(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num /= 10;
        }
        return count;
    }
}
