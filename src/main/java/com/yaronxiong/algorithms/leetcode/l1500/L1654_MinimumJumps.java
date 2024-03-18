package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1654. 到家的最少跳跃次数
 * 提示
 * 中等
 * 106
 * 相关企业
 * 有一只跳蚤的家在数轴上的位置 x 处。请你帮助它从位置 0 出发，到达它的家。
 * <p>
 * 跳蚤跳跃的规则如下：
 * <p>
 * 它可以 往前 跳恰好 a 个位置（即往右跳）。
 * 它可以 往后 跳恰好 b 个位置（即往左跳）。
 * 它不能 连续 往后跳 2 次。
 * 它不能跳到任何 forbidden 数组中的位置。
 * 跳蚤可以往前跳 超过 它的家的位置，但是它 不能跳到负整数 的位置。
 * <p>
 * 给你一个整数数组 forbidden ，其中 forbidden[i] 是跳蚤不能跳到的位置，同时给你整数 a， b 和 x ，
 * 请你返回跳蚤到家的最少跳跃次数。如果没有恰好到达 x 的可行方案，请你返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * 输出：3
 * 解释：往前跳 3 次（0 -> 3 -> 6 -> 9），跳蚤就到家了。
 * 示例 2：
 * <p>
 * 输入：forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * 输出：2
 * 解释：往前跳一次（0 -> 16），然后往回跳一次（16 -> 7），跳蚤就到家了。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * forbidden 中所有位置互不相同。
 * 位置 x 不在 forbidden 中。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-jumps-to-reach-home/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1654_MinimumJumps {
    public static void main(String[] args) {
        L1654_MinimumJumps l1654MinimumJumps = new L1654_MinimumJumps();
        System.out.println(l1654MinimumJumps.minimumJumps(new int[]{1998}, 1999, 2000, 2000));
    }

    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Deque<int[]> deque = new LinkedList<>();
        boolean[][] visit = new boolean[6001][2];
        for (int i : forbidden) {
            visit[i][0] = true;
            visit[i][1] = true;
        }
        deque.add(new int[]{0, 0});
        int jumps = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size > 0) {
                size--;
                int[] node = deque.pollFirst();
                if (node[0] == x) {
                    return jumps;
                }
                if (visit[node[0]][node[1]]) {
                    continue;
                }
                visit[node[0]][node[1]] = true;
                //向左边
                if (node[1] != 1 &&  node[0] - b >= 0) {
                    deque.add(new int[]{node[0] - b, 1});
                }
                //向右边
                if (node[0] + a <= 6000) {
                    deque.add(new int[]{node[0] + a, 0});
                }
            }
            jumps++;
        }
        return -1;
    }
}
