package com.yaronxiong.algorithms.swordFingerOffer.linked;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 * 简单
 * 449
 * 相关企业
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/?envType=study-plan-v2&envId=coding-interviews">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S06_ReversePrint {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode curNode = head;
        while (curNode != null) {
            deque.push(curNode);
            curNode = curNode.next;
        }
        int[] res = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()) {
            ListNode pop = deque.pop();
            res[index++] = pop.val;
        }
        return res;
    }
}
