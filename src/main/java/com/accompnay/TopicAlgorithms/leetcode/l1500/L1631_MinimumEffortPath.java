package com.accompnay.TopicAlgorithms.leetcode.l1500;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 1631. 最小体力消耗路径
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你准备参加一场远足活动。给你一个二维 rows x columns 的地图 heights ，其中 heights[row][col] 表示格子 (row, col) 的高度。一开始你在最左上角的格子 (0, 0) ，且你希望去最右下角的格子 (rows-1, columns-1) （注意下标从 0 开始编号）。你每次可以往 上，下，左，右 四个方向之一移动，你想要找到耗费 体力 最小的一条路径。
 * <p>
 * 一条路径耗费的 体力值 是路径上相邻格子之间 高度差绝对值 的 最大值 决定的。
 * <p>
 * 请你返回从左上角走到右下角的最小 体力消耗值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：heights = [[1,2,2],[3,8,2],[5,3,5]]
 * 输出：2
 * 解释：路径 [1,3,5,3,5] 连续格子的差值绝对值最大为 2 。
 * 这条路径比路径 [1,2,2,2,5] 更优，因为另一条路径差值最大值为 3 。
 * 示例 2：
 * <p>
 * 输入：heights = [[1,2,3],[3,8,4],[5,3,5]]
 * 输出：1
 * 解释：路径 [1,2,3,4,5] 的相邻格子差值绝对值最大为 1 ，比路径 [1,3,5,3,5] 更优。
 * 示例 3：
 * <p>
 * <p>
 * 输入：heights = [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]
 * 输出：0
 * 解释：上图所示路径不需要消耗任何体力。
 * <p>
 * 提示：
 * <p>
 * rows == heights.length
 * columns == heights[i].length
 * 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/path-with-minimum-effort/description/?envType=daily-question&envId=2023-12-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1631_MinimumEffortPath {
    public static void main(String[] args) {
        L1631_MinimumEffortPath l1631MinimumEffortPath = new L1631_MinimumEffortPath();
        System.out.println(l1631MinimumEffortPath.minimumEffortPath2(new int[][]{{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}}));
    }

    public class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public void connect(int a, int b) {
            int aParent = find(a);
            int bParent = find(b);
            if (aParent == bParent) {
                return;
            }
            if (size[aParent] > size[bParent]) {
                //B迁移去A
                size[aParent] += size[bParent];
                parent[bParent] = aParent;
            } else {
                size[bParent] += size[aParent];
                parent[aParent] = bParent;
            }
        }

        public boolean isConnect(int a, int b) {
            return find(a) == find(b);
        }

        public int find(int node) {
            while (parent[node] != parent[parent[node]]) {
                parent[node] = parent[parent[node]];
                node = parent[node];
            }
            return parent[node];
        }

    }

    /**
     * UNION FIND
     */
    public int minimumEffortPath2(int[][] heights) {
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                //构建两边条的边对象
                //{i,j}->{i+1,j}
                //{i,j}->{i,j+1}
                int curNodeId = getIndex(i, j, heights);
                if (i + 1 < heights.length) {
                    edges.add(new int[]{curNodeId, getIndex(i + 1, j, heights), Math.abs(heights[i][j] - heights[i + 1][j])});
                }
                if (j + 1 < heights[0].length) {
                    edges.add(new int[]{curNodeId, getIndex(i, j + 1, heights), Math.abs(heights[i][j] - heights[i][j + 1])});
                }
            }
        }
        edges.sort((a, b) -> a[2] - b[2]);
        UnionFind unionFind = new UnionFind(heights.length * heights[0].length);
        int end = heights.length * heights[0].length - 1;
        int ans = 0;
        for (int[] edge : edges) {
            unionFind.connect(edge[0], edge[1]);
            ans = edge[2];
            if (unionFind.isConnect(0, end)) {
                break;
            }
        }
        return ans;
    }

    public int getIndex(int x, int y, int[][] heights) {
        return x * heights[x].length + y;
    }

    /**
     * 二分答案
     */
    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1_000_000;
        while (left < right) {
            int mid = (left + right) >> 1;
            boolean b = check(mid, heights);
            if (b) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private boolean check(int target, int[][] heights) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0, 0});
        boolean[][] visit = new boolean[heights.length][heights[0].length];
        while (!deque.isEmpty()) {
            int[] pop = deque.pop();
            int nodeX = pop[0];
            int nodeY = pop[1];
            if (visit[nodeX][nodeY]) {
                continue;
            }
            visit[nodeX][nodeY] = true;
            if (nodeX == heights.length - 1 && nodeY == heights[0].length - 1) {
                return true;
            }
            if (nodeX - 1 >= 0 && Math.abs(heights[nodeX][nodeY] - heights[nodeX - 1][nodeY]) <= target) {
                deque.add(new int[]{nodeX - 1, nodeY});
            }
            if (nodeX + 1 < heights.length && Math.abs(heights[nodeX][nodeY] - heights[nodeX + 1][nodeY]) <= target) {
                deque.add(new int[]{nodeX + 1, nodeY});
            }
            if (nodeY - 1 >= 0 && Math.abs(heights[nodeX][nodeY] - heights[nodeX][nodeY - 1]) <= target) {
                deque.add(new int[]{nodeX, nodeY - 1});
            }
            if (nodeY + 1 < heights[0].length && Math.abs(heights[nodeX][nodeY] - heights[nodeX][nodeY + 1]) <= target) {
                deque.add(new int[]{nodeX, nodeY + 1});
            }
        }
        return false;
    }


}
