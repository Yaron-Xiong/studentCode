package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3202. 找出有效子序列的最大长度 II
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个 正 整数 k 。
 * nums 的一个 子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列 ：
 * <p>
 * (sub[0] + sub[1]) % k == (sub[1] + sub[2]) % k == ... == (sub[x - 2] + sub[x - 1]) % k
 * 返回 nums 的 最长有效子序列 的长度。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5], k = 2
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 最长有效子序列是 [1, 2, 3, 4, 5] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,2,3,1,4], k = 3
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 最长有效子序列是 [1, 4, 1, 4] 。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 103
 * 1 <= nums[i] <= 107
 * 1 <= k <= 103
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-maximum-length-of-valid-subsequence-ii/description/?envType=daily-question&envId=2025-07-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3202_MaximumLength {
    public int maximumLength(int[] nums, int k) {
        //a0 a1 a2 a3 a4
        //假设上面的符合规则
        //那么会出现
        //(a0-a2) % k = 0
        //(a1-a3) % k = 0
        //(a2-a4) % k = 0
        //(ai-ai+2) %k = 0

        //假设 a0 跟 a2 可以，那么[a0,a1,a2] 是一个结果
        //那么可以选择[a0,a1,a2,a3]?
        return 0;
    }
}
