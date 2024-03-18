package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2652. 倍数求和
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 n ，请你计算在 [1，n] 范围内能被 3、5、7 整除的所有整数之和。
 * <p>
 * 返回一个整数，用于表示给定范围内所有满足约束条件的数字之和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 解释：在 [1, 7] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7 。数字之和为 21。
 * 示例 2：
 * <p>
 * 输入：n = 10
 * 输出：40
 * 解释：在 [1, 10] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9、10 。数字之和为 40。
 * 示例 3：
 * <p>
 * 输入：n = 9
 * 输出：30
 * 解释：在 [1, 9] 范围内能被 3、5、7 整除的所有整数分别是 3、5、6、7、9 。数字之和为 30。
 * 提示：
 * <p>
 * 1 <= n <= 103
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/sum-multiples/description/?envType=daily-question&envId=2023-10-17">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2652_SumOfMultiples {
    public static void main(String[] args) {
        L2652_SumOfMultiples l2652SumOfMultiples = new L2652_SumOfMultiples();
        System.out.println(l2652SumOfMultiples.sumOfMultiples(7));
    }
    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans += i;
            }
        }
        return ans;
    }
}
