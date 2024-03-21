package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1793. 好子数组的最大分数
 * 第 232 场周赛
 * Q4
 * 1946
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums （下标从 0 开始）和一个整数 k 。
 * <p>
 * 一个子数组 (i, j) 的 分数 定义为 min(nums[i], nums[i+1], ..., nums[j]) * (j - i + 1) 。一个 好 子数组的两个端点下标需要满足 i <= k <= j 。
 * <p>
 * 请你返回 好 子数组的最大可能 分数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,4,3,7,4,5], k = 3
 * 输出：15
 * 解释：最优子数组的左右端点下标是 (1, 5) ，分数为 min(4,3,7,4,5) * (5-1+1) = 3 * 5 = 15 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,5,4,5,4,1,1,1], k = 0
 * 输出：20
 * 解释：最优子数组的左右端点下标是 (0, 4) ，分数为 min(5,5,4,5,4) * (4-0+1) = 4 * 5 = 20 。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 2 * 104
 * 0 <= k < nums.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-score-of-a-good-subarray/description/?envType=daily-question&envId=2024-03-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1793_MaximumScore {
    public static void main(String[] args) {
        L1793_MaximumScore l1793MaximumScore = new L1793_MaximumScore();
        System.out.println(l1793MaximumScore.maximumScore2(new int[]{5, 5, 4, 5, 4, 1, 1, 1}, 0));
    }

    public int maximumScore2(int[] nums, int k) {
        int left = k;
        int right = k;
        int ans = nums[k];
        int minValue = nums[k];
        while (true) {
            if (left - 1 < 0 && right + 1 >= nums.length) {
                break;
            }
            //什么时候向左边走
            if (right + 1 >= nums.length || (left-1>=0 && nums[left - 1] > nums[right + 1])) {
                left--;
                minValue = Math.min(minValue, nums[left]);
            } else {
                right++;
                minValue = Math.min(minValue, nums[right]);
            }
            ans = Math.max(ans, minValue * (right - left + 1));
        }
        return ans;
    }

    public int maximumScore(int[] nums, int k) {
        int[] left = new int[nums.length];
        Deque<int[]> deque = new LinkedList<>();
        deque.addFirst(new int[]{0, nums[0]});
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            while (!deque.isEmpty() && nums[i] <= deque.peekFirst()[1]) {
                index = deque.pollFirst()[0];
            }
            deque.addFirst(new int[]{index, nums[i]});
            //此时deque的队列第一个 就是小于 nums[i] 元素
            left[i] = deque.isEmpty() ? 0 : deque.peekFirst()[0];
        }
        deque.clear();
        int[] right = new int[nums.length];
        deque.addFirst(new int[]{nums.length - 1, nums[nums.length - 1]});
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = i;
            while (!deque.isEmpty() && nums[i] <= deque.peekFirst()[1]) {
                index = deque.pollFirst()[0];
            }
            deque.addFirst(new int[]{index, nums[i]});
            right[i] = deque.isEmpty() ? nums.length - 1 : deque.peekFirst()[0];
        }
        //对比left && right 找到最大值
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int leftIndex = left[i];
            int rightIndex = right[i];
            //条件需要leftIndex->rightIndex 需要横穿 k
            if (leftIndex > k || rightIndex < k) {
                continue;
            }
            ans = Math.max(ans, nums[i] * (rightIndex - leftIndex + 1));
        }
        return ans;
    }
}
