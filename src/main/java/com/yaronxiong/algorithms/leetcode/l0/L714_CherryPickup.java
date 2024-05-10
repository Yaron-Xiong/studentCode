package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 741. 摘樱桃
 * 算术评级: 9
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个 n x n 的网格 grid ，代表一块樱桃地，每个格子由以下三种数字的一种来表示：
 * <p>
 * 0 表示这个格子是空的，所以你可以穿过它。
 * 1 表示这个格子里装着一个樱桃，你可以摘到樱桃然后穿过它。
 * -1 表示这个格子里有荆棘，挡着你的路。
 * 请你统计并返回：在遵守下列规则的情况下，能摘到的最多樱桃数：
 * <p>
 * 从位置 (0, 0) 出发，最后到达 (n - 1, n - 1) ，只能向下或向右走，并且只能穿越有效的格子（即只可以穿过值为 0 或者 1 的格子）；
 * 当到达 (n - 1, n - 1) 后，你要继续走，直到返回到 (0, 0) ，只能向上或向左走，并且只能穿越有效的格子；
 * 当你经过一个格子且这个格子包含一个樱桃时，你将摘到樱桃并且这个格子会变成空的（值变为 0 ）；
 * 如果在 (0, 0) 和 (n - 1, n - 1) 之间不存在一条可经过的路径，则无法摘到任何一个樱桃。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1,-1],[1,0,-1],[1,1,1]]
 * 输出：5
 * 解释：玩家从 (0, 0) 出发：向下、向下、向右、向右移动至 (2, 2) 。
 * 在这一次行程中捡到 4 个樱桃，矩阵变成 [[0,1,-1],[0,0,-1],[0,0,0]] 。
 * 然后，玩家向左、向上、向上、向左返回起点，再捡到 1 个樱桃。
 * 总共捡到 5 个樱桃，这是最大可能值。
 * 示例 2：
 * <p>
 * 输入：grid = [[1,1,-1],[1,-1,1],[-1,1,1]]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * grid[i][j] 为 -1、0 或 1
 * grid[0][0] != -1
 * grid[n - 1][n - 1] != -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/cherry-pickup/description/?envType=daily-question&envId=2024-05-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L714_CherryPickup {
    public static void main(String[] args) {
        L714_CherryPickup l714CherryPickup = new L714_CherryPickup();
        System.out.println(l714CherryPickup.cherryPickup(new int[][]{{0, 1, -1}, {1, 0, -1}, {1, 1, 1}}));
    }

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][] f = new int[n][n];
        for (int i = 0; i < n; ++i) {
            Arrays.fill(f[i], Integer.MIN_VALUE);
        }
        f[0][0] = grid[0][0];
        for (int k = 1; k < n * 2 - 1; ++k) {
            for (int x1 = Math.min(k, n - 1); x1 >= Math.max(k - n + 1, 0); --x1) {
                for (int x2 = Math.min(k, n - 1); x2 >= x1; --x2) {
                    int y1 = k - x1, y2 = k - x2;
                    if (grid[x1][y1] == -1 || grid[x2][y2] == -1) {
                        f[x1][x2] = Integer.MIN_VALUE;
                        continue;
                    }
                    int res = f[x1][x2]; // 都往右
                    if (x1 > 0) {
                        res = Math.max(res, f[x1 - 1][x2]); // 往下，往右
                    }
                    if (x2 > 0) {
                        res = Math.max(res, f[x1][x2 - 1]); // 往右，往下
                    }
                    if (x1 > 0 && x2 > 0) {
                        res = Math.max(res, f[x1 - 1][x2 - 1]); // 都往下
                    }
                    res += grid[x1][y1];
                    if (x2 != x1) { // 避免重复摘同一个樱桃
                        res += grid[x2][y2];
                    }
                    f[x1][x2] = res;
                }
            }
        }
        return Math.max(f[n - 1][n - 1], 0);
    }


}
