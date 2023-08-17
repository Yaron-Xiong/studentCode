package com.accompnay.TopicAlgorithms.swordFingerOffer.tree;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * <p>
 * 例如:
 * 给定二叉树:[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S32_LevelOrder_III {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        boolean isOrder = true;
        while (!queue.isEmpty()) {
            Deque<Integer> temp = new LinkedList<>();
            int size = queue.size();
            while (size > 0) {
                size--;
                TreeNode poll = queue.pollFirst();
                if (isOrder) {
                    temp.addLast(poll.val);
                } else {
                    temp.addFirst(poll.val);
                }
                if (poll.left != null) {
                    queue.addLast(poll.left);
                }
                if (poll.right != null) {
                    queue.addLast(poll.right);
                }
            }
            isOrder = !isOrder;
            res.add(new LinkedList<>(temp));
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        //treeNode.left.left = new TreeNode(4);
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        S32_LevelOrder_III levelOrder_ii = new S32_LevelOrder_III();
        List<List<Integer>> lists = levelOrder_ii.levelOrder(treeNode);
        System.out.println(lists);
    }
}
