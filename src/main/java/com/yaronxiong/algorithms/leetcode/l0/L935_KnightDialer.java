package com.yaronxiong.algorithms.leetcode.l0;

import java.util.*;

/**
 * 935. 骑士拨号器
 * 算术评级: 5
 * 第 109 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1690
 * 相关标签
 * 相关企业
 * 象棋骑士有一个独特的移动方式，它可以垂直移动两个方格，水平移动一个方格，或者水平移动两个方格，垂直移动一个方格(两者都形成一个 L 的形状)。
 * <p>
 * 象棋骑士可能的移动方式如下图所示:
 * <p>
 * 我们有一个象棋骑士和一个电话垫，如下所示，骑士只能站在一个数字单元格上(即蓝色单元格)。
 * <p>
 * 给定一个整数 n，返回我们可以拨多少个长度为 n 的不同电话号码。
 * <p>
 * 你可以将骑士放置在任何数字单元格上，然后你应该执行 n - 1 次移动来获得长度为 n 的号码。所有的跳跃应该是有效的骑士跳跃。
 * <p>
 * 因为答案可能很大，所以输出答案模 109 + 7.
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：10
 * 解释：我们需要拨一个长度为1的数字，所以把骑士放在10个单元格中的任何一个数字单元格上都能满足条件。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：20
 * 解释：我们可以拨打的所有有效号码为[04, 06, 16, 18, 27, 29, 34, 38, 40, 43, 49, 60, 61, 67, 72, 76, 81, 83, 92, 94]
 * 示例 3：
 * <p>
 * 输入：n = 3131
 * 输出：136006598
 * 解释：注意取模
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 5000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/knight-dialer/description/?envType=daily-question&envId=2024-12-10">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L935_KnightDialer {
    public static void main(String[] args) {
        L935_KnightDialer l935KnightDialer = new L935_KnightDialer();
        System.out.println(l935KnightDialer.knightDialer(2));
    }

    int MOD = 1000000007;
    List<Integer>[] graph;
    long[][] memo;

    public int knightDialer(int n) {
        graph = new List[13];
        memo = new long[10][n];
        Arrays.setAll(graph, i -> new ArrayList<Integer>());
        graph[1].add(6);
        graph[1].add(8);
        graph[2].add(7);
        graph[2].add(9);
        graph[3].add(4);
        graph[3].add(8);
        graph[4].add(3);
        graph[4].add(9);
        graph[4].add(0);
        graph[6].add(1);
        graph[6].add(7);
        graph[6].add(0);
        graph[7].add(2);
        graph[7].add(6);
        graph[8].add(1);
        graph[8].add(3);
        graph[9].add(4);
        graph[9].add(2);
        graph[0].add(4);
        graph[0].add(6);
        long ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans += dfs2(i, n - 1);
            ans %= MOD;
        }
        return (int) (ans % MOD);
    }

    private long dfs2(int i, int n) {
        if (n == 0) {
            return 1;
        }
        if (memo[i][n] != 0) {
            return memo[i][n];
        }
        long ans = 0;
        for (Integer neighbor : graph[i]) {
            ans += dfs2(neighbor, n - 1);
            ans %= MOD;
        }
        return memo[i][n] = ans;
    }

}
