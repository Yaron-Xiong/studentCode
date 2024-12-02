package com.yaronxiong.algorithms.leetcode.l0;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * 已解答
 * 算术评级: 6
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * 相关企业
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
 * 解释：如上图所示，4 皇后问题存在两个不同的解法。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[["Q"]]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 9
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/n-queens/description/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L51_SolveNQueens {
    public static void main(String[] args) {
        L51_SolveNQueens l51SolveNQueens = new L51_SolveNQueens();
        System.out.println(l51SolveNQueens.solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();
        dfs2(0, new boolean[n][n]);
        return ans;
    }

    List<List<String>> ans;

    private void dfs2(int rowIndex, boolean[][] board) {
        if (rowIndex == board.length) {
            List<String> temp = new ArrayList<>();
            for (boolean[] booleans : board) {
                StringBuilder sb = new StringBuilder();
                for (boolean aBoolean : booleans) {
                    sb.append(aBoolean ? "Q" : ".");
                }
                temp.add(sb.toString());
            }
            ans.add(temp);
            return;
        }

        //判断当前行什么列可以摆
        for (int j = 0; j < board[rowIndex].length; j++) {
            //判断当前位置是否可以摆放
            boolean canPlace = check2(rowIndex, j, board);
            if (!canPlace) {
                continue;
            }
            board[rowIndex][j] = true;
            dfs2(rowIndex + 1, board);
            board[rowIndex][j] = false;
        }
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
