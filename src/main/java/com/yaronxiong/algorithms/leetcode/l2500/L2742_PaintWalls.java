package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 2742. 给墙壁刷油漆
 * 算术评级: 8
 * 第 350 场周赛
 * Q4
 * 2425
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个长度为 n 下标从 0 开始的整数数组 cost 和 time ，分别表示给 n 堵不同的墙刷油漆需要的开销和时间。你有两名油漆匠：
 * <p>
 * 一位需要 付费 的油漆匠，刷第 i 堵墙需要花费 time[i] 单位的时间，开销为 cost[i] 单位的钱。
 * 一位 免费 的油漆匠，刷 任意 一堵墙的时间为 1 单位，开销为 0 。但是必须在付费油漆匠 工作 时，免费油漆匠才会工作。
 * 请你返回刷完 n 堵墙最少开销为多少。
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [1,2,3,2], time = [1,2,3,2]
 * 输出：3
 * 解释：下标为 0 和 1 的墙由付费油漆匠来刷，需要 3 单位时间。同时，免费油漆匠刷下标为 2 和 3 的墙，需要 2 单位时间，开销为 0 。总开销为 1 + 2 = 3 。
 * 示例 2：
 * <p>
 * 输入：cost = [2,3,4,2], time = [1,1,1,1]
 * 输出：4
 * 解释：下标为 0 和 3 的墙由付费油漆匠来刷，需要 2 单位时间。同时，免费油漆匠刷下标为 1 和 2 的墙，需要 2 单位时间，开销为 0 。总开销为 2 + 2 = 4 。
 * <p>
 * 提示：
 * <p>
 * 1 <= cost.length <= 500
 * cost.length == time.length
 * 1 <= cost[i] <= 106
 * 1 <= time[i] <= 500
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/painting-the-walls/description/?envType=daily-question&envId=2024-06-28">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2742_PaintWalls {
    public static void main(String[] args) {
        L2742_PaintWalls l2742PaintWalls = new L2742_PaintWalls();
        System.out.println(l2742PaintWalls.paintWalls(new int[]{2, 3, 4, 2}, new int[]{1, 1, 1, 1}));
    }

    public int paintWalls(int[] cost, int[] time) {
        //假设开销高的都由免费工人做  开销低的都由付费的工人做
        //但是还有一个维度 时间？
        //时间会决定 免费工人的工作时长，假设付费工人 工作10H 那么免费工人能刷10面墙
        this.cost = cost;
        this.time = time;
        this.n = cost.length;
        this.memo = new Integer[n][n * 2 + 1];
        return dfs2(0, n);
    }

    int[] cost;
    int[] time;
    Integer[][] memo;
    int n;

    /**
     * 原本j是可以小于0的，但是为了加memo需要让j发生偏移使得其都是>=0的数
     */
    private int dfs2(int i, int j) {
        //如果免费劳动力剩余次数 大于等于 剩余墙壁 则无需额外花费
        //免费劳动力是可以透支的，但是后面要补齐，什么情况下证明没补齐？
        //没补齐的条件是 i 抵达最后一位，但是剩余免费时间<0
        if (j - n >= n - i) {
            return 0;
        }
        //说明不可能抵达
        if (i >= n && j - n < 0) {
            return Integer.MAX_VALUE / 2;
        }
        if (i >= n) {
            return 0;
        }
        if (memo[i][j] == null) {
            //当前墙壁用付费刷
            int v1 = dfs2(i + 1, j + time[i]) + cost[i];
            //当前墙壁用免费刷
            int v2 = dfs2(i + 1, j - 1);
            memo[i][j] = Math.min(v1, v2);
        }
        return memo[i][j];
    }


}

