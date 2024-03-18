package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1690. 石子游戏 VII
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 石子游戏中，爱丽丝和鲍勃轮流进行自己的回合，爱丽丝先开始 。
 * <p>
 * 有 n 块石子排成一排。每个玩家的回合中，可以从行中 移除 最左边的石头或最右边的石头，并获得与该行中剩余石头值之 和 相等的得分。当没有石头可移除时，得分较高者获胜。
 * <p>
 * 鲍勃发现他总是输掉游戏（可怜的鲍勃，他总是输），所以他决定尽力 减小得分的差值 。爱丽丝的目标是最大限度地 扩大得分的差值 。
 * <p>
 * 给你一个整数数组 stones ，其中 stones[i] 表示 从左边开始 的第 i 个石头的值，如果爱丽丝和鲍勃都 发挥出最佳水平 ，请返回他们 得分的差值 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：stones = [5,3,1,4,2]
 * 输出：6
 * 解释：
 * - 爱丽丝移除 2 ，得分 5 + 3 + 1 + 4 = 13 。游戏情况：爱丽丝 = 13 ，鲍勃 = 0 ，石子 = [5,3,1,4] 。
 * - 鲍勃移除 5 ，得分 3 + 1 + 4 = 8 。游戏情况：爱丽丝 = 13 ，鲍勃 = 8 ，石子 = [3,1,4] 。
 * - 爱丽丝移除 3 ，得分 1 + 4 = 5 。游戏情况：爱丽丝 = 18 ，鲍勃 = 8 ，石子 = [1,4] 。
 * - 鲍勃移除 1 ，得分 4 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [4] 。
 * - 爱丽丝移除 4 ，得分 0 。游戏情况：爱丽丝 = 18 ，鲍勃 = 12 ，石子 = [] 。
 * 得分的差值 18 - 12 = 6 。
 * 示例 2：
 * <p>
 * 输入：stones = [7,90,5,1,100,10,10,2]
 * 输出：122
 * <p>
 * 提示：
 * <p>
 * n == stones.length
 * 2 <= n <= 1000
 * 1 <= stones[i] <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/stone-game-vii/description/?envType=daily-question&envId=2024-02-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1690_StoneGameVII {
    public static void main(String[] args) {
        L1690_StoneGameVII l1690StoneGameVII = new L1690_StoneGameVII();
        System.out.println(l1690StoneGameVII.stoneGameVII(new int[]{5, 3, 1, 4, 2}));
    }

    public int stoneGameVII(int[] stones) {
        int[] preSum = new int[stones.length + 1];
        for (int i = 0; i < stones.length; i++) {
            preSum[i + 1] = preSum[i] + stones[i];
        }
        int[][] memo = new int[stones.length][stones.length];
        return dfs(0, stones.length - 1, preSum,memo);
    }


    private int dfs(int left, int right, int[] preSum, int[][] memo) {
        if (left == right) {
            return 0;
        }
        if (memo[left][right] != 0) {
            return memo[left][right];
        }
        //假设选择最左边
        int res1 = preSum[right + 1] - preSum[left + 1] - dfs(left + 1, right, preSum, memo);
        //假设选择最右边
        int res2 = preSum[right] - preSum[left] - dfs(left, right - 1, preSum, memo);
        return memo[left][right] = Math.max(res1, res2);
    }
}
