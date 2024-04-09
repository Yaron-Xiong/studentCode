package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 894. 所有可能的真二叉树
 * 第 99 场周赛
 * Q3
 * 1784
 * 相关标签
 * 相关企业
 * 给你一个整数 n ，请你找出所有可能含 n 个节点的 真二叉树 ，并以列表形式返回。答案中每棵树的每个节点都必须符合 Node.val == 0 。
 * <p>
 * 答案的每个元素都是一棵真二叉树的根节点。你可以按 任意顺序 返回最终的真二叉树列表。
 * <p>
 * 真二叉树 是一类二叉树，树中每个节点恰好有 0 或 2 个子节点。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7
 * 输出：[[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * 示例 2：
 * <p>
 * 输入：n = 3
 * 输出：[[0,0,0]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/all-possible-full-binary-trees/description/?envType=daily-question&envId=2024-04-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L894_AllPossibleFBT {


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

    public static void main(String[] args) {
        L894_AllPossibleFBT l894AllPossibleFBT = new L894_AllPossibleFBT();
        System.out.println(l894AllPossibleFBT.allPossibleFBT(7));
    }

    Map<Integer, List<TreeNode>> memo = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        List<TreeNode> ans = new ArrayList<>();
        if (n == 1) {
            ans.add(new TreeNode());
            memo.put(1, ans);
            return ans;
        }
        //此时将n拆分成 leftN 跟rightN
        n--;
        int leftN = 1;
        int rightN = n - leftN;
        while (rightN >= 1) {
            List<TreeNode> leftList = allPossibleFBT(leftN);
            List<TreeNode> rightList = allPossibleFBT(rightN);
            //这种情况下 为leftList 与 rightList的组合
            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode();
                    root.left = leftNode;
                    root.right = rightNode;
                    ans.add(root);
                }
            }
            leftN += 2;
            rightN -= 2;
        }
        memo.put(n, ans);
        return ans;
    }

}
