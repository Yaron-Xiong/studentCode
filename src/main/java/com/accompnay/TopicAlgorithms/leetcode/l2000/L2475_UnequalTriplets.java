package com.accompnay.TopicAlgorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2475. 数组中不等三元组的数目
 * 提示
 * 简单
 * 40
 * 相关企业
 * 给你一个下标从 0 开始的正整数数组 nums 。请你找出并统计满足下述条件的三元组 (i, j, k) 的数目：
 * <p>
 * 0 <= i < j < k < nums.length
 * nums[i]、nums[j] 和 nums[k] 两两不同 。
 * 换句话说：nums[i] != nums[j]、nums[i] != nums[k] 且 nums[j] != nums[k] 。
 * 返回满足上述条件三元组的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,2,4,3]
 * 输出：3
 * 解释：下面列出的三元组均满足题目条件：
 * - (0, 2, 4) 因为 4 != 2 != 3
 * - (1, 2, 4) 因为 4 != 2 != 3
 * - (2, 3, 4) 因为 2 != 4 != 3
 * 共计 3 个三元组，返回 3 。
 * 注意 (2, 0, 4) 不是有效的三元组，因为 2 > 0 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：0
 * 解释：不存在满足条件的三元组，所以返回 0 。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/number-of-unequal-triplets-in-array/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2475_UnequalTriplets {
    public static void main(String[] args) {
        L2475_UnequalTriplets l2475UnequalTriplets = new L2475_UnequalTriplets();
        System.out.println(l2475UnequalTriplets.unequalTriplets(new int[]{4, 4, 2, 4, 3}));
    }

    public int unequalTriplets(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0, j = 0; i < nums.length; i = j) {
            while (j < nums.length && nums[i] == nums[j]) {
                j++;
            }
            res += i * (j - i) * (nums.length - j);
        }
        return res;
    }
}
