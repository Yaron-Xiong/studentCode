package com.yaronxiong.algorithms.leetcode.l3000;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * 3286. 穿越网格图的安全路径
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的二进制矩形 grid 和一个整数 health 表示你的健康值。
 * <p>
 * 你开始于矩形的左上角 (0, 0) ，你的目标是矩形的右下角 (m - 1, n - 1) 。
 * <p>
 * 你可以在矩形中往上下左右相邻格子移动，但前提是你的健康值始终是 正数 。
 * <p>
 * 对于格子 (i, j) ，如果 grid[i][j] = 1 ，那么这个格子视为 不安全 的，会使你的健康值减少 1 。
 * <p>
 * 如果你可以到达最终的格子，请你返回 true ，否则返回 false 。
 * <p>
 * 注意 ，当你在最终格子的时候，你的健康值也必须为 正数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]], health = 1
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 沿着下图中灰色格子走，可以安全到达最终的格子。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：grid = [[0,1,1,0,0,0],[1,0,1,0,0,0],[0,1,1,1,0,1],[0,0,1,0,1,0]], health = 3
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 健康值最少为 4 才能安全到达最后的格子。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]], health = 5
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 沿着下图中灰色格子走，可以安全到达最终的格子。
 * <p>
 * 任何不经过格子 (1, 1) 的路径都是不安全的，因为你的健康值到达最终格子时，都会小于等于 0 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 2 <= m * n
 * 1 <= health <= m + n
 * grid[i][j] 要么是 0 ，要么是 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-a-safe-walk-through-a-grid/description/?envType=daily-question&envId=2026-07-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3286_FindSafeWalk {
    public static void main(String[] args) {
        L3286_FindSafeWalk l3286FindSafeWalk = new L3286_FindSafeWalk();
        System.out.println(l3286FindSafeWalk.findSafeWalk(Lists.newArrayList(Lists.newArrayList(0,1,0,0,0),
                Lists.newArrayList(0,1,0,1,0),
                Lists.newArrayList(0,0,0,1,0)
                ), 1));

        /*List<Integer> list = Lists.newArrayList(1, 1, 1, 1);
        List<List<Integer>> es = Lists.newArrayList(Collections.singleton(list));
        System.out.println(l3286FindSafeWalk.findSafeWalk(es, 4));
        System.out.println(l3286FindSafeWalk.findSafeWalk(Lists.newArrayList(Lists.newArrayList(0, 1, 1, 0, 0, 0),
                Lists.newArrayList(1, 0, 1, 0, 0, 0),
                Lists.newArrayList(0, 1, 1, 1, 0, 1),
                Lists.newArrayList(0, 0, 1, 0, 1, 0)), 3));*/
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int[][] forwards = new int[][]{{1, 0},{0, 1} , {0, -1}, {-1, 0}};
        PriorityQueue<int[]> deque = new PriorityQueue<>((a, b) -> -Integer.compare(a[2], b[2]));
        deque.add(new int[]{0, 0, health - grid.get(0).get(0)});
        int[][] dist = new int[grid.size()][grid.get(0).size()];
        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            if (dist[poll[0]][poll[1]] >= poll[2]) {
                continue;
            }
            dist[poll[0]][poll[1]] = poll[2];
            if (dist[dist.length - 1][dist[0].length - 1] > 0) {
                return true;
            }
            for (int[] forward : forwards) {
                int nextX = poll[0] + forward[0];
                int nextY = poll[1] + forward[1];
                if (nextX < 0 || nextY < 0 || nextX >= dist.length || nextY >= dist[0].length) {
                    continue;
                }
                deque.add(new int[]{nextX, nextY, poll[2] - grid.get(nextX).get(nextY)});
            }
        }
        return false;
    }

    private boolean dfs2(int x, int y, List<List<Integer>> grid, boolean[][] visit, int health, int[][] forwards) {
        if (x < 0 || y < 0 || x >= visit.length || y >= visit[0].length) {
            return false;
        }
        int curHealth = health - grid.get(x).get(y);
        if (visit[x][y] || curHealth <= 0) {
            return false;
        }
        if (x == visit.length - 1 && y == visit[0].length - 1) {
            return true;
        }
        visit[x][y] = true;
        for (int[] forward : forwards) {
            int nextX = x + forward[0];
            int nextY = y + forward[1];
            if (dfs2(nextX, nextY, grid, visit, curHealth, forwards)) {
                return true;
            }
        }
        visit[x][y] = false;
        return false;
    }
}
