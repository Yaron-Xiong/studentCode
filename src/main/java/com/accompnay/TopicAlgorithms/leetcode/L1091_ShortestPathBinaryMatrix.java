package com.accompnay.TopicAlgorithms.leetcode;

import java.util.*;

/**
 * 1091. 二进制矩阵中的最短路径
 * 提示
 * 中等
 * 280
 * 相关企业
 * 给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。
 * <p>
 * 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求：
 * <p>
 * 路径途经的所有单元格都的值都是 0 。
 * 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。
 * 畅通路径的长度 是该路径途经的单元格总数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1],[1,0]]
 * 输出：2
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
 * 输出：-1
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 100
 * grid[i][j] 为 0 或 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/shortest-path-in-binary-matrix/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1091_ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        L1091_ShortestPathBinaryMatrix l1091ShortestPathBinaryMatrix = new L1091_ShortestPathBinaryMatrix();
        System.out.println(l1091ShortestPathBinaryMatrix.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}}));
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0, 0});
        int[][] forward = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int[][] visit = new int[grid.length][grid[0].length];
        while (!deque.isEmpty()) {
            int[] pop = deque.pop();
            if (pop[0] == grid.length - 1 && pop[1] == grid[0].length - 1) {
                return pop[2] + 1;
            }
            if (visit[pop[0]][pop[1]] == 1) {
                continue;
            }
            visit[pop[0]][pop[1]] = 1;
            for (int[] next : forward) {
                int newX = pop[0] + next[0];
                int newY = pop[1] + next[1];
                if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length) {
                    continue;
                }
                if (grid[newX][newY] == 1) {
                    continue;
                }
                deque.add(new int[]{newX, newY, pop[2] + 1});
            }
        }
        return -1;
    }
}
