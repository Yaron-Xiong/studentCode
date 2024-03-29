package com.yaronxiong.algorithms.practiceSet.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 51. N 皇后
 * <p>
 * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
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
 * 链接：https://leetcode-cn.com/problems/n-queens
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SolveNQueens {
	public static void main(String[] args) {
		SolveNQueens solveNQueens = new SolveNQueens();
		List<List<String>> lists = solveNQueens.solveNQueens(4);
		System.out.println(lists);
	}

	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (char[] chars : board) {
			Arrays.fill(chars, '.');
		}
		List<List<String>> res = new ArrayList<>();
		backtracking(n, board, res);
		return res;
	}

	private void backtracking(int n, char[][] board, List<List<String>> res) {
		if (n == 0) {
			List<String> subRes = Arrays.stream(board).map(String::valueOf).collect(Collectors.toList());
			res.add(subRes);
			return;
		}
		int y = board.length - n;
		for (int i = 0; i < board[y].length; i++) {
			if (board[y][i] != '.') {
				continue;
			}
			if (!isValid(board, y, i)) {
				continue;
			}
			board[y][i] = 'Q';
			backtracking(n - 1, board, res);
			board[y][i] = '.';
		}

	}

	private boolean isValid(char[][] board, int y, int x) {
		for (int i = 0; i <= x; i++) {
			if (board[y][i] == 'Q') {
				return false;
			}
		}
		for (int i = 0; i <= y; i++) {
			if (board[i][x] == 'Q') {
				return false;
			}
		}
		int curX = x;
		int curY = y;
		while (curX >= 0 && curY >= 0) {
			if (board[curY][curX] == 'Q') {
				return false;
			}
			curX--;
			curY--;
		}
		curX = x;
		curY = y;
		while (curX < board[y].length && curY >= 0) {
			if (board[curY][curX] == 'Q') {
				return false;
			}
			curX++;
			curY--;
		}
		return true;
	}


}
