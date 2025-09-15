package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1277. 统计全为 1 的正方形子矩阵
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 * <p>
 * 输入：matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-square-submatrices-with-all-ones/description/?envType=daily-question&envId=2025-08-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1277_CountSquares {
    public static void main(String[] args) {
        L1277_CountSquares l1277CountSquares = new L1277_CountSquares();
        System.out.println(l1277CountSquares.countSquares2(new int[][]{{0,1,1,1},{1,1,1,1},{0,1,1,1}}));
    }

    public int countSquares2(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    continue;
                } else if (i - 1 < 0 || j - 1 < 0) {
                    dp[i][j] = matrix[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
                ans +=  dp[i][j];
            }
        }
        return ans;
    }

    public int countSquares(int[][] matrix) {
        //二维前缀和
        int res = 0;
        int[][] preSum = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[0].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + matrix[i - 1][j - 1];
                int offest = 1;
                while (i - offest >= 0 && j - offest >= 0) {
                    int v = preSum[i][j] - preSum[i - offest][j] - preSum[i][j - offest] + preSum[i - offest][j - offest];
                    if (v != offest * offest) {
                        break;
                    }
                    res++;
                    offest++;
                }
            }
        }
        return res;
    }
}
