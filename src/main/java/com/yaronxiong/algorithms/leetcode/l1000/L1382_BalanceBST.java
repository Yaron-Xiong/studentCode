package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. 将二叉搜索树变平衡
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一棵二叉搜索树，请你返回一棵 平衡后 的二叉搜索树，新生成的树应该与原来的树有着相同的节点值。如果有多种构造方法，请你返回任意一种。
 * <p>
 * 如果一棵二叉搜索树中，每个节点的两棵子树高度差不超过 1 ，我们就称这棵二叉搜索树是 平衡的 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,2,null,3,null,4,null,null]
 * 输出：[2,1,3,null,null,null,4]
 * 解释：这不是唯一的正确答案，[3,1,4,null,2,null,null] 也是一个可行的构造方案。
 * 示例 2：
 * <p>
 * 输入: root = [2,1,3]
 * 输出: [2,1,3]
 * <p>
 * 提示：
 * <p>
 * 树节点的数目在 [1, 104] 范围内。
 * 1 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/balance-a-binary-search-tree/description/?envType=daily-question&envId=2026-02-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1382_BalanceBST {

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
        L1382_BalanceBST solution = new L1382_BalanceBST();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);
        TreeNode balancedRoot = solution.balanceBST(root);
        System.out.println(balancedRoot);
    }

    public TreeNode balanceBST(TreeNode root) {
        //先构建有序数组
        List<Integer> list = new ArrayList<>();
        getSortList(root, list);
        //构建一个平衡二叉树
        return builderBalancedBST(list, 0, list.size() - 1);
    }

    private TreeNode builderBalancedBST(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = builderBalancedBST(list, start, mid - 1);
        root.right = builderBalancedBST(list, mid + 1, end);
        return root;
    }

    private void getSortList(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        //中序遍历
        getSortList(root.left, list);
        list.add(root.val);
        getSortList(root.right, list);
    }


}
