package com.accompnay.TopicAlgorithms.leetcode.l0;

import lombok.ToString;

/**
 * 82. 删除排序链表中的重复元素 II
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/?envType=daily-question&envId=2024-01-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L82_DeleteDuplicates {
    @ToString
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
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(2);
        node.next.next.next.next = new ListNode(3);
        L82_DeleteDuplicates l82DeleteDuplicates = new L82_DeleteDuplicates();
        System.out.println(l82DeleteDuplicates.deleteDuplicates(node));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode curNode = dummy;
        while (curNode.next != null && curNode.next.next != null) {
            if (curNode.next.val == curNode.next.next.val) {
                int x = curNode.next.val;
                while (curNode.next != null && curNode.next.val == x) {
                    curNode.next = curNode.next.next;
                }
            } else {
                curNode = curNode.next;
            }
        }
        return dummy.next;
    }
}
