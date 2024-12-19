package com.yaronxiong.algorithms.leetcode.l2500;

/**
 * 3274. 检查棋盘方格颜色是否相同
 * 算术评级: 2
 * 第 413 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1162
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串 coordinate1 和 coordinate2，代表 8 x 8 国际象棋棋盘上的两个方格的坐标。
 * <p>
 * 以下是棋盘的参考图。
 * <p>
 * 如果这两个方格颜色相同，返回 true，否则返回 false。
 * <p>
 * 坐标总是表示有效的棋盘方格。坐标的格式总是先字母（表示列），再数字（表示行）。
 * <p>
 * 示例 1：
 * <p>
 * 输入： coordinate1 = "a1", coordinate2 = "c3"
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 两个方格均为黑色。
 * <p>
 * 示例 2：
 * <p>
 * 输入： coordinate1 = "a1", coordinate2 = "h3"
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 方格 "a1" 是黑色，而 "h3" 是白色。
 * <p>
 * 提示：
 * <p>
 * coordinate1.length == coordinate2.length == 2
 * 'a' <= coordinate1[0], coordinate2[0] <= 'h'
 * '1' <= coordinate1[1], coordinate2[1] <= '8'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/check-if-two-chessboard-squares-have-the-same-color/description/?envType=daily-question&envId=2024-12-03">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3274_CheckTwoChessboards {
    public boolean checkTwoChessboards(String coordinate1, String coordinate2) {
        int v1 = (coordinate1.charAt(0) + coordinate1.charAt(1) - 'a' - '0') % 2;
        int v2 = (coordinate2.charAt(0) + coordinate2.charAt(1) - 'a' - '0') % 2;
        return v1 == v2;
    }
}
