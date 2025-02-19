package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Arrays;

/**
 * 1760. 袋子里最少数目的球
 * 算术评级: 5
 * 第 228 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1940
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，其中 nums[i] 表示第 i 个袋子里球的数目。同时给你一个整数 maxOperations 。
 * <p>
 * 你可以进行如下操作至多 maxOperations 次：
 * <p>
 * 选择任意一个袋子，并将袋子里的球分到 2 个新的袋子中，每个袋子里都有 正整数 个球。
 * 比方说，一个袋子里有 5 个球，你可以把它们分到两个新袋子里，分别有 1 个和 4 个球，或者分别有 2 个和 3 个球。
 * 你的开销是单个袋子里球数目的 最大值 ，你想要 最小化 开销。
 * <p>
 * 请你返回进行上述操作后的最小开销。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [9], maxOperations = 2
 * 输出：3
 * 解释：
 * - 将装有 9 个球的袋子分成装有 6 个和 3 个球的袋子。[9] -> [6,3] 。
 * - 将装有 6 个球的袋子分成装有 3 个和 3 个球的袋子。[6,3] -> [3,3,3] 。
 * 装有最多球的袋子里装有 3 个球，所以开销为 3 并返回 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,8,2], maxOperations = 4
 * 输出：2
 * 解释：
 * - 将装有 8 个球的袋子分成装有 4 个和 4 个球的袋子。[2,4,8,2] -> [2,4,4,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,4,4,4,2] -> [2,2,2,4,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,4,4,2] -> [2,2,2,2,2,4,2] 。
 * - 将装有 4 个球的袋子分成装有 2 个和 2 个球的袋子。[2,2,2,2,2,4,2] -> [2,2,2,2,2,2,2,2] 。
 * 装有最多球的袋子里装有 2 个球，所以开销为 2 并返回 2 。
 * 示例 3：
 * <p>
 * 输入：nums = [7,17], maxOperations = 2
 * 输出：7
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= maxOperations, nums[i] <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-limit-of-balls-in-a-bag/?envType=daily-question&envId=2025-02-12">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1760_MinimumSize {
    public static void main(String[] args) {
        L1760_MinimumSize l1760MinimumSize = new L1760_MinimumSize();
        System.out.println(l1760MinimumSize.minimumSize(new int[]{7, 17}, 2));
    }

    public int minimumSize(int[] nums, int maxOperations) {
        //最小化最大值（二分答案）
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 1;
        int right = max + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            //假设将所有元素都调整成 <= mid 需要操作多少次
            int tempOperations = 0;
            for (int num : nums) {
                if (num <= mid) {
                    continue;
                }
                tempOperations += (num - 1) / mid;
            }

            if (tempOperations <= maxOperations) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
