package com.accompnay.SwordFingerOffer;

import javax.swing.tree.TreeNode;
import java.util.Arrays;

/**
 * @author Accompany
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 */
public class Demo4 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,7,3,5,6,7};
        int [] in = {4,7,2,1,5,3,8,6};
        TreeNode node = reConstructBinaryTree(pre, in);
        System.out.println(node);
    }

    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre.length==0){
            return null;
        }
        //前序遍历第一个节点为根节点
        TreeNode node = new TreeNode(pre[0]);
        //根节点在中序遍历中位置
        int index = 0;
        for (int i = 0; i < in.length; i++) {
            if (in[i]==pre[0]){
                index = i;
            }
        }
        node.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,pre.length),Arrays.copyOfRange(in,0,index));
        node.right = reConstructBinaryTree(Arrays.copyOfRange(pre,1,pre.length),Arrays.copyOfRange(in,index+1,in.length));
        return node;
    }
}
