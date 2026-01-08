package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1339. 分裂二叉树的最大乘积
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * <p>
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：110
 * 解释：删除红色的边，得到 2 棵子树，和分别为 11 和 10 。它们的乘积是 110 （11*10）
 * 示例 2：
 * <p>
 * 输入：root = [1,null,2,3,4,null,null,5,6]
 * 输出：90
 * 解释：移除红色的边，得到 2 棵子树，和分别是 15 和 6 。它们的乘积为 90 （15*6）
 * 示例 3：
 * <p>
 * 输入：root = [2,3,9,10,7,8,6,5,4,11,1]
 * 输出：1025
 * 示例 4：
 * <p>
 * 输入：root = [1,1]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 每棵树最多有 50000 个节点，且至少有 2 个节点。
 * 每个节点的值在 [1, 10000] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-product-of-splitted-binary-tree/description/?envType=daily-question&envId=2026-01-07">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1339_MaxProduct {
    public static class TreeNode {
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

    public static void main(String[] args) {
        L1339_MaxProduct l1339MaxProduct = new L1339_MaxProduct();
        TreeNode left = new TreeNode(2, new TreeNode(4), new TreeNode(5));
        TreeNode right = new TreeNode(3, new TreeNode(6), null);
        TreeNode root = new TreeNode(1, left, right);
        int i = l1339MaxProduct.maxProduct(root);
        System.out.println(i);
    }

    public int maxProduct(TreeNode root) {
        long sum = sum(root);
        //来一次后序遍历
        dfs2(root, sum);
        return (int) (ans % mod);
    }

    private long sum(TreeNode node) {
        return node == null ? 0 : sum(node.left) + sum(node.right) + node.val;
    }

    int mod = (int) (1e9 + 7);
    long ans = 0;

    private long dfs2(TreeNode root, long sum) {
        if (root == null) {
            return 0;
        }
        long lv = dfs2(root.left, sum);
        long rv = dfs2(root.right, sum);
        long tempValue = Math.max((sum - lv) * lv, (sum - rv) * rv);
        ans = Math.max(ans, tempValue);
        return lv + rv + root.val;
    }

}
