package com.accompnay.TopicAlgorithms.leetcode;

import java.util.*;

/**
 * 1263. 推箱子
 * 提示
 * 困难
 * 113
 * 相关企业
 * 「推箱子」是一款风靡全球的益智小游戏，玩家需要将箱子推到仓库中的目标位置。
 * <p>
 * 游戏地图用大小为 m x n 的网格 grid 表示，其中每个元素可以是墙、地板或者是箱子。
 * <p>
 * 现在你将作为玩家参与游戏，按规则将箱子 'B' 移动到目标位置 'T' ：
 * <p>
 * 玩家用字符 'S' 表示，只要他在地板上，就可以在网格中向上、下、左、右四个方向移动。
 * 地板用字符 '.' 表示，意味着可以自由行走。
 * 墙用字符 '#' 表示，意味着障碍物，不能通行。
 * 箱子仅有一个，用字符 'B' 表示。相应地，网格上有一个目标位置 'T'。
 * 玩家需要站在箱子旁边，然后沿着箱子的方向进行移动，此时箱子会被移动到相邻的地板单元格。记作一次「推动」。
 * 玩家无法越过箱子。
 * 返回将箱子推到目标位置的最小 推动 次数，如果无法做到，请返回 -1。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 * ["#",".",".","B",".","#"],
 * ["#",".","#","#",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * 输出：3
 * 解释：我们只需要返回推箱子的次数。
 * 示例 2：
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 * ["#","T","#","#","#","#"],
 * ["#",".",".","B",".","#"],
 * ["#","#","#","#",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：grid = [["#","#","#","#","#","#"],
 * ["#","T",".",".","#","#"],
 * ["#",".","#","B",".","#"],
 * ["#",".",".",".",".","#"],
 * ["#",".",".",".","S","#"],
 * ["#","#","#","#","#","#"]]
 * 输出：5
 * 解释：向下、向左、向左、向上再向上。
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 20
 * grid 仅包含字符 '.', '#',  'S' , 'T', 以及 'B'。
 * grid 中 'S', 'B' 和 'T' 各只能出现一个。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1263_MinPushBox {
    public static void main(String[] args) {
        L1263_MinPushBox l1263MinPushBox = new L1263_MinPushBox();
        int x = l1263MinPushBox.minPushBox(new char[][]{{'#', '#', '#', '#', '#', '#'}, {'#', 'T', '#', '#', '#', '#'}, {'#', '.', '.', 'B', '.', '#'}, {'#', '.', '#', '#', '.', '#'}, {'#', '.', '.', '.', 'S', '#'}, {'#', '#', '#', '#', '#', '#'}});
        System.out.println(x);
    }

    int[][] forward = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};
    char[][] grid;

    public static class State {
        int[] personIndex = new int[2];
        int[] boxIndex = new int[2];
        int motionTimes;
    }

    public int minPushBox(char[][] grid) {
        this.grid = grid;
        int[] targetPosition = new int[2];
        //找到人的位置&箱子的位置
        State state = new State();
        state.motionTimes = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 'S') {
                    state.personIndex[0] = i;
                    state.personIndex[1] = j;
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'B') {
                    state.boxIndex[0] = i;
                    state.boxIndex[1] = j;
                    grid[i][j] = '.';
                } else if (grid[i][j] == 'T') {
                    targetPosition[0] = i;
                    targetPosition[1] = j;
                    grid[i][j] = '.';
                }
            }
        }
        //判断箱子可以如何移动
        //如果箱子要移动，那么人应该在箱子的反方向
        //箱子如果向右移动 那么人要在箱子的左边
        //此时就需要判断：人能否从当前位置移动至箱子移动的相反位置
        PriorityQueue<State> deque = new PriorityQueue<>(Comparator.comparingInt(a -> a.motionTimes));
        boolean[][] dp = new boolean[401][401];
        deque.add(state);
        while (!deque.isEmpty()) {
            State curStatus = deque.poll();
            if (curStatus.boxIndex[0] == targetPosition[0] && curStatus.boxIndex[1] == targetPosition[1]) {
                return curStatus.motionTimes;
            }
            for (int i = 0; i < forward.length; i++) {
                int[] ints = forward[i];
                State nextState = new State();
                //每次人动，如果人动的位置刚好为箱子位置则 人动加箱子动
                nextState.personIndex[0] = curStatus.personIndex[0] + ints[0];
                nextState.personIndex[1] = curStatus.personIndex[1] + ints[1];
                nextState.boxIndex[0] = curStatus.boxIndex[0];
                nextState.boxIndex[1] = curStatus.boxIndex[1];
                nextState.motionTimes = curStatus.motionTimes;
                if (nextState.personIndex[0] == curStatus.boxIndex[0] && nextState.personIndex[1] == curStatus.boxIndex[1]) {
                    nextState.boxIndex[0] += ints[0];
                    nextState.boxIndex[1] += ints[1];
                    nextState.motionTimes++;
                }
                //检查箱子的目标位置 & 人的目标位置是否合法
                if (checkPosition(nextState.boxIndex) ||
                        checkPosition(nextState.personIndex) ||
                        dp[getIndex(nextState.personIndex)][getIndex(nextState.boxIndex)]) {
                    continue;
                }
                dp[getIndex(nextState.personIndex)][getIndex(nextState.boxIndex)] = true;
                deque.add(nextState);
            }
        }
        return -1;
    }

    private int getIndex(int[] position) {
        return position[0] * 20 + position[1];
    }

    private boolean checkPosition(int[] position) {
        if (position[0] >= this.grid.length || position[0] < 0 || position[1] >= this.grid[0].length || position[1] < 0) {
            return true;
        }
        if (this.grid[position[0]][position[1]] == '#') {
            return true;
        }
        return false;
    }

}
