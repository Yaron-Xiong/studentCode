package com.accompnay.swordFingerOffer;


import java.util.ArrayList;

/**
 * @author Accompany
 * Date:2019/12/31
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 *
 * 解决思路1：用递归天然从后往前思想
 *
 * 解决思路2：用list数组不断将节点加入list(0,node)保持倒序
 *
 * 解决思路3：手动压栈
 */
public class Demo3 {
    public static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(5);
        node.next = new ListNode(4);
        node.next.next = new ListNode(3);
        ArrayList<Integer> list =printListFromTailToHead(node);
        System.out.println(list);
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode!=null){
            list.add(0,listNode.val);
            listNode = listNode.next;
        }
        return list;
    }
    /*
    解决思路1
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        addNode(list,listNode);
        return list;
    }
    private static void addNode(ArrayList<Integer> list,ListNode listNode){
        if (listNode==null){
            //表示最后一个节点
             return;
        }
        addNode(list,listNode.next);
        list.add(listNode.val);
    }*/

}
