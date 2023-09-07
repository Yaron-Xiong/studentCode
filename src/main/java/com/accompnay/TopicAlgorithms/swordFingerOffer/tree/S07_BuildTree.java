package com.accompnay.TopicAlgorithms.swordFingerOffer.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 07. 重建二叉树：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 示例 1:
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 示例 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S07_BuildTree {

    public class TreeNode {
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
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return dfs(preorder, 0, inorder.length - 1);
    }

    int index = 0;
    Map<Integer, Integer> indexMap = new HashMap<>();

    private TreeNode dfs(int[] preorder, int left, int right) {
        if (right < left || index >= preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index++]);
        int rootValueIndex = indexMap.get(root.val);
        if (rootValueIndex > left) {
            root.left = dfs(preorder, left, rootValueIndex - 1);
        }
        if (rootValueIndex < right) {
            root.right = dfs(preorder, rootValueIndex + 1, right);
        }
        return root;
    }

    public static void main(String[] args) {
        S07_BuildTree s07BuildTree = new S07_BuildTree();
        TreeNode node = s07BuildTree.buildTree(new int[]{3, 1, 2, 4}, new int[]{1, 2, 3, 4});
        System.out.println(node);
    }
}
