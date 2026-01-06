package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1975. 最大方阵和
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 n x n 的整数方阵 matrix 。你可以执行以下操作 任意次 ：
 *
 * 选择 matrix 中 相邻 两个元素，并将它们都 乘以 -1 。
 * 如果两个元素有 公共边 ，那么它们就是 相邻 的。
 *
 * 你的目的是 最大化 方阵元素的和。请你在执行以上操作之后，返回方阵的 最大 和。
 *
 * 示例 1：
 *
 *
 * 输入：matrix = [[1,-1],[-1,1]]
 * 输出：4
 * 解释：我们可以执行以下操作使和等于 4 ：
 * - 将第一行的 2 个元素乘以 -1 。
 * - 将第一列的 2 个元素乘以 -1 。
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
 * 输出：16
 * 解释：我们可以执行以下操作使和等于 16 ：
 * - 将第二行的最后 2 个元素乘以 -1 。
 *
 * 提示：
 *
 * n == matrix.length == matrix[i].length
 * 2 <= n <= 250
 * -105 <= matrix[i][j] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-matrix-sum/description/?envType=daily-question&envId=2026-01-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1975_MaxMatrixSum {
    public long maxMatrixSum(int[][] matrix) {
        long ans = 0;
        int negCnt = 0;
        int mn = Integer.MAX_VALUE;
        for (int[] arr : matrix) {
            for (int x : arr) {
                if (x < 0) {
                    negCnt++;
                    x = -x;
                }
                mn = Math.min(mn, x);
                ans += x;
            }
        }
        //如果存在偶个数负数，那么通过运算可以全部变成正数
        if (negCnt % 2 == 0) {
            return ans;
        }
        //如果存在奇数个负数，那么会剩下一个负数
        return ans - mn * 2L;
    }

}
