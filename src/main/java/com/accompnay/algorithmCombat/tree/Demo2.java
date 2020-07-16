package com.accompnay.algorithmCombat.tree;

/**
 * @author Accompany
 * LeetCode 236(二叉树的公共祖先）
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出: 3
 * 解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
 * 示例 2:
 * <p>
 * 输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出: 5
 * 解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 树之类的题需要考虑到二叉树的一些奇奇怪怪的性质
 * 例如这道题，找公共祖先，p,q属于树中的某两个节点
 * 那么从跟节点开始看
 * 情况1：如果p和q分别在左子树和右子树，那么根节点就为最近的公共祖先
 * 情况2：如果p或者q是根节点，那么根节点就是最近的公共祖先
 * 情况3：如果p和q都在右子树或者左子树，那么继续判断情况1和情况2
 */
public class Demo2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //判断p和q是否为根节点，如果是那么最近公共祖先为根节点
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
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
        Demo2 demo2 = new Demo2();
        TreeNode node = demo2.lowestCommonAncestor(root, root.left.left, root.right.right);
        System.out.println("最近公共祖先" + node.val);
    }
}
