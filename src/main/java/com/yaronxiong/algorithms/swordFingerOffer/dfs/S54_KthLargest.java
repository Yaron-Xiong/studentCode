package com.yaronxiong.algorithms.swordFingerOffer.dfs;

/**
 * 剑指 Offer 54. 二叉搜索树的第k大节点
 * <p>
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * 限制：
 * <p>
 * 1 ≤ k ≤ 二叉搜索树元素个数
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S54_KthLargest {
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
                    '}';
        }
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(1);
        node.left.right = new TreeNode(2);
        node.right = new TreeNode(4);
        S54_KthLargest s54KthLargest = new S54_KthLargest();
        int i = s54KthLargest.kthLargest(node, 1);
        System.out.println(i);
    }

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }

    int k;
    Integer res = null;

    private void dfs(TreeNode root) {
        if (root == null || res != null) {
            return;
        }
        dfs(root.right);
        if (--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }
}
