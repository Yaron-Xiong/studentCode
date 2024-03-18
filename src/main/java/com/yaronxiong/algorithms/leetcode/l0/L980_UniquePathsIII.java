package com.yaronxiong.algorithms.leetcode.l0;

import java.util.HashMap;
import java.util.Map;

/**
 * 980. 不同路径 III
 * 困难
 * 273
 * 相关企业
 * 在二维网格 grid 上，有 4 种类型的方格：
 * <p>
 * 1 表示起始方格。且只有一个起始方格。
 * 2 表示结束方格，且只有一个结束方格。
 * 0 表示我们可以走过的空方格。
 * -1 表示我们无法跨越的障碍。
 * 返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目。
 * <p>
 * 每一个无障碍方格都要通过一次，但是一条路径中不能重复通过同一个方格。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
 * 输出：2
 * 解释：我们有以下两条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
 * 2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
 * 示例 2：
 * <p>
 * 输入：[[1,0,0,0],[0,0,0,0],[0,0,0,2]]
 * 输出：4
 * 解释：我们有以下四条路径：
 * 1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3)
 * 2. (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3)
 * 3. (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3)
 * 4. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * 示例 3：
 * <p>
 * 输入：[[0,1],[2,0]]
 * 输出：0
 * 解释：
 * 没有一条路能完全穿过每一个空的方格一次。
 * 请注意，起始和结束方格可以位于网格中的任意位置。
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length * grid[0].length <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/unique-paths-iii/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L980_UniquePathsIII {
    public static void main(String[] args) {
        L980_UniquePathsIII l980UniquePathsIII = new L980_UniquePathsIII();
        System.out.println(l980UniquePathsIII.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
    }

    public int uniquePathsIII(int[][] grid) {
        int n = grid[0].length, vis = 0, sx = -1, sy = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] < 0) // 把障碍方格算上
                    vis |= 1 << (i * n + j);
                else if (grid[i][j] == 1) { // 起点
                    sx = i;
                    sy = j;
                }
            }
        }
        this.grid = grid;
        return dfs(sx, sy, vis);
    }

    int[][] grid;
    int[][] forward = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    Map<Integer, Integer> memo = new HashMap<>();

    private int dfs(int x, int y, int vis) {
        int p = x * grid[0].length + y;
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || (vis >> p & 1) > 0) {
            return 0;
        }
        vis |= 1 << p;
        if (grid[x][y] == 2) {
            return vis == (1 << grid.length * grid[0].length) - 1 ? 1 : 0;
        }
        int key = (p << grid.length * grid[0].length) | vis; // 把参数压缩成一个整数（左移 m*n 是因为 vis 至多有 m*n 个比特）
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        //每个节点可以向每个方向走
        int res = 0;
        for (int[] ints : forward) {
            res += dfs(x + ints[0], y + ints[1], vis);
        }
        memo.put(key, res);
        return res;
    }
}
