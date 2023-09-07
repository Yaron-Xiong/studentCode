package com.accompnay.TopicAlgorithms.leetcode.l1000;

import javafx.util.Pair;

/**
 * 1123. 最深叶节点的最近公共祖先
 * 提示
 * 中等
 * 179
 * 相关企业
 * 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 * <p>
 * 回想一下：
 * <p>
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。
 * <p>
 * 提示：
 * <p>
 * 树中的节点数将在 [1, 1000] 的范围内。
 * 0 <= Node.val <= 1000
 * 每个节点的值都是 独一无二 的。
 * <p>
 * 注意：本题与力扣 865 重复：<a href="https://leetcode-cn.com/problems/smallest-subtree-with-all-the-deepest-nodes/">...</a>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves/?envType=daily-question&envId=2023-09-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1123_LcaDeepestLeaves {
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);
        treeNode.right = new TreeNode(1);
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);
        L1123_LcaDeepestLeaves l1123LcaDeepestLeaves = new L1123_LcaDeepestLeaves();
        System.out.println(l1123LcaDeepestLeaves.lcaDeepestLeaves(treeNode));
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        return dfs(root).getValue();
    }

    private Pair<Integer, TreeNode> dfs(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, null);
        }
        Pair<Integer, TreeNode> leftDepth = dfs(root.left);
        Pair<Integer, TreeNode> rightDepth = dfs(root.right);
        if (leftDepth.getKey() > rightDepth.getKey()) {
            return new Pair<>(leftDepth.getKey() + 1, leftDepth.getValue());
        } else if (leftDepth.getKey() < rightDepth.getKey()) {
            return new Pair<>(rightDepth.getKey() + 1, rightDepth.getValue());
        } else {
            return new Pair<>(leftDepth.getKey() + 1, root);
        }
    }
}
