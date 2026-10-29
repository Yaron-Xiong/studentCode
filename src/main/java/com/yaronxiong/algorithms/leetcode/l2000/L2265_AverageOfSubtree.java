package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2265. 统计值等于子树平均值的节点数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一棵二叉树的根节点 root ，找出并返回满足要求的节点数，要求节点的值等于其 子树 中值的 平均值 。
 * <p>
 * 注意：
 * <p>
 * n 个元素的平均值可以由 n 个元素 求和 然后再除以 n ，并 向下舍入 到最近的整数。
 * root 的 子树 由 root 和它的所有后代组成。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [4,8,5,0,1,null,6]
 * 输出：5
 * 解释：
 * 对值为 4 的节点：子树的平均值 (4 + 8 + 5 + 0 + 1 + 6) / 6 = 24 / 6 = 4 。
 * 对值为 5 的节点：子树的平均值 (5 + 6) / 2 = 11 / 2 = 5 。
 * 对值为 0 的节点：子树的平均值 0 / 1 = 0 。
 * 对值为 1 的节点：子树的平均值 1 / 1 = 1 。
 * 对值为 6 的节点：子树的平均值 6 / 1 = 6 。
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：1
 * 解释：对值为 1 的节点：子树的平均值 1 / 1 = 1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 1000] 内
 * 0 <= Node.val <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-nodes-equal-to-average-of-subtree/description/?envType=daily-question&envId=2026-09-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2265_AverageOfSubtree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int averageOfSubtree(TreeNode root) {
        //需要有子节点数 和 子节点和
        cal(root);
        return ans;
    }

    int ans = 0;

    private int[] cal(TreeNode root) {
        if (root == null) return new int[]{0, 0};
        int[] left = cal(root.left);
        int[] right = cal(root.right);
        int[] cur = new int[]{left[0] + right[0] + root.val, left[1] + right[1] + 1};
        if (cur[0] / cur[1] == root.val) {
            ans++;
        }
        return cur;
    }
}
