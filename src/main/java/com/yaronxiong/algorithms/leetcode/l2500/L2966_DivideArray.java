package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2966. 划分数组并满足最大差限制
 * 已解答
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums，以及一个正整数 k 。
 * <p>
 * 将这个数组划分为 n / 3 个长度为 3 的子数组，并满足以下条件：
 * <p>
 * 子数组中 任意 两个元素的差必须 小于或等于 k 。
 * 返回一个 二维数组 ，包含所有的子数组。如果不可能满足条件，就返回一个空数组。如果有多个答案，返回 任意一个 即可。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,8,7,9,3,5,1], k = 2
 * <p>
 * 输出：[[1,1,3],[3,4,5],[7,8,9]]
 * <p>
 * 解释：
 * <p>
 * 每个数组中任何两个元素之间的差小于或等于 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,2,2,5,2], k = 2
 * <p>
 * 输出：[]
 * <p>
 * 解释：
 * <p>
 * 将 nums 划分为 2 个长度为 3 的数组的不同方式有：
 * <p>
 * [[2,2,2],[2,4,5]] （及其排列）
 * [[2,2,4],[2,2,5]] （及其排列）
 * 因为有四个 2，所以无论我们如何划分，都会有一个包含元素 2 和 5 的数组。因为 5 - 2 = 3 > k，条件无法被满足，所以没有合法的划分。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [4,2,9,8,2,12,7,12,10,5,8,5,5,7,9,2,5,11], k = 14
 * <p>
 * 输出：[[2,2,12],[4,8,5],[5,9,7],[7,8,5],[5,9,10],[11,12,2]]
 * <p>
 * 解释：
 * <p>
 * 每个数组中任何两个元素之间的差小于或等于 14。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * n 是 3 的倍数
 * 1 <= nums[i] <= 105
 * 1 <= k <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/divide-array-into-arrays-with-max-difference/description/?envType=daily-question&envId=2025-06-18">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2966_DivideArray {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] ans = new int[nums.length / 3][3];
        for (int i = 0; i < nums.length; i += 3) {
            int groupId = i / 3;
            if (nums[i + 2] - nums[i] > k) {
                return new int[][]{};
            }
            ans[groupId] = new int[]{nums[i], nums[i + 1], nums[i + 2]};
        }
        return ans;
    }
}
