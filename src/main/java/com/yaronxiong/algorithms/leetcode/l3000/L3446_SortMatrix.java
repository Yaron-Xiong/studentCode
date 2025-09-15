package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3446. 按对角线进行矩阵排序
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个大小为 n x n 的整数方阵 grid。返回一个经过如下调整的矩阵：
 * <p>
 * 左下角三角形（包括中间对角线）的对角线按 非递增顺序 排序。
 * 右上角三角形 的对角线按 非递减顺序 排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[1,7,3],[9,8,2],[4,5,6]]
 * <p>
 * 输出： [[8,2,3],[9,6,7],[4,5,1]]
 * <p>
 * 解释：
 * <p>
 * 标有黑色箭头的对角线（左下角三角形）应按非递增顺序排序：
 * <p>
 * [1, 8, 6] 变为 [8, 6, 1]。
 * [9, 5] 和 [4] 保持不变。
 * 标有蓝色箭头的对角线（右上角三角形）应按非递减顺序排序：
 * <p>
 * [7, 2] 变为 [2, 7]。
 * [3] 保持不变。
 * 示例 2：
 * <p>
 * 输入： grid = [[0,1],[1,2]]
 * <p>
 * 输出： [[2,1],[1,0]]
 * <p>
 * 解释：
 * <p>
 * 标有黑色箭头的对角线必须按非递增顺序排序，因此 [0, 2] 变为 [2, 0]。其他对角线已经符合要求。
 * <p>
 * 示例 3：
 * <p>
 * 输入： grid = [[1]]
 * <p>
 * 输出： [[1]]
 * <p>
 * 解释：
 * <p>
 * 只有一个元素的对角线已经符合要求，因此无需修改。
 * <p>
 * 提示：
 * <p>
 * grid.length == grid[i].length == n
 * 1 <= n <= 10
 * -105 <= grid[i][j] <= 105
 */
public class L3446_SortMatrix {
    public static void main(String[] args) {
        L3446_SortMatrix l3446SortMatrix = new L3446_SortMatrix();
        for (int[] anInt : l3446SortMatrix.sortMatrix(new int[][]{{1, 7, 3}, {9, 8, 2}, {4, 5, 6}})) {
            System.out.println(Arrays.toString(anInt));
        }
        for (int[] anInt : l3446SortMatrix.sortMatrix(new int[][]{{-1, 7, 3}, {5, -3, 2}, {4, 9, 0}})) {
            System.out.println(Arrays.toString(anInt));
        }
    }

    public int[][] sortMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            //按递减
            //写一个冒泡把
            //起始位置 (i,0) 终点位置
            for (int j = 0; j < grid.length - i; j++) {
                for (int x = i, y = 0; x + 1 < grid.length - j && y + 1 < grid[0].length - j; x++, y++) {
                    if (grid[x][y] <= grid[x + 1][y + 1]) {
                        //交换
                        int temp = grid[x][y];
                        grid[x][y] = grid[x + 1][y + 1];
                        grid[x + 1][y + 1] = temp;
                    }
                }
            }
        }

        for (int i = 1; i < grid[0].length; i++) {
            //按递增
            //写一个冒泡把
            //起始位置 (0,i) 终点位置
            for (int j = 0; j < grid[0].length - i; j++) {
                for (int x = 0, y = i; x + 1 < grid.length - j && y + 1 < grid[0].length - j; x++, y++) {
                    if (grid[x][y] >= grid[x + 1][y + 1]) {
                        //交换
                        int temp = grid[x][y];
                        grid[x][y] = grid[x + 1][y + 1];
                        grid[x + 1][y + 1] = temp;
                    }
                }
            }
        }
        return grid;
    }
}
