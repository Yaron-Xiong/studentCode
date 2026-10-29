package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3619. 总价值可以被 K 整除的岛屿数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的矩阵 grid 和一个正整数 k。一个 岛屿 是由 正 整数（表示陆地）组成的，并且陆地间 四周 连通（水平或垂直）。
 * <p>
 * 一个岛屿的总价值是该岛屿中所有单元格的值之和。
 * <p>
 * 返回总价值可以被 k 整除 的岛屿数量。
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: grid = [[0,2,1,0,0],[0,5,0,0,5],[0,0,1,0,0],[0,1,4,7,0],[0,2,0,0,8]], k = 5
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 * 网格中包含四个岛屿。蓝色高亮显示的岛屿的总价值可以被 5 整除，而红色高亮显示的岛屿则不能。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: grid = [[3,0,3,0], [0,3,0,3], [3,0,3,0]], k = 3
 * <p>
 * 输出: 6
 * <p>
 * 解释:
 * <p>
 * 网格中包含六个岛屿，每个岛屿的总价值都可以被 3 整除。
 * <p>
 * 提示:
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 1000
 * 1 <= m * n <= 105
 * 0 <= grid[i][j] <= 106
 * 1 <= k < = 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-islands-with-total-value-divisible-by-k/description/?envType=daily-question&envId=2026-10-26">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3619_CountIslands {
    public int countIslands(int[][] grid, int k) {
        //先找到所有的岛
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                long curK = dfs(i, j, grid);
                if (curK > 0 && curK % k == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }

    private long dfs(int x, int y, int[][] grid) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            return 0;
        }
        if (grid[x][y] == 0) {
            return 0;
        }
        long temp = grid[x][y];
        grid[x][y] = 0;
        return dfs(x + 1, y, grid) + dfs(x - 1, y, grid) + dfs(x, y + 1, grid) + dfs(x, y - 1, grid) + temp;
    }
}
