package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 2642. 设计可以求最短路径的图类
 * 第 102 场双周赛
 * Q4
 * 1811
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个有 n 个节点的 有向带权 图，节点编号为 0 到 n - 1 。
 * 图中的初始边用数组 edges 表示，其中 edges[i] = [fromi, toi, edgeCosti] 表示从 fromi 到 toi 有一条代价为 edgeCosti 的边。
 * <p>
 * 请你实现一个 Graph 类：
 * <p>
 * Graph(int n, int[][] edges) 初始化图有 n 个节点，并输入初始边。
 * addEdge(int[] edge) 向边集中添加一条边，其中 edge = [from, to, edgeCost] 。数据保证添加这条边之前对应的两个节点之间没有有向边。
 * int shortestPath(int node1, int node2) 返回从节点 node1 到 node2 的路径 最小 代价。如果路径不存在，返回 -1 。一条路径的代价是路径中所有边代价之和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["Graph", "shortestPath", "shortestPath", "addEdge", "shortestPath"]
 * [[4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]], [3, 2], [0, 3], [[1, 3, 4]], [0, 3]]
 * 输出：
 * [null, 6, -1, null, 6]
 * <p>
 * 解释：
 * Graph g = new Graph(4, [[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]);
 * g.shortestPath(3, 2); // 返回 6 。从 3 到 2 的最短路径如第一幅图所示：3 -> 0 -> 1 -> 2 ，总代价为 3 + 2 + 1 = 6 。
 * g.shortestPath(0, 3); // 返回 -1 。没有从 0 到 3 的路径。
 * g.addEdge([1, 3, 4]); // 添加一条节点 1 到节点 3 的边，得到第二幅图。
 * g.shortestPath(0, 3); // 返回 6 。从 0 到 3 的最短路径为 0 -> 1 -> 3 ，总代价为 2 + 4 = 6 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 0 <= edges.length <= n * (n - 1)
 * edges[i].length == edge.length == 3
 * 0 <= fromi, toi, from, to, node1, node2 <= n - 1
 * 1 <= edgeCosti, edgeCost <= 106
 * 图中任何时候都不会有重边和自环。
 * 调用 addEdge 至多 100 次。
 * 调用 shortestPath 至多 100 次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-number-of-visited-cells-in-a-grid/?envType=daily-question&envId=2024-03-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2642_Graph {
    class Graph {
        private List<int[]>[] graph;

        public Graph(int n, int[][] edges) {
            graph = new List[n];
            Arrays.setAll(graph, a -> new ArrayList<>());
            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }

        public int shortestPath(int node1, int node2) {
            PriorityQueue<int[]> deque = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            deque.add(new int[]{node1, 0});
            int[] dijkstra = new int[graph.length];
            Arrays.fill(dijkstra, Integer.MAX_VALUE);
            while (!deque.isEmpty()) {
                int[] node = deque.poll();
                int curNode = node[0];
                int cost = node[1];
                if (curNode == node2) {
                    return cost;
                }
                if (cost >= dijkstra[curNode]) {
                    continue;
                }
                dijkstra[curNode] = cost;
                for (int[] neighbor : graph[curNode]) {
                    if (cost + neighbor[1] > dijkstra[neighbor[0]]) {
                        continue;
                    }
                    deque.add(new int[]{neighbor[0], cost + neighbor[1]});
                }
            }
            return -1;
        }
    }
}
