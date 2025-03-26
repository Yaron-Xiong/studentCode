package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 2711. 对角线上不同值的数量差
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、大小为 m x n 的二维矩阵 grid ，请你求解大小同样为 m x n 的答案矩阵 answer 。
 * <p>
 * 矩阵 answer 中每个单元格 (r, c) 的值可以按下述方式进行计算：
 * <p>
 * 令 topLeft[r][c] 为矩阵 grid 中单元格 (r, c) 左上角对角线上 不同值 的数量。
 * 令 bottomRight[r][c] 为矩阵 grid 中单元格 (r, c) 右下角对角线上 不同值 的数量。
 * 然后 answer[r][c] = |topLeft[r][c] - bottomRight[r][c]| 。
 * <p>
 * 返回矩阵 answer 。
 * <p>
 * 矩阵对角线 是从最顶行或最左列的某个单元格开始，向右下方向走到矩阵末尾的对角线。
 * <p>
 * 如果单元格 (r1, c1) 和单元格 (r, c) 属于同一条对角线且 r1 < r ，则单元格 (r1, c1) 属于单元格 (r, c) 的左上对角线。类似地，可以定义右下对角线。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[3,1,5],[3,2,1]]
 * 输出：[[1,1,0],[1,0,1],[0,1,1]]
 * 解释：第 1 个图表示最初的矩阵 grid 。
 * 第 2 个图表示对单元格 (0,0) 计算，其中蓝色单元格是位于右下对角线的单元格。
 * 第 3 个图表示对单元格 (1,2) 计算，其中红色单元格是位于左上对角线的单元格。
 * 第 4 个图表示对单元格 (1,1) 计算，其中蓝色单元格是位于右下对角线的单元格，红色单元格是位于左上对角线的单元格。
 * - 单元格 (0,0) 的右下对角线包含 [1,1] ，而左上对角线包含 [] 。对应答案是 |1 - 0| = 1 。
 * - 单元格 (1,2) 的右下对角线包含 [] ，而左上对角线包含 [2] 。对应答案是 |0 - 1| = 1 。
 * - 单元格 (1,1) 的右下对角线包含 [1] ，而左上对角线包含 [1] 。对应答案是 |1 - 1| = 0 。
 * 其他单元格的对应答案也可以按照这样的流程进行计算。
 * 示例 2：
 * <p>
 * 输入：grid = [[1]]
 * 输出：[[0]]
 * 解释：- 单元格 (0,0) 的右下对角线包含 [] ，左上对角线包含 [] 。对应答案是 |0 - 0| = 0 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n, grid[i][j] <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/difference-of-number-of-distinct-values-on-diagonals/description/?envType=daily-question&envId=2025-03-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2711_DifferenceOfDistinctValues {
    public static void main(String[] args) {
        L2711_DifferenceOfDistinctValues l2711DifferenceOfDistinctValues = new L2711_DifferenceOfDistinctValues();
        int[][] ints = l2711DifferenceOfDistinctValues.differenceOfDistinctValues(new int[][]{{6,28,37,34,12,30,43,35,6},{21,47,38,14,31,49,11,14,49},{6,12,35,17,17,2,45,27,43},{34,41,30,28,45,24,50,20,4}});
        for (int[] anInt : ints) {
            String string = Arrays.toString(anInt);
            System.out.println(string);
        }
    }

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        //计算主对角线
        int[] fill2 = fill(0, 0, grid, ans);
        fillRight(fill2[0], fill2[1], grid, ans);
        for (int i = 1; i < m; i++) {
            //左上角
            int[] fill = fill(0, i, grid, ans);
            fillRight(fill[0], fill[1], grid, ans);
        }
        for (int i = 1; i < n; i++) {
            int[] fill1 = fill(i, 0, grid, ans);
            fillRight(fill1[0], fill1[1], grid, ans);
        }
        return ans;
    }

    public int[] fill(int x, int y, int[][] grid, int[][] ans) {
        Set<Integer> set = new HashSet<>();
        //左上角
        while (x < grid.length && y < grid[0].length) {
            ans[x][y] = set.size();
            set.add(grid[x][y]);
            x++;
            y++;
        }
        return new int[]{x - 1, y - 1};
    }

    public void fillRight(int x, int y, int[][] grid, int[][] ans) {
        Set<Integer> set = new HashSet<>();
        //右下角
        while (x >= 0 && y >= 0) {
            ans[x][y] = Math.abs(ans[x][y] - set.size());
            set.add(grid[x][y]);
            x--;
            y--;
        }
    }
}
