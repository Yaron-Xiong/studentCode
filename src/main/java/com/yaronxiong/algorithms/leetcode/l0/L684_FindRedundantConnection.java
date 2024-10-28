package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 684. 冗余连接
 * 已解答
 * 算术评级: 5
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 树可以看成是一个连通且 无环 的 无向 图。
 * <p>
 * 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。
 * 图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。
 * <p>
 * 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的那个。
 * <p>
 * 示例 1：
 * <p>
 * 输入: edges = [[1,2], [1,3], [2,3]]
 * 输出: [2,3]
 * 示例 2：
 * <p>
 * 输入: edges = [[1,2], [2,3], [3,4], [1,4], [1,5]]
 * 输出: [1,4]
 * <p>
 * 提示:
 * <p>
 * n == edges.length
 * 3 <= n <= 1000
 * edges[i].length == 2
 * 1 <= ai < bi <= edges.length
 * ai != bi
 * edges 中无重复元素
 * 给定的图是连通的
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/redundant-connection/description/?envType=daily-question&envId=2024-10-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L684_FindRedundantConnection {

    public class UnionFind {
        private int[] parent;
        private int[] size;

        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public boolean connect(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentB == parentA) {
                return false;
            }
            if (size[parentA] < size[parentB]) {
                parent[parentB] = parentA;
                size[parentA] += size[parentB];
            } else {
                parent[parentA] = parentB;
                size[parentB] += size[parentA];
            }
            return true;
        }

    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind unionFind = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (!unionFind.connect(edge[0], edge[1])) {
                return edge;
            }
        }
        return new int[]{};
    }
}
