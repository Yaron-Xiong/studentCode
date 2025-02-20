package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.HashMap;
import java.util.Map;

/**
 * 3164. 优质数对的总数 II
 * 算术评级: 6
 * 第 399 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1777
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。
 * <p>
 * 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= m - 1）。
 * <p>
 * 返回 优质数对 的总数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 2个优质数对分别是 (3, 0) 和 (3, 1)。
 * <p>
 * 提示：
 * <p>
 * 1 <= n, m <= 105
 * 1 <= nums1[i], nums2[j] <= 106
 * 1 <= k <= 103
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-number-of-good-pairs-ii/description/?envType=daily-question&envId=2024-10-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3164_NumberOfPairs {
    public static void main(String[] args) {
        L3164_NumberOfPairs l3164NumberOfPairs = new L3164_NumberOfPairs();
        System.out.println(l3164NumberOfPairs.numberOfPairs(new int[]{1, 2, 4, 12}, new int[]{2, 4}, 3));
    }

    public long numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Integer> cnt1Map = new HashMap<>();
        int maxNums1Val = 0;
        for (int i : nums1) {
            maxNums1Val = Math.max(maxNums1Val, i);
            if (i % k != 0) {
                continue;
            }
            cnt1Map.merge(i / k, 1, Integer::sum);
        }
        Map<Integer, Integer> cnt2Map = new HashMap<>();
        for (int i : nums2) {
            cnt2Map.merge(i, 1, Integer::sum);
        }
        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : cnt2Map.entrySet()) {
            Integer x = entry.getKey();
            Integer cnt = entry.getValue();
            for (int i = x; i <= maxNums1Val; i += x) {
                if (cnt1Map.containsKey(i)) {
                    ans += (long) cnt * cnt1Map.get(i);
                }
            }
        }
        return ans;
    }
}
