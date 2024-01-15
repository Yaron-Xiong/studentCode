package com.accompnay.TopicAlgorithms.leetcode.l0;

import lombok.Data;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 445. 两数相加 II
 * 中等
 * 618
 * 相关企业
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例1：
 * <p>
 * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
 * 输出：[7,8,0,7]
 * 示例2：
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[8,0,7]
 * 示例3：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 100]
 * 0 <= node.val <= 9
 * 输入数据保证链表代表的数字无前导 0
 * <p>
 * 进阶：如果输入链表不能翻转该如何解决？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/add-two-numbers-ii/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L445_AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);

        ListNode l2 = new ListNode(5);
        L445_AddTwoNumbers l445AddTwoNumbers = new L445_AddTwoNumbers();
        System.out.println(l445AddTwoNumbers.addTwoNumbers(l1, l2));
    }

    @Data
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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode ans = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int v1 = stack1.isEmpty() ? 0 : stack1.pop().val;
            int v2 = stack2.isEmpty() ? 0 : stack2.pop().val;
            int val = v1 + v2 + carry;
            carry = val / 10;
            val %= 10;
            ListNode listNode = new ListNode(val);
            listNode.next = ans;
            ans = listNode;
        }
        return ans;
    }
}
