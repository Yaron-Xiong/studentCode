package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.TreeMap;

/**
 * 3102. 最小化曼哈顿距离
 * 算术评级: 8
 * 第 391 场周赛
 * Q4
 * 2216
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。
 * <p>
 * 两点之间的距离定义为它们的
 * 曼哈顿距离
 * 。
 * <p>
 * 请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：points = [[3,10],[5,15],[10,2],[4,4]]
 * 输出：12
 * 解释：移除每个点后的最大距离如下所示：
 * - 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
 * - 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
 * - 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
 * - 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
 * 在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
 * 示例 2：
 * <p>
 * 输入：points = [[1,1],[1,1],[1,1]]
 * 输出：0
 * 解释：移除任一点后，任意两点之间的最大距离都是 0 。
 * <p>
 * 提示：
 * <p>
 * 3 <= points.length <= 105
 * points[i].length == 2
 * 1 <= points[i][0], points[i][1] <= 108
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/minimize-manhattan-distances/description/?envType=daily-question&envId=2024-07-09">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3102_MinimumDistance {
    public static void main(String[] args) {
        L3102_MinimumDistance l3102MinimumDistance = new L3102_MinimumDistance();
        System.out.println(l3102MinimumDistance.minimumDistance(new int[][]{{3, 10}, {5, 15}, {10, 2}, {4, 4}}));
    }

    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> sx = new TreeMap<Integer, Integer>();
        TreeMap<Integer, Integer> sy = new TreeMap<Integer, Integer>();
        for (int[] p : points) {
            sx.put(p[0] - p[1], sx.getOrDefault(p[0] - p[1], 0) + 1);
            sy.put(p[0] + p[1], sy.getOrDefault(p[0] + p[1], 0) + 1);
        }
        int res = Integer.MAX_VALUE;
        for (int[] p : points) {
            sx.put(p[0] - p[1], sx.get(p[0] - p[1]) - 1);
            if (sx.get(p[0] - p[1]) == 0) {
                sx.remove(p[0] - p[1]);
            }
            sy.put(p[0] + p[1], sy.get(p[0] + p[1]) - 1);
            if (sy.get(p[0] + p[1]) == 0) {
                sy.remove(p[0] + p[1]);
            }
            res = Math.min(res, Math.max(sx.lastKey() - sx.firstKey(), sy.lastKey() - sy.firstKey()));
            sx.put(p[0] - p[1], sx.getOrDefault(p[0] - p[1], 0) + 1);
            sy.put(p[0] + p[1], sy.getOrDefault(p[0] + p[1], 0) + 1);
        }
        return res;
    }
}
