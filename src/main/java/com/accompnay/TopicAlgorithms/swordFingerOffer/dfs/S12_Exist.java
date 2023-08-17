package com.accompnay.TopicAlgorithms.swordFingerOffer.dfs;

/**
 * 剑指 Offer 12. 矩阵中的路径
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
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class S12_Exist {
    public static void main(String[] args) {
        S12_Exist s12Exist = new S12_Exist();
        boolean b = s12Exist.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}}, "ABCESEEEFS");
        System.out.println(b);
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean b = dfs(i, j, 0, new boolean[board.length][board[0].length]);
                if (b) {
                    return true;
                }
            }
        }
        return false;
    }
    char[][] board;
    String word;
    private boolean dfs(int x, int y, int index, boolean[][] visit) {
        if (index >= word.length()) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visit[x][y]) {
            return false;
        }
        visit[x][y] = true;
        boolean res = false;
        if (board[x][y] == word.charAt(index)) {
            res = dfs(x + 1, y, index + 1, visit) ||
                    dfs(x - 1, y, index + 1, visit) ||
                    dfs(x, y + 1, index + 1, visit) ||
                    dfs(x, y - 1, index + 1, visit);
        }
        visit[x][y] = false;
        return res;
    }
}
