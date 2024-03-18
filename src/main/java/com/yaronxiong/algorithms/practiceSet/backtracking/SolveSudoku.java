package com.yaronxiong.algorithms.practiceSet.backtracking;

import java.util.Arrays;

/**
 * 37. 解数独
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字1-9在每一行只能出现一次。
 * 数字1-9在每一列只能出现一次。
 * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用'.'表示。
 * <p>
 * 示例：
 * <p>
 * <p>
 * 输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]
 * 输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 * 解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
 * <p>
 * 提示：
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] 是一位数字或者 '.'
 * 题目数据 保证 输入数独仅有一个解
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sudoku-solver
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveSudoku {
	public static void main(String[] args) {
		SolveSudoku solveSudoku = new SolveSudoku();
		char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		solveSudoku.solveSudoku(board);
		System.out.println(Arrays.toString(board));
	}

	public void solveSudoku(char[][] board) {
		backtracking(board, 0, 0);
	}

	private boolean backtracking(char[][] board, int y, int x) {
		if (y >= board.length) {
			return true;
		}
		if (x >= board[0].length) {
			return backtracking(board, y + 1, 0);
		}
		if (board[y][x] != '.') {
			return backtracking(board, y, x + 1);
		}
		for (char i = '1'; i <= '9'; i++) {
			if (!isValid(board, y, x, i)) {
				continue;
			}
			board[y][x] = i;
			if (backtracking(board, y, x + 1)) {
				return true;
			}
			board[y][x] = '.';
		}
		return false;
	}

	private boolean isValid(char[][] board, int y, int x, char value) {
		for (int i = 0; i < 9; i++) {
			// 判断⾏是否存在重复
			if (board[y][i] == value) return false;
			// 判断列是否存在重复
			if (board[i][x] == value) return false;
			// 判断 3 x 3 ⽅框是否存在重复
			if (board[(y/3)*3 + i/3][(x/3)*3 + i%3] == value)
				return false;
		}
		return true;
	}


}
