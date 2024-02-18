package com.accompnay.TopicAlgorithms.leetcode.l1500;

import java.util.Arrays;

/**
 * 1686. 石子游戏 VI
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * Alice 和 Bob 轮流玩一个游戏，Alice 先手。
 * <p>
 * 一堆石子里总共有 n 个石子，轮到某个玩家时，他可以 移出 一个石子并得到这个石子的价值。Alice 和 Bob 对石子价值有 不一样的的评判标准 。双方都知道对方的评判标准。
 * <p>
 * 给你两个长度为 n 的整数数组 aliceValues 和 bobValues 。aliceValues[i] 和 bobValues[i] 分别表示 Alice 和 Bob 认为第 i 个石子的价值。
 * <p>
 * 所有石子都被取完后，得分较高的人为胜者。如果两个玩家得分相同，那么为平局。两位玩家都会采用 最优策略 进行游戏。
 * <p>
 * 请你推断游戏的结果，用如下的方式表示：
 * <p>
 * 如果 Alice 赢，返回 1 。
 * 如果 Bob 赢，返回 -1 。
 * 如果游戏平局，返回 0 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：aliceValues = [1,3], bobValues = [2,1]
 * 输出：1
 * 解释：
 * 如果 Alice 拿石子 1 （下标从 0开始），那么 Alice 可以得到 3 分。
 * Bob 只能选择石子 0 ，得到 2 分。
 * Alice 获胜。
 * 示例 2：
 * <p>
 * 输入：aliceValues = [1,2], bobValues = [3,1]
 * 输出：0
 * 解释：
 * Alice 拿石子 0 ， Bob 拿石子 1 ，他们得分都为 1 分。
 * 打平。
 * 示例 3：
 * <p>
 * 输入：aliceValues = [2,4,3], bobValues = [1,6,7]
 * 输出：-1
 * 解释：
 * 不管 Alice 怎么操作，Bob 都可以得到比 Alice 更高的得分。
 * 比方说，Alice 拿石子 1 ，Bob 拿石子 2 ， Alice 拿石子 0 ，Alice 会得到 6 分而 Bob 得分为 7 分。
 * Bob 会获胜。
 * <p>
 * 提示：
 * <p>
 * n == aliceValues.length == bobValues.length
 * 1 <= n <= 105
 * 1 <= aliceValues[i], bobValues[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/stone-game-vi/description/?envType=daily-question&envId=2024-02-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1686_StoneGameVI {
    public static void main(String[] args) {
        L1686_StoneGameVI l1686StoneGameVI = new L1686_StoneGameVI();
        System.out.println(l1686StoneGameVI.stoneGameVI(new int[]{9, 8, 3, 8}, new int[]{10, 6, 9, 5}));
    }

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        Integer[] idx = new Integer[aliceValues.length];
        for (int i = 0; i < idx.length; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a, b) -> aliceValues[b] + bobValues[b] - aliceValues[a] - bobValues[a]);
        int[] arr = new int[2];
        for (int i = 0; i < aliceValues.length; i++) {
            if (i % 2 == 0) {
                arr[0] += aliceValues[idx[i]];
            }else {
                arr[1] += bobValues[idx[i]];
            }
        }
        return Integer.compare(arr[0], arr[1]);
    }
}
