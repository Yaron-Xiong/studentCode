package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 377. 组合总和 Ⅳ
 * 算术评级: 5
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 * <p>
 * 输入：nums = [9], target = 3
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 * <p>
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/combination-sum-iv/description/?envType=daily-question&envId=2024-04-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L377_CombinationSum4 {
    public static void main(String[] args) {
        L377_CombinationSum4 l377CombinationSum4 = new L377_CombinationSum4();
        System.out.println(l377CombinationSum4.combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return dfs(target, memo, nums);
    }

    private int dfs(int target, int[] memo, int[] nums) {
        if (target == 0) {
            return 1;
        }
        if (target < 0) {
            return 0;
        }
        if (memo[target] != -1) {
            return memo[target];
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int nextTarget = target - nums[i];
            if (nextTarget < 0) {
                break;
            }
            ans += dfs(nextTarget, memo, nums);
        }
        return memo[target] = ans;
    }
}
