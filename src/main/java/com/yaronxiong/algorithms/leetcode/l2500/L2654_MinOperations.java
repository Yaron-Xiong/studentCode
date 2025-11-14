package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2654. 使数组所有元素变成 1 的最少操作次数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的 正 整数数组 nums 。你可以对数组执行以下操作 任意 次：
 * <p>
 * 选择一个满足 0 <= i < n - 1 的下标 i ，将 nums[i] 或者 nums[i+1] 两者之一替换成它们的最大公约数。
 * 请你返回使数组 nums 中所有元素都等于 1 的 最少 操作次数。如果无法让数组全部变成 1 ，请你返回 -1 。
 * <p>
 * 两个正整数的最大公约数指的是能整除这两个数的最大正整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,3,4]
 * 输出：4
 * 解释：我们可以执行以下操作：
 * - 选择下标 i = 2 ，将 nums[2] 替换为 gcd(3,4) = 1 ，得到 nums = [2,6,1,4] 。
 * - 选择下标 i = 1 ，将 nums[1] 替换为 gcd(6,1) = 1 ，得到 nums = [2,1,1,4] 。
 * - 选择下标 i = 0 ，将 nums[0] 替换为 gcd(2,1) = 1 ，得到 nums = [1,1,1,4] 。
 * - 选择下标 i = 2 ，将 nums[3] 替换为 gcd(1,4) = 1 ，得到 nums = [1,1,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,10,6,14]
 * 输出：-1
 * 解释：无法将所有元素都变成 1 。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 50
 * 1 <= nums[i] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-operations-to-make-all-array-elements-equal-to-1/description/?envType=daily-question&envId=2025-11-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2654_MinOperations {
    public int minOperations(int[] nums) {
        int allGcd = 0;
        int cnt1 = 0;
        for (int num : nums) {
            allGcd = gcd(allGcd, num);
            if (num == 1) {
                cnt1++;
            }
        }
        if (cnt1 != 0) {
            return nums.length - cnt1;
        }
        if (allGcd != 1) {
            return -1;
        }

        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int g = 0;
            for (int j = i; j < nums.length; j++) {
                g = gcd(g, nums[j]);
                if (g == 1) {
                    minLen = Math.min(minLen, j - i);
                    break;
                }
            }
        }
        return minLen + nums.length - 1;
    }

    private int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
}
