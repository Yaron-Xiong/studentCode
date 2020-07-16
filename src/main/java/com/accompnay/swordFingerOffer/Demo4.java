package com.accompnay.swordFingerOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Accompany
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}
 * 和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * 不是特别懂
 */
public class Demo4 {
    int [] pre;
    int preIndex ;
    Map<Integer,Integer> map = new HashMap<>();
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode helper(int l,int r){
        if (l==r){
            return null ;
        }
        //前序遍历到的位置
        int val = pre[preIndex];
        preIndex++;
        TreeNode node = new TreeNode(val);
        //根节点在中序遍历的位置
        Integer inIndex = map.get(val);
        node.left = helper(l,inIndex);
        node.right = helper(inIndex+1,r);
        return node;
    }

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if (pre.length<=0){
            return null;
        }
        this.pre = pre;
        int index = 0;
        for (int i : in) {
            map.put(i,index++);
        }
        return helper(0,in.length);
    }

    public static void main(String[] args) {
        int [] pre = {3,9,20,15,7};
        int [] in = {9,3,15,20,7};
        Demo4 demo4 = new Demo4();
        TreeNode node = demo4.reConstructBinaryTree(pre, in);
        System.out.println(node);
    }

}
