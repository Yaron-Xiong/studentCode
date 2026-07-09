package com.yaronxiong.algorithms.leetcode.l2500;

import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 2812. 找出最安全路径
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、大小为 n x n 的二维矩阵 grid ，其中 (r, c) 表示：
 * <p>
 * 如果 grid[r][c] = 1 ，则表示一个存在小偷的单元格
 * 如果 grid[r][c] = 0 ，则表示一个空单元格
 * 你最开始位于单元格 (0, 0) 。在一步移动中，你可以移动到矩阵中的任一相邻单元格，包括存在小偷的单元格。
 * <p>
 * 矩阵中路径的 安全系数 定义为：从路径中任一单元格到矩阵中任一小偷所在单元格的 最小 曼哈顿距离。
 * <p>
 * 返回所有通向单元格 (n - 1, n - 1) 的路径中的 最大安全系数 。
 * <p>
 * 单元格 (r, c) 的某个 相邻 单元格，是指在矩阵中存在的 (r, c + 1)、(r, c - 1)、(r + 1, c) 和 (r - 1, c) 之一。
 * <p>
 * 两个单元格 (a, b) 和 (x, y) 之间的 曼哈顿距离 等于 | a - x | + | b - y | ，其中 |val| 表示 val 的绝对值。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,0,0],[0,0,0],[0,0,1]]
 * 输出：0
 * 解释：从 (0, 0) 到 (n - 1, n - 1) 的每条路径都经过存在小偷的单元格 (0, 0) 和 (n - 1, n - 1) 。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,1],[0,0,0],[0,0,0]]
 * 输出：2
 * 解释：
 * 上图所示路径的安全系数为 2：
 * - 该路径上距离小偷所在单元格（0，2）最近的单元格是（0，0）。它们之间的曼哈顿距离为 | 0 - 0 | + | 0 - 2 | = 2 。
 * 可以证明，不存在安全系数更高的其他路径。
 * 示例 3：
 * <p>
 * 输入：grid = [[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]
 * 输出：2
 * 解释：
 * 上图所示路径的安全系数为 2：
 * - 该路径上距离小偷所在单元格（0，3）最近的单元格是（1，2）。它们之间的曼哈顿距离为 | 0 - 1 | + | 3 - 2 | = 2 。
 * - 该路径上距离小偷所在单元格（3，0）最近的单元格是（3，2）。它们之间的曼哈顿距离为 | 3 - 3 | + | 0 - 2 | = 2 。
 * 可以证明，不存在安全系数更高的其他路径。
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length == n <= 400
 * grid[i].length == n
 * grid[i][j] 为 0 或 1
 * grid 至少存在一个小偷
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-safest-path-in-a-grid/description/?envType=daily-question&envId=2026-07-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2812_MaximumSafenessFactor {
    public static void main(String[] args) {
        L2812_MaximumSafenessFactor l2812MaximumSafenessFactor = new L2812_MaximumSafenessFactor();
        System.out.println(l2812MaximumSafenessFactor.maximumSafenessFactor(Lists.newArrayList(Lists.newArrayList(0, 1, 1), Lists.newArrayList(0, 0, 0), Lists.newArrayList(0, 0, 0))));
        System.out.println(l2812MaximumSafenessFactor.maximumSafenessFactor(Lists.newArrayList(Lists.newArrayList(0, 0, 0, 1), Lists.newArrayList(0, 0, 0, 0), Lists.newArrayList(0, 0, 0, 0), Lists.newArrayList(1, 0, 0, 0))));
        System.out.println(l2812MaximumSafenessFactor.maximumSafenessFactor(Lists.newArrayList(Lists.newArrayList(1, 0, 0), Lists.newArrayList(0, 0, 0), Lists.newArrayList(0, 0, 1))));
        System.out.println(l2812MaximumSafenessFactor.maximumSafenessFactor(Lists.newArrayList(Lists.newArrayList(0, 0, 1), Lists.newArrayList(0, 0, 0), Lists.newArrayList(0, 0, 0))));
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1) {
            return 0;
        }
        int[][] forwards = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        //从小偷开始出发 计算出每个点的曼哈顿距离 使用bfs
        Deque<int[]> deque = new ArrayDeque<>();
        int[][] dis = new int[grid.size()][grid.get(0).size()];
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.get(i).size(); j++) {
                if (grid.get(i).get(j) == 1) {
                    deque.addLast(new int[]{i, j});
                } else {
                    dis[i][j] = -1;
                }
            }
        }

        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                size--;
                int[] node = deque.pollFirst();
                for (int[] forward : forwards) {
                    int[] neighborNode = new int[]{node[0] + forward[0], node[1] + forward[1]};
                    if (neighborNode[0] < 0 || neighborNode[0] >= dis.length || neighborNode[1] < 0 || neighborNode[1] >= dis[0].length) {
                        continue;
                    }
                    if (dis[neighborNode[0]][neighborNode[1]] != -1) {
                        continue;
                    }
                    dis[neighborNode[0]][neighborNode[1]] = dis[node[0]][node[1]] + 1;
                    deque.addLast(neighborNode);
                }
            }
        }

        //使用一个二分答案
        int left = 0;
        int right = Integer.MAX_VALUE / 2;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (check(dis, mid, forwards)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left - 1;
    }

    private boolean check(int[][] dis, int target, int[][] forwards) {
        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[dis.length][dis.length];
        deque.add(new int[]{0, 0});
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                size--;
                int[] node = deque.pollFirst();
                if (dis[node[0]][node[1]] < target) {
                    continue;
                }
                if (node[0] == dis.length - 1 && node[1] == dis.length - 1) {
                    return true;
                }
                for (int[] forward : forwards) {
                    int[] neighborNode = new int[]{node[0] + forward[0], node[1] + forward[1]};
                    if (neighborNode[0] < 0 || neighborNode[0] >= dis.length || neighborNode[1] < 0 || neighborNode[1] >= dis[0].length) {
                        continue;
                    }
                    if (visited[neighborNode[0]][neighborNode[1]]) {
                        continue;
                    }
                    if (dis[neighborNode[0]][neighborNode[1]] < target) {
                        continue;
                    }
                    visited[neighborNode[0]][neighborNode[1]] = true;
                    deque.addLast(neighborNode);
                }
            }
        }
        return false;
    }
}
