package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2605. 从两个数字数组里生成最小数字
 * 提示
 * 简单
 * 33
 * 相关企业
 * 给你两个只包含 1 到 9 之间数字的数组 nums1 和 nums2 ，每个数组中的元素 互不相同 ，请你返回 最小 的数字，两个数组都 至少 包含这个数字的某个数位。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,1,3], nums2 = [5,7]
 * 输出：15
 * 解释：数字 15 的数位 1 在 nums1 中出现，数位 5 在 nums2 中出现。15 是我们能得到的最小数字。
 * 示例 2：
 * <p>
 * 输入：nums1 = [3,5,2,6], nums2 = [3,1,7]
 * 输出：3
 * 解释：数字 3 的数位 3 在两个数组中都出现了。
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 9
 * 1 <= nums1[i], nums2[i] <= 9
 * 每个数组中，元素 互不相同 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/form-smallest-number-from-two-digit-arrays/?envType=daily-question&envId=2023-09-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2602_MinNumber {

    public int minNumber(int[] nums1, int[] nums2) {
        int value1 = 0;
        for (int item : nums1) {
            value1 = 1 << item | value1;
        }
        int value2 = 0;
        for (int item : nums2) {
            value2 = 1 << item | value2;
        }
        int i = value1 & value2;
        if (i != 0) {
            //说明有重叠部分
            return Integer.numberOfTrailingZeros(i);
        }
        int x = Integer.numberOfTrailingZeros(value1);
        int y = Integer.numberOfTrailingZeros(value2);
        return Math.min(x * 10 + y, y * 10 + x);
    }
}
