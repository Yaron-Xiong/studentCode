package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3176. 求出最长好子序列 I
 * 算术评级: 6
 * 第 132 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1849
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个 非负 整数 k 。
 * 如果一个整数序列 seq 满足在范围下标范围 [0, seq.length - 2] 中存在 不超过 k 个下标 i 满足 seq[i] != seq[i + 1] ，那么我们称这个整数序列为 好 序列。
 * <p>
 * 请你返回 nums 中 好
 * 子序列
 * 的最长长度
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,1,3], k = 2
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 最长好子序列为 [1,2,1,1,3] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5,1], k = 0
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 最长好子序列为 [1,2,3,4,5,1] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 109
 * 0 <= k <= min(nums.length, 25)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-maximum-length-of-a-good-subsequence-i/description/?envType=daily-question&envId=2024-09-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3176_MaximumLength {
    public static void main(String[] args) {
        L3176_MaximumLength l3176MaximumLength = new L3176_MaximumLength();
        System.out.println(l3176MaximumLength.maximumLength(new int[]{29, 30, 30}, 0));
    }

    public int maximumLength(int[] nums, int k) {
        int[][][] memo = new int[nums.length + 1][nums.length + 1][k + 1];
        return dfs2(0, 0, k, nums, memo);
    }

    private int dfs2(int pre, int cur, int k, int[] nums, int[][][] memo) {
        if (cur == nums.length) {
            return 0;
        }
        if (memo[pre + 1][cur + 1][k] != 0) {
            return memo[pre + 1][cur + 1][k];
        }
        //当前节点删除
        int v1 = 0;
        if (pre == -1 || nums[pre] != nums[cur]) {
            v1 = dfs2(pre, cur + 1, k, nums, memo);
        }

        //当前节点不删除
        int v2 = 0;
        int newK = pre != -1 && nums[pre] != nums[cur] ? k - 1 : k;
        if (newK >= 0) {
            v2 = dfs2(cur, cur + 1, newK, nums, memo) + 1;
        }
        return memo[pre + 1][cur + 1][k] = Math.max(v1, v2);
    }


}
