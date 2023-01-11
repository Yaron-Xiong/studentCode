package com.accompnay.TopicAlgorithms.practiceSet.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 886. 可能的二分法
 * 中等
 * 351
 * 相关企业
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 * <p>
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。
 * 当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 * <p>
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/possible-bipartition/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PossibleBipartition {
	public static void main(String[] args) {
		PossibleBipartition possibleBipartition = new PossibleBipartition();
		boolean b = possibleBipartition.possibleBipartition2(50, new int[][]{{21, 47}, {4, 41}, {2, 41}, {36, 42}, {32, 45}, {26, 28}, {32, 44}, {5, 41}, {29, 44}, {10, 46}, {1, 6}, {7, 42}, {46, 49}, {17, 46}, {32, 35}, {11, 48}, {37, 48}, {37, 43}, {8, 41}, {16, 22}, {41, 43}, {11, 27}, {22, 44}, {22, 28}, {18, 37}, {5, 11}, {18, 46}, {22, 48}, {1, 17}, {2, 32}, {21, 37}, {7, 22}, {23, 41}, {30, 39}, {6, 41}, {10, 22}, {36, 41}, {22, 25}, {1, 12}, {2, 11}, {45, 46}, {2, 22}, {1, 38}, {47, 50}, {11, 15}, {2, 37}, {1, 43}, {30, 45}, {4, 32}, {28, 37}, {1, 21}, {23, 37}, {5, 37}, {29, 40}, {6, 42}, {3, 11}, {40, 42}, {26, 49}, {41, 50}, {13, 41}, {20, 47}, {15, 26}, {47, 49}, {5, 30}, {4, 42}, {10, 30}, {6, 29}, {20, 42}, {4, 37}, {28, 42}, {1, 16}, {8, 32}, {16, 29}, {31, 47}, {15, 47}, {1, 5}, {7, 37}, {14, 47}, {30, 48}, {1, 10}, {26, 43}, {15, 46}, {42, 45}, {18, 42}, {25, 42}, {38, 41}, {32, 39}, {6, 30}, {29, 33}, {34, 37}, {26, 38}, {3, 22}, {18, 47}, {42, 48}, {22, 49}, {26, 34}, {22, 36}, {29, 36}, {11, 25}, {41, 44}, {6, 46}, {13, 22}, {11, 16}, {10, 37}, {42, 43}, {12, 32}, {1, 48}, {26, 40}, {22, 50}, {17, 26}, {4, 22}, {11, 14}, {26, 39}, {7, 11}, {23, 26}, {1, 20}, {32, 33}, {30, 33}, {1, 25}, {2, 30}, {2, 46}, {26, 45}, {47, 48}, {5, 29}, {3, 37}, {22, 34}, {20, 22}, {9, 47}, {1, 4}, {36, 46}, {30, 49}, {1, 9}, {3, 26}, {25, 41}, {14, 29}, {1, 35}, {23, 42}, {21, 32}, {24, 46}, {3, 32}, {9, 42}, {33, 37}, {7, 30}, {29, 45}, {27, 30}, {1, 7}, {33, 42}, {17, 47}, {12, 47}, {19, 41}, {3, 42}, {24, 26}, {20, 29}, {11, 23}, {22, 40}, {9, 37}, {31, 32}, {23, 46}, {11, 38}, {27, 29}, {17, 37}, {23, 30}, {14, 42}, {28, 30}, {29, 31}, {1, 8}, {1, 36}, {42, 50}, {21, 41}, {11, 18}, {39, 41}, {32, 34}, {6, 37}, {30, 38}, {21, 46}, {16, 37}, {22, 24}, {17, 32}, {23, 29}, {3, 30}, {8, 30}, {41, 48}, {1, 39}, {8, 47}, {30, 44}, {9, 46}, {22, 45}, {7, 26}, {35, 42}, {1, 27}, {17, 30}, {20, 46}, {18, 29}, {3, 29}, {4, 30}, {3, 46}});
		System.out.println(b);
	}

	public boolean possibleBipartition2(int n, int[][] dislikes) {
		List<List<Integer>> graph = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] ints : dislikes) {
			graph.get(ints[0] - 1).add(ints[1] - 1);
			graph.get(ints[1] - 1).add(ints[0] - 1);
		}
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visitor = new boolean[n];
		boolean[] color = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visitor[i]){
				continue;
			}
			queue.add(i);
			while (!queue.isEmpty()) {
				Integer curNode = queue.poll();
				visitor[curNode] = true;
				boolean nextColor = !color[curNode];
				for (Integer neighbor : graph.get(curNode)) {
					if (visitor[neighbor]) {
						if (color[neighbor] != nextColor) {
							return false;
						}
					} else {
						color[neighbor] = nextColor;
						queue.add(neighbor);
					}
				}
			}
		}
		return true;
	}

	public boolean possibleBipartition(int n, int[][] dislikse) {
		List<List<Integer>> graph = new ArrayList<>(n);
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}
		for (int[] ints : dislikse) {
			graph.get(ints[0] - 1).add(ints[1] - 1);
			graph.get(ints[1] - 1).add(ints[0] - 1);
		}
		boolean[] color = new boolean[n];
		boolean[] visitor = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visitor[i]) {
				continue;
			}
			boolean b = dfs(i, graph, color, visitor);
			if (!b) {
				return false;
			}
		}
		return true;
	}

	private boolean dfs(int curNode, List<List<Integer>> graph, boolean[] color, boolean[] visitor) {
		boolean nextColor = !color[curNode];
		visitor[curNode] = true;
		for (Integer neighbor : graph.get(curNode)) {
			if (visitor[neighbor]) {
				if (color[neighbor] != nextColor) {
					return false;
				}
			} else {
				color[neighbor] = nextColor;
				boolean b = dfs(neighbor, graph, color, visitor);
				if (!b) {
					return false;
				}
			}
		}
		return true;
	}
}
