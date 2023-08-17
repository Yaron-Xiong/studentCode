package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1444. 切披萨的方案数
 * 提示
 * 困难
 * 118
 * 相关企业
 * 给你一个 rows x cols 大小的矩形披萨和一个整数 k ，矩形包含两种字符： 'A' （表示苹果）和 '.' （表示空白格子）。你需要切披萨 k-1 次，得到 k 块披萨并送给别人。
 * <p>
 * 切披萨的每一刀，先要选择是向垂直还是水平方向切，再在矩形的边界上选一个切的位置，将披萨一分为二。
 * 如果垂直地切披萨，那么需要把左边的部分送给一个人，如果水平地切，那么需要把上面的部分送给一个人。
 * 在切完最后一刀后，需要把剩下来的一块送给最后一个人。
 * <p>
 * 请你返回确保每一块披萨包含 至少 一个苹果的切披萨方案数。由于答案可能是个很大的数字，请你返回它对 10^9 + 7 取余的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：pizza = ["A..","AAA","..."], k = 3
 * 输出：3
 * 解释：上图展示了三种切披萨的方案。注意每一块披萨都至少包含一个苹果。
 * 示例 2：
 * <p>
 * 输入：pizza = ["A..","AA.","..."], k = 3
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：pizza = ["A..","A..","..."], k = 1
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= rows, cols <= 50
 * rows == pizza.length
 * cols == pizza[i].length
 * 1 <= k <= 10
 * pizza 只包含字符 'A' 和 '.' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1444_Ways {
    public static void main(String[] args) {
        L1444_Ways l1444Ways = new L1444_Ways();
        System.out.println(l1444Ways.ways(new String[]{"A..", "AAA", "..."}, 3));
    }

    static class MatrixSum {
        private final int[][] sum;

        public MatrixSum(String[] pizza) {
            this.sum = new int[pizza.length + 1][pizza[0].length() + 1];
            for (int i = 0; i < pizza.length; i++) {
                for (int j = 0; j < pizza[i].length(); j++) {
                    this.sum[i + 1][j + 1] = this.sum[i][j + 1] + this.sum[i + 1][j] - this.sum[i][j] + (pizza[i].charAt(j) == 'A' ? 1 : 0);
                }
            }
        }

        public int getValue(int x1, int y1, int x2, int y2) {
            return this.sum[x2 + 1][y2 + 1] - this.sum[x2 + 1][y1] - this.sum[x1][y2 + 1] + this.sum[x1][y1];
        }

    }

    int[][][] memo;
    MatrixSum matrixSum;

    public int ways(String[] pizza, int k) {
        this.memo = new int[pizza.length][pizza[0].length()][k + 1];
        for (int[][] value : memo) {
            for (int[] ints : value) {
                Arrays.fill(ints, -1);
            }
        }
        this.matrixSum = new MatrixSum(pizza);
        return dfs(0, 0, pizza.length - 1, pizza[0].length() - 1, k);
    }

    //说明了 f(x1,y1,k ) ==>
    private int dfs(int x1, int y1, int x2, int y2, int k) {
        if (k == 1) {
            return hasApple(x1, y1, x2, y2) ? 1 : 0;
        }
        if (memo[x1][y1][k] != -1) {
            return memo[x1][y1][k];
        }
        int res = 0;
        //x1->x2之间都可以选择一个间隙进行切割
        for (int i = x1 + 1; i <= x2; i++) {
            //检测  (x1,y1) (i-1,y2) 区域 是否至少有一个苹果
            //检测  (i,y1) (x2,y2) 区域也至少有一个苹果
            boolean a = hasApple(x1, y1, i - 1, y2);
            boolean b = hasApple(i, y1, x2, y2);
            if (!a || !b) {
                continue;
            }
            res += dfs(i, y1, x2, y2, k - 1) % 1000000007;
            res %= 1000000007;
        }
        //y1->y2之间都可以选择一个间隙进行切割
        for (int i = y1 + 1; i <= y2; i++) {
            //检测  (x1,y1) (x2,i-1) 区域 是否至少有一个苹果
            //检测  (x1,i) (x2,y2) 区域也至少有一个苹果
            boolean a = hasApple(x1, y1, x2, i - 1);
            boolean b = hasApple(x1, i, x2, y2);
            if (!a || !b) {
                continue;
            }
            res += dfs(x1, i, x2, y2, k - 1) % 1000000007;
            res %= 1000000007;
        }
        return memo[x1][y1][k] = res;
    }

    private boolean hasApple(int x1, int y1, int x2, int y2) {
        return this.matrixSum.getValue(x1, y1, x2, y2) > 0;
    }

}
