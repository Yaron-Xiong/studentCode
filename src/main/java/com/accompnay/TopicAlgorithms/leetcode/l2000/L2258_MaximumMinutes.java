package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 2258. 逃离火灾
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始大小为 m x n 的二维整数数组 grid ，它表示一个网格图。每个格子为下面 3 个值之一：
 * <p>
 * 0 表示草地。
 * 1 表示着火的格子。
 * 2 表示一座墙，你跟火都不能通过这个格子。
 * 一开始你在最左上角的格子 (0, 0) ，你想要到达最右下角的安全屋格子 (m - 1, n - 1) 。
 * 每一分钟，你可以移动到 相邻 的草地格子。每次你移动 之后 ，着火的格子会扩散到所有不是墙的 相邻 格子。
 * <p>
 * 请你返回你在初始位置可以停留的 最多 分钟数，且停留完这段时间后你还能安全到达安全屋。如果无法实现，请你返回 -1 。
 * 如果不管你在初始位置停留多久，你 总是 能到达安全屋，请你返回 109 。
 * <p>
 * 注意，如果你到达安全屋后，火马上到了安全屋，这视为你能够安全到达安全屋。
 * <p>
 * 如果两个格子有共同边，那么它们为 相邻 格子。
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,2,0,0,0,0,0],[0,0,0,2,2,1,0],[0,2,0,0,1,2,0],[0,0,2,2,2,0,2],[0,0,0,0,0,0,0]]
 * 输出：3
 * 解释：上图展示了你在初始位置停留 3 分钟后的情形。
 * 你仍然可以安全到达安全屋。
 * 停留超过 3 分钟会让你无法安全到达安全屋。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,0,0],[0,1,2,0],[0,2,0,0]]
 * 输出：-1
 * 解释：上图展示了你马上开始朝安全屋移动的情形。
 * 火会蔓延到你可以移动的所有格子，所以无法安全到达安全屋。
 * 所以返回 -1 。
 * 示例 3：
 * <p>
 * 输入：grid = [[0,0,0],[2,2,0],[1,2,0]]
 * 输出：1000000000
 * 解释：上图展示了初始网格图。
 * 注意，由于火被墙围了起来，所以无论如何你都能安全到达安全屋。
 * 所以返回 109 。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 2 <= m, n <= 300
 * 4 <= m * n <= 2 * 104
 * grid[i][j] 是 0 ，1 或者 2 。
 * grid[0][0] == grid[m - 1][n - 1] == 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/escape-the-spreading-fire/description/?envType=daily-question&envId=2023-11-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2258_MaximumMinutes {
    public static void main(String[] args) {
        L2258_MaximumMinutes l2258MaximumMinutes = new L2258_MaximumMinutes();
        System.out.println(l2258MaximumMinutes.maximumMinutes(new int[][]{{0,0,0,0,0,0},{0,2,2,2,2,0},{0,0,0,1,2,0},{0,2,2,2,2,0},{0,0,0,0,0,0}}));
    }

    public int maximumMinutes(int[][] grid) {
        //计算每个格子最早着火时间
        int[][] fireDp = new int[grid.length][grid[0].length];
        for (int[] ints : fireDp) {
            //-1代表火无法抵达
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 1) {
                    continue;
                }
                fireDp[i][j] = 0;
                //计算这个火能扩散到哪里去
                diffusion(fireDp, grid, i + 1, j, 1);
                diffusion(fireDp, grid, i - 1, j, 1);
                diffusion(fireDp, grid, i, j + 1, 1);
                diffusion(fireDp, grid, i, j - 1, 1);
            }
        }
        //找到每条去终点的路
        boolean[][] visit = new boolean[grid.length][grid[0].length];
        dfs(fireDp, grid, visit, 0, 0, new LinkedList<>());

        return globeAns == Integer.MIN_VALUE ? -1 : globeAns == Integer.MAX_VALUE ? 1000000000 : globeAns;
    }

    int globeAns = Integer.MIN_VALUE;

    private void dfs(int[][] fireDp, int[][] grid, boolean[][] visit, int x, int y, Deque<int[]> paths) {
        if (x < 0 || x >= fireDp.length || y < 0 || y >= fireDp[x].length) {
            return;
        }
        if (grid[x][y] != 0 || visit[x][y]) {
            return;
        }
        if (fireDp[x][y] != -1 && paths.size() - 1 >= fireDp[x][y]) {
            //抵达时 已经着火了
            return;
        }
        visit[x][y] = true;
        paths.addLast(new int[]{x, y});
        if (x == grid.length - 1 && y == grid[x].length - 1) {
            //抵达终点，开始统计最长耗时
            int level = 0;
            int ans = Integer.MAX_VALUE;
            for (int[] node : paths) {
                int nodeX = node[0];
                int nodeY = node[1];
                //抵达node点的着火时间
                int fireTime = fireDp[nodeX][nodeY];
                //从start->抵达node点的时间最短耗时 == level
                //抵达这个点的剩余时间即为空闲时间
                if (fireTime != -1) {
                    if (nodeX == x && nodeY == y) {
                        ans = Math.min(ans, fireTime - level);
                    }else {
                        ans = Math.min(ans, fireTime - level - 1);
                    }
                }
                level++;
            }
            globeAns = Integer.max(globeAns, ans);
        }else {
            dfs(fireDp, grid, visit, x + 1, y, paths);
            dfs(fireDp, grid, visit, x - 1, y, paths);
            dfs(fireDp, grid, visit, x, y - 1, paths);
            dfs(fireDp, grid, visit, x, y + 1, paths);
        }
        visit[x][y] = false;
        paths.removeLast();
    }


    private void diffusion(int[][] fireDp, int[][] grid, int x, int y, int time) {
        if (x < 0 || x >= fireDp.length || y < 0 || y >= fireDp[x].length) {
            return;
        }
        //如果发现  当前的格子存在着火时间 并且 比x-y 更快着火 则放弃
        if (fireDp[x][y] != -1 && fireDp[x][y] < time) {
            return;
        }
        if (grid[x][y] != 0) {
            return;
        }
        fireDp[x][y] = time;
        diffusion(fireDp, grid, x + 1, y, time + 1);
        diffusion(fireDp, grid, x - 1, y, time + 1);
        diffusion(fireDp, grid, x, y + 1, time + 1);
        diffusion(fireDp, grid, x, y - 1, time + 1);
    }
}
