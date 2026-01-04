package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 840. 矩阵中的幻方
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 3 x 3 的幻方是一个填充有 从 1 到 9  的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * <p>
 * 给定一个由整数组成的row x col 的 grid，其中有多少个 3 × 3 的 “幻方” 子矩阵？
 * <p>
 * 注意：虽然幻方只能包含 1 到 9 的数字，但 grid 可以包含最多15的数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入: grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * <p>
 * 而这一个不是：
 * <p>
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 示例 2:
 * <p>
 * 输入: grid = [[8]]
 * 输出: 0
 * <p>
 * 提示:
 * <p>
 * row == grid.length
 * col == grid[i].length
 * 1 <= row, col <= 10
 * 0 <= grid[i][j] <= 15
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/magic-squares-in-grid/description/?envType=daily-question&envId=2025-12-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L840_NumMagicSquaresInside {
    public static void main(String[] args) {
        L840_NumMagicSquaresInside l840NumMagicSquaresInside = new L840_NumMagicSquaresInside();
        System.out.println(l840NumMagicSquaresInside.numMagicSquaresInside(new int[][]{{4, 3, 8, 4}, {9, 5, 1, 9}, {2, 7, 6, 2}}));
        System.out.println(l840NumMagicSquaresInside.numMagicSquaresInside(new int[][]{{8}}));
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                //以这个点开始，进行[3*3]的检查
                // X轴=Y轴=斜对角 且 不含重复元素
                //左上角=[i,j]
                //右上角=[i,j+2]
                //左下角=[i+2,j]
                //右下角=[i+2,j+2]
                //判断方案可行性
                if (i + 2 >= grid.length || j + 2 >= grid[0].length) {
                    continue;
                }
                if (isSameElement(grid, i, j)) {
                    continue;
                }
                ans++;
            }
        }
        return ans;
    }

    public boolean isSameElement(int[][] grid, int x, int y) {
        int[] row = new int[3];
        int[] col = new int[3];
        int[] diag = new int[]{grid[x][y] + grid[x + 1][y + 1] + grid[x + 2][y + 2], grid[x][y + 2] + grid[x + 1][y + 1] + grid[x + 2][y]};
        if (diag[0] != diag[1]) {
            return true;
        }
        int base = diag[0];

        boolean[] visit = new boolean[10];
        for (int i = x; i <= x + 2; i++) {
            for (int j = y; j <= y + 2; j++) {
                if (grid[i][j] > 9 || grid[i][j] < 1 || visit[grid[i][j]]) {
                    return true;
                }
                visit[grid[i][j]] = true;
                row[i - x] += grid[i][j];
                col[j - y] += grid[i][j];
                if (j == y && i != x + 1) {
                    diag[0] += grid[i][j];
                }
                if (j == y + 2 && i != x + 1) {
                    diag[1] += grid[i][j];
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            if (row[i] != base || col[i] != base) {
                return true;
            }
        }
        return false;
    }
}
