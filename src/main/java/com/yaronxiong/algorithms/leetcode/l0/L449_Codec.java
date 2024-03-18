package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 449. 序列化和反序列化二叉搜索树
 * 中等
 * 448
 * 相关企业
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。
 * 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 提示：
 * <p>
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/serialize-and-deserialize-bst/?envType=daily-question&envId=2023-09-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L449_Codec {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.pollFirst();
                if (node == null) {
                    sb.append("#");
                } else {
                    sb.append(node.val);
                    deque.addLast(node.left);
                    deque.addLast(node.right);
                }
                sb.append(",");
                size--;
            }
        }
        return sb.deleteCharAt(sb.length() - 1).append("]").toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode head = new TreeNode(Integer.parseInt(nodes[0]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(head);
        int i = 0;
        while (!deque.isEmpty()) {
            TreeNode root = deque.pollFirst();
            String left = nodes[++i];
            String right = nodes[++i];
            if (!left.equals("#")) {
                root.left = new TreeNode(Integer.parseInt(left));
                deque.addLast(root.left);
            }
            if (!right.equals("#")) {
                root.right = new TreeNode(Integer.parseInt(right));
                deque.addLast(root.right);
            }
        }
        return head;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(5);
        treeNode.left = new TreeNode(3);
        treeNode.right = new TreeNode(6);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(4);
        treeNode.left.left.left = new TreeNode(1);
        L449_Codec l449Codec = new L449_Codec();
        String serialize = l449Codec.serialize(treeNode);
        System.out.println(serialize);
        l449Codec.deserialize(serialize);
    }
}
