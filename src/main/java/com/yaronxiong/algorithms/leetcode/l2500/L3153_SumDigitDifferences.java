package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3153. 所有数对中数位不同之和
 * 算术评级: 5
 * 第 398 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1645
 * 相关标签
 * 相关企业
 * 提示
 * 你有一个数组 nums ，它只包含 正 整数，所有正整数的数位长度都 相同 。
 * <p>
 * 两个整数的 数位不同 指的是两个整数 相同 位置上不同数字的数目。
 * <p>
 * 请你返回 nums 中 所有 整数对里，数位不同之和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [13,23,12]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 计算过程如下：
 * - 13 和 23 的数位不同为 1 。
 * - 13 和 12 的数位不同为 1 。
 * - 23 和 12 的数位不同为 2 。
 * 所以所有整数数对的数位不同之和为 1 + 1 + 2 = 4 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [10,10,10,10]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * 数组中所有整数都相同，所以所有整数数对的数位不同之和为 0 。
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] < 109
 * nums 中的整数都有相同的数位长度。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sum-of-digit-differences-of-all-pairs/description/?envType=daily-question&envId=2024-08-30">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3153_SumDigitDifferences {
    public static void main(String[] args) {
        L3153_SumDigitDifferences l3153SumDigitDifferences = new L3153_SumDigitDifferences();
        System.out.println(l3153SumDigitDifferences.sumDigitDifferences(new int[]{13,23,12}));
    }

    public long sumDigitDifferences(int[] nums) {
        long ans = 0;
        while (nums[0] > 0) {
            long[] tags = new long[10];
            for (int i = nums.length - 1; i >= 0; i--) {
                int value = nums[i] % 10;
                long oldValue = tags[value];
                int size = (int) (nums.length - i - oldValue - 1);
                ans += size;
                tags[value]++;
                nums[i] = nums[i] / 10;
            }
        }
        return ans;
    }
}
