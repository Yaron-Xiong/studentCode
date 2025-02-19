package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 59. 螺旋矩阵 II
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/spiral-matrix-ii/description/?envType=daily-question&envId=2025-02-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L59_GenerateMatrix {
    public static void main(String[] args) {
        L59_GenerateMatrix l59GenerateMatrix = new L59_GenerateMatrix();
        int[][] a = l59GenerateMatrix.generateMatrix(4);
        for (int[] ints : a) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int[][] forwards = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        dfs2(1, n, new int[]{0, 0}, matrix, forwards);
        return matrix;
    }

    private void dfs2(int v, int n, int[] curPosition, int[][] matrix, int[][] forwards) {
        if (n < 0) {
            return;
        }
        if (n == 1) {
            matrix[curPosition[0]][curPosition[1]] = v;
            return;
        }
        int curX = curPosition[0];
        int curY = curPosition[1];
        for (int[] forward : forwards) {
            //往某个方向前进
            for (int i = 0; i <= n - 2; i++) {
                matrix[curX][curY] = v++;
                curX += forward[0];
                curY += forward[1];
            }
        }
        dfs2(v, n - 2, new int[]{curX + 1, curY + 1}, matrix, forwards);
    }
}
