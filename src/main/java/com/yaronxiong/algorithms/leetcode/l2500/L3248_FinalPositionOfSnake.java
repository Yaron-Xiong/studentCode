package com.yaronxiong.algorithms.leetcode.l2500;

import com.google.common.collect.Lists;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 3248. 矩阵中的蛇
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。
 * 矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i * n) + j。
 * <p>
 * 蛇从单元格 0 开始，并遵循一系列命令移动。
 * <p>
 * 给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，其中包括 "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。
 * <p>
 * 返回执行 commands 后蛇所停留的最终单元格的位置。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, commands = ["RIGHT","DOWN"]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 0	1
 * 2	3
 * 0	1
 * 2	3
 * 0	1
 * 2	3
 * 示例 2：
 * <p>
 * 输入：n = 3, commands = ["DOWN","RIGHT","UP"]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 0	1	2
 * 3	4	5
 * 6	7	8
 * 0	1	2
 * 3	4	5
 * 6	7	8
 * 0	1	2
 * 3	4	5
 * 6	7	8
 * 0	1	2
 * 3	4	5
 * 6	7	8
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10
 * 1 <= commands.length <= 100
 * commands 仅由 "UP"、"RIGHT"、"DOWN" 和 "LEFT" 组成。
 * 生成的测评数据确保蛇不会移动到矩阵的边界外。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/snake-in-matrix/description/?envType=daily-question&envId=2024-11-21">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3248_FinalPositionOfSnake {
    public static void main(String[] args) {
        L3248_FinalPositionOfSnake l3248FinalPositionOfSnake = new L3248_FinalPositionOfSnake();
        System.out.println(l3248FinalPositionOfSnake.finalPositionOfSnake(2, Lists.newArrayList("DOWN", "RIGHT", "UP")));
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int ans = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("UP", -n);
        map.put("DOWN", n);
        map.put("LEFT", -1);
        map.put("RIGHT", 1);
        for (String command : commands) {
            ans += map.get(command);
        }
        return ans;
    }
}
