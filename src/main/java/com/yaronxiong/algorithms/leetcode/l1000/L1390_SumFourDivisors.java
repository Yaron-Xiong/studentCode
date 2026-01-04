package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1390. 四因数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，请你返回该数组中恰有四个因数的这些整数的各因数之和。如果数组中不存在满足题意的整数，则返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [21,4,7]
 * 输出：32
 * 解释：
 * 21 有 4 个因数：1, 3, 7, 21
 * 4 有 3 个因数：1, 2, 4
 * 7 有 2 个因数：1, 7
 * 答案仅为 21 的所有因数的和。
 * 示例 2:
 * <p>
 * 输入: nums = [21,21]
 * 输出: 64
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,4,5]
 * 输出: 0
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * 1 <= nums[i] <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/four-divisors/description/?envType=daily-question&envId=2026-01-04">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1390_SumFourDivisors {
    public static void main(String[] args) {
        L1390_SumFourDivisors l1390SumFourDivisors = new L1390_SumFourDivisors();
        System.out.println(l1390SumFourDivisors.sumFourDivisors(new int[]{21, 4, 7}));
        System.out.println(l1390SumFourDivisors.sumFourDivisors(new int[]{21, 21}));
        System.out.println(l1390SumFourDivisors.sumFourDivisors(new int[]{1, 2, 3, 4, 5}));
    }

    public int max = 100001;
    public int[] sum = new int[max];
    public int[] count = new int[max];

    public void init() {
        for (int i = 1; i < max; i++) {
            for (int j = i; j < max; j += i) {
                sum[j] += i;
                count[j]++;
            }
        }
    }

    public int sumFourDivisors(int[] nums) {
        init();
        int ans = 0;
        for (int num : nums) {
            if (count[num] == 4) {
                ans += sum[num];
            }
        }
        return ans;
    }
}
