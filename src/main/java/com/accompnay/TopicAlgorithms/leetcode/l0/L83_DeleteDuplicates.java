package com.accompnay.TopicAlgorithms.leetcode.l0;

/**
 * 83. 删除排序链表中的重复元素
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 * 示例 2：
 * <p>
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 * <p>
 * 提示：
 * <p>
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/?envType=daily-question&envId=2024-01-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L83_DeleteDuplicates {
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

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }
}
