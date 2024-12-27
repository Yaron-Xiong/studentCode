package com.yaronxiong.algorithms.leetcode.l3000;

/**
 * 3096. 得到更多分数的最少关卡数目
 * 算术评级: 4
 * 第 127 场双周赛
 * Q2
 * 1501
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的二进制数组 possible 。
 * <p>
 * Alice 和 Bob 正在玩一个有 n 个关卡的游戏，游戏中有一些关卡是 困难 模式，其他的关卡是 简单 模式。
 * 如果 possible[i] == 0 ，那么第 i 个关卡是 困难 模式。一个玩家通过一个简单模式的关卡可以获得 1 分，通过困难模式的关卡将失去 1 分。
 * <p>
 * 游戏的一开始，Alice 将从第 0 级开始 按顺序 完成一些关卡，然后 Bob 会完成剩下的所有关卡。
 * <p>
 * 假设两名玩家都采取最优策略，目的是 最大化 自己的得分，Alice 想知道自己 最少 需要完成多少个关卡，才能获得比 Bob 更多的分数。
 * <p>
 * 请你返回 Alice 获得比 Bob 更多的分数所需要完成的 最少 关卡数目，如果 无法 达成，那么返回 -1 。
 * <p>
 * 注意，每个玩家都至少需要完成 1 个关卡。
 * <p>
 * 示例 1：
 * <p>
 * 输入：possible = [1,0,1,0]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 我们来看一下 Alice 可以完成的关卡数目：
 * <p>
 * 如果 Alice 只完成关卡 0 ，Bob 完成剩下的所有关卡，那么 Alice 获得 1 分，Bob 获得 -1 + 1 - 1 = -1 分。
 * 如果 Alice 完成到关卡 1 ，Bob 完成剩下的所有关卡，那么 Alice 获得 1 - 1 = 0 分，Bob 获得 1 - 1 = 0 分。
 * 如果 Alice 完成到关卡 2 ，Bob 完成剩下的所有关卡，那么 Alice 获得 1 - 1 + 1 = 1 分，Bob 获得 -1 分。
 * Alice 需要完成至少一个关卡获得更多的分数。
 * <p>
 * 示例 2：
 * <p>
 * 输入：possible = [1,1,1,1,1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 我们来看一下 Alice 可以完成的关卡数目：
 * <p>
 * 如果 Alice 只完成关卡 0 ，Bob 完成剩下的所有关卡，那么 Alice 获得 1 分，Bob 获得 4 分。
 * 如果 Alice 完成到关卡 1 ，Bob 完成剩下的所有关卡，那么 Alice 获得 2 分，Bob 获得 3 分。
 * 如果 Alice 完成到关卡 2 ，Bob 完成剩下的所有关卡，那么 Alice 获得 3 分，Bob 获得 2 分。
 * 如果 Alice 完成到关卡 3 ，Bob 完成剩下的所有关卡，那么 Alice 获得 4 分，Bob 获得 1 分。
 * Alice 需要完成至少三个关卡获得更多的分数。
 * <p>
 * 示例 3：
 * <p>
 * 输入：possible = [0,0]
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * 两名玩家只能各完成 1 个关卡，Alice 完成关卡 0 得到 -1 分，Bob 完成关卡 1 得到 -1 分。两名玩家得分相同，所以 Alice 无法得到更多分数。
 * <p>
 * 提示：
 * <p>
 * 2 <= n == possible.length <= 105
 * possible[i] 要么是 0 要么是 1 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-levels-to-gain-more-points/description/?envType=daily-question&envId=2024-07-19">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3096_MinimumLevels {
    public static void main(String[] args) {
        L3096_MinimumLevels l3096MinimumLevels = new L3096_MinimumLevels();
        System.out.println(l3096MinimumLevels.minimumLevels(new int[]{1, 1}));
    }

    public int minimumLevels(int[] possible) {
        int sum = 0;
        for (int i : possible) {
            sum += i == 0 ? -1 : 1;
        }
        int alice = 0;
        for (int i = 0; i < possible.length - 1; i++) {
            alice += possible[i] == 0 ? -1 : 1;
            if (alice > sum - alice) {
                return i + 1;
            }
        }
        return -1;
    }
}
