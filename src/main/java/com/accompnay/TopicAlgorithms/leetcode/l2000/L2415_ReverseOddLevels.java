package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 2415. 反转二叉树的奇数层
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵 完美 二叉树的根节点 root ，请你反转这棵树中每个 奇数 层的节点值。
 * <p>
 * 例如，假设第 3 层的节点值是 [2,1,3,4,7,11,29,18] ，那么反转后它应该变成 [18,29,11,7,4,3,1,2] 。
 * 反转后，返回树的根节点。
 * <p>
 * 完美 二叉树需满足：二叉树的所有父节点都有两个子节点，且所有叶子节点都在同一层。
 * <p>
 * 节点的 层数 等于该节点到根节点之间的边数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,3,5,8,13,21,34]
 * 输出：[2,5,3,8,13,21,34]
 * 解释：
 * 这棵树只有一个奇数层。
 * 在第 1 层的节点分别是 3、5 ，反转后为 5、3 。
 * 示例 2：
 * <p>
 * 输入：root = [7,13,11]
 * 输出：[7,11,13]
 * 解释：
 * 在第 1 层的节点分别是 13、11 ，反转后为 11、13 。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,2,0,0,0,0,1,1,1,1,2,2,2,2]
 * 输出：[0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
 * 解释：奇数层由非零值组成。
 * 在第 1 层的节点分别是 1、2 ，反转后为 2、1 。
 * 在第 3 层的节点分别是 1、1、1、1、2、2、2、2 ，反转后为 2、2、2、2、1、1、1、1 。
 * <p>
 * 提示：
 * <p>
 * 树中的节点数目在范围 [1, 214] 内
 * 0 <= Node.val <= 105
 * root 是一棵 完美 二叉树
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reverse-odd-levels-of-binary-tree/description/?envType=daily-question&envId=2023-12-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2415_ReverseOddLevels {

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
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        node.left = new TreeNode(3);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(8);
        node.left.right = new TreeNode(13);
        node.right.left = new TreeNode(21);
        node.right.right = new TreeNode(34);
        L2415_ReverseOddLevels l2415ReverseOddLevels = new L2415_ReverseOddLevels();
        TreeNode node1 = l2415ReverseOddLevels.reverseOddLevels(node);
        System.out.println(node1);

    }

    public TreeNode reverseOddLevels2(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        }
        dfs(root.left, root.right, 1);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, int level) {
        if (level % 2 != 0) {
            //left 与 right 交换值
            int temp = left.val;
            left.val = right.val;
            right.val = temp;
        }
        if (left.left != null) {
            dfs(left.left, right.right, level + 1);
            dfs(left.right, right.left, level + 1);
        }
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean isOdds = false;
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<TreeNode> list = new ArrayList<>();
            while (size > 0) {
                size--;
                TreeNode node = deque.pollFirst();
                if (isOdds) {
                    list.add(node);
                }
                if (node.left != null && node.right != null) {
                    deque.addLast(node.left);
                    deque.addLast(node.right);
                }
            }
            if (isOdds) {
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    TreeNode leftNode = list.get(left);
                    TreeNode rightNode = list.get(right);
                    int temp = leftNode.val;
                    leftNode.val = rightNode.val;
                    rightNode.val = temp;
                    left++;
                    right--;
                }
            }
            isOdds = !isOdds;
        }
        return root;
    }

}
