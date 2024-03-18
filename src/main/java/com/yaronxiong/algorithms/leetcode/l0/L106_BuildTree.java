package com.yaronxiong.algorithms.leetcode.l0;

import java.util.HashMap;
import java.util.Map;

/**
 * 106. 从中序与后序遍历序列构造二叉树
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 * <p>
 * 示例 1:
 * <p>
 * 输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
 * 输出：[3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * 输入：inorder = [-1], postorder = [-1]
 * 输出：[-1]
 * <p>
 * 提示:
 * <p>
 * 1 <= inorder.length <= 3000
 * postorder.length == inorder.length
 * -3000 <= inorder[i], postorder[i] <= 3000
 * inorder 和 postorder 都由 不同 的值组成
 * postorder 中每一个值都在 inorder 中
 * inorder 保证是树的中序遍历
 * postorder 保证是树的后序遍历
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/?envType=daily-question&envId=2024-02-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L106_BuildTree {

    public class TreeNode {
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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.inordrMap = map;
        this.postIndex = postorder.length - 1;
        this.postorder = postorder;
        return buildTree(0, postorder.length - 1);
    }

    private TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex--]);
        int index = inordrMap.get(root.val);
        root.right = buildTree(index + 1, right);
        root.left = buildTree(left, index - 1);
        return root;
    }

    Map<Integer, Integer> inordrMap;
    int[] postorder;
    int postIndex;
}
