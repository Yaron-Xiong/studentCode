package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.*;

/**
 * 2454. 下一个更大元素 IV
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的非负整数数组 nums 。对于 nums 中每一个整数，你必须找到对应元素的 第二大 整数。
 * <p>
 * 如果 nums[j] 满足以下条件，那么我们称它为 nums[i] 的 第二大 整数：
 * <p>
 * j > i
 * nums[j] > nums[i]
 * 恰好存在 一个 k 满足 i < k < j 且 nums[k] > nums[i] 。
 * 如果不存在 nums[j] ，那么第二大整数为 -1 。
 * <p>
 * 比方说，数组 [1, 2, 4, 3] 中，1 的第二大整数是 4 ，2 的第二大整数是 3 ，3 和 4 的第二大整数是 -1 。
 * 请你返回一个整数数组 answer ，其中 answer[i]是 nums[i] 的第二大整数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,4,0,9,6]
 * 输出：[9,6,6,-1,-1]
 * 解释：
 * 下标为 0 处：2 的右边，4 是大于 2 的第一个整数，9 是第二个大于 2 的整数。
 * 下标为 1 处：4 的右边，9 是大于 4 的第一个整数，6 是第二个大于 4 的整数。
 * 下标为 2 处：0 的右边，9 是大于 0 的第一个整数，6 是第二个大于 0 的整数。
 * 下标为 3 处：右边不存在大于 9 的整数，所以第二大整数为 -1 。
 * 下标为 4 处：右边不存在大于 6 的整数，所以第二大整数为 -1 。
 * 所以我们返回 [9,6,6,-1,-1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,3]
 * 输出：[-1,-1]
 * 解释：
 * 由于每个数右边都没有更大的数，所以我们返回 [-1,-1] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/next-greater-element-iv/description/?envType=daily-question&envId=2023-12-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2454_SecondGreaterElement {
    public static void main(String[] args) {
        L2454_SecondGreaterElement l2454SecondGreaterElement = new L2454_SecondGreaterElement();
        System.out.println(Arrays.toString(l2454SecondGreaterElement.secondGreaterElement(new int[]{11, 13, 15, 12, 0, 15, 12, 11, 9})));
    }

    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> s = new ArrayDeque<>();
        Deque<Integer> t = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (!t.isEmpty() && x > nums[t.peekFirst()]) {
                Integer remove = t.pollFirst();
                ans[remove] = x;
            }
            Deque<Integer> temp = new ArrayDeque<>();
            while (!s.isEmpty() && x > nums[s.peekFirst()]) {
                Integer remove = s.pollFirst();
                temp.addFirst(remove);
            }
            while (!temp.isEmpty()) {
                Integer remove = temp.pollFirst();
                t.addFirst(remove);
            }
            s.addFirst(i);
        }
        return ans;
    }
}
