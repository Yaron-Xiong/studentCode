package com.yaronxiong.algorithms.swordFingerOffer.tree;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * <p>
 * 例如:
 * 给定的树 A:
 * 3
 * / \
 * 4  5
 * / \
 * 1  2
 * <p>
 * 给定的树 B：
 * <p>
 * 4
 * /
 * 1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 * <p>
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S26_IsSubStructure {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (equals(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }

    public boolean equals(TreeNode A, TreeNode B) {
        if (A == B) {
            return true;
        }
        if (A == null || B == null) {
            return false;
        }
        if (A.val == B.val) {
            return (B.left == null || equals(A.left, B.left)) && (B.right == null || equals(A.right, B.right));
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(8);
        treeNode.left.left.right = new TreeNode(9);

        TreeNode treeNode1 = new TreeNode(4);
        treeNode1.left = new TreeNode(8);
        treeNode1.right = new TreeNode(9);
        S26_IsSubStructure s26IsSubStructure = new S26_IsSubStructure();
        boolean subStructure = s26IsSubStructure.isSubStructure(treeNode, treeNode1);
        System.out.println(subStructure);
    }
}
