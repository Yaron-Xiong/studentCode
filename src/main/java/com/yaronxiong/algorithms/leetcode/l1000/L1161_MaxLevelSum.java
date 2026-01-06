package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1161. 最大层内元素和
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 返回总和 最大 的那一层的层号 x。如果有多层的总和一样大，返回其中 最小 的层号 x。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 104]范围内
 * -105 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/description/?envType=daily-question&envId=2026-01-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1161_MaxLevelSum {
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
        L1161_MaxLevelSum l1161MaxLevelSum = new L1161_MaxLevelSum();
        TreeNode root = new TreeNode(1, new TreeNode(7, new TreeNode(7), new TreeNode(-8)), new TreeNode(0));
        System.out.println(l1161MaxLevelSum.maxLevelSum(root));
    }

    public int maxLevelSum(TreeNode root) {
        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        int maxLevelSumValue = Integer.MIN_VALUE;
        int ansLevel = 0;
        int curLevel = 0;
        while (!dq.isEmpty()) {
            curLevel++;
            int size = dq.size();
            int levelSum = 0;
            while (size > 0) {
                size--;
                TreeNode node = dq.pollFirst();
                levelSum += node.val;
                if (node.left != null) {
                    dq.addLast(node.left);
                }
                if (node.right != null) {
                    dq.addLast(node.right);
                }
            }

            if (levelSum > maxLevelSumValue) {
                maxLevelSumValue = levelSum;
                ansLevel = curLevel;
            }
        }
        return ansLevel;
    }
}
