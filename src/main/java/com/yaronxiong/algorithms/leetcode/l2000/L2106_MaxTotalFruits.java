package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2106. 摘水果
 * 提示
 * 困难
 * 62
 * 相关企业
 * 在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 fruits ，
 * 其中 fruits[i] = [positioni, amounti] 表示共有 amounti 个水果放置在 positioni 上。
 * fruits 已经按 positioni 升序排列 ，每个 positioni 互不相同 。
 * <p>
 * 另给你两个整数 startPos 和 k 。最初，你位于 startPos 。
 * 从任何位置，你可以选择 向左或者向右 走。在 x 轴上每移动 一个单位 ，就记作 一步 。你总共可以走 最多 k 步。
 * 你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。
 * <p>
 * 返回你可以摘到水果的 最大总数 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
 * 输出：9
 * 解释：
 * 最佳路线为：
 * - 向右移动到位置 6 ，摘到 3 个水果
 * - 向右移动到位置 8 ，摘到 6 个水果
 * 移动 3 步，共摘到 3 + 6 = 9 个水果
 * 示例 2：
 * <p>
 * 输入：fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
 * 输出：14
 * 解释：
 * 可以移动最多 k = 4 步，所以无法到达位置 0 和位置 10 。
 * 最佳路线为：
 * - 在初始位置 5 ，摘到 7 个水果
 * - 向左移动到位置 4 ，摘到 1 个水果
 * - 向右移动到位置 6 ，摘到 2 个水果
 * - 向右移动到位置 7 ，摘到 4 个水果
 * 移动 1 + 3 = 4 步，共摘到 7 + 1 + 2 + 4 = 14 个水果
 * 示例 3：
 * <p>
 * 输入：fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
 * 输出：0
 * 解释：
 * 最多可以移动 k = 2 步，无法到达任一有水果的地方
 * <p>
 * 提示：
 * <p>
 * 1 <= fruits.length <= 105
 * fruits[i].length == 2
 * 0 <= startPos, positioni <= 2 * 105
 * 对于任意 i > 0 ，positioni-1 < positioni 均成立（下标从 0 开始计数）
 * 1 <= amounti <= 104
 * 0 <= k <= 2 * 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/maximum-fruits-harvested-after-at-most-k-steps/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2106_MaxTotalFruits {
    public static void main(String[] args) {
        L2106_MaxTotalFruits l2106MaxTotalFruits = new L2106_MaxTotalFruits();
        int x = l2106MaxTotalFruits.maxTotalFruits(new int[][]{{0, 15}, {3, 56}, {4, 98}, {5, 81}, {7, 16}, {8, 77}, {9, 89}, {12, 82}, {13, 49}, {14, 59}, {17, 40}, {18, 83}, {19, 35}, {20, 31}, {21, 44}, {22, 92}, {25, 84}, {26, 42}, {29, 4}, {33, 78}, {35, 83}, {36, 3}, {37, 71}, {41, 24}, {44, 81}, {45, 35}, {46, 81}, {48, 81}, {50, 85}, {52, 32}, {53, 93}, {54, 89}, {55, 82}, {56, 60}, {59, 52}, {62, 79}, {63, 90}, {64, 41}, {66, 15}, {68, 43}, {69, 32}, {70, 51}, {71, 79}, {75, 39}, {76, 21}, {78, 16}, {79, 44}, {80, 73}, {81, 95}, {83, 95}, {85, 11}, {87, 80}, {88, 2}, {90, 89}, {99, 35}, {100, 95}}, 86, 107);
        System.out.println(x);
    }

    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] preSum = new int[200002];
        for (int[] fruit : fruits) {
            preSum[fruit[0] + 1] += fruit[1];
        }
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += preSum[i - 1];
        }
        int maxTotalFruits = 0;
        int right = startPos;
        while (right <= startPos + k) {
            //当right已知 那么left有两种可能
            int rightStep = (right - startPos);

            //向左位移出现几种可能：
            // 1.位移距离很大，超过了startPos 能承载的范围 值为0
            // 2.没有位移距离，唯一距离为负数 值为startPost
            // 3.正常的位移距离 值为 startPos - 位移距离
            //第一种 先向right移动 再向left移动
            int ls1 = getIndex(startPos, k - (rightStep * 2));
            int ls1PreSum = preSum[ls1];
            //第二种 先向left移动 再向right移动
            int ls2 = getIndex(startPos, (k - rightStep) / 2);
            int ls2PerSum  = preSum[ls2];
            //对比每种的最大值
            //计算当前窗口大小
            int rightPreSum = right + 1 >= preSum.length ? preSum[preSum.length - 1] : preSum[right + 1];
            maxTotalFruits = Math.max(maxTotalFruits, Math.max(rightPreSum - ls1PreSum, rightPreSum - ls2PerSum));
            //每次窗口向右移动
            right++;
        }
        return maxTotalFruits;
    }

    public int getIndex(int startPos, int step) {
        if (step < 0) {
            return startPos;
        }
        if (startPos - step < 0) {
            return 0;
        }
        return startPos - step;
    }
}
