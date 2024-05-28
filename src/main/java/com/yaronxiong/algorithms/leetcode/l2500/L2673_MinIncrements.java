package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2673. 使二叉树所有路径值相等的最小代价
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n 表示一棵 满二叉树 里面节点的数目，节点编号从 1 到 n 。
 * 根节点编号为 1 ，树中每个非叶子节点 i 都有两个孩子，分别是左孩子 2 * i 和右孩子 2 * i + 1 。
 * <p>
 * 树中每个节点都有一个值，用下标从 0 开始、长度为 n 的整数数组 cost 表示，
 * 其中 cost[i] 是第 i + 1 个节点的值。每次操作，你可以将树中 任意 节点的值 增加 1 。你可以执行操作 任意 次。
 * <p>
 * 你的目标是让根到每一个 叶子结点 的路径值相等。请你返回 最少 需要执行增加操作多少次。
 * <p>
 * 注意：
 * <p>
 * 满二叉树 指的是一棵树，它满足树中除了叶子节点外每个节点都恰好有 2 个子节点，且所有叶子节点距离根节点距离相同。
 * 路径值 指的是路径上所有节点的值之和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 7, cost = [1,5,2,2,3,3,1]
 * 输出：6
 * 解释：我们执行以下的增加操作：
 * - 将节点 4 的值增加一次。
 * - 将节点 3 的值增加三次。
 * - 将节点 7 的值增加两次。
 * 从根到叶子的每一条路径值都为 9 。
 * 总共增加次数为 1 + 3 + 2 = 6 。
 * 这是最小的答案。
 * 示例 2：
 * <p>
 * 输入：n = 3, cost = [5,3,3]
 * 输出：0
 * 解释：两条路径已经有相等的路径值，所以不需要执行任何增加操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n <= 105
 * n + 1 是 2 的幂
 * cost.length == n
 * 1 <= cost[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree/description/?envType=daily-question&envId=2024-02-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2673_MinIncrements {
    public static void main(String[] args) {
        L2673_MinIncrements l2673MinIncrements = new L2673_MinIncrements();
        System.out.println(l2673MinIncrements.minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1}));
    }

    public int minIncrements(int n, int[] cost) {
        //如果要让所有路径和一致，那么就会导致一个现象，所有层级中兄弟节点的值都会一样
        int ans = 0;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            //让子节点值相等
            ans += Math.abs(cost[i * 2 + 1] - cost[i * 2 + 2]);
            cost[i] += Math.max(cost[i * 2 + 1], cost[i * 2 + 2]);
        }
        return ans;
    }

}
