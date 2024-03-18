package com.yaronxiong.algorithms.leetcode.l1000;

/**
 * 1039. 多边形三角剖分的最低得分
 * 提示
 * 中等
 * 154
 * 相关企业
 * 你有一个凸的 n 边形，其每个顶点都有一个整数值。给定一个整数数组 values ，其中 values[i] 是第 i 个顶点的值（即 顺时针顺序 ）。
 * <p>
 * 假设将多边形 剖分 为 n - 2 个三角形。对于每个三角形，该三角形的值是顶点标记的乘积，三角剖分的分数是进行三角剖分后所有 n - 2 个三角形的值之和。
 * <p>
 * 返回 多边形进行三角剖分后可以得到的最低分 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [1,2,3]
 * 输出：6
 * 解释：多边形已经三角化，唯一三角形的分数为 6。
 * 示例 2：
 * <p>
 * 输入：values = [3,7,4,5]
 * 输出：144
 * 解释：有两种三角剖分，可能得分分别为：3*7*5 + 4*5*7 = 245，或 3*4*5 + 3*4*7 = 144。最低分数为 144。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：values = [1,3,1,4,1,5]
 * 输出：13
 * 解释：最低分数三角剖分的得分情况为 1*1*3 + 1*1*4 + 1*1*5 + 1*1*1 = 13。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == values.length
 * 3 <= n <= 50
 * 1 <= values[i] <= 100
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L1039_MinScoreTriangulation {
	public static void main(String[] args) {
		L1039_MinScoreTriangulation l1039MinScoreTriangulation = new L1039_MinScoreTriangulation();
		System.out.println(l1039MinScoreTriangulation.minScoreTriangulation(new int[]{3,7,4,5}));
	}

	int[] values;
	int[][] memo;

	public int minScoreTriangulation(int[] values) {
		this.values = values;
		memo = new int[values.length][values.length];
		return dfs(0, values.length - 1);
	}

	private int dfs(int i, int j) {
		//说明不可能构成三角形
		if (i + 1 == j) {
			return 0;
		}
		if (memo[i][j] != 0) {
			return memo[i][j];
		}
		int res = Integer.MAX_VALUE;
		for (int k = i + 1; k < j; k++) {
			res = Math.min(res, dfs(i, k) + dfs(k, j) + (values[i] * values[j] * values[k]));
		}
		return memo[i][j] = res;
	}

}
