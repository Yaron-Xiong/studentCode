package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 21. 合并两个有序链表
 * 简单
 * 3.2K
 * 相关企业
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 * 示例 2：
 * <p>
 * 输入：l1 = [], l2 = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 * <p>
 * 提示：
 * <p>
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/merge-two-sorted-lists/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L21_MergeTwoLists {
    public class ListNode {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode nullNode = new ListNode(Integer.MAX_VALUE);
        ListNode curNode = dummy;
        while (list1 != null || list2 != null) {
            ListNode node1 = list1 == null ? nullNode : list1;
            ListNode node2 = list2 == null ? nullNode : list2;
            if (node1.val > node2.val) {
                curNode.next = node2;
                list2 = list2.next;
            } else {
                curNode.next = node1;
                list1 = list1.next;
            }
            curNode = curNode.next;
        }
        return dummy.next;
    }
}
