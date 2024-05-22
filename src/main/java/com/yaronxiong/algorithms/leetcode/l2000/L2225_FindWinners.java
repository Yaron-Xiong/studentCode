package com.yaronxiong.algorithms.leetcode.l2000;

import java.util.ArrayList;
import java.util.List;

/**
 * 2225. 找出输掉零场或一场比赛的玩家
 * 算术评级: 3
 * 第 287 场周赛
 * Q2
 * 1316
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了 loseri 。
 * <p>
 * 返回一个长度为 2 的列表 answer ：
 * <p>
 * answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * 两个列表中的值都应该按 递增 顺序返回。
 * <p>
 * 注意：
 * <p>
 * 只考虑那些参与 至少一场 比赛的玩家。
 * 生成的测试用例保证 不存在 两场比赛结果 相同 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * 输出：[[1,2,10],[4,5,7,8]]
 * 解释：
 * 玩家 1、2 和 10 都没有输掉任何比赛。
 * 玩家 4、5、7 和 8 每个都输掉一场比赛。
 * 玩家 3、6 和 9 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
 * 示例 2：
 * <p>
 * 输入：matches = [[2,3],[1,3],[5,4],[6,4]]
 * 输出：[[1,2,5,6],[]]
 * 解释：
 * 玩家 1、2、5 和 6 都没有输掉任何比赛。
 * 玩家 3 和 4 每个都输掉两场比赛。
 * 因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
 * <p>
 * 提示：
 * <p>
 * 1 <= matches.length <= 105
 * matches[i].length == 2
 * 1 <= winneri, loseri <= 105
 * winneri != loseri
 * 所有 matches[i] 互不相同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/find-players-with-zero-or-one-losses/description/?envType=daily-question&envId=2024-05-22">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2225_FindWinners {
    public List<List<Integer>> findWinners(int[][] matches) {
        int[] lose = new int[100001];
        boolean[] plays = new boolean[100001];
        for (int[] match : matches) {
            lose[match[1]]++;
            plays[match[0]] = true;
            plays[match[1]] = true;
        }
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.add(new ArrayList<>());
        for (int i = 0; i < lose.length; i++) {
            if (plays[i] && lose[i] < 2) {
                ans.get(lose[i]).add(i);
            }
        }
        return ans;
    }
}
