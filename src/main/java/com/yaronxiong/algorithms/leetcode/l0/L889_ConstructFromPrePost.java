package com.yaronxiong.algorithms.leetcode.l0;

import java.util.HashMap;
import java.util.Map;

/**
 * 889. 根据前序和后序遍历构造二叉树
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * <p>
 * 如果存在多个答案，您可以返回其中 任何 一个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
 * 输出：[1,2,3,4,5,6,7]
 * 示例 2:
 * <p>
 * 输入: preorder = [1], postorder = [1]
 * 输出: [1]
 * <p>
 * 提示：
 * <p>
 * 1 <= preorder.length <= 30
 * 1 <= preorder[i] <= preorder.length
 * preorder 中所有值都 不同
 * postorder.length == preorder.length
 * 1 <= postorder[i] <= postorder.length
 * postorder 中所有值都 不同
 * 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/?envType=daily-question&envId=2024-02-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L889_ConstructFromPrePost {
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
        L889_ConstructFromPrePost l889ConstructFromPrePost = new L889_ConstructFromPrePost();
        System.out.println(l889ConstructFromPrePost.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1}));
    }

    int[] preorder;
    int[] postorder;
    Map<Integer, Integer> postMap = new HashMap<>();
    int preIndex = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        this.preorder = preorder;
        this.postorder = postorder;
        for (int i = 0; i < this.postorder.length; i++) {
            postMap.put(this.postorder[i], i);
        }
        return builderTreeNode(0, preorder.length - 1);
    }

    private TreeNode builderTreeNode(int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(this.preorder[this.preIndex++]);
        //说明当前节点存在子节点
        if (left < right) {
            //从Left->index 都为左节点
            Integer index = this.postMap.get(this.preorder[this.preIndex]);
            root.left = builderTreeNode(left, index);
            //从index+1 -> right 都为右节点
            root.right = builderTreeNode(index + 1, right - 1);
        }
        return root;
    }
}
