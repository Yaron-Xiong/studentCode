package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 2. 两数相加
 * 中等
 * 9.6K
 * 相关企业
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个链表中的节点数在范围 [1, 100] 内
 * 0 <= Node.val <= 9
 * 题目数据保证列表表示的数字不含前导零
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/add-two-numbers/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2_AddTwoNumbers {
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
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        L2_AddTwoNumbers l2AddTwoNumbers = new L2_AddTwoNumbers();
        System.out.println(l2AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l1CurNode = l1;
        ListNode l2CurNode = l2;
        ListNode resHeadNode = new ListNode(-1);
        ListNode resCurNode = resHeadNode;
        int carry = 0;
        while (l1CurNode != null || l2CurNode != null) {
            //resCurNode = l1node + l2node 如果大于10 则进位
            int l1Val = l1CurNode == null ? 0 : l1CurNode.val;
            int l2Val = l2CurNode == null ? 0 : l2CurNode.val;
            int nodeValue = l1Val + l2Val + carry;
            carry = 0;
            if (nodeValue >= 10) {
                nodeValue -= 10;
                carry = 1;
            }
            resCurNode.next = new ListNode(nodeValue);
            resCurNode = resCurNode.next;
            l1CurNode = l1CurNode == null ? null : l1CurNode.next;
            l2CurNode = l2CurNode == null ? null : l2CurNode.next;
        }
        if (carry == 1) {
            resCurNode.next = new ListNode(1);
        }
        return resHeadNode.next;
    }

}
