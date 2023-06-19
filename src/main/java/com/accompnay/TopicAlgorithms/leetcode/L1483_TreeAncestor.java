package com.accompnay.TopicAlgorithms.leetcode;

/**
 * 1483. 树节点的第 K 个祖先
 * 提示
 * 困难
 * 137
 * 相关企业
 * 给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。
 * 树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
 * <p>
 * 树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
 * <p>
 * 实现 TreeAncestor 类：
 * <p>
 * TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
 * getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["TreeAncestor","getKthAncestor","getKthAncestor","getKthAncestor"]
 * [[7,[-1,0,0,1,1,2,2]],[3,1],[5,2],[6,3]]
 * <p>
 * 输出：
 * [null,1,0,-1]
 * <p>
 * 解释：
 * TreeAncestor treeAncestor = new TreeAncestor(7, [-1, 0, 0, 1, 1, 2, 2]);
 * <p>
 * treeAncestor.getKthAncestor(3, 1);  // 返回 1 ，它是 3 的父节点
 * treeAncestor.getKthAncestor(5, 2);  // 返回 0 ，它是 5 的祖父节点
 * treeAncestor.getKthAncestor(6, 3);  // 返回 -1 因为不存在满足要求的祖先节点
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 5 * 104
 * parent[0] == -1 表示编号为 0 的节点是根节点。
 * 对于所有的 0 < i < n ，0 <= parent[i] < n 总成立
 * 0 <= node < n
 * 至多查询 5 * 104 次
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/kth-ancestor-of-a-tree-node/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1483_TreeAncestor {
    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }

    public static class TreeAncestor {
        private int[][] dp;

        //n最多为5K
        public TreeAncestor(int n, int[] parent) {
            //dp的每一层只记录 1 、2、4、8的父亲,那么需要 log2^n的格子去记录
            dp = new int[n][32 - Integer.numberOfLeadingZeros(n)];
            for (int i = 0; i < parent.length; i++) {
                dp[i][0] = parent[i];
            }
            for (int i = 0; i < dp.length; i++) {
                for (int j = 1; j < dp[i].length; j++) {
                    int p = dp[i][j - 1];
                    dp[i][j] = p == -1 ? -1 : dp[p][j - 1];
                }
            }
        }

        public int getKthAncestor(int node, int k) {
            int m = 32 - Integer.numberOfLeadingZeros(k);
            for (int i = 0; i < m; i++) {
                if ((k >> i & 1) > 0) {
                    node = dp[node][i];
                    if (node < 0) {
                        return node;
                    }
                }
            }
            return node;
        }
    }

}
