package com.yaronxiong.algorithms.leetcode.l0;

import java.util.*;

/**
 * 145. 二叉树的后序遍历
 * 简单
 * 相关标签
 * 相关企业
 * 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,null,2,3]
 * 输出：[3,2,1]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [0, 100] 内
 * -100 <= Node.val <= 100
 * <p>
 * 进阶：递归算法很简单，你可以通过迭代算法完成吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description/?envType=daily-question&envId=2024-02-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L145_PostorderTraversal {

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
        L145_PostorderTraversal l145PostorderTraversal = new L145_PostorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(l145PostorderTraversal.postorderTraversal(null));
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.pollFirst();
            ans.add(node.val);
            if (node.left != null) {
                deque.addFirst(node.left);
            }
            if (node.right != null) {
                deque.addFirst(node.right);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
