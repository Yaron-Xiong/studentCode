package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3040. 相同分数的最大操作数目 II
 * 算术评级: 6
 * 第 124 场双周赛
 * Q3
 * 1709
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：
 * <p>
 * 选择 nums 中最前面两个元素并且删除它们。
 * 选择 nums 中最后两个元素并且删除它们。
 * 选择 nums 中第一个和最后一个元素并且删除它们。
 * 一次操作的 分数 是被删除元素的和。
 * <p>
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 * <p>
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,2,3,4]
 * 输出：3
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,2,3,4] 。
 * - 删除第一个元素和最后一个元素，分数为 1 + 4 = 5 ，nums = [2,3] 。
 * - 删除第一个元素和最后一个元素，分数为 2 + 3 = 5 ，nums = [] 。
 * 由于 nums 为空，我们无法继续进行任何操作。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,6,1,4]
 * 输出：2
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
 * - 删除最后两个元素，分数为 1 + 4 = 5 ，nums = [6] 。
 * 至多进行 2 次操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2000
 * 1 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-of-operations-with-the-same-score-ii/description/?envType=daily-question&envId=2024-06-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3040_MaxOperations {
    public static void main(String[] args) {
        L3040_MaxOperations l3040MaxOperations = new L3040_MaxOperations();
        System.out.println(l3040MaxOperations.maxOperations(new int[]{13, 1, 11, 7, 15}));
    }

    int[][] memo;
    int[] nums;
    boolean done;

    public int maxOperations(int[] nums) {
        if (nums.length == 2)
            return 1;
        this.nums = nums;
        this.memo = new int[nums.length][nums.length];
        int lastIndex = nums.length - 1;
        int v1 = helper(2, lastIndex, nums[0] + nums[1]);
        int v2 = helper(0, lastIndex - 2, nums[lastIndex] + nums[lastIndex - 1]);
        int v3 = helper(1, lastIndex - 1, nums[0] + nums[lastIndex]);
        return Math.max(v1, Math.max(v2, v3)) + 1;
    }

    public int helper(int left, int right, int sore) {
        if (done) {
            return 0;
        }
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs2(left, right, sore);
    }

    public int dfs2(int left, int right, int sore) {
        int[] nums = this.nums;
        int[][] memo = this.memo;
        if (left >= right) {
            done = true;
            return 0;
        }
        if (right - left == 1) {
            return nums[right] + nums[left] == sore ? 1 : 0;
        }
        //如果头跟尾是一样的值 是可以跳过的
        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        //删除前两个
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        if (nums[left] + nums[left + 1] == sore) {
            v1 = dfs2(left + 2, right, sore) + 1;
        }
        if (nums[right - 1] + nums[right] == sore) {
            v2 = dfs2(left, right - 2, sore) + 1;
        }
        if (nums[left] + nums[right] == sore) {
            v3 = dfs2(left + 1, right - 1, sore) + 1;
        }
        int ans = Math.max(v1, Math.max(v2, v3));
        return memo[left][right] = ans;
    }
}
