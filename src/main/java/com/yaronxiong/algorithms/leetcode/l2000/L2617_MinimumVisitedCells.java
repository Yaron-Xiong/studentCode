package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 2617. 网格图中最少访问的格子数
 * 已解答
 * 第 340 场周赛
 * Q4
 * 2582
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的 m x n 整数矩阵 grid 。你一开始的位置在 左上角 格子 (0, 0) 。
 * <p>
 * 当你在格子 (i, j) 的时候，你可以移动到以下格子之一：
 * <p>
 * 满足 j < k <= grid[i][j] + j 的格子 (i, k) （向右移动），或者
 * 满足 i < k <= grid[i][j] + i 的格子 (k, j) （向下移动）。
 * 请你返回到达 右下角 格子 (m - 1, n - 1) 需要经过的最少移动格子数，如果无法到达右下角格子，请你返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[3,4,2,1],[4,2,3,1],[2,1,0,0],[2,4,0,0]]
 * 输出：4
 * 解释：上图展示了到达右下角格子经过的 4 个格子。
 * 示例 2：
 * <p>
 * 输入：grid = [[3,4,2,1],[4,2,1,1],[2,1,1,0],[3,4,1,0]]
 * 输出：3
 * 解释：上图展示了到达右下角格子经过的 3 个格子。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[2,1,0],[1,0,0]]
 * 输出：-1
 * 解释：无法到达右下角格子。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 0 <= grid[i][j] < m * n
 * grid[m - 1][n - 1] == 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/?envType=daily-question&envId=2024-03-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2617_MinimumVisitedCells {
    public static void main(String[] args) {
        L2617_MinimumVisitedCells l2617MinimumVisitedCells = new L2617_MinimumVisitedCells();
        System.out.println(l2617MinimumVisitedCells.minimumVisitedCells(new int[][]{{0,1,0}}));
    }

    public int minimumVisitedCells(int[][] grid) {
        PriorityQueue<int[]>[] colArr = new PriorityQueue[grid[0].length];
        Arrays.setAll(colArr, item -> new PriorityQueue<>((int[] a, int[] b) -> Integer.compare(a[2], b[2])));
        PriorityQueue<int[]> row = new PriorityQueue<>((int[] a, int[] b) -> Integer.compare(a[2], b[2]));
        int[][] dp = new int[grid.length][grid[0].length];
        //填充第一列
        dp[0][0] = 1;
        colArr[0].add(new int[]{0, 0, 1});
        row.add(new int[]{0, 0, 1});
        for (int i = 1; i < grid[0].length; i++) {
            while (!row.isEmpty() && grid[row.peek()[0]][row.peek()[1]] + row.peek()[1] < i) {
                row.poll();
            }
            dp[0][i] = row.isEmpty() ? Integer.MAX_VALUE : row.peek()[2] + 1;
            if (dp[0][i] != Integer.MAX_VALUE) {
                colArr[i].add(new int[]{0, i, dp[0][i]});
                row.add(new int[]{0, i, dp[0][i]});
            }
        }
        row.clear();
        for (int i = 1; i < grid.length; i++) {
            //分析 能从什么位置跳转到(i,j)
            // (x,j) -> (i,j) 其中 x<i
            // (i,y) -> (i,j) 其中 y<j
            for (int j = 0; j < grid[i].length; j++) {
                //找可以从上面跳转下来的最优解
                //可以从colArr[j]中跳转过来
                PriorityQueue<int[]> queue = colArr[j];
                while (!queue.isEmpty() && grid[queue.peek()[0]][queue.peek()[1]] + queue.peek()[0] < i) {
                    queue.poll();
                }

                //找可以从左边跳转过来的最优解
                while (!row.isEmpty() && grid[row.peek()[0]][row.peek()[1]] + row.peek()[1] < j) {
                    row.poll();
                }

                //OK，这时候我们知道了 从上面以及从左边跳转的过来的最优解
                int colValue = queue.isEmpty() ? Integer.MAX_VALUE : queue.peek()[2] + 1;
                int rowValue = row.isEmpty() ? Integer.MAX_VALUE : row.peek()[2] + 1;

                dp[i][j] = Math.min(colValue, rowValue);

                //此时将当前位置加入优先级队列
                if (dp[i][j] != Integer.MAX_VALUE) {
                    row.add(new int[]{i, j, dp[i][j]});
                    queue.add(new int[]{i, j, dp[i][j]});
                }
            }

            row.clear();
        }

        int n = grid.length - 1;
        int m = grid[0].length - 1;
        return dp[n][m] == Integer.MAX_VALUE ? -1 : dp[n][m];
    }

}
