package com.accompnay.TopicAlgorithms.leetcode.l0;

/**
 * 24. 两两交换链表中的节点
 * 中等
 * 1.9K
 * 相关企业
 * 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 * 示例 2：
 * <p>
 * 输入：head = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：head = [1]
 * 输出：[1]
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数目在范围 [0, 100] 内
 * 0 <= Node.val <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/swap-nodes-in-pairs/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L24_SwapPairs {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        L24_SwapPairs l24SwapPairs = new L24_SwapPairs();
        System.out.println(l24SwapPairs.swapPairs(listNode));
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode dummyNode = dummy;
        while (dummyNode.next != null && dummyNode.next.next != null) {
            ListNode nodeB = dummyNode.next;
            ListNode nodeA = dummyNode.next.next;
            ListNode temp = dummyNode.next.next.next;
            nodeA.next = nodeB;
            nodeB.next = temp;
            dummyNode.next = nodeA;
            dummyNode = nodeB;
        }
        return dummy.next;
    }
}
