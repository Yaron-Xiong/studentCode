package com.accompnay.diagram;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

public class Dijkstra2 {

	public static final int N = 65535;
	public static final char[] vertex = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

	public static void main(String[] args) {
		//邻接矩阵
		int[][] matrix = new int[vertex.length][vertex.length];
		matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
		matrix[1] = new int[]{5, N, N, 9, N, N, 3};
		matrix[2] = new int[]{7, N, N, N, 8, N, N};
		matrix[3] = new int[]{N, 9, N, N, N, 4, N};
		matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
		matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
		matrix[6] = new int[]{2, 3, N, N, 4, 6, N};
		int dijkstra = dijkstra(matrix, 6);
		System.out.println(dijkstra);
	}

	public static int dijkstra(int[][] matrix, int target) {
		Map<Integer, Integer> map = Maps.newHashMap();
		List<int[]> need = Lists.newArrayList();
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == N) {
				continue;
			}
			need.add(new int[]{0, i});
			map.put(i, matrix[0][i]);
		}

		while (!need.isEmpty()) {
			int[] arr = findMin(need, matrix);
			int point = arr[1];
			for (int i = 0; i < matrix[point].length; i++) {
				if (matrix[point][i] == N) {
					continue;
				}
				need.add(new int[]{point, i});
				map.put(i, matrix[point][i]);
			}
		}
		return map.get(target);
	}

	public static int[] findMin(List<int[]> list, int[][] matrix) {
		int[] result = list.get(0);
		for (int[] ints : list) {
			int start = ints[0];
			int end = ints[1];
			if (matrix[result[0]][result[1]] > matrix[start][end]) {
				result = ints;
			}
		}
		return result;
	}


}
