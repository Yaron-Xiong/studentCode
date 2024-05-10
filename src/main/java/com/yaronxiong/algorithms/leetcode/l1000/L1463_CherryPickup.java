package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1463. 摘樱桃 II
 * 算术评级: 8
 * 第 27 场双周赛
 * Q4
 * 1957
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 rows x cols 的矩阵 grid 来表示一块樱桃地。 grid 中每个格子的数字表示你能获得的樱桃数目。
 * <p>
 * 你有两个机器人帮你收集樱桃，机器人 1 从左上角格子 (0,0) 出发，机器人 2 从右上角格子 (0, cols-1) 出发。
 * <p>
 * 请你按照如下规则，返回两个机器人能收集的最多樱桃数目：
 * <p>
 * 从格子 (i,j) 出发，机器人可以移动到格子 (i+1, j-1)，(i+1, j) 或者 (i+1, j+1) 。
 * 当一个机器人经过某个格子时，它会把该格子内所有的樱桃都摘走，然后这个位置会变成空格子，即没有樱桃的格子。
 * 当两个机器人同时到达同一个格子时，它们中只有一个可以摘到樱桃。
 * 两个机器人在任意时刻都不能移动到 grid 外面。
 * 两个机器人最后都要到达 grid 最底下一行。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
 * 输出：24
 * 解释：机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
 * 机器人 1 摘的樱桃数目为 (3 + 2 + 5 + 2) = 12 。
 * 机器人 2 摘的樱桃数目为 (1 + 5 + 5 + 1) = 12 。
 * 樱桃总数为： 12 + 12 = 24 。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]
 * 输出：28
 * 解释：机器人 1 和机器人 2 的路径在上图中分别用绿色和蓝色表示。
 * 机器人 1 摘的樱桃数目为 (1 + 9 + 5 + 2) = 17 。
 * 机器人 2 摘的樱桃数目为 (1 + 3 + 4 + 3) = 11 。
 * 樱桃总数为： 17 + 11 = 28 。
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]
 * 输出：22
 * 示例 4：
 * <p>
 * 输入：grid = [[1,1],[1,1]]
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * rows == grid.length
 * cols == grid[i].length
 * 2 <= rows, cols <= 70
 * 0 <= grid[i][j] <= 100
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/cherry-pickup-ii/?envType=daily-question&envId=2024-05-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1463_CherryPickup {
    public static void main(String[] args) {
        L1463_CherryPickup l1463CherryPickup = new L1463_CherryPickup();
        System.out.println(l1463CherryPickup.cherryPickup(new int[][]{{3, 1, 1}, {2, 5, 1}, {1, 5, 5}, {2, 1, 1}}));
    }

    public int cherryPickup(int[][] grid) {
        //第0行的收益，已经确定了 就是 (0,0) 跟 (0,n-1)
        //那么下一行的收益 = 上一行的位置到下一行的位置 + 上一行的收益
        memo = new int[grid.length][grid[0].length][grid[0].length];
        for (int[][] ints : memo) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt, -1);
            }
        }
        return dfs2(0, 0, grid[0].length - 1, grid);
    }

    int[][][] memo;

    private int dfs2(int row, int x1, int x2, int[][] grid) {
        if (row == grid.length) {
            return 0;
        }
        if (x1 < 0 || x1 >= grid[row].length || x2 < 0 || x2 >= grid[row].length) {
            return 0;
        }
        if (memo[row][x1][x2] != -1) {
            return memo[row][x1][x2];
        }
        int ans = Integer.MIN_VALUE;
        int v1 = dfs2(row + 1, x1, x2 - 1, grid);
        ans = Math.max(ans, v1);
        int v2 = dfs2(row + 1, x1, x2, grid);
        ans = Math.max(ans, v2);
        int v3 = dfs2(row + 1, x1, x2 + 1, grid);
        ans = Math.max(ans, v3);
        int v4 = dfs2(row + 1, x1 + 1, x2 - 1, grid);
        ans = Math.max(ans, v4);
        int v5 = dfs2(row + 1, x1 + 1, x2, grid);
        ans = Math.max(ans, v5);
        int v6 = dfs2(row + 1, x1 + 1, x2 + 1, grid);
        ans = Math.max(ans, v6);
        int v7 = dfs2(row + 1, x1 - 1, x2 - 1, grid);
        ans = Math.max(ans, v7);
        int v8 = dfs2(row + 1, x1 - 1, x2, grid);
        ans = Math.max(ans, v8);
        int v9 = dfs2(row + 1, x1 - 1, x2 + 1, grid);
        ans = Math.max(ans, v9);
        return memo[row][x1][x2] = ans + (x1 == x2 ? grid[row][x1] : grid[row][x1] + grid[row][x2]);
    }
}
