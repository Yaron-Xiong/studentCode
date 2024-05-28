package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 2656. K 个元素的最大和
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分：
 * <p>
 * 从 nums 中选择一个元素 m 。
 * 将选中的元素 m 从数组中删除。
 * 将新元素 m + 1 添加到数组中。
 * 你的得分增加 m 。
 * 请你返回执行以上操作恰好 k 次后的最大得分。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5], k = 3
 * 输出：18
 * 解释：我们需要从 nums 中恰好选择 3 个元素并最大化得分。
 * 第一次选择 5 。和为 5 ，nums = [1,2,3,4,6] 。
 * 第二次选择 6 。和为 6 ，nums = [1,2,3,4,7] 。
 * 第三次选择 7 。和为 5 + 6 + 7 = 18 ，nums = [1,2,3,4,8] 。
 * 所以我们返回 18 。
 * 18 是可以得到的最大答案。
 * 示例 2：
 * <p>
 * 输入：nums = [5,5,5], k = 2
 * 输出：11
 * 解释：我们需要从 nums 中恰好选择 2 个元素并最大化得分。
 * 第一次选择 5 。和为 5 ，nums = [5,5,6] 。
 * 第二次选择 6 。和为 6 ，nums = [5,5,7] 。
 * 所以我们返回 11 。
 * 11 是可以得到的最大答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-sum-with-exactly-k-elements/description/?envType=daily-question&envId=2023-11-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2656_MaximizeSum {
    public static void main(String[] args) {
        L2656_MaximizeSum l2656MaximizeSum = new L2656_MaximizeSum();
        System.out.println(l2656MaximizeSum.maximizeSum(new int[]{1, 2, 3, 4, 5}, 3));
    }

    public int maximizeSum(int[] nums, int k) {
        int maxV = Arrays.stream(nums).max().getAsInt();
        return (maxV * k) + (k * (k - 1)) / 2;
    }
}
