package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.HashSet;
import java.util.Set;

/**
 * 2956. 找到两个数组中的公共元素
 * 算术评级: 2
 * 第 119 场双周赛
 * Q1
 * 1215
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们分别含有 n 和 m 个元素。
 * <p>
 * 请你计算以下两个数值：
 * <p>
 * 统计 0 <= i < n 中的下标 i ，满足 nums1[i] 在 nums2 中 至少 出现了一次。
 * 统计 0 <= i < m 中的下标 i ，满足 nums2[i] 在 nums1 中 至少 出现了一次。
 * 请你返回一个长度为 2 的整数数组 answer ，按顺序 分别为以上两个数值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,3,2,3,1], nums2 = [2,2,5,2,3,6]
 * 输出：[3,4]
 * 解释：分别计算两个数值：
 * - nums1 中下标为 1 ，2 和 3 的元素在 nums2 中至少出现了一次，所以第一个值为 3 。
 * - nums2 中下标为 0 ，1 ，3 和 4 的元素在 nums1 中至少出现了一次，所以第二个值为 4 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,4,2,3], nums2 = [1,5]
 * 输出：[0,0]
 * 解释：两个数组中没有公共元素，所以两个值都为 0 。
 * <p>
 * 提示：
 * <p>
 * n == nums1.length
 * m == nums2.length
 * 1 <= n, m <= 100
 * 1 <= nums1[i], nums2[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-common-elements-between-two-arrays/description/?envType=daily-question&envId=2024-07-16">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2956_FindIntersectionValues {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }

        int[] ans = new int[]{0, 0};
        for (int i : nums1) {
            if (set2.contains(i)) {
                ans[0]++;
            }
        }

        for (int i : nums2) {
            if (set1.contains(i)) {
                ans[1]++;
            }
        }

        return ans;
    }
}
