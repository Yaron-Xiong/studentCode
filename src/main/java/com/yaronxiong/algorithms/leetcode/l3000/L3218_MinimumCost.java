package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.Arrays;

/**
 * 3218. 切蛋糕的最小总开销 I
 * 算术评级: 7
 * 第 406 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1654
 * 相关标签
 * 相关企业
 * 提示
 * 有一个 m x n 大小的矩形蛋糕，需要切成 1 x 1 的小块。
 * <p>
 * 给你整数 m ，n 和两个数组：
 * <p>
 * horizontalCut 的大小为 m - 1 ，其中 horizontalCut[i] 表示沿着水平线 i 切蛋糕的开销。
 * verticalCut 的大小为 n - 1 ，其中 verticalCut[j] 表示沿着垂直线 j 切蛋糕的开销。
 * 一次操作中，你可以选择任意不是 1 x 1 大小的矩形蛋糕并执行以下操作之一：
 * <p>
 * 沿着水平线 i 切开蛋糕，开销为 horizontalCut[i] 。
 * 沿着垂直线 j 切开蛋糕，开销为 verticalCut[j] 。
 * 每次操作后，这块蛋糕都被切成两个独立的小蛋糕。
 * <p>
 * 每次操作的开销都为最开始对应切割线的开销，并且不会改变。
 * <p>
 * 请你返回将蛋糕全部切成 1 x 1 的蛋糕块的 最小 总开销。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 3, n = 2, horizontalCut = [1,3], verticalCut = [5]
 * <p>
 * 输出：13
 * <p>
 * 解释：
 * <p>
 * 沿着垂直线 0 切开蛋糕，开销为 5 。
 * 沿着水平线 0 切开 3 x 1 的蛋糕块，开销为 1 。
 * 沿着水平线 0 切开 3 x 1 的蛋糕块，开销为 1 。
 * 沿着水平线 1 切开 2 x 1 的蛋糕块，开销为 3 。
 * 沿着水平线 1 切开 2 x 1 的蛋糕块，开销为 3 。
 * 总开销为 5 + 1 + 1 + 3 + 3 = 13 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：m = 2, n = 2, horizontalCut = [7], verticalCut = [4]
 * <p>
 * 输出：15
 * <p>
 * 解释：
 * <p>
 * 沿着水平线 0 切开蛋糕，开销为 7 。
 * 沿着垂直线 0 切开 1 x 2 的蛋糕块，开销为 4 。
 * 沿着垂直线 0 切开 1 x 2 的蛋糕块，开销为 4 。
 * 总开销为 7 + 4 + 4 = 15 。
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 20
 * horizontalCut.length == m - 1
 * verticalCut.length == n - 1
 * 1 <= horizontalCut[i], verticalCut[i] <= 103
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-cost-for-cutting-cake-i/description/?envType=daily-question&envId=2024-12-25">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3218_MinimumCost {
    public static void main(String[] args) {
        L3218_MinimumCost l3218MinimumCost = new L3218_MinimumCost();
        System.out.println(l3218MinimumCost.minimumCost(6, 3, new int[]{2, 3, 2, 3, 1}, new int[]{1, 2}));
    }

    public int minimumCost(int m, int n, int[] horizontalCut, int[] verticalCut) {
        Arrays.sort(horizontalCut);
        Arrays.sort(verticalCut);
        int hIndex = horizontalCut.length - 1;
        int vIndex = verticalCut.length - 1;
        int hCnt = 1;
        int vCnt = 1;
        int ans = 0;
        while (hIndex >= 0 && vIndex >= 0) {
            //用h的代价
            if (horizontalCut[hIndex] > verticalCut[vIndex]) {
                ans += horizontalCut[hIndex--] * vCnt;
                //用h
                hCnt++;
            } else {
                //用v的代价
                ans += verticalCut[vIndex--] * hCnt;
                vCnt++;
            }
        }
        for (int i = hIndex; i >= 0; i--) {
            ans += horizontalCut[i] * vCnt;
        }
        for (int i = vIndex; i >= 0; i--) {
            ans += verticalCut[i] * hCnt;
        }
        return ans;
    }

}
