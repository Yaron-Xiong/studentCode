package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3532. 针对图的路径存在性查询 I
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n，表示图中的节点数量，这些节点按从 0 到 n - 1 编号。
 * <p>
 * 同时给你一个长度为 n 的整数数组 nums，该数组按 非递减 顺序排序，以及一个整数 maxDiff。
 * <p>
 * 如果满足 |nums[i] - nums[j]| <= maxDiff（即 nums[i] 和 nums[j] 的 绝对差 至多为 maxDiff），则节点 i 和节点 j 之间存在一条 无向边 。
 * <p>
 * 此外，给你一个二维整数数组 queries。对于每个 queries[i] = [ui, vi]，需要判断节点 ui 和 vi 之间是否存在路径。
 * <p>
 * 返回一个布尔数组 answer，其中 answer[i] 等于 true 表示在第 i 个查询中节点 ui 和 vi 之间存在路径，否则为 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 2, nums = [1,3], maxDiff = 1, queries = [[0,0],[0,1]]
 * <p>
 * 输出: [true,false]
 * <p>
 * 解释:
 * <p>
 * 查询 [0,0]：节点 0 有一条到自己的显然路径。
 * 查询 [0,1]：节点 0 和节点 1 之间没有边，因为 |nums[0] - nums[1]| = |1 - 3| = 2，大于 maxDiff。
 * 因此，在处理完所有查询后，最终答案为 [true, false]。
 * 示例 2：
 * <p>
 * 输入: n = 4, nums = [2,5,6,8], maxDiff = 2, queries = [[0,1],[0,2],[1,3],[2,3]]
 * <p>
 * 输出: [false,false,true,true]
 * <p>
 * 解释:
 * <p>
 * 生成的图如下：
 * <p>
 * 查询 [0,1]：节点 0 和节点 1 之间没有边，因为 |nums[0] - nums[1]| = |2 - 5| = 3，大于 maxDiff。
 * 查询 [0,2]：节点 0 和节点 2 之间没有边，因为 |nums[0] - nums[2]| = |2 - 6| = 4，大于 maxDiff。
 * 查询 [1,3]：节点 1 和节点 3 之间存在路径通过节点 2，因为 |nums[1] - nums[2]| = |5 - 6| = 1 和 |nums[2] - nums[3]| = |6 - 8| = 2，都小于等于 maxDiff。
 * 查询 [2,3]：节点 2 和节点 3 之间有一条边，因为 |nums[2] - nums[3]| = |6 - 8| = 2，等于 maxDiff。
 * 因此，在处理完所有查询后，最终答案为 [false, false, true, true]。
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 105
 * 0 <= nums[i] <= 105
 * nums 按 非递减 顺序排序。
 * 0 <= maxDiff <= 105
 * 1 <= queries.length <= 105
 * queries[i] == [ui, vi]
 * 0 <= ui, vi < n
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/path-existence-queries-in-a-graph-i/description/?envType=daily-question&envId=Invalid%20Date">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3532_PathExistenceQueries {
    public static class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if (px == py) {
                return;
            }
            if (size[px] > size[py]) {
                parent[py] = px;
                size[px] += size[py];
            } else {
                parent[px] = py;
                size[py] += size[px];
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }


    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        UnionFind unionFind = new UnionFind(n);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                unionFind.union(i, i - 1);
            }
        }
        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int x = query[0];
            int y = query[1];
            ans[i] = unionFind.connected(x, y);
        }
        return ans;
    }


}
