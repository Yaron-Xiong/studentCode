package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 865. 具有所有最深节点的最小子树
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 * <p>
 * 返回包含原始树中所有 最深节点 的 最小子树 。
 * <p>
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 * <p>
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * 我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。
 * 提示：
 * <p>
 * 树中节点的数量在 [1, 500] 范围内。
 * 0 <= Node.val <= 500
 * 每个节点的值都是 独一无二 的。
 * <p>
 * <p>
 * 注意：本题与力扣 1123 重复：<a href="https://leetcode.cn/problems/lowest-common-ancestor-of-deepest-leaves">...</a>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/smallest-subtree-with-all-the-deepest-nodes/description/?envType=daily-question&envId=2026-01-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L865_SubtreeWithAllDeepest {
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
        L865_SubtreeWithAllDeepest l865SubtreeWithAllDeepest = new L865_SubtreeWithAllDeepest();
        TreeNode node = new TreeNode(3);
        node.left = new TreeNode(5);
        node.right = new TreeNode(1);
        node.left.left = new TreeNode(6);
        node.left.right = new TreeNode(2);
        node.right.left = new TreeNode(0);
        node.right.right = new TreeNode(8);
        node.left.right.left = new TreeNode(7);
        node.left.right.right = new TreeNode(4);
        TreeNode node1 = l865SubtreeWithAllDeepest.subtreeWithAllDeepest(node);
        System.out.println(node1);
    }

    TreeNode ans;
    int maxLevel;

    public int dfs2(TreeNode root, int level) {
        if (root == null) {
            maxLevel = Math.max(maxLevel, level);
            return level;
        }
        int left = dfs2(root.left, level + 1);
        int right = dfs2(root.right, level + 1);
        if (left == right && left == maxLevel) {
            ans = root;
        }
        return Math.max(left, right);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        dfs2(root, 0);
        return ans;
    }
}
