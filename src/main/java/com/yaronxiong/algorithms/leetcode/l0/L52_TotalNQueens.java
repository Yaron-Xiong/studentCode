package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 52. N 皇后 II
 * 算术评级: 6
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * 相关企业
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：2
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/n-queens-ii/description/?envType=daily-question&envId=2024-12-02">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L52_TotalNQueens {
    public static void main(String[] args) {
        L52_TotalNQueens l52TotalNQueens = new L52_TotalNQueens();
        System.out.println(l52TotalNQueens.totalNQueens(4));
    }

    public int totalNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        return dfs2(0, board);
    }

    private int dfs2(int rowIndex, boolean[][] board) {
        if (rowIndex == board.length) {
            return 1;
        }
        int ans = 0;
        //判断当前行什么列可以摆
        for (int j = 0; j < board[rowIndex].length; j++) {
            //判断当前位置是否可以摆放
            boolean canPlace = check2(rowIndex, j, board);
            if (!canPlace) {
                continue;
            }
            board[rowIndex][j] = true;
            ans += dfs2(rowIndex + 1, board);
            board[rowIndex][j] = false;
        }
        return ans;
    }

    private boolean check2(int i, int j, boolean[][] board) {
        //判断top
        for (int curI = 0; curI < i; curI++) {
            if (board[curI][j]) {
                return false;
            }
        }
        //判断左上角
        for (int curI = i, curJ = j; curI >= 0 && curJ >= 0; curI--, curJ--) {
            if (board[curI][curJ]) {
                return false;
            }
        }
        //判断右上角
        for (int curI = i, curJ = j; curI >= 0 && curJ < board.length; curI--, curJ++) {
            if (board[curI][curJ]) {
                return false;
            }
        }
        return true;
    }
}
