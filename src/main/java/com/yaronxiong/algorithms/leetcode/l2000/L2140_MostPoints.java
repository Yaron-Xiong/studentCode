package com.yaronxiong.algorithms.leetcode.l2000;

/**
 * 2140. 解决智力问题
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 questions ，其中 questions[i] = [pointsi, brainpoweri] 。
 * <p>
 * 这个数组表示一场考试里的一系列题目，你需要 按顺序 （也就是从问题 0 开始依次解决），
 * 针对每个问题选择 解决 或者 跳过 操作。解决问题 i 将让你 获得  pointsi 的分数，
 * 但是你将 无法 解决接下来的 brainpoweri 个问题（即只能跳过接下来的 brainpoweri 个问题）。如果你跳过问题 i ，你可以对下一个问题决定使用哪种操作。
 * <p>
 * 比方说，给你 questions = [[3, 2], [4, 3], [4, 4], [2, 5]] ：
 * 如果问题 0 被解决了， 那么你可以获得 3 分，但你不能解决问题 1 和 2 。
 * 如果你跳过问题 0 ，且解决问题 1 ，你将获得 4 分但是不能解决问题 2 和 3 。
 * 请你返回这场考试里你能获得的 最高 分数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：questions = [[3,2],[4,3],[4,4],[2,5]]
 * 输出：5
 * 解释：解决问题 0 和 3 得到最高分。
 * - 解决问题 0 ：获得 3 分，但接下来 2 个问题都不能解决。
 * - 不能解决问题 1 和 2
 * - 解决问题 3 ：获得 2 分
 * 总得分为：3 + 2 = 5 。没有别的办法获得 5 分或者多于 5 分。
 * 示例 2：
 * <p>
 * 输入：questions = [[1,1],[2,2],[3,3],[4,4],[5,5]]
 * 输出：7
 * 解释：解决问题 1 和 4 得到最高分。
 * - 跳过问题 0
 * - 解决问题 1 ：获得 2 分，但接下来 2 个问题都不能解决。
 * - 不能解决问题 2 和 3
 * - 解决问题 4 ：获得 5 分
 * 总得分为：2 + 5 = 7 。没有别的办法获得 7 分或者多于 7 分。
 * <p>
 * 提示：
 * <p>
 * 1 <= questions.length <= 105
 * questions[i].length == 2
 * 1 <= pointsi, brainpoweri <= 105
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/solving-questions-with-brainpower/description/?envType=daily-question&envId=2025-04-01">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2140_MostPoints {
    public static void main(String[] args) {
        L2140_MostPoints l2140MostPoints = new L2140_MostPoints();
        int[][] arr = new int[][]{{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        System.out.println(l2140MostPoints.mostPoints(arr));
    }


    public long mostPoints(int[][] questions) {
        //每个问题可以选择跳过也可以选择不跳过
        long[] memo = new long[questions.length];
        return dfs2(0, questions, memo);
    }

    private long dfs2(int i, int[][] questions, long[] memo) {
        if (i >= questions.length) {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        //选择i
        long v1 = dfs2(i + questions[i][1] + 1, questions, memo) + questions[i][0];
        //不选择
        long v2 = dfs2(i + 1, questions, memo);
        return memo[i] = Math.max(v1, v2);
    }
}
