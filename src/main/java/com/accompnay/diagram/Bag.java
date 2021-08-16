package com.accompnay.diagram;

import java.util.Arrays;

/**
 * 背包问题：解决了什么？
 * 在有限的资源下，做最多的事情
 *
 * 限制：
 * 每个子问题不能存在依赖关系
 *
 * 小贴士：
 * 每种动态规划解决方案都涉及网格。
 * 单元格中的值通常就是你要优化的值。在前面的背包问题中，单元格的值为商品的价值。
 * 每个单元格都是一个子问题，因此你应考虑如何将问题分成子问题，这有助于你找出网格的坐标轴。
 */
public class Bag {
	private static int[] value = new int[]{1500, 3000, 2000, 2000, 1000};
	private static String[] name = new String[]{"吉他", "音箱", "笔记本电脑", "Iphone", "MP3"};
	private static int[] weight = new int[]{1, 4, 3, 1, 1};
	private static int bagSize = 5;

	public static void main(String[] args) {
		bag();
	}

	public static void bag() {
		int[][] result = new int[name.length][bagSize];

		//初始化第一行
		for (int i = 0; i < result[0].length; i++) {
			result[0][i] = i >= weight[0] ? value[0] : 0;
		}

		for (int i = 1; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				int temp2 = 0;
				//当前可装重量大于当前物品
				if (j >= weight[i]) {
					temp2 = value[i] + result[i-1][j  - weight[i]];
				}
				//动态转移方程
				result[i][j] = Math.max(result[i - 1][j], temp2);
			}
		}

		Arrays.toString(result);
	}
}
