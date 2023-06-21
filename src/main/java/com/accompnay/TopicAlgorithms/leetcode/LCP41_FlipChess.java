package com.accompnay.TopicAlgorithms.leetcode;

import java.util.*;

/**
 * LCP 41. 黑白翻转棋
 * 中等
 * 32
 * 相关企业
 * 在 n*m 大小的棋盘中，有黑白两种棋子，黑棋记作字母 "X", 白棋记作字母 "O"，
 * 空余位置记作 "."。当落下的棋子与其他相同颜色的棋子在行、
 * 列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
 * <p>
 * 1.gif2.gif3.gif
 * <p>
 * 「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，
 * 其状态记作 chessboard。若下一步可放置一枚黑棋，请问选手最多能翻转多少枚白棋。
 * <p>
 * 注意：
 * <p>
 * 若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 继续 翻转白棋
 * 输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
 * 示例 1：
 * <p>
 * 输入：chessboard = ["....X.","....X.","XOOO..","......","......"]
 * <p>
 * 输出：3
 * <p>
 * 解释： 可以选择下在 [2,4] 处，能够翻转白方三枚棋子。
 * <p>
 * 示例 2：
 * <p>
 * 输入：chessboard = [".X.",".O.","XO."]
 * <p>
 * 输出：2
 * <p>
 * 解释： 可以选择下在 [2,2] 处，能够翻转白方两枚棋子。2126c1d21b1b9a9924c639d449cc6e65.gif
 * <p>
 * 示例 3：
 * <p>
 * 输入：chessboard = [".......",".......",".......","X......",".O.....","..O....","....OOX"]
 * <p>
 * 输出：4
 * <p>
 * 解释： 可以选择下在 [6,3] 处，能够翻转白方四枚棋子。803f2f04098b6174397d6c696f54d709.gif
 * <p>
 * 提示：
 * <p>
 * 1 <= chessboard.length, chessboard[i].length <= 8
 * chessboard[i] 仅包含 "."、"O" 和 "X"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/fHi6rV/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LCP41_FlipChess {
    public static void main(String[] args) {
        LCP41_FlipChess lcp41FlipChess = new LCP41_FlipChess();
        System.out.println(lcp41FlipChess.flipChess(new String[]{"....X.","....X.","XOOO..","......","......"}));
    }
    int[][] forwards = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
    private static boolean rangeCheck(char[][] board, int iIndex, int jIndex) {
        return iIndex >= 0 && iIndex < board.length && jIndex >= 0 && jIndex < board[iIndex].length;
    }

    public int flipChess(String[] chessboard) {
        char[][] board = new char[chessboard.length][chessboard[0].length()];
        for (int i = 0; i < chessboard.length; i++) {
            String row = chessboard[i];
            for (int j = 0; j < row.length(); j++) {
                board[i][j] = row.charAt(j);
            }
        }
        int res = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                res = Math.max(bfs(board, i, j), res);
            }
        }
        return res;
    }

    private int bfs(char[][] board, int i, int j) {
        if (board[i][j] != '.') {
            return 0;
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        List<int[]> modifyNode = new ArrayList<>();
        board[i][j] = 'X';

        int res = 0;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int[] forward : forwards) {
                List<int[]> modify = new ArrayList<>();
                int iIndex = node[0] + forward[0];
                int jIndex = node[1] + forward[1];
                while (rangeCheck(board, iIndex, jIndex)) {
                    if (board[iIndex][jIndex] != 'O') {
                        break;
                    }
                    modify.add(new int[]{iIndex, jIndex});
                    iIndex += forward[0];
                    jIndex += forward[1];
                }
                if (rangeCheck(board, iIndex, jIndex) && board[iIndex][jIndex] == 'X') {
                    modifyNode.addAll(modify);
                    //开始染色
                    for (int[] ints : modify) {
                        if (board[ints[0]][ints[1]] == 'X') {
                            continue;
                        }
                        board[ints[0]][ints[1]] = 'X';
                        queue.offer(ints);
                        res++;
                    }
                }
            }
        }
        board[i][j] = '.';
        for (int[] ints : modifyNode) {
            board[ints[0]][ints[1]] = 'O';
        }
        return res;
    }



    private void dfs(char[][] board, int i, int j, Set<Integer> pathSet) {
        if (board[i][j] == '.') {
            return;
        }
        List<int[]> tempRes = new ArrayList<>();
        for (int[] forward : forwards) {
            List<int[]> tempPath = new ArrayList<>();
            int iIndex = i + forward[0];
            int jIndex = j + forward[1];
            while (rangeCheck(board, iIndex, jIndex)) {
                if (board[iIndex][jIndex] != 'O') {
                    break;
                }
                tempPath.add(new int[]{iIndex, jIndex});
                iIndex += forward[0];
                jIndex += forward[1];
            }
            if (rangeCheck(board, iIndex, jIndex) && board[iIndex][jIndex] == 'X') {
                tempRes.addAll(tempPath);
            }
        }
        for (int[] ints : tempRes) {
            pathSet.add(ints[0] * 10 + ints[1]);
            board[ints[0]][ints[1]] = 'X';
        }
        for (int[] p : tempRes) {
            dfs(board, p[0], p[1], pathSet);
        }
        for (int[] ints : tempRes) {
            board[ints[0]][ints[1]] = 'O';
        }

    }


}
