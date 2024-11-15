package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 3255. 长度为 K 的子数组的能量值 II
 * 已解答
 * 算术评级: 4
 * 第 137 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1595
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 和一个正整数 k 。
 * <p>
 * 一个数组的 能量值 定义为：
 * <p>
 * 如果 所有 元素都是依次 连续 且 上升 的，那么能量值为 最大 的元素。
 * 否则为 -1 。
 * 你需要求出 nums 中所有长度为 k 的
 * 子数组
 * 的能量值。
 * <p>
 * 请你返回一个长度为 n - k + 1 的整数数组 results ，其中 results[i] 是子数组 nums[i..(i + k - 1)] 的能量值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,3,2,5], k = 3
 * <p>
 * 输出：[3,4,-1,-1,-1]
 * <p>
 * 解释：
 * <p>
 * nums 中总共有 5 个长度为 3 的子数组：
 * <p>
 * [1, 2, 3] 中最大元素为 3 。
 * [2, 3, 4] 中最大元素为 4 。
 * [3, 4, 3] 中元素 不是 连续的。
 * [4, 3, 2] 中元素 不是 上升的。
 * [3, 2, 5] 中元素 不是 连续的。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2], k = 4
 * <p>
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,3,2,3,2], k = 2
 * <p>
 * 输出：[-1,3,-1,3,-1]
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= n
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-power-of-k-size-subarrays-ii/description/?envType=daily-question&envId=2024-11-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3255_ResultsArray {
    public static void main(String[] args) {
        L3255_ResultsArray l3255ResultsArray = new L3255_ResultsArray();
        System.out.println(Arrays.toString(l3255ResultsArray.resultsArray(new int[]{1, 2, 3, 4, 3, 2, 5}, 3)));
    }
    public int[] resultsArray(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Arrays.fill(ans, -1);
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] - 1 == nums[i - 1]) {
                cnt++;
            } else {
                cnt = 1;
            }
            if (cnt >= k) {
                ans[i - k + 1] = nums[i];
            }
        }
        return ans;
    }
}
