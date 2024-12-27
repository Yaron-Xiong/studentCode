package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3250. 单调数组对的数目 I
 * 算术评级: 6
 * 第 410 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1898
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的 正 整数数组 nums 。
 * <p>
 * 如果两个 非负 整数数组 (arr1, arr2) 满足以下条件，我们称它们是 单调 数组对：
 * <p>
 * 两个数组的长度都是 n 。
 * arr1 是单调 非递减 的，换句话说 arr1[0] <= arr1[1] <= ... <= arr1[n - 1] 。
 * arr2 是单调 非递增 的，换句话说 arr2[0] >= arr2[1] >= ... >= arr2[n - 1] 。
 * 对于所有的 0 <= i <= n - 1 都有 arr1[i] + arr2[i] == nums[i] 。
 * 请你返回所有 单调 数组对的数目。
 * <p>
 * 由于答案可能很大，请你将它对 109 + 7 取余 后返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 单调数组对包括：
 * <p>
 * ([0, 1, 1], [2, 2, 1])
 * ([0, 1, 2], [2, 2, 0])
 * ([0, 2, 2], [2, 1, 0])
 * ([1, 2, 2], [1, 1, 0])
 * 示例 2：
 * <p>
 * 输入：nums = [5,5,5,5]
 * <p>
 * 输出：126
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 2000
 * 1 <= nums[i] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-count-of-monotonic-pairs-i/description/?envType=daily-question&envId=2024-11-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3250_CountOfPairs {
    public static void main(String[] args) {
        L3250_CountOfPairs l3250CountOfPairs = new L3250_CountOfPairs();
        System.out.println(l3250CountOfPairs.countOfPairs(new int[]{2, 3, 2}));
    }

    int maxV = 50;
    int mod = 1000000007;

    public int countOfPairs(int[] nums) {
        maxV = Arrays.stream(nums).max().getAsInt();
        long[][] memo = new long[nums.length][maxV + 1];
        for (int i = 0; i < nums.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        long ans = 0;
        for (int curArr1Val = 0; curArr1Val <= maxV && nums[0] - curArr1Val >= 0; curArr1Val++) {
            ans += dfs(0, curArr1Val, nums, memo);
            ans %= mod;
        }
        return (int) (ans % mod);
    }

    public long dfs(int i, int preArr1Val, int[] nums, long[][] memo) {
        if (i == nums.length - 1) {
            return 1;
        }
        if (memo[i][preArr1Val] != -1) {
            return memo[i][preArr1Val];
        }
        //下一个位置能填什么？
        //i+1 在选择后需要保证以下情况
        long ans = 0;
        int preArr2Val = nums[i] - preArr1Val;
        for (int curArr1Val = preArr1Val; curArr1Val <= maxV; curArr1Val++) {
            if (nums[i + 1] - curArr1Val < 0) {
                break;
            }
            if (nums[i + 1] - curArr1Val > preArr2Val) {
                continue;
            }
            ans += dfs(i + 1, curArr1Val, nums, memo);
            ans %= mod;
        }
        return memo[i][preArr1Val] = ans;
    }

}
