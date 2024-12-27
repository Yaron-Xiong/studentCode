package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3007. 价值和小于等于 K 的最大数字
 * 算术评级: 8
 * 第 380 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 2258
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 k 和一个整数 x 。整数 num 的价值是它的二进制表示中在 x，2x，3x 等位置处
 * 设置位
 * 的数目（从最低有效位开始）。下面的表格包含了如何计算价值的例子。
 * <p>
 * x	num	Binary Representation	Price
 * 1	13	000001101	3
 * 2	13	000001101	1
 * 2	233	011101001	3
 * 3	13	000001101	1
 * 3	362	101101010	2
 * <p>
 * num 的 累加价值 是从 1 到 num 的数字的 总 价值。如果 num 的累加价值小于或等于 k 则被认为是 廉价 的。
 * <p>
 * 请你返回 最大 的廉价数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 9, x = 1
 * 输出：6
 * 解释：由下表所示，6 是最大的廉价数字。
 * x	num	Binary Representation	Price	Accumulated Price
 * 1	1	001	1	1
 * 1	2	010	1	2
 * 1	3	011	2	4
 * 1	4	100	1	5
 * 1	5	101	2	7
 * 1	6	110	2	9
 * 1	7	111	3	12
 * 示例 2：
 * <p>
 * 输入：k = 7, x = 2
 * 输出：9
 * 解释：由下表所示，9 是最大的廉价数字。
 * x	num	Binary Representation	Price	Accumulated Price
 * 2	1	0001	0	0
 * 2	2	0010	1	1
 * 2	3	0011	1	2
 * 2	4	0100	0	2
 * 2	5	0101	0	2
 * 2	6	0110	1	3
 * 2	7	0111	1	4
 * 2	8	1000	1	5
 * 2	9	1001	1	6
 * 2	10	1010	2	8
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 1015
 * 1 <= x <= 8
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/description/?envType=daily-question&envId=2024-08-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3007_FindMaximumNumber {
    public long findMaximumNumber(long k, int x) {
        this.x = x;
        // 开区间二分，原理见 https://www.bilibili.com/video/BV1AP41137w7/
        long left = 0;
        long right = (k + 1) << x;
        while (left + 1 < right) {
            long mid = (left + right) >>> 1;
            if (countDigitOne(mid) <= k) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int x;
    private long num;
    private long memo[][];

    private long countDigitOne(long num) {
        this.num = num;
        int m = 64 - Long.numberOfLeadingZeros(num);
        memo = new long[m][m + 1];
        for (long[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(m - 1, 0, true);
    }

    private long dfs(int i, int cnt1, boolean isLimit) {
        if (i < 0) {
            return cnt1;
        }
        if (!isLimit && memo[i][cnt1] != -1) {
            return memo[i][cnt1];
        }
        int up = isLimit ? (int) (num >> i & 1) : 1;
        long res = 0;
        for (int d = 0; d <= up; d++) { // 枚举要填入的数字 d
            res += dfs(i - 1, cnt1 + (d == 1 && (i + 1) % x == 0 ? 1 : 0), isLimit && d == up);
        }
        if (!isLimit) {
            memo[i][cnt1] = res;
        }
        return res;
    }

}
