package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3131. 找出与数组相加的整数 I
 * 已解答
 * 算术评级: 2
 * 第 395 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1161
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个长度相等的数组 nums1 和 nums2。
 * <p>
 * 数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 * <p>
 * 在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 * <p>
 * 返回整数 x 。
 * <p>
 * 示例 1:
 * <p>
 * 输入：nums1 = [2,6,4], nums2 = [9,7,5]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 与 3 相加后，nums1 和 nums2 相等。
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums1 = [10], nums2 = [5]
 * <p>
 * 输出：-5
 * <p>
 * 解释：
 * <p>
 * 与 -5 相加后，nums1 和 nums2 相等。
 * <p>
 * 示例 3:
 * <p>
 * 输入：nums1 = [1,1,1,1], nums2 = [1,1,1,1]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 与 0 相加后，nums1 和 nums2 相等。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length == nums2.length <= 100
 * 0 <= nums1[i], nums2[i] <= 1000
 * 测试用例以这样的方式生成：存在一个整数 x，使得 nums1 中的每个元素都与 x 相加后，nums1 与 nums2 相等。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-integer-added-to-array-i/description/?envType=daily-question&envId=2024-08-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3131_AddedInteger {
    public int addedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        return nums2[0] - nums1[0];
    }
}
