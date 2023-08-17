package com.accompnay.TopicAlgorithms.swordFingerOffer.dfs;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 剑指 Offer 13. 机器人的运动范围
 * <p>
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，
 * 因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * <p>
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 提示：
 * <p>
 * 1 <= n,m <= 100
 * 0 <= k<= 20
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S13_MovingCount {
    public static void main(String[] args) {
        S13_MovingCount s13MovingCount = new S13_MovingCount();
        int i = s13MovingCount.movingCount(3, 2, 17);
        System.out.println(i);
    }

    public int movingCount(int m, int n, int k) {
        Deque<int[]> deque = new LinkedList<>();
        deque.addLast(new int[]{0, 0});
        boolean[][] visit = new boolean[m][n];
        int res = 0;
        while (!deque.isEmpty()) {
            int[] node = deque.pollFirst();
            if (node[0] < 0 || node[1] < 0 || node[0] >= m || node[1] >= n || getNumber(node[0]) + getNumber(node[1]) > k) {
                continue;
            }
            if (visit[node[0]][node[1]]) {
                continue;
            }
            res++;
            visit[node[0]][node[1]] = true;
            deque.addLast(new int[]{node[0] + 1, node[1]});
            deque.addLast(new int[]{node[0], node[1] + 1});
        }
        return res;
    }
    private int getNumber(int value) {
        int res = 0;
        while (value != 0) {
            res += value % 10;
            value /= 10;
        }
        return res;
    }


}
