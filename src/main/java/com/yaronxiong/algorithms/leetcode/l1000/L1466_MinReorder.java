package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1466. 重新规划路线
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
 * <p>
 * 路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
 * <p>
 * 今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
 * <p>
 * 请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
 * <p>
 * 题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
 * 输出：3
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 2：
 * <p>
 * 输入：n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
 * 输出：2
 * 解释：更改以红色显示的路线的方向，使每个城市都可以到达城市 0 。
 * 示例 3：
 * <p>
 * 输入：n = 3, connections = [[1,0],[2,0]]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5 * 10^4
 * connections.length == n-1
 * connections[i].length == 2
 * 0 <= connections[i][0], connections[i][1] <= n-1
 * connections[i][0] != connections[i][1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/description/?envType=daily-question&envId=2023-12-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1466_MinReorder {
    public static void main(String[] args) {
        L1466_MinReorder l1466MinReorder = new L1466_MinReorder();
        System.out.println(l1466MinReorder.minReorder(6, new int[][]{{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}}));
    }

    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new List[n];
        Arrays.setAll(graph, a -> new ArrayList<>());
        for (int[] connection : connections) {
            graph[connection[0]].add(new int[]{connection[1], 1});
            graph[connection[1]].add(new int[]{connection[0], 2});
        }
        return dfs(0, -1, graph);
    }

    private int dfs(int curNode, int fa, List<int[]>[] graph) {
        int ans = 0;
        for (int[] neighbor : graph[curNode]) {
            if (neighbor[0] == fa) {
                continue;
            }
            if (neighbor[1] != 2) {
                ans++;
            }
            ans += dfs(neighbor[0], curNode, graph);
        }
        return ans;
    }
}
