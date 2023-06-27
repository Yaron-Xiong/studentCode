package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 1080. 根到叶路径上的不足节点
 * 提示
 * 中等
 * 102
 * 相关企业
 * 给你二叉树的根节点 root 和一个整数 limit ，请你同时删除树中所有 不足节点 ，并返回最终二叉树的根节点。
 * <p>
 * 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为 不足节点 ，需要被删除。
 * <p>
 * 叶子节点，就是没有子节点的节点。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14], limit = 1
 * 输出：[1,2,3,4,null,null,7,8,9,null,14]
 * 示例 2：
 * <p>
 * 输入：root = [5,4,8,11,null,17,4,7,1,null,null,5,3], limit = 22
 * 输出：[5,4,8,11,null,17,4,7,null,null,null,5]
 * 示例 3：
 * <p>
 * <p>
 * 输入：root = [1,2,-3,-5,null,4,null], limit = -1
 * 输出：[1,null,-3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [1, 5000] 内
 * -105 <= Node.val <= 105
 * -109 <= limit <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/insufficient-nodes-in-root-to-leaf-paths/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1080_SufficientSubset {
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

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if (root == null) {
            return root;
        }
        limit -= root.val;
        if (root.left == null && root.right == null) {
            return limit > 0 ? null : root;
        }
        root.left = sufficientSubset(root.left, limit);
        root.right = sufficientSubset(root.right, limit);
        if (root.left == null && root.right == null) {
            return null;
        }
        return root;
    }

}
