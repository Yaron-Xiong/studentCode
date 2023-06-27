package com.accompnay.TopicAlgorithms.leetcode.l1000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1042. 不邻接植花
 * 提示
 * 中等
 * 220
 * 相关企业
 * 有 n 个花园，按从 1 到 n 标记。另有数组 paths ，其中 paths[i] = [xi, yi] 描述了花园 xi 到花园 yi 的双向路径。在每个花园中，你打算种下四种花之一。
 * <p>
 * 另外，所有花园 最多 有 3 条路径可以进入或离开.
 * <p>
 * 你需要为每个花园选择一种花，使得通过路径相连的任何两个花园中的花的种类互不相同。
 * <p>
 * 以数组形式返回 任一 可行的方案作为答案 answer，其中 answer[i] 为在第 (i+1) 个花园中种植的花的种类。花的种类用  1、2、3、4 表示。保证存在答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, paths = [[1,2],[2,3],[3,1]]
 * 输出：[1,2,3]
 * 解释：
 * 花园 1 和 2 花的种类不同。
 * 花园 2 和 3 花的种类不同。
 * 花园 3 和 1 花的种类不同。
 * 因此，[1,2,3] 是一个满足题意的答案。其他满足题意的答案有 [1,2,4]、[1,4,2] 和 [3,2,1]
 * 示例 2：
 * <p>
 * 输入：n = 4, paths = [[1,2],[3,4]]
 * 输出：[1,2,1,2]
 * 示例 3：
 * <p>
 * 输入：n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]]
 * 输出：[1,2,3,4]
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 * 0 <= paths.length <= 2 * 104
 * paths[i].length == 2
 * 1 <= xi, yi <= n
 * xi != yi
 * 每个花园 最多 有 3 条路径可以进入或离开
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/flower-planting-with-no-adjacent/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1042_GardenNoAdj {
	public int[] gardenNoAdj(int n, int[][] paths) {
		List<Integer>[] graph = new List[n];
		Arrays.setAll(graph, e -> new ArrayList<>());
		for (int[] path : paths) {
			int x = path[0] - 1;
			int y = path[1] - 1;
			graph[x].add(y);
			graph[y].add(x);
		}
		//每个节点可以选择4中颜色
		int[] res = new int[n];
		boolean[] color = new boolean[5];
		for (int i = 0; i < n; i++) {
			Arrays.fill(color, false);
			for (Integer x : graph[i]) {
				color[res[x]] = true;
			}
			//找到第一个没用过的颜色
			for (int j = 1; j < color.length; j++) {
				if (!color[j]) {
					res[i] = j;
					break;
				}
			}
		}
		return res;
	}
}
