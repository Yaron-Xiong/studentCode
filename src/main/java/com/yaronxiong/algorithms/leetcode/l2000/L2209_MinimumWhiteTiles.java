package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.Arrays;

/**
 * 2209. 用地毯覆盖后的最少白色砖块
 * 算术评级: 7
 * 第 74 场双周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2106
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的 二进制 字符串 floor ，它表示地板上砖块的颜色。
 * <p>
 * floor[i] = '0' 表示地板上第 i 块砖块的颜色是 黑色 。
 * floor[i] = '1' 表示地板上第 i 块砖块的颜色是 白色 。
 * 同时给你 numCarpets 和 carpetLen 。你有 numCarpets 条 黑色 的地毯，每一条 黑色 的地毯长度都为 carpetLen 块砖块。请你使用这些地毯去覆盖砖块，使得未被覆盖的剩余 白色 砖块的数目 最小 。地毯相互之间可以覆盖。
 * <p>
 * 请你返回没被覆盖的白色砖块的 最少 数目。
 * <p>
 * 示例 1：
 * <p>
 * 输入：floor = "10110101", numCarpets = 2, carpetLen = 2
 * 输出：2
 * 解释：
 * 上图展示了剩余 2 块白色砖块的方案。
 * 没有其他方案可以使未被覆盖的白色砖块少于 2 块。
 * 示例 2：
 * <p>
 * 输入：floor = "11111", numCarpets = 2, carpetLen = 3
 * 输出：0
 * 解释：
 * 上图展示了所有白色砖块都被覆盖的一种方案。
 * 注意，地毯相互之间可以覆盖。
 * <p>
 * 提示：
 * <p>
 * 1 <= carpetLen <= floor.length <= 1000
 * floor[i] 要么是 '0' ，要么是 '1' 。
 * 1 <= numCarpets <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-white-tiles-after-covering-with-carpets/description/?envType=daily-question&envId=2025-02-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2209_MinimumWhiteTiles {
    public static void main(String[] args) {
        L2209_MinimumWhiteTiles l2209MinimumWhiteTiles = new L2209_MinimumWhiteTiles();
        System.out.println(l2209MinimumWhiteTiles.minimumWhiteTiles("10110101", 2, 2));
    }

    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        char[] floorArr = floor.toCharArray();
        memo = new int[floorArr.length][numCarpets + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, numCarpets, floorArr, carpetLen);
    }

    private int[][] memo;

    private int dfs(int i, int numCarpets, char[] floor, int carpetLen) {
        if (floor.length - i <= numCarpets * carpetLen) {
            return 0;
        }
        if (memo[i][numCarpets] != -1) {
            return memo[i][numCarpets];
        }
        int ans = Integer.MAX_VALUE;
        //不选择用毯子
        ans = Math.min(ans, dfs(i + 1, numCarpets, floor, carpetLen) + (floor[i] - '0'));
        if (numCarpets > 0) {
            //选择用毯子
            ans = Math.min(ans, dfs(i + carpetLen, numCarpets - 1, floor, carpetLen));
        }
        return memo[i][numCarpets] = ans;
    }
}
