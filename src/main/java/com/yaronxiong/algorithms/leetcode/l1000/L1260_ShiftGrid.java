package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * 位于 grid[i][j]（j < n - 1）的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 * <p>
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shift-2d-grid/description/?envType=daily-question&envId=2026-07-20">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1260_ShiftGrid {
    public static void main(String[] args) {
        L1260_ShiftGrid l1260ShiftGrid = new L1260_ShiftGrid();
        System.out.println(l1260ShiftGrid.shiftGrid(new int[][]{{1}, {2}, {3}, {4}, {5}, {6}, {7}}, 23));
        System.out.println(l1260ShiftGrid.shiftGrid(new int[][]{{3, 8, 1, 9}, {19, 7, 2, 5}, {4, 6, 11, 10}, {12, 0, 21, 13}}, 4));
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int size = grid.length * grid[0].length;
        int[][] ans = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int target = (i * grid[i].length + j + k) % size;
                int tagetX = target / grid[i].length;
                int tagetY = target % grid[i].length;
                ans[tagetX][tagetY] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            res.add(list);
            for (int j = 0; j < grid[0].length; j++) {
                list.add(ans[i][j]);
            }
        }
        return res;
    }
}
