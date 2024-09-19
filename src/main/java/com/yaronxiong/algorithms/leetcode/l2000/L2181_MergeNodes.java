package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2181. 合并零之间的节点
 * 算术评级: 3
 * 第 281 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1333
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个链表的头节点 head ，该链表包含由 0 分隔开的一连串整数。链表的 开端 和 末尾 的节点都满足 Node.val == 0 。
 * <p>
 * 对于每两个相邻的 0 ，请你将它们之间的所有节点合并成一个节点，其值是所有已合并节点的值之和。然后将所有 0 移除，修改后的链表不应该含有任何 0 。
 * <p>
 * 返回修改后链表的头节点 head 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [0,3,1,0,4,5,2,0]
 * 输出：[4,11]
 * 解释：
 * 上图表示输入的链表。修改后的链表包含：
 * - 标记为绿色的节点之和：3 + 1 = 4
 * - 标记为红色的节点之和：4 + 5 + 2 = 11
 * 示例 2：
 * <p>
 * 输入：head = [0,1,0,3,0,2,2,0]
 * 输出：[1,3,4]
 * 解释：
 * 上图表示输入的链表。修改后的链表包含：
 * - 标记为绿色的节点之和：1 = 1
 * - 标记为红色的节点之和：3 = 3
 * - 标记为黄色的节点之和：2 + 2 = 4
 * <p>
 * 提示：
 * <p>
 * 列表中的节点数目在范围 [3, 2 * 105] 内
 * 0 <= Node.val <= 1000
 * 不 存在连续两个 Node.val == 0 的节点
 * 链表的 开端 和 末尾 节点都满足 Node.val == 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/merge-nodes-in-between-zeros/description/?envType=daily-question&envId=2024-09-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2181_MergeNodes {
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
        int[] arr = {0, 3, 1, 0, 4, 5, 2, 0};
        ListNode head = new ListNode(0);
        ListNode curNode = head;
        for (int i = 1; i < arr.length; i++) {
            curNode.next = new ListNode(arr[i]);
            curNode = curNode.next;
        }
        L2181_MergeNodes l2181MergeNodes = new L2181_MergeNodes();
        System.out.println(l2181MergeNodes.mergeNodes(head));
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode tail = head;
        ListNode curNode = head.next;
        while (curNode.next != null) {
            if (curNode.val != 0) {
                tail.val += curNode.val;
            } else {
                tail.next = curNode;
                tail = tail.next;
            }
            curNode = curNode.next;
        }
        tail.next = null;
        return head;
    }

}
