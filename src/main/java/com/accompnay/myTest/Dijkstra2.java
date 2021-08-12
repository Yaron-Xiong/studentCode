package com.accompnay.myTest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Dijkstra2 {

	public static final int N = 65535;
	public static final char[] vertex = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};

	public static void main(String[] args) {
		//邻接矩阵
		int[][] matrix = new int[vertex.length][vertex.length];
		matrix[0] = new int[]{N, 5, 7, N, N, N};
		matrix[1] = new int[]{5, N, N, 9, N, N};
		matrix[2] = new int[]{7, N, N, N, 8, N};
		matrix[3] = new int[]{N, 9, N, N, N, 4};
		matrix[4] = new int[]{N, N, 8, N, N, 5};
		matrix[5] = new int[]{N, N, N, 4, 5, N};
		int dijkstra = dijkstra(matrix, 5);
		System.out.println(dijkstra);
	}

	public static int dijkstra(int[][] matrix, int target) {
		Map<Integer, int[]> map = Maps.newHashMap();
		List<Integer> need = Lists.newArrayList(0);
		Set<Integer> has = Sets.newHashSet();
		map.put(0, new int[]{-1, 0});
		while (!need.isEmpty()) {
			int index = findMin(need, map);
			Integer point = need.remove(index);
			has.add(point);
			for (int endPoint = 0; endPoint < matrix[point].length; endPoint++) {
				if (matrix[point][endPoint] == N || has.contains(endPoint)) {
					continue;
				}
				need.add(endPoint);
				int[] oldFree = map.getOrDefault(endPoint, new int[]{-1, Integer.MAX_VALUE});
				int[] newFree = new int[]{point, map.get(point)[1] + matrix[point][endPoint]};
				int[] result = oldFree;
				if (newFree[1] < oldFree[1]) {
					result = newFree;
				}
				map.put(endPoint, result);
			}
		}
		printPath(map, target);
		return map.get(target)[1];
	}

	private static void printPath(Map<Integer, int[]> map, int target) {
		System.out.println("print path start");
		int point = target;
		while (point != -1) {
			System.out.println(point);
			int[] sub = map.get(point);
			point = sub[0];
		}
		System.out.println("print path end");
	}

	public static int findMin(List<Integer> list, Map<Integer, int[]> pointFreeMap) {
		int result = 0;
		int[] ints = pointFreeMap.get(list.get(0));
		int minFree = ints[1];
		for (int i = 0; i < list.size(); i++) {
			Integer point = list.get(i);
			int pointFree = pointFreeMap.get(point)[1];
			if (pointFree < minFree) {
				minFree = pointFreeMap.get(i)[1];
				result = i;
			}
		}
		return result;
	}


}
