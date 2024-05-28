package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2596. 检查骑士巡视方案
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 骑士在一张 n x n 的棋盘上巡视。在有效的巡视方案中，骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
 * <p>
 * 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成，
 * 其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格。骑士的行动是从下标 0 开始的。
 * <p>
 * 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
 * <p>
 * 注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。下图展示了骑士从某个格子出发可能的八种行动路线。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
 * 输出：true
 * 解释：grid 如上图所示，可以证明这是一个有效的巡视方案。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,3,6],[5,8,1],[2,7,4]]
 * 输出：false
 * 解释：grid 如上图所示，考虑到骑士第 7 次行动后的位置，第 8 次行动是无效的。
 * <p>
 * 提示：
 * <p>
 * n == grid.length == grid[i].length
 * 3 <= n <= 7
 * 0 <= grid[row][col] < n * n
 * grid 中的所有整数 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-knight-tour-configuration/description/?envType=daily-question&envId=2023-09-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2596_CheckValidGrid {
    public static void main(String[] args) {
        L2596_CheckValidGrid l2596CheckValidGrid = new L2596_CheckValidGrid();
        System.out.println(l2596CheckValidGrid.checkValidGrid(new int[][]{{24,11,22,17,4},{21,16,5,12,9},{6,23,10,3,18},{15,20,1,8,13},{0,7,14,19,2}}));
    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int[][] sortArr = new int[grid.length * grid[0].length][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                sortArr[grid[i][j]][0] = i;
                sortArr[grid[i][j]][1] = j;
            }
        }
        for (int i = 1; i < sortArr.length; i++) {
            int[] curArr = sortArr[i];
            int[] preArr = sortArr[i - 1];
            int xValue = Math.abs(curArr[0] - preArr[0]);
            int yValue = Math.abs(curArr[1] - preArr[1]);
            if (xValue * yValue != 2) {
                return false;
            }
        }
        return true;
    }
}
