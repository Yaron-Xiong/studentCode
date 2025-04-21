package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashMap;
import java.util.Map;

/**
 * 2537. 统计好子数组的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 * <p>
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 * <p>
 * 子数组 是原数组中一段连续 非空 的元素序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], k = 10
 * 输出：1
 * 解释：唯一的好子数组是这个数组本身。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,3,2,2,4], k = 2
 * 输出：4
 * 解释：总共有 4 个不同的好子数组：
 * - [3,1,4,3,2,2] 有 2 对。
 * - [3,1,4,3,2,2,4] 有 3 对。
 * - [1,4,3,2,2,4] 有 2 对。
 * - [4,3,2,2,4] 有 2 对。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i], k <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-the-number-of-good-subarrays/description/?envType=daily-question&envId=2025-04-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2537_CountGood {
    public static void main(String[] args) {
        L2537_CountGood l2537CountGood = new L2537_CountGood();
        System.out.println(l2537CountGood.countGood(new int[]{3, 1, 4, 3, 2, 2, 4}, 2));
        System.out.println(l2537CountGood.countGood(new int[]{1,1,1,1,1}, 10));
    }

    public long countGood(int[] nums, int k) {
        long sumSubArr = 0;
        long calSubArr = 0;
        int left = 0;
        long cntCouple = 0;
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sumSubArr += i + 1;
            int merge = cntMap.merge(nums[i], 1, Integer::sum);
            cntCouple += merge - 1;
            while (cntCouple >= k && left < i) {
                merge = cntMap.merge(nums[left], -1, Integer::sum);
                cntCouple -= merge;
                left++;
            }
            //这时候 (left,i] 都是不满足的
            calSubArr += i + 1 - left;
        }
        return sumSubArr - calSubArr;
    }
}
