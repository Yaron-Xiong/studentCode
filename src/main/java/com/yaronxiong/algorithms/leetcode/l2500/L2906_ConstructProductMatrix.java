package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2906. 构造乘积矩阵
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、大小为 n * m 的二维整数矩阵 grid ，
 * 定义一个下标从 0 开始、大小为 n * m 的的二维矩阵 p。如果满足以下条件，则称 p 为 grid 的 乘积矩阵 ：
 * <p>
 * 对于每个元素 p[i][j] ，它的值等于除了 grid[i][j] 外所有元素的乘积。乘积对 12345 取余数。
 * 返回 grid 的乘积矩阵。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,2],[3,4]]
 * 输出：[[24,12],[8,6]]
 * 解释：p[0][0] = grid[0][1] * grid[1][0] * grid[1][1] = 2 * 3 * 4 = 24
 * p[0][1] = grid[0][0] * grid[1][0] * grid[1][1] = 1 * 3 * 4 = 12
 * p[1][0] = grid[0][0] * grid[0][1] * grid[1][1] = 1 * 2 * 4 = 8
 * p[1][1] = grid[0][0] * grid[0][1] * grid[1][0] = 1 * 2 * 3 = 6
 * 所以答案是 [[24,12],[8,6]] 。
 * 示例 2：
 * <p>
 * 输入：grid = [[12345],[2],[1]]
 * 输出：[[2],[0],[0]]
 * 解释：p[0][0] = grid[0][1] * grid[0][2] = 2 * 1 = 2
 * p[0][1] = grid[0][0] * grid[0][2] = 12345 * 1 = 12345. 12345 % 12345 = 0 ，所以 p[0][1] = 0
 * p[0][2] = grid[0][0] * grid[0][1] = 12345 * 2 = 24690. 24690 % 12345 = 0 ，所以 p[0][2] = 0
 * 所以答案是 [[2],[0],[0]] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == grid.length <= 105
 * 1 <= m == grid[i].length <= 105
 * 2 <= n * m <= 105
 * 1 <= grid[i][j] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/construct-product-matrix/description/?envType=daily-question&envId=2026-03-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2906_ConstructProductMatrix {
    public static void main(String[] args) {
        L2906_ConstructProductMatrix l2906ConstructProductMatrix = new L2906_ConstructProductMatrix();
        System.out.println(Arrays.deepToString(l2906ConstructProductMatrix.constructProductMatrix(new int[][]{
                {7, 9, 3, 5, 1, 1, 9, 6, 5, 7, 2, 10, 8, 1, 1, 5, 10, 4, 10, 9, 5, 1},
                {10, 6, 10, 1, 10, 8, 1, 4, 2, 10, 5, 1, 4, 2, 6, 5, 8, 10, 4, 5, 6, 3},
                {2, 10, 2, 5, 5, 6, 10, 10, 6, 2, 7, 2, 3, 2, 1, 2, 10, 2, 3, 8, 8, 4},
                {3, 5, 6, 6, 6, 9, 8, 3, 6, 8, 5, 6, 9, 7, 3, 1, 10, 9, 5, 9, 2, 9},
                {8, 1, 1, 3, 5, 1, 2, 9, 4, 6, 7, 8, 2, 9, 2, 2, 3, 5, 1, 1, 3, 6}})));
        System.out.println(Arrays.deepToString(l2906ConstructProductMatrix.constructProductMatrix(new int[][]{{12345}, {2}, {1}})));
        System.out.println(Arrays.deepToString(l2906ConstructProductMatrix.constructProductMatrix(new int[][]{{1, 2}, {3, 4}})));
        System.out.println(Arrays.deepToString(l2906ConstructProductMatrix.constructProductMatrix(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}})));
    }

    public int[][] constructProductMatrix(int[][] grid) {
        long pre = 1;
        int[][] ans = new int[grid.length][grid[0].length];
        //前缀
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                ans[i][j] = (int) pre;
                pre = (grid[i][j] * pre) % 12345;
            }
        }
        //后缀
        long sub = 1;
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[i].length - 1; j >= 0; j--) {
                ans[i][j] = (int) ((ans[i][j] * sub) % 12345);
                sub = (sub * grid[i][j]) % 12345;
            }
        }
        return ans;
    }
}
