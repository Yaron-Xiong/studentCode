package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1523. 在区间范围内统计奇数数目
 * 已解答
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * 示例 2：
 * <p>
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * <p>
 * 提示：
 * <p>
 * 0 <= low <= high <= 10^9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-odd-numbers-in-an-interval-range/description/?envType=daily-question&envId=2025-12-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1523_CountOdds {
    public static void main(String[] args) {
        L1523_CountOdds l1523CountOdds = new L1523_CountOdds();
        System.out.println(l1523CountOdds.countOdds(3, 7));
        System.out.println(l1523CountOdds.countOdds(8, 10));
        System.out.println(l1523CountOdds.countOdds(7, 10));
        System.out.println(l1523CountOdds.countOdds(6, 7));
    }

    public int countOdds(int low, int high) {
        return (int) (Math.ceil((double) high / 2) - Math.floor(((double) low / 2)));
    }
}
