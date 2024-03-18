package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1782. 统计点对的数目
 * 提示
 * 困难
 * 73
 * 相关企业
 * 给你一个无向图，无向图由整数 n  ，表示图中节点的数目，和 edges 组成，
 * 其中 edges[i] = [ui, vi] 表示 ui 和 vi 之间有一条无向边。
 * 同时给你一个代表查询的整数数组 queries 。
 * <p>
 * 第 j 个查询的答案是满足如下条件的点对 (a, b) 的数目：
 * <p>
 * a < b
 * cnt 是与 a 或者 b 相连的边的数目，且 cnt 严格大于 queries[j] 。
 * 请你返回一个数组 answers ，其中 answers.length == queries.length 且 answers[j] 是第 j 个查询的答案。
 * <p>
 * 请注意，图中可能会有 重复边 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, edges = [[1,2],[2,4],[1,3],[2,3],[2,1]], queries = [2,3]
 * 输出：[6,5]
 * 解释：每个点对中，与至少一个点相连的边的数目如上图所示。
 * 示例 2：
 * <p>
 * 输入：n = 5, edges = [[1,5],[1,5],[3,4],[2,5],[1,3],[5,1],[2,3],[2,5]], queries = [1,2,3,4,5]
 * 输出：[10,10,9,8,6]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 2 * 104
 * 1 <= edges.length <= 105
 * 1 <= ui, vi <= n
 * ui != vi
 * 1 <= queries.length <= 20
 * 0 <= queries[j] < edges.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-pairs-of-nodes/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1782_CountPairs {
    public static void main(String[] args) {
        L1782_CountPairs l1782CountPairs = new L1782_CountPairs();
        System.out.println(Arrays.toString(l1782CountPairs.countPairs(5, new int[][]{{1, 5}, {1, 5}, {3, 4}, {2, 5}, {1, 3}, {5, 1}, {2, 3}, {2, 5}}, new int[]{1, 2, 3, 4, 5})));
    }

    public int[] countPairs(int n, int[][] edges, int[] queries) {
        //算两个点的边的总数，重复只计算一次
        //先计算每个点的边数，然后计算边跟边之间的边数，
        //每个点的不重复的边数= A点边数+ B点边数- （A，B）直接连接的边数
        Map<Integer, Integer> pointEdgeMap = new HashMap<>();
        int[] edgeCount = new int[n];
        for (int[] edge : edges) {
            int from = edge[0] - 1;
            int to = edge[1] - 1;
            if (from > to) {
                int temp = from;
                from = to;
                to = temp;
            }
            edgeCount[from]++;
            edgeCount[to]++;
            pointEdgeMap.merge(from << 16 | to, 1, Integer::sum);
        }
        int[] res = new int[queries.length];
        //这里要优化
        int[] copyEdge = edgeCount.clone();
        Arrays.sort(copyEdge);
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int left = 0;
            int right = copyEdge.length - 1;
            while (left < right) {
                if (copyEdge[left] + copyEdge[right] > query) {
                    res[i] += right - left;
                    right--;
                } else {
                    left++;
                }
            }
            for (Map.Entry<Integer, Integer> entry : pointEdgeMap.entrySet()) {
                int c = edgeCount[entry.getKey() >> 16] + edgeCount[entry.getKey() & 0xFFFF];
                if (c > query && c - entry.getValue() <= query) {
                    res[i]--;
                }
            }
        }
        return res;
    }
}
