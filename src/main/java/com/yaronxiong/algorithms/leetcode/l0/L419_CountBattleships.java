package com.yaronxiong.algorithms.leetcode.l0;

/**
 * 419. 甲板上的战舰
 * 算术评级: 4
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个大小为 m x n 的矩阵 board 表示甲板，其中，每个单元格可以是一艘战舰 'X' 或者是一个空位 '.' ，返回在甲板 board 上放置的 战舰 的数量。
 * <p>
 * 战舰 只能水平或者垂直放置在 board 上。换句话说，战舰只能按 1 x k（1 行，k 列）或 k x 1（k 行，1 列）的形状建造，
 * 其中 k 可以是任意大小。两艘战舰之间至少有一个水平或垂直的空位分隔 （即没有相邻的战舰）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：board = [["."]]
 * 输出：0
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 是 '.' 或 'X'
 * <p>
 * <p>
 * 进阶：你可以实现一次扫描算法，并只使用 O(1) 额外空间，并且不修改 board 的值来解决这个问题吗？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/battleships-in-a-board/description/?envType=daily-question&envId=2024-06-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L419_CountBattleships {
    public int countBattleships(char[][] board) {
        int ans = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    dfs2(board, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs2(char[][] board, int x, int y) {
        if (board[x][y] == '.') {
            return;
        }
        board[x][y] = '.';
        if (x + 1 < board.length && board[x + 1][y] == 'X') {
            dfs2(board, x + 1, y);
        } else if (y + 1 < board[0].length && board[x][y + 1] == 'X') {
            dfs2(board, x, y + 1);
        }
    }
}

