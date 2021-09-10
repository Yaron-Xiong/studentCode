package com.accompnay.swordFingerOffer.backtracking;

/**
 * 剑指 Offer 12. 矩阵中的路径：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
 * <p>
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * board 和 word 仅由大小写英文字母组成
 */
public class Exist {
	public static void main(String[] args) {
		Exist exist = new Exist();
		boolean b = exist.exist(new char[][]{{'a', 'a'}, {'a', 'b'}}, "aaab");
		System.out.println(b);
	}

	public boolean exist(char[][] board, String word) {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[0].length; x++) {
				if (A(board, word, x, y, 0)){
					return true;
				}
			}
		}
		return false;
	}

	public boolean A(char[][] board, String word, int x, int y, int index) {
		//判断是否遍历完了字符
		if (index >= word.length()) {
			return true;
		}
		//位置合法性判断
		if (y < 0 || x < 0 || y >= board.length || x >= board[0].length || board[y][x] != word.charAt(index)) {
			return false;
		}
		board[y][x] = '&';
		boolean result = A(board, word, x + 1, y, index + 1)
				||A(board, word, x - 1, y, index + 1)
				||A(board, word, x, y + 1, index + 1)
				||A(board, word, x, y - 1, index + 1);
		board[y][x] = word.charAt(index);
		return result;
	}

}
