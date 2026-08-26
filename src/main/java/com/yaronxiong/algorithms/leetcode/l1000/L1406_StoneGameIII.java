package com.yaronxiong.algorithms.leetcode.l1000;

import java.util.Arrays;

/**
 * 1406. 石子游戏 III
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * Alice 和 Bob 继续他们的石子游戏。几堆石子 排成一行 ，每堆石子都对应一个得分，由数组 stoneValue 给出。
 * <p>
 * Alice 和 Bob 轮流取石子，Alice 总是先开始。在每个玩家的回合中，该玩家可以拿走剩下石子中的的前 1、2 或 3 堆石子 。比赛一直持续到所有石头都被拿走。
 * <p>
 * 每个玩家的最终得分为他所拿到的每堆石子的对应得分之和。每个玩家的初始分数都是 0 。
 * <p>
 * 比赛的目标是决出最高分，得分最高的选手将会赢得比赛，比赛也可能会出现平局。
 * <p>
 * 假设 Alice 和 Bob 都采取 最优策略 。
 * <p>
 * 如果 Alice 赢了就返回 "Alice" ，Bob 赢了就返回 "Bob"，分数相同返回 "Tie" 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [1,2,3,7]
 * 输出："Bob"
 * 解释：Alice 总是会输，她的最佳选择是拿走前三堆，得分变成 6 。但是 Bob 的得分为 7，Bob 获胜。
 * 示例 2：
 * <p>
 * 输入：values = [1,2,3,-9]
 * 输出："Alice"
 * 解释：Alice 要想获胜就必须在第一个回合拿走前三堆石子，给 Bob 留下负分。
 * 如果 Alice 只拿走第一堆，那么她的得分为 1，接下来 Bob 拿走第二、三堆，得分为 5 。之后 Alice 只能拿到分数 -9 的石子堆，输掉比赛。
 * 如果 Alice 拿走前两堆，那么她的得分为 3，接下来 Bob 拿走第三堆，得分为 3 。之后 Alice 只能拿到分数 -9 的石子堆，同样会输掉比赛。
 * 注意，他们都应该采取 最优策略 ，所以在这里 Alice 将选择能够使她获胜的方案。
 * 示例 3：
 * <p>
 * 输入：values = [1,2,3,6]
 * 输出："Tie"
 * 解释：Alice 无法赢得比赛。如果她决定选择前三堆，她可以以平局结束比赛，否则她就会输。
 * <p>
 * 提示：
 * <p>
 * 1 <= stoneValue.length <= 5 * 104
 * -1000 <= stoneValue[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/stone-game-iii/?envType=daily-question&envId=2026-08-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1406_StoneGameIII {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] memo = new int[n];
        Arrays.fill(memo, Integer.MIN_VALUE); // MIN_VALUE 表示该状态没有计算过

        int diff = dfs(0, stoneValue, memo);
        if (diff == 0) {
            return "Tie";
        }
        return diff > 0 ? "Alice" : "Bob";
    }

    private int dfs(int i, int[] stoneValue, int[] memo) {
        if (i == stoneValue.length) {
            return 0;
        }

        if (memo[i] != Integer.MIN_VALUE) { // 之前计算过
            return memo[i];
        }

        int res = Integer.MIN_VALUE;
        int sum = 0;
        for (int j = i; j < Math.min(i + 3, stoneValue.length); j++) {
            sum += stoneValue[j];
            res = Math.max(res, sum - dfs(j + 1, stoneValue, memo));
        }
        return memo[i] = res; // 记忆化
    }

}
