package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1457. 二叉树中的伪回文路径
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
 * <p>
 * 请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,3,1,3,1,null,1]
 * 输出：2
 * 解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
 * 在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 2：
 * <p>
 * 输入：root = [2,1,1,1,3,null,null,null,null,null,1]
 * 输出：1
 * 解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
 * 这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
 * 示例 3：
 * <p>
 * 输入：root = [9]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 给定二叉树的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/pseudo-palindromic-paths-in-a-binary-tree/description/?envType=daily-question&envId=2023-11-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1457_PseudoPalindromicPaths {

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
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        L1457_PseudoPalindromicPaths l1457PseudoPalindromicPaths = new L1457_PseudoPalindromicPaths();
        System.out.println(l1457PseudoPalindromicPaths.pseudoPalindromicPaths(root));
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, new int[10]);
    }

    private int dfs(TreeNode root, int[] arr) {
        arr[root.val]++;
        if (root.left == null && root.right == null) {
            //检查所有节点
            int odd = 0;
            for (int j : arr) {
                if (j % 2 != 0 && ++odd > 1) {
                    arr[root.val]--;
                    return 0;
                }
            }
            arr[root.val]--;
            return 1;
        }
        int ans = 0;
        if (root.left != null) {
            ans += dfs(root.left, arr);
        }
        if (root.right != null) {
            ans += dfs(root.right, arr);
        }
        arr[root.val]--;
        return ans;
    }

}
