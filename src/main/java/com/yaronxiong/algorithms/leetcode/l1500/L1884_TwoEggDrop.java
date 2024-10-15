package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1884. 鸡蛋掉落-两枚鸡蛋
 * 算术评级: 7
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你 2 枚相同 的鸡蛋，和一栋从第 1 层到第 n 层共有 n 层楼的建筑。
 * <p>
 * 已知存在楼层 f ，满足 0 <= f <= n ，任何从 高于 f 的楼层落下的鸡蛋都 会碎 ，从 f 楼层或比它低 的楼层落下的鸡蛋都 不会碎 。
 * <p>
 * 每次操作，你可以取一枚 没有碎 的鸡蛋并把它从任一楼层 x 扔下（满足 1 <= x <= n）。
 * 如果鸡蛋碎了，你就不能再次使用它。如果某枚鸡蛋扔下后没有摔碎，则可以在之后的操作中 重复使用 这枚鸡蛋。
 * <p>
 * 请你计算并返回要确定 f 确切的值 的 最小操作次数 是多少？
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：我们可以将第一枚鸡蛋从 1 楼扔下，然后将第二枚从 2 楼扔下。
 * 如果第一枚鸡蛋碎了，可知 f = 0；
 * 如果第二枚鸡蛋碎了，但第一枚没碎，可知 f = 1；
 * 否则，当两个鸡蛋都没碎时，可知 f = 2。
 * 示例 2：
 * <p>
 * 输入：n = 100
 * 输出：14
 * 解释：
 * 一种最优的策略是：
 * - 将第一枚鸡蛋从 9 楼扔下。如果碎了，那么 f 在 0 和 8 之间。将第二枚从 1 楼扔下，然后每扔一次上一层楼，在 8 次内找到 f 。总操作次数 = 1 + 8 = 9 。
 * - 如果第一枚鸡蛋没有碎，那么再把第一枚鸡蛋从 22 层扔下。如果碎了，那么 f 在 9 和 21 之间。将第二枚鸡蛋从 10 楼扔下，然后每扔一次上一层楼，在 12 次内找到 f 。总操作次数 = 2 + 12 = 14 。
 * - 如果第一枚鸡蛋没有再次碎掉，则按照类似的方法从 34, 45, 55, 64, 72, 79, 85, 90, 94, 97, 99 和 100 楼分别扔下第一枚鸡蛋。
 * 不管结果如何，最多需要扔 14 次来确定 f 。
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/egg-drop-with-2-eggs-and-n-floors/description/?envType=daily-question&envId=2024-10-13">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1884_TwoEggDrop {
    public static void main(String[] args) {
        L1884_TwoEggDrop l1884TwoEggDrop = new L1884_TwoEggDrop();
        System.out.println(l1884TwoEggDrop.twoEggDrop(100));
    }

    private int[] dp = new int[1001];

    public int twoEggDrop(int n) {
        //现在我们有两个鸡蛋，主要是考虑什么时候丢第一个
        // [0,n] 都可以丢第一个
        if (n == 0) {
            return 0;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 1; j <= n; j++) {
            // 假设在i层丢
            // 假设挑选了j(0<=j<=n) 进行丢，如果碎了或者没碎
            // 结果为这两种情况的最大值 碎了 ans = j  没碎 ans = dfs(n-j)+1
            int temp = Math.max(j, twoEggDrop(n - j) + 1);
            ans = Math.min(ans, temp);
        }
        return dp[n] = ans;
    }

}
