package com.yaronxiong.algorithms.leetcode.l2500;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 3238. 求出胜利玩家的数目
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，表示在一个游戏中的玩家数目。同时给你一个二维整数数组 pick ，其中 pick[i] = [xi, yi] 表示玩家 xi 获得了一个颜色为 yi 的球。
 * <p>
 * 如果玩家 i 获得的球中任何一种颜色球的数目 严格大于 i 个，那么我们说玩家 i 是胜利玩家。换句话说：
 * <p>
 * 如果玩家 0 获得了任何的球，那么玩家 0 是胜利玩家。
 * 如果玩家 1 获得了至少 2 个相同颜色的球，那么玩家 1 是胜利玩家。
 * ...
 * 如果玩家 i 获得了至少 i + 1 个相同颜色的球，那么玩家 i 是胜利玩家。
 * 请你返回游戏中 胜利玩家 的数目。
 * <p>
 * 注意，可能有多个玩家是胜利玩家。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, pick = [[0,0],[1,0],[1,0],[2,1],[2,1],[2,0]]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 玩家 0 和玩家 1 是胜利玩家，玩家 2 和玩家 3 不是胜利玩家。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 5, pick = [[1,1],[1,2],[1,3],[1,4]]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 没有胜利玩家。
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 5, pick = [[1,1],[2,4],[2,4],[2,4]]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 玩家 2 是胜利玩家，因为玩家 2 获得了 3 个颜色为 4 的球。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10
 * 1 <= pick.length <= 100
 * pick[i].length == 2
 * 0 <= xi <= n - 1
 * 0 <= yi <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-number-of-winning-players/description/?envType=daily-question&envId=2024-11-23">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3238_WinningPlayerCount {
    public int winningPlayerCount(int n, int[][] pick) {
        int[][] arr = new int[n][11];
        boolean[] winnerFlag = new boolean[n];
        int ans = 0;
        for (int[] ints : pick) {
            if (winnerFlag[ints[0]]) {
                continue;
            }
            if (++arr[ints[0]][ints[1]] > ints[0]) {
                ans++;
                winnerFlag[ints[0]] = true;
            }
        }
        return ans;
    }
}













