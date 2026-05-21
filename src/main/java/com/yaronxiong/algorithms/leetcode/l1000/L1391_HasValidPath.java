package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1391. 检查网格中是否存在有效路径
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的网格 grid。网格里的每个单元都代表一条街道。grid[i][j] 的街道可以是：
 * <p>
 * 1 表示连接左单元格和右单元格的街道。
 * 2 表示连接上单元格和下单元格的街道。
 * 3 表示连接左单元格和下单元格的街道。
 * 4 表示连接右单元格和下单元格的街道。
 * 5 表示连接左单元格和上单元格的街道。
 * 6 表示连接右单元格和上单元格的街道。
 * <p>
 * <p>
 * 你最开始从左上角的单元格 (0,0) 开始出发，
 * 网格中的「有效路径」是指从左上方的单元格 (0,0) 开始、一直到右下方的 (m-1,n-1) 结束的路径。该路径必须只沿着街道走。
 * <p>
 * 注意：你 不能 变更街道。
 * <p>
 * 如果网格中存在有效的路径，则返回 true，否则返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[2,4,3],[6,5,2]]
 * 输出：true
 * 解释：如图所示，你可以从 (0, 0) 开始，访问网格中的所有单元格并到达 (m - 1, n - 1) 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,1],[1,2,1]]
 * 输出：false
 * 解释：如图所示，单元格 (0, 0) 上的街道没有与任何其他单元格上的街道相连，你只会停在 (0, 0) 处。
 * 示例 3：
 * <p>
 * 输入：grid = [[1,1,2]]
 * 输出：false
 * 解释：你会停在 (0, 1)，而且无法到达 (0, 2) 。
 * 示例 4：
 * <p>
 * 输入：grid = [[1,1,1,1,1,1,3]]
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：grid = [[2],[2],[2],[2],[2],[2],[6]]
 * 输出：true
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * 1 <= grid[i][j] <= 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-if-there-is-a-valid-path-in-a-grid/description/?envType=daily-question&envId=2026-04-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1391_HasValidPath {
    public static void main(String[] args) {
        L1391_HasValidPath l1391HasValidPath = new L1391_HasValidPath();
        System.out.println(l1391HasValidPath.hasValidPath(new int[][]{{1, 1, 2}}));
        System.out.println(l1391HasValidPath.hasValidPath(new int[][]{{2, 4, 3}, {6, 5, 2}}));
        System.out.println(l1391HasValidPath.hasValidPath(new int[][]{{1, 2, 1}, {1, 2, 1}}));
        System.out.println(l1391HasValidPath.hasValidPath(new int[][]{{1, 1, 1, 1, 1, 1, 3}}));
        System.out.println(l1391HasValidPath.hasValidPath(new int[][]{{2}, {2}, {2}, {2}, {2}, {2}, {6}}));
    }

    public boolean hasValidPath(int[][] grid) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        List<int[][]> forwards = new ArrayList<>();
        forwards.add(new int[][]{{0, -1}, {0, 1}});
        forwards.add(new int[][]{{1, 0}, {-1, 0}});
        forwards.add(new int[][]{{0, -1}, {1, 0}});
        forwards.add(new int[][]{{0, 1}, {1, 0}});
        forwards.add(new int[][]{{0, -1}, {-1, 0}});
        forwards.add(new int[][]{{0, 1}, {-1, 0}});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                size--;
                int[] node = deque.pollFirst();
                if (node[0] == grid.length - 1 && node[1] == grid[0].length - 1) {
                    return true;
                }
                if (visited[node[0]][node[1]]) {
                    continue;
                }
                visited[node[0]][node[1]] = true;
                int currentNodeValue = grid[node[0]][node[1]];
                int[][] currentNodeForward = forwards.get(currentNodeValue - 1);
                for (int[] forward : currentNodeForward) {
                    int nextX = node[0] + forward[0];
                    int nextY = node[1] + forward[1];
                    if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) {
                        continue;
                    }
                    if (visited[nextX][nextY]) {
                        continue;
                    }
                    //判断是否能过去,判断x y是否有互斥对
                    int[][] nextNodeForward = forwards.get(grid[nextX][nextY] - 1);
                    if (contains(forward, nextNodeForward)) {
                        if (nextX == grid.length - 1 && nextY == grid[0].length - 1) {
                            return true;
                        }
                        deque.addLast(new int[]{nextX, nextY});
                    }
                }
            }
        }
        return false;
    }

    private boolean contains(int[] forward, int[][] nextNodeForward) {
        for (int[] ints : nextNodeForward) {
            if (-ints[0] == forward[0] && -ints[1] == forward[1]) {
                return true;
            }
        }
        return false;
    }
}
