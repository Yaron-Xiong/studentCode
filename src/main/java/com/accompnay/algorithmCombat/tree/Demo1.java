package com.accompnay.algorithmCombat.tree;

/**
 * @author Accompany
 * <p>
 * LeetCode 98 验证是否为二叉搜索树
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * <p>
 * 输入:
 * 2
 * / \
 * 1   3
 * 输出: true
 *
 * 示例 2:
 * <p>
 * 输入:
 * 5
 * / \
 * 1   4
 * / \
 * 3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 *
 * 解法：
 * 1.递归，保存遍历过程中，上层的最大值与最小值，
 *  如果是走左节点，则最小值更新为root.val
 *  如果是走右节点，则最大值更新为root.val
 *
 * 2.中序遍历 的结果为升序 则也是BST
 *
 * 3.
 */
public class Demo1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    /*public boolean isValidBST(TreeNode root) {
        //假设根节点存在两个父节点，一个右，一个左，用于保存上届与下届
        return isValidBST(root,null,null);
    }
    public boolean isValidBST(TreeNode root,Integer rightMin , Integer leftMax){
        if (root==null){
            return true;
        }
        if ((rightMin!=null && root.val>=rightMin) || (leftMax!=null &&root.val<=leftMax) ){
            return false;
        }
        //执行递归
        if (!isValidBST(root.left,root.val,leftMax)) return false;
        if (!isValidBST(root.right,rightMin,root.val)) return false;
        return true;
    }*/
    private Integer val ;
    public boolean isValidBST(TreeNode root) {
        //根据中序遍历来判断是否为BST
        return inOrder(root);
    }
    private boolean inOrder(TreeNode root){
        if (root==null){
            return true;
        }
        //中序遍历
        if (!inOrder(root.left))  return false;
        //判断中序打印点是否比上次中序打印点大
        if (val!=null&&root.val<=val) return false;
        val = root.val;
        if (!inOrder(root.right)) return false;
        return true;
    }
    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        /*TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right = new TreeNode(5);*/

        /*TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        System.out.println(demo1.isValidBST(root));
    }
}
