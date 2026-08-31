package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2058. 找出临界点之间的最小和最大距离
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 链表中的 临界点 定义为一个 局部极大值点 或 局部极小值点 。
 * <p>
 * 如果当前节点的值 严格大于 前一个节点和后一个节点，那么这个节点就是一个  局部极大值点 。
 * <p>
 * 如果当前节点的值 严格小于 前一个节点和后一个节点，那么这个节点就是一个  局部极小值点 。
 * <p>
 * 注意：节点只有在同时存在前一个节点和后一个节点的情况下，才能成为一个 局部极大值点 / 极小值点 。
 * <p>
 * 给你一个链表 head ，返回一个长度为 2 的数组 [minDistance, maxDistance] ，
 * 其中 minDistance 是任意两个不同临界点之间的最小距离，maxDistance 是任意两个不同临界点之间的最大距离。如果临界点少于两个，则返回 [-1，-1] 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,1]
 * 输出：[-1,-1]
 * 解释：链表 [3,1] 中不存在临界点。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [5,3,1,2,5,1,2]
 * 输出：[1,3]
 * 解释：存在三个临界点：
 * - [5,3,1,2,5,1,2]：第三个节点是一个局部极小值点，因为 1 比 3 和 2 小。
 * - [5,3,1,2,5,1,2]：第五个节点是一个局部极大值点，因为 5 比 2 和 1 大。
 * - [5,3,1,2,5,1,2]：第六个节点是一个局部极小值点，因为 1 比 5 和 2 小。
 * 第五个节点和第六个节点之间距离最小。minDistance = 6 - 5 = 1 。
 * 第三个节点和第六个节点之间距离最大。maxDistance = 6 - 3 = 3 。
 * 示例 3：
 * <p>
 * 输入：head = [1,3,2,2,3,2,2,2,7]
 * 输出：[3,3]
 * 解释：存在两个临界点：
 * - [1,3,2,2,3,2,2,2,7]：第二个节点是一个局部极大值点，因为 3 比 1 和 2 大。
 * - [1,3,2,2,3,2,2,2,7]：第五个节点是一个局部极大值点，因为 3 比 2 和 2 大。
 * 最小和最大距离都存在于第二个节点和第五个节点之间。
 * 因此，minDistance 和 maxDistance 是 5 - 2 = 3 。
 * 注意，最后一个节点不算一个局部极大值点，因为它之后就没有节点了。
 * 示例 4：
 * <p>
 * 输入：head = [2,3,3,2]
 * 输出：[-1,-1]
 * 解释：链表 [2,3,3,2] 中不存在临界点。
 * <p>
 * 提示：
 * <p>
 * 链表中节点的数量在范围 [2, 105] 内
 * 1 <= Node.val <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/?envType=daily-question&envId=2026-08-31">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2058_NodesBetweenCriticalPoints {
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
        ListNode node = new ListNode(6);
        node.next = new ListNode(8);
        node.next.next = new ListNode(4);
        node.next.next.next = new ListNode(1);
        node.next.next.next.next = new ListNode(9);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next.next = new ListNode(10);
        node.next.next.next.next.next.next.next.next = new ListNode(6);
        L2058_NodesBetweenCriticalPoints l2058NodesBetweenCriticalPoints = new L2058_NodesBetweenCriticalPoints();
        int[] ints = l2058NodesBetweenCriticalPoints.nodesBetweenCriticalPoints(node);
        System.out.println(Arrays.toString(ints));
    }

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] ans = new int[2];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ListNode cur = head.next;
        ListNode pre = head;
        int minIndex = -1;
        int lastIndex = -1;
        int index = 1;
        while (cur != null && cur.next != null) {
            boolean a = cur.val > pre.val && cur.val > cur.next.val;
            boolean b = cur.val < pre.val && cur.val < cur.next.val;
            if (a || b) {
                //命中
                if (minIndex == -1) {
                    minIndex = index;
                    lastIndex = index;
                } else {
                    ans[0] = Math.min(index - lastIndex, ans[0]);
                    ans[1] = index - minIndex;
                    minIndex = Math.min(minIndex, index);
                    lastIndex = Math.max(lastIndex, index);
                }
            }
            index++;
            pre = cur;
            cur = cur.next;
        }
        if (ans[0] == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }
        return ans;
    }
}
