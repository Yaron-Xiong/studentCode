package com.accompnay.TopicAlgorithms.practiceSet.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
		char[][] paths = new char[n][n];
		for (char[] path : paths) {
			Arrays.fill(path, '.');
		}
		List<List<String>> res = new ArrayList<>();
		backtracking(0, paths, res);
		return res;
	}

	public void backtracking(int curN, char[][] path, List<List<String>> res) {
		if (curN >= path.length) {
			List<String> subRes = new ArrayList<>();
			for (char[] ints : path) {
				subRes.add(String.valueOf(ints));
			}
			res.add(subRes);
			return;
		}
		for (int i = 0; i < path[curN].length; i++) {
			boolean isValid = isValid(path, curN, i);
			if (isValid) {
				continue;
			}
			path[curN][i] = 'Q';
			backtracking(curN + 1, path, res);
			path[curN][i] = '.';
		}
	}

	private boolean isValid(char[][] path, int curN, int x) {
		for (int i = 0; i < x; i++) {
			if (path[curN][i] == 'Q') {
				return true;
			}
		}
		for (int i = 0; i < curN; i++) {
			if (path[i][x] == 'Q') {
				return true;
			}
		}
		for (int tempY = curN, tempX = x; tempY >= 0 && tempX >= 0; tempX--, tempY--) {
			if (path[tempY][tempX] == 'Q') {
				return true;
			}
		}
		for (int tempY = curN, tempX = x; tempY >= 0 && tempX < path[curN].length; tempX++, tempY--) {
			if (path[tempY][tempX] == 'Q') {
				return true;
			}
		}
		return false;
	}


}
