package com.yaronxiong.algorithms.leetcode.l0;

import java.util.Arrays;

/**
 * 808. 分汤
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 你有两种汤，A 和 B，每种初始为 n 毫升。在每一轮中，会随机选择以下四种服务操作中的一种，每种操作的概率为 0.25，且与之前的所有轮次 无关：
 * <p>
 * 从汤 A 取 100 毫升，从汤 B 取 0 毫升
 * 从汤 A 取 75 毫升，从汤 B 取 25 毫升
 * 从汤 A 取 50 毫升，从汤 B 取 50 毫升
 * 从汤 A 取 25 毫升，从汤 B 取 75 毫升
 * 注意：
 * <p>
 * 不存在先分配 100 ml 汤B 的操作。
 * 汤 A 和 B 在每次操作中同时被倒入。
 * 如果一次操作要求你倒出比剩余的汤更多的量，请倒出该汤剩余的所有部分。
 * 操作过程在任何回合中任一汤被用完后立即停止。
 * <p>
 * 返回汤 A 在 B 前耗尽的概率，加上两种汤在 同一回合 耗尽概率的一半。返回值在正确答案 10-5 的范围内将被认为是正确的。
 * <p>
 * 示例 1:
 * <p>
 * 输入：n = 50
 * 输出：0.62500
 * 解释：
 * 如果我们选择前两个操作，A 首先将变为空。
 * 对于第三个操作，A 和 B 会同时变为空。
 * 对于第四个操作，B 首先将变为空。
 * 所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.25 *(1 + 1 + 0.5 + 0)= 0.625。
 * 示例 2:
 * <p>
 * 输入：n = 100
 * 输出：0.71875
 * 解释：
 * 如果我们选择第一个操作，A 首先将变为空。
 * 如果我们选择第二个操作，A 将在执行操作 [1, 2, 3] 时变为空，然后 A 和 B 在执行操作 4 时同时变空。
 * 如果我们选择第三个操作，A 将在执行操作 [1, 2] 时变为空，然后 A 和 B 在执行操作 3 时同时变空。
 * 如果我们选择第四个操作，A 将在执行操作 1 时变为空，然后 A 和 B 在执行操作 2 时同时变空。
 * 所以 A 变为空的总概率加上 A 和 B 同时变为空的概率的一半是 0.71875。
 * <p>
 * 提示:
 * <p>
 * 0 <= n <= 109
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/soup-servings/description/?envType=daily-question&envId=2025-08-08">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L808_SoupServings {
    public static void main(String[] args) {
        L808_SoupServings l808SoupServings = new L808_SoupServings();
        System.out.println(l808SoupServings.soupServings(0));
        System.out.println(l808SoupServings.soupServings(50));
    }

    public double soupServings(int n) {
        if (n >= 4500) {
            return 1;
        }
        //开始遍历所有可能性
        //1. A:-100 B:-0
        //2. A:-75 B:-25
        //3. A:-50 B:-50
        //4. A:-25 B:-75
        double[][] memo = new double[n + 1][n + 1];
        for (double[] doubles : memo) {
            Arrays.fill(doubles, -1);
        }
        int[][] arr = new int[][]{{-100, -0}, {-75, -25}, {-50, -50}, {-25, -75}};
        return dfs2(arr, memo, n, n);
    }

    private double dfs2(int[][] arr, double[][] memo, int a, int b) {
        if (memo[a][b] != -1) {
            return memo[a][b];
        }
        double ans = 0;
        for (int[] ints : arr) {
            //尝试使用i
            int tempA = a + ints[0];
            int tempB = b + ints[1];
            if (tempA > 0 && tempB > 0) {
                ans += dfs2(arr, memo, tempA, tempB) * 0.25;
            } else if (tempA <= 0 && tempB <= 0) {
                ans += 0.125;
            } else if (tempA <= 0) {
                ans += 0.25;
            }
        }
        return memo[a][b] = ans;
    }

}
