package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1970. 你能穿过矩阵的最后一天
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 1 开始的二进制矩阵，其中 0 表示陆地，1 表示水域。同时给你 row 和 col 分别表示矩阵中行和列的数目。
 * <p>
 * 一开始在第 0 天，整个 矩阵都是 陆地 。但每一天都会有一块新陆地被 水 淹没变成水域。
 * 给你一个下标从 1 开始的二维数组 cells ，其中 cells[i] = [ri, ci] 表示在第 i 天，第 ri 行 ci 列（下标都是从 1 开始）的陆地会变成 水域 （也就是 0 变成 1 ）。
 * <p>
 * 你想知道从矩阵最 上面 一行走到最 下面 一行，且只经过陆地格子的 最后一天 是哪一天。你可以从最上面一行的 任意 格子出发，到达最下面一行的 任意 格子。
 * 你只能沿着 四个 基本方向移动（也就是上下左右）。
 * <p>
 * 请返回只经过陆地格子能从最 上面 一行走到最 下面 一行的 最后一天 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：row = 2, col = 2, cells = [[1,1],[2,1],[1,2],[2,2]]
 * 输出：2
 * 解释：上图描述了矩阵从第 0 天开始是如何变化的。
 * 可以从最上面一行到最下面一行的最后一天是第 2 天。
 * 示例 2：
 * <p>
 * 输入：row = 2, col = 2, cells = [[1,1],[1,2],[2,1],[2,2]]
 * 输出：1
 * 解释：上图描述了矩阵从第 0 天开始是如何变化的。
 * 可以从最上面一行到最下面一行的最后一天是第 1 天。
 * 示例 3：
 * <p>
 * 输入：row = 3, col = 3, cells = [[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]
 * 输出：3
 * 解释：上图描述了矩阵从第 0 天开始是如何变化的。
 * 可以从最上面一行到最下面一行的最后一天是第 3 天。
 * <p>
 * 提示：
 * <p>
 * 2 <= row, col <= 2 * 104
 * 4 <= row * col <= 2 * 104
 * cells.length == row * col
 * 1 <= ri <= row
 * 1 <= ci <= col
 * cells 中的所有格子坐标都是 唯一 的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/last-day-where-you-can-still-cross/description/?envType=daily-question&envId=2025-12-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1970_LatestDayToCross {
    public static void main(String[] args) {
        L1970_LatestDayToCross l1970LatestDayToCross = new L1970_LatestDayToCross();
        System.out.println(l1970LatestDayToCross.latestDayToCross(4, 3, new int[][]{{3, 2}, {2, 1}, {1, 3}, {1, 2}, {3, 3}, {2, 2}, {4, 3}, {1, 1}, {2, 3}, {4, 1}, {3, 1}, {4, 2}}));
        System.out.println(l1970LatestDayToCross.latestDayToCross(6, 2, new int[][]{{4, 2}, {6, 2}, {2, 1}, {4, 1}, {6, 1}, {3, 1}, {2, 2}, {3, 2}, {1, 1}, {5, 1}, {5, 2}, {1, 2}}));
        System.out.println(l1970LatestDayToCross.latestDayToCross(2, 2, new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(l1970LatestDayToCross.latestDayToCross(2, 2, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}}));
        System.out.println(l1970LatestDayToCross.latestDayToCross(3, 3, new int[][]{{1, 2}, {2, 1}, {3, 3}, {2, 2}, {1, 1}, {1, 3}, {2, 3}, {3, 2}, {3, 1}}));
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0;
        int right = cells.length;
        //开始二分拉
        //可以用BFS去校验是否联通
        while (left < right) {
            int mid = left + (right - left) / 2;
            //判断能不能在 mid 天完成穿越
            boolean[][] flag = new boolean[row][col];
            for (int i = 0; i < mid; i++) {
                flag[cells[i][0] - 1][cells[i][1] - 1] = true;
            }
            if (check(flag)) {
                //尝试放大 k
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    int[][] forwards = new int[][]{{0, 1}, {0, -1}, {1, 0},{-1, 0}};

    private boolean check(boolean[][] flag) {
        Deque<int[]> queue = new LinkedList<>();
        for (int i = 0; i < flag[0].length; i++) {
            //如果是陆地 放进队列
            if (!flag[0][i]) {
                queue.offer(new int[]{0, i});
            }
        }
        while (!queue.isEmpty()) {
            int[] pop = queue.pop();
            if (flag[pop[0]][pop[1]]) {
                continue;
            }
            //抵达最后一行
            if (pop[0] == flag.length - 1) {
                return true;
            }
            //如果访问过要标记成访问过
            flag[pop[0]][pop[1]] = true;
            //尝试走其他方向
            for (int[] forward : forwards) {
                int x = pop[0] + forward[0];
                int y = pop[1] + forward[1];
                if (x >= 0 && x < flag.length && y >= 0 && y < flag[0].length && !flag[x][y]) {
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return false;
    }

}
