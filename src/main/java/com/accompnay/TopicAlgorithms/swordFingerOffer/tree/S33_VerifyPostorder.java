package com.accompnay.TopicAlgorithms.swordFingerOffer.tree;

/**
 * 剑指 Offer 33. 二叉搜索树的后序遍历序列
 * <p>
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回true，否则返回false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 提示：
 * <p>
 * 数组长度 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S33_VerifyPostorder {

    public boolean verifyPostorder(int[] postorder) {
        return dfs(postorder, 0, postorder.length - 1);
    }

    private boolean dfs(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int mid = left;
        //比父亲节点小的节点都是左节点
        int root = postorder[right];
        while (mid < right && postorder[mid] < root) {
            mid++;
        }

        //比父亲节点大的节点都是右节点
        int q = mid;
        while (q < right) {
            if (postorder[q++] < root) {
                return false;
            }
        }
        return dfs(postorder, left, mid - 1) && dfs(postorder, mid, right - 1);
    }

    public static void main(String[] args) {
        S33_VerifyPostorder s33VerifyPostorder = new S33_VerifyPostorder();
        boolean b = s33VerifyPostorder.verifyPostorder(new int[]{5, 4, 3, 2, 1});
        System.out.println(b);
    }
}
