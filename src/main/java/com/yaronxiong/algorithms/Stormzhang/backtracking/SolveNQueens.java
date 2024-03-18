package com.yaronxiong.algorithms.Stormzhang.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 51. N 皇后
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
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

	private List<List<String>> res;
	private int[] queens;
	private HashSet<Integer> column;
	private HashSet<Integer> diagonal1;
	private HashSet<Integer> diagonal2;

	private int layer;

	public List<List<String>> solveNQueens(int n) {
		res = new ArrayList<>();
		layer = 0;
		queens = new int[n];
		column = new HashSet<>();
		diagonal1 = new HashSet<>();
		diagonal2 = new HashSet<>();
		backtracking(n);
		return res;
	}

	private void backtracking(int n) {
		if (layer == n) {
			//一定是找到才能layer==n
			res.add(getStr(n));
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!canChess(layer, i)) {
				continue;
			}
			queens[layer] = i;
			column.add(i);
			diagonal1.add(layer + i);
			diagonal2.add(i - layer);
			layer++;
			backtracking(n);
			layer--;
			queens[layer] = 0;
			column.remove(i);
			diagonal1.remove(layer + i);
			diagonal2.remove(i - layer);
		}
	}

	public List<String> getStr(int n) {
		List<String> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			char[] chars = new char[n];
			Arrays.fill(chars,'.');
			chars[queens[i]] = 'Q';
			res.add(new String(chars));
		}
		return res;
	}

	public boolean canChess(int y, int x) {
		if (column.contains(x)) {
			return false;
		}
		int i2 = x + y;
		if (diagonal1.contains(i2)) {
			return false;
		}
		int i = x - y;
		if (diagonal2.contains(i)) {
			return false;
		}
		return true;
	}
}
