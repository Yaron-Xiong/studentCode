package com.accompnay.leetcode;

import org.apache.poi.ss.formula.functions.T;

public class Demo11 {
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

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(5);
        treeNode.left.left = new TreeNode(3);
        treeNode.left.right = new TreeNode(4);
        Demo11 demo11 = new Demo11();
        demo11.convertBiNode(treeNode);
    }

    TreeNode pre = null;
    TreeNode head = null;

    public TreeNode convertBiNode(TreeNode root) {
        help(root);
        return head;
    }

    private void help(TreeNode root) {
        if (root == null) {
            return;
        }
        convertBiNode(root.left);
        if (pre == null) {
            pre = root;
            head = root;
        } else {
            pre.right = root;
            pre = root;
        }
        root.left = null;
        convertBiNode(root.right);
    }
}
