package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2679. 矩阵中的和
 * 提示
 * 中等
 * 24
 * 相关企业
 * 给你一个下标从 0 开始的二维整数数组 nums 。一开始你的分数为 0 。你需要执行以下操作直到矩阵变为空：
 * <p>
 * 矩阵中每一行选取最大的一个数，并删除它。如果一行中有多个最大的数，选择任意一个并删除。
 * 在步骤 1 删除的所有数字中找到最大的一个数字，将它添加到你的 分数 中。
 * 请你返回最后的 分数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [[7,2,1],[6,4,2],[6,5,3],[3,2,1]]
 * 输出：15
 * 解释：第一步操作中，我们删除 7 ，6 ，6 和 3 ，将分数增加 7 。
 * 下一步操作中，删除 2 ，4 ，5 和 2 ，将分数增加 5 。最后删除 1 ，2 ，3 和 1 ，将分数增加 3 。所以总得分为 7 + 5 + 3 = 15 。
 * 示例 2：
 * <p>
 * 输入：nums = [[1]]
 * 输出：1
 * 解释：我们删除 1 并将分数增加 1 ，所以返回 1 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 300
 * 1 <= nums[i].length <= 500
 * 0 <= nums[i][j] <= 103
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sum-in-a-matrix/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2679_MatrixSum {
    public int matrixSum(int[][] nums) {
        for (int[] num : nums) {
            Arrays.sort(num);
        }
        int res = 0;
        for (int i = 0; i < nums[0].length; i++) {
            int temp = 0;
            for (int[] num : nums) {
                temp = Math.max(temp, num[i]);
            }
            res += temp;
        }
        return res;
    }
}
