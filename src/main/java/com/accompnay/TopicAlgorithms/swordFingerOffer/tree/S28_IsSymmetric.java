package com.accompnay.TopicAlgorithms.swordFingerOffer.tree;

/**
 * 剑指 Offer 28. 对称的二叉树
 * <p>
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S28_IsSymmetric {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        //中序遍历
        return check(root.left, root.right);
    }

    public boolean check(TreeNode nodeA, TreeNode nodeB) {
        if (isEquals(nodeA, nodeB)) {
            if (nodeA == null) {
                return true;
            }
            return check(nodeA.left, nodeB.right) && check(nodeA.right, nodeB.left);
        }
        return false;
    }

    public boolean isEquals(TreeNode nodeA, TreeNode nodeB) {
        return (nodeA == nodeB) || (nodeA != null && nodeB != null && nodeA.val == nodeB.val);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        //root.right.right = new TreeNode(2);
        S28_IsSymmetric s28IsSymmetric = new S28_IsSymmetric();
        boolean symmetric = s28IsSymmetric.isSymmetric(root);
        System.out.println(symmetric);
    }

}
