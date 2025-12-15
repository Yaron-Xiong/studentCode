package com.yaronxiong.algorithms.leetcode.l3000;

import java.util.*;

/**
 * 3531. 统计被覆盖的建筑
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 n，表示一个 n x n 的城市，同时给定一个二维数组 buildings，其中 buildings[i] = [x, y] 表示位于坐标 [x, y] 的一个 唯一 建筑。
 * <p>
 * 如果一个建筑在四个方向（左、右、上、下）中每个方向上都至少存在一个建筑，则称该建筑 被覆盖 。
 * <p>
 * 返回 被覆盖 的建筑数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3, buildings = [[1,2],[2,2],[3,2],[2,1],[2,3]]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * <p>
 * 只有建筑 [2,2] 被覆盖，因为它在每个方向上都至少存在一个建筑：
 * 上方 ([1,2])
 * 下方 ([3,2])
 * 左方 ([2,1])
 * 右方 ([2,3])
 * 因此，被覆盖的建筑数量是 1。
 * 示例 2：
 * <p>
 * 输入: n = 3, buildings = [[1,1],[1,2],[2,1],[2,2]]
 * <p>
 * 输出: 0
 * <p>
 * 解释:
 * <p>
 * 没有任何一个建筑在每个方向上都有至少一个建筑。
 * 示例 3：
 * <p>
 * 输入: n = 5, buildings = [[1,3],[3,2],[3,3],[3,5],[5,3]]
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * <p>
 * 只有建筑 [3,3] 被覆盖，因为它在每个方向上至少存在一个建筑：
 * 上方 ([1,3])
 * 下方 ([5,3])
 * 左方 ([3,2])
 * 右方 ([3,5])
 * 因此，被覆盖的建筑数量是 1。
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * 1 <= buildings.length <= 105
 * buildings[i] = [x, y]
 * 1 <= x, y <= n
 * buildings 中所有坐标均 唯一 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/count-covered-buildings/description/?envType=daily-question&envId=2025-12-11">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L3531_CountCoveredBuildings {
    public static void main(String[] args) {
        L3531_CountCoveredBuildings l3531CountCoveredBuildings = new L3531_CountCoveredBuildings();
        System.out.println(l3531CountCoveredBuildings.countCoveredBuildings(3, new int[][]{{1, 2}, {3, 1}, {1, 1}, {3, 2}, {1, 3}}));
        System.out.println(l3531CountCoveredBuildings.countCoveredBuildings(3, new int[][]{{1, 2}, {2, 2}, {3, 2}, {2, 1}, {2, 3}}));
        System.out.println(l3531CountCoveredBuildings.countCoveredBuildings(3, new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}}));
        System.out.println(l3531CountCoveredBuildings.countCoveredBuildings(5, new int[][]{{1, 3}, {3, 2}, {3, 3}, {3, 5}, {5, 3}}));
    }

    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] maxX = new int[n + 1];
        int[] minX = new int[n + 1];
        int[] maxY = new int[n + 1];
        int[] minY = new int[n + 1];
        Arrays.fill(maxX, Integer.MIN_VALUE);
        Arrays.fill(maxY, Integer.MIN_VALUE);
        Arrays.fill(minY, Integer.MAX_VALUE);
        Arrays.fill(minX, Integer.MAX_VALUE);
        for (int[] building : buildings) {
            maxX[building[0]] = Math.max(maxX[building[0]], building[1]);
            minX[building[0]] = Math.min(minX[building[0]], building[1]);
            maxY[building[1]] = Math.max(maxY[building[1]], building[0]);
            minY[building[1]] = Math.min(minY[building[1]], building[0]);
        }
        int ans = 0;
        for (int[] building : buildings) {
            int x = building[0];
            int y = building[1];
            if (y < maxX[x] && y > minX[x] && x < maxY[y] && x > minY[y]) {
                ans++;
            }
        }
        return ans;
    }
}
