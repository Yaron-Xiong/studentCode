package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.*;

/**
 * 2176. 统计数组中相等且可以被整除的数对
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，请你返回满足 0 <= i < j < n ，
 * nums[i] == nums[j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,2,2,2,1,3], k = 2
 * 输出：4
 * 解释：
 * 总共有 4 对数符合所有要求：
 * - nums[0] == nums[6] 且 0 * 6 == 0 ，能被 2 整除。
 * - nums[2] == nums[3] 且 2 * 3 == 6 ，能被 2 整除。
 * - nums[2] == nums[4] 且 2 * 4 == 8 ，能被 2 整除。
 * - nums[3] == nums[4] 且 3 * 4 == 12 ，能被 2 整除。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4], k = 1
 * 输出：0
 * 解释：由于数组中没有重复数值，所以没有数对 (i,j) 符合所有要求。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i], k <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-equal-and-divisible-pairs-in-an-array/description/?envType=daily-question&envId=2025-04-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2176_CountPairs {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.computeIfAbsent(nums[i], a -> new ArrayList<>());
            for (Integer preIndex : list) {
                if ((preIndex * i) % k == 0) {
                    ans++;
                }
            }
            list.add(i);
        }
        return ans;
    }
}
