package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3222. 求出硬币游戏的赢家
 * 算术评级: 2
 * 第 135 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1270
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
 * <p>
 * Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，玩家需要拿出价值 总和 为 115 的硬币。
 * 如果一名玩家无法执行此操作，那么这名玩家 输掉 游戏。
 * <p>
 * 两名玩家都采取 最优 策略，请你返回游戏的赢家。
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 7
 * <p>
 * 输出："Alice"
 * <p>
 * 解释：
 * <p>
 * 游戏一次操作后结束：
 * <p>
 * Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * 示例 2：
 * <p>
 * 输入：x = 4, y = 11
 * <p>
 * 输出："Bob"
 * <p>
 * 解释：
 * <p>
 * 游戏 2 次操作后结束：
 * <p>
 * Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * Bob 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * <p>
 * 提示：
 * <p>
 * 1 <= x, y <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-the-winning-player-in-coin-game/description/?envType=daily-question&envId=2024-11-05">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3222_LosingPlayer {
    public static void main(String[] args) {
        L3222_LosingPlayer l3222LosingPlayer = new L3222_LosingPlayer();
        System.out.println(l3222LosingPlayer.losingPlayer(1, 1));
    }

    public String losingPlayer(int x, int y) {
        String[] arr = new String[]{"Alice", "Bob"};
        //计算能拿多少组
        int v = y / 4;
        v = Math.min(v, x);
        if (v == 0) {
            return arr[1];
        }
        return arr[(v - 1) % 2];
    }
}
