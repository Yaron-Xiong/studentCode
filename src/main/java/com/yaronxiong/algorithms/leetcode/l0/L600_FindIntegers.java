package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 600. 不含连续1的非负整数
 * 算术评级: 8
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * 相关企业
 * 给定一个正整数 n ，请你统计在 [0, n] 范围的非负整数中，有多少个整数的二进制表示中不存在 连续的 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 5
 * 输出: 5
 * 解释:
 * 下面列出范围在 [0, 5] 的非负整数与其对应的二进制表示：
 * 0 : 0
 * 1 : 1
 * 2 : 10
 * 3 : 11
 * 4 : 100
 * 5 : 101
 * 其中，只有整数 3 违反规则（有两个连续的 1 ），其他 5 个满足规则。
 * 示例 2:
 * <p>
 * 输入: n = 1
 * 输出: 2
 * 示例 3:
 * <p>
 * 输入: n = 2
 * 输出: 3
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/non-negative-integers-without-consecutive-ones/description/?envType=daily-question&envId=2024-08-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L600_FindIntegers {
    public static void main(String[] args) {
        L600_FindIntegers l600FindIntegers = new L600_FindIntegers();
        System.out.println(l600FindIntegers.findIntegers(5));
    }

    public int findIntegers(int n) {
        int m = Integer.SIZE - Integer.numberOfLeadingZeros(n);
        return dfs(m, n, 0, true, false);
    }

    public int dfs(int i, int n, int preItem, boolean isLimit, boolean isNum) {
        if (i < 0) {
            return 1;
        }
        int up = isLimit ? n >> i & 1 : 1;
        int res = dfs(i - 1, n, 0, isLimit && up == 0, isNum);
        if (preItem == 0 && up == 1) {
            res += dfs(i - 1, n, 1, isLimit, isNum);
        }
        return res;
    }
}
