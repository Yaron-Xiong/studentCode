package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.HashSet;
import java.util.Set;

/**
 * 874. 模拟行走机器人
 * 中等
 * 187
 * 相关企业
 * 机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
 * <p>
 * -2 ：向左转 90 度
 * -1 ：向右转 90 度
 * 1 <= x <= 9 ：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点  obstacles[i] = (xi, yi) 。
 * <p>
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。
 * <p>
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ）
 * <p>
 * 注意：
 * <p>
 * 北表示 +Y 方向。
 * 东表示 +X 方向。
 * 南表示 -Y 方向。
 * 西表示 -X 方向。
 * <p>
 * 示例 1：
 * <p>
 * 输入：commands = [4,-1,3], obstacles = []
 * 输出：25
 * 解释：
 * 机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 3 个单位，到达 (3, 4)
 * 距离原点最远的是 (3, 4) ，距离为 32 + 42 = 25
 * 示例 2：
 * <p>
 * 输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
 * 输出：65
 * 解释：机器人开始位于 (0, 0)：
 * 1. 向北移动 4 个单位，到达 (0, 4)
 * 2. 右转
 * 3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
 * 4. 左转
 * 5. 向北走 4 个单位，到达 (1, 8)
 * 距离原点最远的是 (1, 8) ，距离为 12 + 82 = 65
 * <p>
 * 提示：
 * <p>
 * 1 <= commands.length <= 104
 * commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9].
 * 0 <= obstacles.length <= 104
 * -3 * 104 <= xi, yi <= 3 * 104
 * 答案保证小于 231
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/walking-robot-simulation/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L874_RobotSim {
    public static void main(String[] args) {
        L874_RobotSim l874RobotSim = new L874_RobotSim();
        System.out.println(l874RobotSim.robotSim(new int[]{-2, -1, -2, 3, 7}, new int[][]{{1, -3}, {2, -3}, {4, 0}, {-2, 5}, {-5, 2}, {0, 0}, {4, -4}, {-2, -5}, {-1, -2}, {0, 2}}));
    }

    //北，西，东，南

    public int robotSim(int[] commands, int[][] obstacles) {
        int[][] forward = new int[][]{{0, 1, 1, 2}, {-1, 0, 3, 0}, {1, 0, 0, 3}, {0, -1, 2, 1}};
        Set<Integer> set = new HashSet<>();
        for (int[] obstacle : obstacles) {
            set.add(obstacle[0] * 60001 + obstacle[1]);
        }
        //如何找到前进的方向存在障碍物呢？
        int curFor = 0;
        int[] curPosition = new int[]{0, 0};
        int maxPosition = 0;
        for (int command : commands) {
            if (command == -1) {
                curFor = forward[curFor][3];
            } else if (command == -2) {
                curFor = forward[curFor][2];
            } else {
                //朝着curFor方向 移动command位 每次移动 一位
                int startX = curPosition[0];
                int startY = curPosition[1];
                for (int i = 0; i < command; i++) {
                    startX += forward[curFor][0];
                    startY += forward[curFor][1];
                    int v = startX * 60001 + startY;
                    if (set.contains(v)) {
                        //存在障碍物,停止
                        startX -= forward[curFor][0];
                        startY -= forward[curFor][1];
                        break;
                    }
                }
                curPosition[0] = startX;
                curPosition[1] = startY;
                maxPosition = Math.max(maxPosition, curPosition[0] * curPosition[0] + curPosition[1] * curPosition[1]);
            }
        }
        return maxPosition;
    }
}
