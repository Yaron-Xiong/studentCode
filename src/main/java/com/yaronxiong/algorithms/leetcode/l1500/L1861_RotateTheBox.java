package com.yaronxiong.algorithms.leetcode.l1500;

import java.util.Arrays;

/**
 * 1861. 旋转盒子
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的字符矩阵 boxGrid ，它表示一个箱子的侧视图。箱子的每一个格子可能为：
 * <p>
 * '#' 表示石头
 * '*' 表示固定的障碍物
 * '.' 表示空位置
 * 这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。
 * 每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会 影响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。
 * <p>
 * 题目保证初始时 boxGrid 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。
 * <p>
 * 请你返回一个 n x m 的矩阵，表示按照上述旋转后，箱子内的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：box = [["#",".","#"]]
 * 输出：[["."],
 * ["#"],
 * ["#"]]
 * 示例 2：
 * <p>
 * 输入：box = [["#",".","*","."],
 * ["#","#","*","."]]
 * 输出：[["#","."],
 * ["#","#"],
 * ["*","*"],
 * [".","."]]
 * 示例 3：
 * <p>
 * 输入：box = [["#","#","*",".","*","."],
 * ["#","#","#","*",".","."],
 * ["#","#","#",".","#","."]]
 * 输出：[[".","#","#"],
 * [".","#","#"],
 * ["#","#","*"],
 * ["#","*","."],
 * ["#",".","*"],
 * ["#",".","."]]
 * <p>
 * 提示：
 * <p>
 * m == boxGrid.length
 * n == boxGrid[i].length
 * 1 <= m, n <= 500
 * boxGrid[i][j] 只可能是 '#' ，'*' 或者 '.' 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/rotating-the-box/description/?envType=daily-question&envId=2026-05-06">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1861_RotateTheBox {
    public static void main(String[] args) {
        L1861_RotateTheBox l1861RotateTheBox = new L1861_RotateTheBox();
        char[][] boxGrid = new char[][]{{'#', '.', '#'}};
        System.out.println(Arrays.deepToString(l1861RotateTheBox.rotateTheBox(boxGrid)));
        boxGrid = new char[][]{{'#', '.', '*', '.'}, {'#', '#', '*', '.'}};
        System.out.println(Arrays.deepToString(l1861RotateTheBox.rotateTheBox(boxGrid)));
        boxGrid = new char[][]{{'#', '#', '*', '.', '*', '.'}, {'#', '#', '#', '.', '#', '.'}, {'#', '#', '#', '.', '#', '.'}};
        System.out.println(Arrays.deepToString(l1861RotateTheBox.rotateTheBox(boxGrid)));
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        char[][] ans = new char[boxGrid[0].length][boxGrid.length];
        for (char[] an : ans) {
            Arrays.fill(an, '.');
        }
        for (int i = 0; i < boxGrid.length; i++) {
            //从屁股开始处理
            int position = boxGrid[i].length;
            for (int j = boxGrid[i].length - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    position = j;
                    ans[j][boxGrid.length - i - 1] = '*';
                }
                if (boxGrid[i][j] == '#') {
                    //要往下挪动
                    ans[--position][boxGrid.length - i - 1] = '#';
                }
            }
        }
        return ans;
    }
}
