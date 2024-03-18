package com.yaronxiong.algorithms.swordFingerOffer.tree;

/**
 * 剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：
 * “对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉搜索树: root =[6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S68_LowestCommonAncestor {
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //如果 p 或者 q 在root的左右两边则说明 root是最近祖先
        //如果 p 或者q 都在同一侧 说明祖先不是root ，而是在左子树或者右子树
        int minValue = Math.min(p.val, q.val);
        int maxValue = Math.max(p.val, q.val);
        if (root.val >= minValue && root.val <= maxValue) {
            return root;
        }
        if (root.val < minValue) {
            //说明在右侧
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        S68_LowestCommonAncestor s68LowestCommonAncestor = new S68_LowestCommonAncestor();
        TreeNode treeNode = s68LowestCommonAncestor.lowestCommonAncestor(root, root.left.right, root.left);
        System.out.println(treeNode);
    }
}
