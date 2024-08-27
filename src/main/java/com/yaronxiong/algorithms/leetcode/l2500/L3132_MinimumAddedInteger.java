package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;

/**
 * 3132. 找出与数组相加的整数 II
 * 已解答
 * 算术评级: 3
 * 第 395 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1620
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数数组 nums1 和 nums2。
 * <p>
 * 从 nums1 中移除两个元素，并且所有其他元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。
 * <p>
 * 执行上述操作后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。
 * <p>
 * 返回能够实现数组相等的 最小 整数 x 。
 * <p>
 * 示例 1:
 * <p>
 * 输入：nums1 = [4,20,16,12,8], nums2 = [14,18,10]
 * <p>
 * 输出：-2
 * <p>
 * 解释：
 * <p>
 * 移除 nums1 中下标为 [0,4] 的两个元素，并且每个元素与 -2 相加后，nums1 变为 [18,14,10] ，与 nums2 相等。
 * <p>
 * 示例 2:
 * <p>
 * 输入：nums1 = [3,5,5,3], nums2 = [7,7]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 移除 nums1 中下标为 [0,3] 的两个元素，并且每个元素与 2 相加后，nums1 变为 [7,7] ，与 nums2 相等。
 * <p>
 * 提示：
 * <p>
 * 3 <= nums1.length <= 200
 * nums2.length == nums1.length - 2
 * 0 <= nums1[i], nums2[i] <= 1000
 * 测试用例以这样的方式生成：存在一个整数 x，nums1 中的每个元素都与 x 相加后，再移除两个元素，nums1 可以与 nums2 相等。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-integer-added-to-array-i/description/?envType=daily-question&envId=2024-08-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3132_MinimumAddedInteger {
    public static void main(String[] args) {
        L3132_MinimumAddedInteger l3132MinimumAddedInteger = new L3132_MinimumAddedInteger();
        System.out.println(l3132MinimumAddedInteger.minimumAddedInteger(new int[]{4, 20, 16, 12, 8}, new int[]{14, 18, 10}));
    }

    public int minimumAddedInteger(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        //nums1中最小三个 一定会保留一个
        for (int i = 2; i >= 0; i--) {
            //假设保留的是i
            int diff = nums2[0] - nums1[i];
            //那么如果将nums1中所有元素+diff, 生成的新数组numsN
            //numsN应该是做为num1的子数组存在
            //如何判断numsN是否为nums1的子数组？
            //同向双指针
            int nums2Index = 0;
            for (int k = 0; k < nums1.length; k++) {
                //消耗nums2[z]
                if (nums1[k] + diff == nums2[nums2Index] && ++nums2Index == nums2.length) {
                    return diff;
                }
            }
        }
        return 0;
    }

}
