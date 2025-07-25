package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2894. 分类求和并作差
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个正整数 n 和 m 。
 * <p>
 * 现定义两个整数 num1 和 num2 ，如下所示：
 * <p>
 * num1：范围 [1, n] 内所有 无法被 m 整除 的整数之和。
 * num2：范围 [1, n] 内所有 能够被 m 整除 的整数之和。
 * 返回整数 num1 - num2 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 10, m = 3
 * 输出：19
 * 解释：在这个示例中：
 * - 范围 [1, 10] 内无法被 3 整除的整数为 [1,2,4,5,7,8,10] ，num1 = 这些整数之和 = 37 。
 * - 范围 [1, 10] 内能够被 3 整除的整数为 [3,6,9] ，num2 = 这些整数之和 = 18 。
 * 返回 37 - 18 = 19 作为答案。
 * 示例 2：
 * <p>
 * 输入：n = 5, m = 6
 * 输出：15
 * 解释：在这个示例中：
 * - 范围 [1, 5] 内无法被 6 整除的整数为 [1,2,3,4,5] ，num1 = 这些整数之和 =  15 。
 * - 范围 [1, 5] 内能够被 6 整除的整数为 [] ，num2 = 这些整数之和 = 0 。
 * 返回 15 - 0 = 15 作为答案。
 * 示例 3：
 * <p>
 * 输入：n = 5, m = 1
 * 输出：-15
 * 解释：在这个示例中：
 * - 范围 [1, 5] 内无法被 1 整除的整数为 [] ，num1 = 这些整数之和 = 0 。
 * - 范围 [1, 5] 内能够被 1 整除的整数为 [1,2,3,4,5] ，num2 = 这些整数之和 = 15 。
 * 返回 0 - 15 = -15 作为答案。
 * <p>
 * 提示：
 * <p>
 * 1 <= n, m <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/divisible-and-non-divisible-sums-difference/description/?envType=daily-question&envId=2025-05-27">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2894_DifferenceOfSums {
    public int differenceOfSums(int n, int m) {
        int sum1 = 0;
        int sum2 = 0;
        for (int i = 1; i <= n; i++) {
            if (i % m != 0) {
                sum1 += i;
            }else {
                sum2 += i;
            }
        }
        return sum1 - sum2;
    }
}
