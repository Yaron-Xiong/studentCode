package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 * 已解答
 * 算术评级: 6
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * <p>
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，
 * 这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/next-greater-element-ii/description/?envType=daily-question&envId=2024-06-24">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class L503_NextGreaterElements {
    public static void main(String[] args) {
        L503_NextGreaterElements l503NextGreaterElements = new L503_NextGreaterElements();
        System.out.println(Arrays.toString(l503NextGreaterElements.nextGreaterElements(new int[]{1,2,1})));
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 0; i--) {
            while (!deque.isEmpty() && nums[i] >= deque.peekLast()) {
                deque.pollLast();
            }
            ans[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.addLast(nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!deque.isEmpty() && nums[i] >= deque.peekLast()) {
                deque.pollLast();
            }
            ans[i] = deque.isEmpty() ? -1 : deque.peekLast();
            deque.addLast(nums[i]);
        }
        return ans;
    }
}
