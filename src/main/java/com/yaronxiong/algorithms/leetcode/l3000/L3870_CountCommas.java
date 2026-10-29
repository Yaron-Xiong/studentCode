package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3870. 统计范围内的逗号
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。
 * <p>
 * 返回将所有从 [1, n]（包含两端）范围内的整数以 标准 数字格式书写时所用到的 逗号总数。
 * <p>
 * 在 标准 格式中：
 * <p>
 * 从右边开始，每 三位 数字后插入一个逗号。
 * 位数 少于四位 的数字不包含逗号。
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 1002
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 数字 "1,000"、"1,001" 和 "1,002" 每个都包含一个逗号，总计 3 个逗号。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 998
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 从 1 到 998 的所有数字位数都少于四位，因此没有使用逗号。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-commas-in-range/description/?envType=daily-question&envId=2026-09-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3870_CountCommas {
    public int countCommas(int n) {
        long ans = 0;
        // 从低到高，枚举逗号的位置
        for (long low = 1000; low <= n; low *= 1000) {
            // [low, n] 中的每个数都在这个位置上有一个逗号
            ans += n - low + 1;
        }
        return (int) ans;
    }
}
