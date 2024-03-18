package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1696. 跳跃游戏 VI
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i + k)] 包含 两个端点的任意位置。
 * <p>
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * <p>
 * 请你返回你能得到的 最大得分 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 * 示例 2：
 * <p>
 * 输入：nums = [10,-5,-2,4,0,3], k = 3
 * 输出：17
 * 解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, k <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/jump-game-vi/description/?envType=daily-question&envId=2024-02-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1696_MaxResult {
    public static void main(String[] args) {
        L1696_MaxResult l1696MaxResult = new L1696_MaxResult();
        System.out.println(l1696MaxResult.maxResult(new int[]{100,-1,-100,-1,100}, 2));
    }

    public int maxResult(int[] nums, int k) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        //维持k个窗口大小的队列
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        for (int i = 1; i < nums.length; i++) {
            //从[i-k,i) 选择一个最大的加上nums[i]
            while (!queue.isEmpty() && queue.peekFirst() < i - k) {
                queue.pollFirst();
            }
            dp[i] = nums[i] + dp[queue.peekFirst()];
            while (!queue.isEmpty() && dp[i] > dp[queue.peekLast()]) {
                queue.pollLast();
            }
            queue.addLast(i);
        }
        return dp[nums.length - 1];
    }

}
