package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 3542. 将所有元素变为 0 的最少操作次数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个大小为 n 的 非负 整数数组 nums 。你的任务是对该数组执行若干次（可能为 0 次）操作，使得 所有 元素都变为 0。
 * <p>
 * 在一次操作中，你可以选择一个子数组 [i, j]（其中 0 <= i <= j < n），将该子数组中所有 最小的非负整数 的设为 0。
 * <p>
 * 返回使整个数组变为 0 所需的最少操作次数。
 * <p>
 * 一个 子数组 是数组中的一段连续元素。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: nums = [0,2]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * <p>
 * 选择子数组 [1,1]（即 [2]），其中最小的非负整数是 2。将所有 2 设为 0，结果为 [0,0]。
 * 因此，所需的最少操作次数为 1。
 * 示例 2：
 * <p>
 * 输入: nums = [3,1,2,1]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * <p>
 * 选择子数组 [1,3]（即 [1,2,1]），最小非负整数是 1。将所有 1 设为 0，结果为 [3,0,2,0]。
 * 选择子数组 [2,2]（即 [2]），将 2 设为 0，结果为 [3,0,0,0]。
 * 选择子数组 [0,0]（即 [3]），将 3 设为 0，结果为 [0,0,0,0]。
 * 因此，最少操作次数为 3。
 * 示例 3：
 * <p>
 * 输入: nums = [1,2,1,2,1,2]
 * <p>
 * 输出: 4
 * <p>
 * 解释:
 * <p>
 * 选择子数组 [0,5]（即 [1,2,1,2,1,2]），最小非负整数是 1。将所有 1 设为 0，结果为 [0,2,0,2,0,2]。
 * 选择子数组 [1,1]（即 [2]），将 2 设为 0，结果为 [0,0,0,2,0,2]。
 * 选择子数组 [3,3]（即 [2]），将 2 设为 0，结果为 [0,0,0,0,0,2]。
 * 选择子数组 [5,5]（即 [2]），将 2 设为 0，结果为 [0,0,0,0,0,0]。
 * 因此，最少操作次数为 4。
 * <p>
 * 提示:
 * <p>
 * 1 <= n == nums.length <= 105
 * 0 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-operations-to-convert-all-elements-to-zero/description/?envType=daily-question&envId=2025-11-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3542_MinOperations {
    public static void main(String[] args) {
        L3542_MinOperations l3542MinOperations = new L3542_MinOperations();
        System.out.println(l3542MinOperations.minOperations(new int[]{0,2}));
        System.out.println(l3542MinOperations.minOperations(new int[]{3,1,2,1}));
        System.out.println(l3542MinOperations.minOperations(new int[]{1,2,1,2,1,2}));
    }
    public int minOperations(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int ans = 0;
        for (int num : nums) {
            //如果top比num大，说明top会产生孤岛，需要del
            while (!stack.isEmpty() && stack.peekLast() > num) {
                stack.pollLast();
                ans++;
            }
            //相等的话 等后面在处理
            if (num == 0 || !stack.isEmpty() && stack.peekLast() == num) {
                continue;
            }
            stack.addLast(num);
        }
        return ans + stack.size();
    }
}
