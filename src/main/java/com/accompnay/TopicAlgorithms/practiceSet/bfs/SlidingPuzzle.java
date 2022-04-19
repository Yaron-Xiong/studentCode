package com.accompnay.TopicAlgorithms.practiceSet.bfs;

import java.util.*;

/**
 * 773. 滑动谜题
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * <p>
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * <p>
 * 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [[1,2,3],[4,0,5]]
 * 输出：1
 * 解释：交换 0 和 5 ，1 步完成
 * 示例 2:
 * <p>
 * 输入：board = [[1,2,3],[5,4,0]]
 * 输出：-1
 * 解释：没有办法完成谜板
 * 示例 3:
 * <p>
 * 输入：board = [[4,1,2],[5,0,3]]
 * 输出：5
 * 解释：
 * 最少完成谜板的最少移动次数是 5 ，
 * 一种移动路径:
 * 尚未移动: [[4,1,2],[5,0,3]]
 * 移动 1 次: [[4,1,2],[0,5,3]]
 * 移动 2 次: [[0,1,2],[4,5,3]]
 * 移动 3 次: [[1,0,2],[4,5,3]]
 * 移动 4 次: [[1,2,0],[4,5,3]]
 * 移动 5 次: [[1,2,3],[4,5,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * board.length == 2
 * board[i].length == 3
 * 0 <= board[i][j] <= 5
 * board[i][j] 中每个值都 不同
 */
public class SlidingPuzzle {
	public static void main(String[] args) {
		SlidingPuzzle slidingPuzzle = new SlidingPuzzle();
		int i = slidingPuzzle.slidingPuzzle(new int[][]{{1, 2, 3}, {4, 0, 5}});
		System.out.println(i);
	}

	public int slidingPuzzle(int[][] board) {
		String targetStr = "123450";
		int[][] neighbor = {
				{1, 3},
				{0, 2, 4},
				{1, 5},
				{0, 4},
				{1, 3, 5},
				{2, 4}
		};
		StringBuilder builder = new StringBuilder();
		for (int[] ints : board) {
			for (int anInt : ints) {
				builder.append(anInt);
			}
		}
		String start = builder.toString();

		Deque<String> queue = new LinkedList<>();
		HashSet<String> visited = new HashSet<>();
		queue.add(start);
		int step = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				size--;
				String curStr = queue.poll();
				if (visited.contains(curStr)) {
					continue;
				}
				visited.add(curStr);
				if (Objects.equals(curStr, targetStr)) {
					return step;
				}
				int index = curStr.indexOf('0');
				for (int swapIndex : neighbor[index]) {
					String swapStr = swap(curStr, swapIndex, index);
					queue.add(swapStr);
				}
			}
			step++;
		}
		return -1;
	}

	private String swap(String curStr, int index1, int index2) {
		char[] chars = curStr.toCharArray();
		char temp = chars[index1];
		chars[index1] = chars[index2];
		chars[index2] = temp;
		return new String(chars);
	}

}
