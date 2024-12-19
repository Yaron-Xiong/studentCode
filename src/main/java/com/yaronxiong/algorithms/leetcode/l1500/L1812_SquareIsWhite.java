package com.yaronxiong.algorithms.leetcode.l1500;

/**
 * 1812. 判断国际象棋棋盘中一个格子的颜色
 * 算术评级: 2
 * 第 49 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1329
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个坐标 coordinates ，它是一个字符串，表示国际象棋棋盘中一个格子的坐标。下图是国际象棋棋盘示意图。
 * <p>
 * 如果所给格子的颜色是白色，请你返回 true，如果是黑色，请返回 false 。
 * <p>
 * 给定坐标一定代表国际象棋棋盘上一个存在的格子。坐标第一个字符是字母，第二个字符是数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：coordinates = "a1"
 * 输出：false
 * 解释：如上图棋盘所示，"a1" 坐标的格子是黑色的，所以返回 false 。
 * 示例 2：
 * <p>
 * 输入：coordinates = "h3"
 * 输出：true
 * 解释：如上图棋盘所示，"h3" 坐标的格子是白色的，所以返回 true 。
 * 示例 3：
 * <p>
 * 输入：coordinates = "c7"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * coordinates.length == 2
 * 'a' <= coordinates[0] <= 'h'
 * '1' <= coordinates[1] <= '8'
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/determine-color-of-a-chessboard-square/?envType=daily-question&envId=2024-12-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1812_SquareIsWhite {
    public boolean squareIsWhite(String coordinates) {
        char aValue = coordinates.charAt(0);
        char bValue = coordinates.charAt(1);
        return aValue % 2 == bValue % 2;
    }
}
