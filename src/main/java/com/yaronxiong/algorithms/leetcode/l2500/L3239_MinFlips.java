package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3239. 最少翻转次数使二进制矩阵回文 I
 * 算术评级: 3
 * 第 136 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1388
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m x n 的二进制矩阵 grid 。
 * <p>
 * 如果矩阵中一行或者一列从前往后与从后往前读是一样的，那么我们称这一行或者这一列是 回文 的。
 * <p>
 * 你可以将 grid 中任意格子的值 翻转 ，也就是将格子里的值从 0 变成 1 ，或者从 1 变成 0 。
 * <p>
 * 请你返回 最少 翻转次数，使得矩阵 要么 所有行是 回文的 ，要么所有列是 回文的 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,0,0],[0,0,0],[0,0,1]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 将高亮的格子翻转，得到所有行都是回文的。
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[0,1],[0,1],[0,0]]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 将高亮的格子翻转，得到所有列都是回文的。
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[1],[0]]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 所有行已经是回文的。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m * n <= 2 * 105
 * 0 <= grid[i][j] <= 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-flips-to-make-binary-grid-palindromic-i/?envType=daily-question&envId=2024-11-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3239_MinFlips {
    public int minFlips(int[][] grid) {
        //试试行
        int rowN = grid.length;
        int colN = grid[0].length;
        int rowNHalf = grid.length / 2;
        int colNHalf = grid[0].length / 2;
        int v1 = 0;
        for (int row = 0; row < rowN; row++) {
            for (int col = 0; col < colNHalf; col++) {
                if (grid[row][col] != grid[row][colN - col - 1]) {
                    v1++;
                }
            }
        }
        int v2 = 0;
        //试试列
        for (int col = 0; col < colN; col++) {
            for (int row = 0; row < rowNHalf; row++) {
                if (grid[row][col] != grid[rowN - row - 1][col]) {
                    v2++;
                }
            }
        }
        return Math.min(v1, v2);
    }
}
