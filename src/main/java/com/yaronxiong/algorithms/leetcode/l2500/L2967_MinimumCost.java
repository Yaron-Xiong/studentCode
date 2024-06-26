package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2967. 使数组成为等数数组的最小代价
 * 尝试过
 * 中等
 * 相关企业
 * 提示
 * 给你一个长度为 n 下标从 0 开始的整数数组 nums 。
 * <p>
 * 你可以对 nums 执行特殊操作 任意次 （也可以 0 次）。每一次特殊操作中，你需要 按顺序 执行以下步骤：
 * <p>
 * 从范围 [0, n - 1] 里选择一个下标 i 和一个 正 整数 x 。
 * 将 |nums[i] - x| 添加到总代价里。
 * 将 nums[i] 变为 x 。
 * 如果一个正整数正着读和反着读都相同，那么我们称这个数是 回文数 。比方说，121 ，2552 和 65756 都是回文数，但是 24 ，46 ，235 都不是回文数。
 * <p>
 * 如果一个数组中的所有元素都等于一个整数 y ，且 y 是一个小于 109 的 回文数 ，那么我们称这个数组是一个 等数数组 。
 * <p>
 * 请你返回一个整数，表示执行任意次特殊操作后使 nums 成为 等数数组 的 最小 总代价。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：6
 * 解释：我们可以将数组中所有元素变为回文数 3 得到等数数组，
 * 数组变成 [3,3,3,3,3] 需要执行 4 次特殊操作，代价为 |1 - 3| + |2 - 3| + |4 - 3| + |5 - 3| = 6 。
 * 将所有元素变为其他回文数的总代价都大于 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,12,13,14,15]
 * 输出：11
 * 解释：我们可以将数组中所有元素变为回文数 11 得到等数数组，
 * 数组变成 [11,11,11,11,11] 需要执行 5 次特殊操作，代价为 |10 - 11| + |12 - 11| + |13 - 11| + |14 - 11| + |15 - 11| = 11 。
 * 将所有元素变为其他回文数的总代价都大于 11 。
 * 示例 3 ：
 * <p>
 * 输入：nums = [22,33,22,33,22]
 * 输出：22
 * 解释：我们可以将数组中所有元素变为回文数 22 得到等数数组，
 * 数组变为 [22,22,22,22,22] 需要执行 2 次特殊操作，代价为 |33 - 22| + |33 - 22| = 22 。
 * 将所有元素变为其他回文数的总代价都大于 22 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 1 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-cost-to-make-array-equalindromic/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2967_MinimumCost {
    public static void main(String[] args) {
        L2967_MinimumCost l2967MinimumCost = new L2967_MinimumCost();
        System.out.println(l2967MinimumCost.minimumCost(new int[]{}));
    }
    public long minimumCost(int[] nums) {
        Arrays.sort(nums);
        int mid = nums.length >> 1;
        if (check(nums[mid])) {
            return cost(nums, nums[mid]);
        }
        //找到最靠近mid的中位数有两个，一个是 <mid 一个是>mid
        int temp = nums[mid];
        int a;
        int b;
        while (true) {
            if (check(temp)) {
                a = temp;
                break;
            }
            temp--;
        }
        temp = nums[mid];
        while (true) {
            if (check(temp)) {
                b = temp;
                break;
            }
            temp++;
        }
        return Math.min(cost(nums, a), cost(nums, b));
    }

    private long cost(int[] nums, int num) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += Math.abs(nums[i] - num);
        }
        return ans;
    }

    public boolean check(int value) {
        String str = String.valueOf(value);
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
