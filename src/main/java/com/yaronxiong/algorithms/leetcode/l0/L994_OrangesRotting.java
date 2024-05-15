package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 994. 腐烂的橘子
 * 算术评级: 4
 * 第 124 场周赛
 * Q2
 * 1433
 * 相关标签
 * 相关企业
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * <p>
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * <p>
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * <p>
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 示例 3：
 * <p>
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/rotting-oranges/description/?envType=daily-question&envId=2024-05-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L994_OrangesRotting {
    public static void main(String[] args) {
        L994_OrangesRotting l994OrangesRotting = new L994_OrangesRotting();
        System.out.println(l994OrangesRotting.orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }

    public int orangesRotting(int[][] grid) {
        int rotOranges = 0;
        int[][] forwards = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> stack = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    stack.addLast(new int[]{i, j});
                } else if (grid[i][j] == 1) {
                    rotOranges++;
                }
            }
        }

        int ans = 0;
        while (!stack.isEmpty()) {
            int size = stack.size();
            while (size > 0) {
                int[] node = stack.pollFirst();
                for (int[] forward : forwards) {
                    int newY = node[0] + forward[0];
                    int newX = node[1] + forward[1];
                    if (newY < 0 || newY >= grid.length || newX < 0 || newX >= grid[newY].length) {
                        continue;
                    }
                    if (grid[newY][newX] == 1) {
                        rotOranges--;
                        grid[newY][newX] = 2;
                        stack.addLast(new int[]{newY, newX});
                    }
                }
                size--;
            }
            if (!stack.isEmpty()) {
                ans++;
            }
        }
        return rotOranges != 0 ? -1 : ans;
    }
}
