package com.yaronxiong.algorithms.swordFingerOffer.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 37. 序列化二叉树:https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * <p>
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * <p>
 * 你需要设计一个算法来实现二叉树的序列化与反序列化。
 * 这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示：输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。
 * 你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * 示例：
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/xu-lie-hua-er-cha-shu-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S37_Codec {
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
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.pollFirst();
                if (node == null) {
                    sb.append("null");
                } else {
                    sb.append(node.val);
                    deque.addLast(node.left);
                    deque.addLast(node.right);
                }
                sb.append(",");
                size--;
            }
        }
        return sb.deleteCharAt(sb.length() - 1).append(']').toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] split = data.substring(1, data.length() - 1).split(",");
        Deque<TreeNode> deque = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        deque.addLast(root);
        int i = 0;
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            String left = split[++i];
            String right = split[++i];
            if (!left.equals("null")) {
                node.left = new TreeNode(Integer.parseInt(left));
                deque.addLast(node.left);
            }
            if (!right.equals("null")) {
                node.right = new TreeNode(Integer.parseInt(right));
                deque.addLast(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.left.left = new TreeNode(3);
        treeNode.right.left.right = new TreeNode(1);

        S37_Codec s37Codec = new S37_Codec();
        String serialize = s37Codec.serialize(treeNode);
        System.out.println(serialize);
        System.out.println(s37Codec.deserialize(serialize));
    }
}
