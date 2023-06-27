package com.accompnay.TopicAlgorithms.leetcode.l1000;

/**
 * 1373. 二叉搜索子树的最大键值和
 * 提示
 * 困难
 * 173
 * 相关企业
 * 给你一棵以 root 为根的 二叉树 ，请你返回 任意 二叉搜索子树的最大键值和。
 * <p>
 * 二叉搜索树的定义如下：
 * <p>
 * 任意节点的左子树中的键值都 小于 此节点的键值。
 * 任意节点的右子树中的键值都 大于 此节点的键值。
 * 任意节点的左子树和右子树都是二叉搜索树。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
 * 输出：20
 * 解释：键值为 3 的子树是和最大的二叉搜索树。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,3,null,1,2]
 * 输出：2
 * 解释：键值为 2 的单节点子树是和最大的二叉搜索树。
 * 示例 3：
 * <p>
 * 输入：root = [-4,-2,-5]
 * 输出：0
 * 解释：所有节点键值都为负数，和最大的二叉搜索树为空。
 * 示例 4：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：6
 * 示例 5：
 * <p>
 * 输入：root = [5,4,8,3,null,6,3]
 * 输出：7
 * <p>
 * 提示：
 * <p>
 * 每棵树有 1 到 40000 个节点。
 * 每个节点的键值在 [-4 * 10^4 , 4 * 10^4] 之间。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-sum-bst-in-binary-tree/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1373_MaxSumBST {
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
        TreeNode treeNode = new TreeNode(1);
        treeNode.right = new TreeNode(10);
        treeNode.right.left = new TreeNode(-5);
        treeNode.right.right = new TreeNode(20);
        L1373_MaxSumBST l1373MaxSumBST = new L1373_MaxSumBST();
        System.out.println(l1373MaxSumBST.maxSumBST(treeNode));
    }

    int maxV = 0;

    public int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        isSearchTree(root);
        return maxV;
    }

    //是否二叉搜索、当前最小值、当前最大值、总和
    private int[] isSearchTree(TreeNode root) {
        int[] leftV = root.left == null ? new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0} : isSearchTree(root.left);
        int[] rightV = root.right == null ? new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0} : isSearchTree(root.right);
        if (leftV[0] == 1 && rightV[0] == 1 && root.val > leftV[2] && root.val < rightV[1]) {
            int leftMinV = root.left == null ? root.val : leftV[1];
            int rightMaxV = root.right == null ? root.val : rightV[2];
            int sum = root.val + leftV[3] + rightV[3];
            maxV = Math.max(sum, maxV);
            return new int[]{1, leftMinV, rightMaxV, sum};
        } else {
            //说明当前节点不是二叉搜索树
            return new int[]{0, 0, 0, 0};
        }
    }

}
