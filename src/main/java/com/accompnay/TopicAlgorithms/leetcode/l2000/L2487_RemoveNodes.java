package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 2487. 从链表中移除节点
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个链表的头节点 head 。
 * <p>
 * 移除每个右侧有一个更大数值的节点。
 * <p>
 * 返回修改后链表的头节点 head 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [5,2,13,3,8]
 * 输出：[13,8]
 * 解释：需要移除的节点是 5 ，2 和 3 。
 * - 节点 13 在节点 5 右侧。
 * - 节点 13 在节点 2 右侧。
 * - 节点 8 在节点 3 右侧。
 * 示例 2：
 * <p>
 * 输入：head = [1,1,1,1]
 * 输出：[1,1,1,1]
 * 解释：每个节点的值都是 1 ，所以没有需要移除的节点。
 * <p>
 * 提示：
 * <p>
 * 给定列表中的节点数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/remove-nodes-from-linked-list/?envType=daily-question&envId=2024-01-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2487_RemoveNodes {
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

    public ListNode removeNodes2(ListNode head) {
        if (head.next == null) {
            return head;
        }
        ListNode listNode = removeNodes2(head.next);
        if (head.val < listNode.val) {
            return listNode;
        }
        head.next = listNode;
        return head;
    }

    public ListNode removeNodes(ListNode head) {
        ListNode demon = new ListNode(-1);
        demon.next = head;
        Deque<ListNode[]> deque = new LinkedList<>();
        ListNode cur = head;
        ListNode pre = demon;
        while (cur != null) {
            while (!deque.isEmpty() && cur.val > deque.peekFirst()[1].val) {
                ListNode[] listNodes = deque.pollFirst();
                listNodes[0].next = cur;
                listNodes[1].next = null;
                pre = listNodes[0];
            }
            deque.addFirst(new ListNode[]{pre, cur});
            pre = cur;
            cur = cur.next;
        }
        return demon.next;
    }
}
