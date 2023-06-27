package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class L1110_DelNodes {
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        L1110_DelNodes l1110DelNodes = new L1110_DelNodes();
        System.out.println(l1110DelNodes.delNodes(root, new int[]{3, 5}));
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> delSet = new HashSet<>();
        for (int i : to_delete) {
            delSet.add(i);
        }
        TreeNode newRoot = dfs(root, delSet, res);
        if (newRoot != null) {
            res.add(newRoot);
        }
        return res;
    }

    public TreeNode dfs(TreeNode root, Set<Integer> delSet, List<TreeNode> res) {
        if (root == null) {
            return null;
        }
        root.left = dfs(root.left, delSet, res);
        root.right = dfs(root.right, delSet, res);
        if (delSet.contains(root.val)) {
            if (root.left != null) {
                res.add(root.left);
            }
            if (root.right != null) {
                res.add(root.right);
            }
            root.left = null;
            root.right = null;
            return null;
        }
        return root;
    }
}
