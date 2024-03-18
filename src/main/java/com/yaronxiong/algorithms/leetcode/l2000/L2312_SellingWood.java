package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2312. 卖木头块
 * 第 298 场周赛
 * Q4
 * 2363
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数 m 和 n ，分别表示一块矩形木块的高和宽。同时给你一个二维整数数组 prices ，
 * 其中 prices[i] = [hi, wi, pricei] 表示你可以以 pricei 元的价格卖一块高为 hi 宽为 wi 的矩形木块。
 * <p>
 * 每一次操作中，你必须按下述方式之一执行切割操作，以得到两块更小的矩形木块：
 * <p>
 * 沿垂直方向按高度 完全 切割木块，或
 * 沿水平方向按宽度 完全 切割木块
 * 在将一块木块切成若干小木块后，你可以根据 prices 卖木块。你可以卖多块同样尺寸的木块。你不需要将所有小木块都卖出去。你 不能 旋转切好后木块的高和宽。
 * <p>
 * 请你返回切割一块大小为 m x n 的木块后，能得到的 最多 钱数。
 * <p>
 * 注意你可以切割木块任意次。
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 5, prices = [[1,4,2],[2,2,7],[2,1,3]]
 * 输出：19
 * 解释：上图展示了一个可行的方案。包括：
 * - 2 块 2 x 2 的小木块，售出 2 * 7 = 14 元。
 * - 1 块 2 x 1 的小木块，售出 1 * 3 = 3 元。
 * - 1 块 1 x 4 的小木块，售出 1 * 2 = 2 元。
 * 总共售出 14 + 3 + 2 = 19 元。
 * 19 元是最多能得到的钱数。
 * 示例 2：
 * <p>
 * 输入：m = 4, n = 6, prices = [[3,2,10],[1,4,2],[4,1,3]]
 * 输出：32
 * 解释：上图展示了一个可行的方案。包括：
 * - 3 块 3 x 2 的小木块，售出 3 * 10 = 30 元。
 * - 1 块 1 x 4 的小木块，售出 1 * 2 = 2 元。
 * 总共售出 30 + 2 = 32 元。
 * 32 元是最多能得到的钱数。
 * 注意我们不能旋转 1 x 4 的木块来得到 4 x 1 的木块。
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 200
 * 1 <= prices.length <= 2 * 104
 * prices[i].length == 3
 * 1 <= hi <= m
 * 1 <= wi <= n
 * 1 <= pricei <= 106
 * 所有 (hi, wi) 互不相同 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/selling-pieces-of-wood/description/?envType=daily-question&envId=2024-03-15">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2312_SellingWood {
    public static void main(String[] args) {
        L2312_SellingWood l2312SellingWood = new L2312_SellingWood();
        System.out.println(l2312SellingWood.sellingWood(20, 13, new int[][]{{5, 10, 15}, {7, 12, 24}, {15, 12, 1}, {17, 3, 10}, {20, 9, 22}, {5, 13, 15}, {16, 7, 28}, {12, 10, 29}, {2, 9, 1}, {14, 6, 15}, {20, 8, 20}}));
    }

    public long sellingWood(int m, int n, int[][] prices) {
        int[][] pr = new int[m + 1][n + 1];
        for (int[] p : prices) {
            pr[p[0]][p[1]] = p[2];
        }
        //prices太长了，可以缩短
        long[][] f = new long[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //开始构建 f[i][j]
                f[i][j] = pr[i][j];
                //切割方式1：水平切割
                for (int k = 1; k < i; k++) {
                    f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
                }
                //切割方式1：垂直切割
                for (int k = 1; k < j; k++) {
                    f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
                }
            }
        }
        return f[m][n];
    }

}
