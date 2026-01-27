package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3507. 移除最小数对使数组有序 I
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个数组 nums，你可以执行以下操作任意次数：
 * <p>
 * 选择 相邻 元素对中 和最小 的一对。如果存在多个这样的对，选择最左边的一个。
 * 用它们的和替换这对元素。
 * 返回将数组变为 非递减 所需的 最小操作次数 。
 * <p>
 * 如果一个数组中每个元素都大于或等于它前一个元素（如果存在的话），则称该数组为非递减。
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [5,2,3,1]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 元素对 (3,1) 的和最小，为 4。替换后 nums = [5,2,4]。
 * 元素对 (2,4) 的和为 6。替换后 nums = [5,6]。
 * 数组 nums 在两次操作后变为非递减。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,2]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组 nums 已经是非递减的。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * -1000 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-pair-removal-to-sort-array-i/description/?envType=daily-question&envId=2026-01-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3507_MinimumPairRemoval {
    public static void main(String[] args) {
        L3507_MinimumPairRemoval l3507MinimumPairRemoval = new L3507_MinimumPairRemoval();
        System.out.println(l3507MinimumPairRemoval.minimumPairRemoval(new int[]{5, 2, 3, 1}));
        System.out.println(l3507MinimumPairRemoval.minimumPairRemoval(new int[]{1, 2, 2}));
    }

    public static class Node {
        int val;
        Node next;

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public int minimumPairRemoval(int[] nums) {
        Node head = new Node(-1, null);
        Node pre = head;
        for (int num : nums) {
            pre.next = new Node(num, null);
            pre = pre.next;
        }
        int cnt = 0;
        while (true) {
            Node node = head.next;
            Node minNode = node;
            boolean sort = true;
            while (node.next != null) {
                if (node.val + node.next.val < minNode.val + minNode.next.val) {
                    minNode = node;
                }
                if (node.val > node.next.val) {
                    sort = false;
                }
                node = node.next;
            }
            if (sort) {
                return cnt;
            }
            //移除掉minNode.next
            minNode.val = minNode.val + minNode.next.val;
            minNode.next = minNode.next.next;
            cnt++;
        }
    }
}
