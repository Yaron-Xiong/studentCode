package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 887. 鸡蛋掉落
 * 已解答
 * 算术评级: 9
 * 第 97 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2377
 * 相关标签
 * 相关企业
 * 给你 k 枚相同的鸡蛋，并可以使用一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都会碎，从 f 楼层或比它低的楼层落下的鸡蛋都不会破。
 * <p>
 * 每次操作，你可以取一枚没有碎的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
 * 如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 1, n = 2
 * 输出：2
 * 解释：
 * 鸡蛋从 1 楼掉落。如果它碎了，肯定能得出 f = 0 。
 * 否则，鸡蛋从 2 楼掉落。如果它碎了，肯定能得出 f = 1 。
 * 如果它没碎，那么肯定能得出 f = 2 。
 * 因此，在最坏的情况下我们需要移动 2 次以确定 f 是多少。
 * 示例 2：
 * <p>
 * 输入：k = 2, n = 6
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：k = 3, n = 14
 * 输出：4
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 100
 * 1 <= n <= 104
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/super-egg-drop/description/?envType=daily-question&envId=2024-10-14">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L887_SuperEggDrop {
    public int superEggDrop(int k, int n) {
        int[][] memo = new int[n + 1][];
        for (int i = 1; ; i++) {
            memo[i] = new int[k + 1]; // 动态创建 memo
            if (dfs(i, k, memo) >= n) {
                return i;
            }
        }
    }

    private int dfs(int i, int j, int[][] memo) {
        if (i == 0 || j == 0) {
            return 0;
        }
        if (memo[i][j] != 0) { // 之前计算过
            return memo[i][j];
        }
        return memo[i][j] = dfs(i - 1, j, memo) + dfs(i - 1, j - 1, memo) + 1;
    }

}
