package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 1261. 在受污染的二叉树中查找元素
 * 第 163 场周赛
 * Q2
 * 1440
 * 相关标签
 * 相关企业
 * 提示
 * 给出一个满足下述规则的二叉树：
 * <p>
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 * <p>
 * 请你先还原二叉树，然后实现 FindElements 类：
 * <p>
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["FindElements","find","find"]
 * [[[-1,null,-1]],[1],[2]]
 * 输出：
 * [null,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1]);
 * findElements.find(1); // return False
 * findElements.find(2); // return True
 * 示例 2：
 * <p>
 * 输入：
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * 输出：
 * [null,true,true,false]
 * 解释：
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 * 示例 3：
 * <p>
 * 输入：
 * ["FindElements","find","find","find","find"]
 * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
 * 输出：
 * [null,true,false,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
 * findElements.find(2); // return True
 * findElements.find(3); // return False
 * findElements.find(4); // return False
 * findElements.find(5); // return True
 * <p>
 * 提示：
 * <p>
 * TreeNode.val == -1
 * 二叉树的高度不超过 20
 * 节点的总数在 [1, 10^4] 之间
 * 调用 find() 的总次数在 [1, 10^4] 之间
 * 0 <= target <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/description/?envType=daily-question&envId=2024-03-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1261_FindElements {
    public class TreeNode {
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

    class FindElements {
        private Set<Integer> set;

        public FindElements(TreeNode root) {
            set = new HashSet<>();
            root.val = 0;
            dfs(root);
        }

        private void dfs(TreeNode node) {
            set.add(node.val);
            if (node.left != null) {
                node.left.val = node.val * 2 + 1;
                dfs(node.left);
            }
            if (node.right != null) {
                node.right.val = node.val * 2 + 2;
                dfs(node.right);
            }
        }

        public boolean find(int target) {
            return set.contains(target);
        }
    }


}
